import {Group, Shape, ExtrudeGeometry, MeshLambertMaterial,
  Mesh, TextureLoader, DoubleSide, RepeatWrapping, Vector2,
  Vector4, Path, ShaderMaterial, Color,UniformsUtils, UniformsLib} from 'three';
import {getRgbNumber, getAlpha} from "../../../utils/colorUtil";
import {clearGroup} from "../../../utils/threeUtil";
import {vertex, fragment} from './meshlambert.glsl'
import type {Polygon} from "./Type";

interface Options {
  sideTopColor: string // 侧面顶部颜色。缺省值为 '#ffffff'。
  sideBottomColor: string // 侧面顶部颜色。缺省值为 '#ffffff'。
  sideTexture?: string
  topColor: string
  bottomColor: string
  height: number
  depthTest: boolean // 是否开启深度检测，深度检测的话会面会进行融合
  source: Polygon
}

interface Properties {
  height?: number
}

class ThreePolygon {
  object: any // Group
  layer: any // threejs的图层对象
  bottomMaterial: MeshLambertMaterial //底部材质
  topMaterial: MeshLambertMaterial // 顶部材质
  sideImgMaterial: MeshLambertMaterial // 侧面贴图材质

  constructor(layer: any, options: Options) {
    this.layer = layer;
    this.object = new Group();
    this.createGlobalMaterial(options);
    this.layer.addObject(this.object);
    this.init(options);
  }

  createGlobalMaterial(options: Options){
    if(options.sideTexture){
      const sideTexture = new TextureLoader().load(options.sideTexture);
      sideTexture.wrapS = sideTexture.wrapT = RepeatWrapping;
      sideTexture.offset.set(0, 0.5);
      sideTexture.repeat.set(0.1,0.1);
      this.sideImgMaterial = new MeshLambertMaterial({
        depthTest: options.depthTest,
        map: sideTexture,
        side: DoubleSide
      })
    }
    this.bottomMaterial = new MeshLambertMaterial({
      depthTest: options.depthTest,
      transparent: true,
      color: getRgbNumber(options.bottomColor),
      opacity: getAlpha(options.bottomColor),
    })
    this.topMaterial = new MeshLambertMaterial({
      depthTest: options.depthTest,
      transparent: true,
      color: getRgbNumber(options.topColor),
      opacity: getAlpha(options.topColor)
    })
  }

  init(options: Options) {
    options.source.features.forEach( feature => {
      if(feature.geometry.type === 'Polygon'){
        this.createMesh(feature.geometry.coordinates, feature.properties as Properties, options);
      }else if(feature.geometry.type === 'MultiPolygon'){
        feature.geometry.coordinates.forEach( cood => {
          this.createMesh(cood, feature.properties as Properties, options);
        })
      }
    })
    this.refresh();
  }

  createMesh(paths: number[][][], properties:Properties, options: Options ) {
    if(paths.length === 0){
      return
    }
    properties = properties || {}
    const height = properties.height !== undefined ? properties.height : options.height;
    const path = paths[0];
    const outPolygonArray: Vector2[] = []
    const holesArray: Path[] = [];
    // 生成面的外围圈
    for(let i=0;i<path.length;i++){
      const point = this.convertLngLat(path[i]);
      outPolygonArray.push(new Vector2(point[0], point[1]))
    }
    // 生成孔洞
    for(let i=1;i<paths.length;i++){
      const inPolygonPath = paths[i];
      const array:Vector2[] = [];
      for(let j=0;j<inPolygonPath.length;j++){
        const inPoint = this.convertLngLat(inPolygonPath[j]);
        array.push(new Vector2(inPoint[0], inPoint[1]))
      }
      holesArray.push(new Path(array));
    }
    const shape = new Shape(outPolygonArray);
    shape.holes = holesArray;
    // 由于需要对顶面，侧面，地面单独控制，因此在此处划分了3个mesh
    if(height > 0){
      // 生成侧面结构
      const sideExtrudeGeometry = new ExtrudeGeometry(shape, {
        depth: height,
        bevelEnabled: false,
        steps: 1
      })
      const hideMaterial = new MeshLambertMaterial({
        visible: false
      })
      const materialList = [hideMaterial]
      // 生成侧面
      let sideMaterial;
      if(options.sideTexture){
        sideMaterial = this.sideImgMaterial;
      }else{
        /*sideMaterial = new MeshLambertMaterial({
          depthTest: options.depthTest,
          transparent: true,
          color: getRgbNumber(options.sideColor),
          opacity: getAlpha(options.sideColor),
          side: DoubleSide
        })*/
        const topColor = new Color();
        topColor.setHex(getRgbNumber(options.sideTopColor));
        const topColorVector4 = new Vector4(topColor.r, topColor.g, topColor.b, getAlpha(options.sideTopColor))
        const bottomColor = new Color();
        bottomColor.setHex(getRgbNumber(options.sideBottomColor));
        const bottomColorVector4 = new Vector4(bottomColor.r, bottomColor.g, bottomColor.b, getAlpha(options.sideBottomColor))
        const uniforms = UniformsUtils.merge( [
          UniformsLib.common,
          UniformsLib.specularmap,
          UniformsLib.envmap,
          UniformsLib.aomap,
          UniformsLib.lightmap,
          UniformsLib.emissivemap,
          UniformsLib.fog,
          UniformsLib.lights,
          {
            emissive: { value: new Color( '#000' ) },
            "topColorVector4": {value: bottomColorVector4},
            "bottomColorVector4": {value: topColorVector4},
            "height": {value: height},
          }

        ] )
        sideMaterial = new ShaderMaterial({
          depthTest: options.depthTest,
          side: DoubleSide,
          transparent: true,
          lights: true,
          uniforms,
          vertexShader: vertex,
          fragmentShader: fragment
        })
      }
      materialList.push(sideMaterial);

      // 生成底面
      const bottomExtrudeGeometry = new ExtrudeGeometry(shape, {
        depth: 0
      })
      const bottomMesh = new Mesh(bottomExtrudeGeometry, this.bottomMaterial);
      this.object.add(bottomMesh);
      const sideMesh = new Mesh(sideExtrudeGeometry, materialList);
      this.object.add(sideMesh);
    }
    // 生成顶面
    const topExtrudeGeometry = new ExtrudeGeometry(shape, {
      depth: 0
    })
    const topMesh = new Mesh(topExtrudeGeometry, this.topMaterial);
    topMesh.translateZ(height);
    this.object.add(topMesh);
  }

  convertLngLat(lnglat: number[]) {
    return this.layer.convertLngLat(lnglat);
  }

  refresh() {
    this.layer.setUpdate();
  }

  show() {
    this.object.visible = true;
    this.refresh();
  }

  hide() {
    this.object.visible = false;
    this.refresh();
  }

  remove(){
    if (this.object) {
      this.layer.removeObject(this.object)
    }
  }

  destroy() {
    if (this.object) {
      clearGroup(this.object);
      if(this.bottomMaterial){
        this.bottomMaterial.dispose();
        this.bottomMaterial = null;
      }
      if(this.topMaterial){
        this.topMaterial.dispose();
        this.topMaterial = null;
      }
      if(this.sideImgMaterial){
        this.sideImgMaterial.dispose();
        this.sideImgMaterial = null
      }
      this.object = null;
      this.layer = null;
    }
  }
}

export default ThreePolygon
