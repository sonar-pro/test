---
title: Amap
---

# Amap

地图容器

## Attributes

Attribute | Type | Description
---|---|---|
viewMode | String | 地图视图模式, 默认为‘2D’，可选’3D’，选择‘3D’会显示 3D 地图效果。
showLabel | Boolean | 是否展示地图文字和 POI 信息。默认 true
defaultCursor | String | 地图默认鼠标样式。参数defaultCursor应符合CSS的cursor属性规范。
isHotspot | Boolean | 是否开启地图热点和标注的 hover 效果。PC端默认是true, 移动端默认是 false。
wallColor | String, Array | 地图楼块的侧面颜色，示例：'#ffffff' 或者 [255, 0, 0, 1]
roofColor | String, Array | 地图楼块的顶面颜色，示例：'#ffffff' 或者 [255, 0, 0, 1]
showBuildingBlock | Boolean | 是否展示地图 3D 楼块，默认 true
skyColor | String, Array | 天空颜色，3D 模式下带有俯仰角时会显示，示例：'#ffffff' 或者 [255, 0, 0, 1]
WebGLParams | Object | 额外配置的WebGL参数 eg: preserveDrawingBuffer。默认 {}
touchZoom | Boolean | 地图在移动终端上是否可通过多点触控缩放浏览地图，默认为true。关闭手势缩放地图，请设置为false。
touchZoomCenter | Number | 可缺省，当touchZoomCenter=1的时候，手机端双指缩放的以地图中心为中心，否则默认以双指中间点为中心。默认：1
showLabel | Boolean | 是否展示地图文字和 POI 信息。默认 true
center | Array | 初始中心经纬度
zoom | Number | 地图显示的缩放级别，可以设置为浮点数；若center与level未赋值，地图初始化默认显示用户所在城市范围。
zooms | Array | 图显示的缩放级别范围, 默认为 [2, 20] ，取值范围 [2 ~ 30]
rotation | Number | 地图顺时针旋转角度，取值范围 [0-360] ，默认值：0
pitch | Number | 俯仰角度，默认 0，最大值根据地图当前 zoom 级别不断增大，2D地图下无效 。
features | Array | 设置地图上显示的元素种类, 支持'bg'（地图背景）、'point'（POI点）、'road'（道路）、'building'（建筑物），默认值：['bg','point','road','building']
layers | Array | 地图图层数组，数组可以是图层 中的一个或多个，默认为普通二维地图。 当叠加多个 图层 时，普通二维地图需通过实例化一个TileLayer类实现。 如果你希望创建一个默认底图图层，使用 AMap.createDefaultLayer()
resizeEnable | Boolean | 是否监控地图容器尺寸变化，默认值为false。此属性可被 setStatus/getStatus 方法控制
dragEnable | Boolean | 地图是否可通过鼠标拖拽平移, 默认为 true。此属性可被 setStatus/getStatus 方法控制
zoomEnable | Boolean | 地图是否可缩放，默认值为 true。此属性可被 setStatus/getStatus 方法控制
jogEnable | Boolean | 地图是否使用缓动效果，默认值为true。此属性可被setStatus/getStatus 方法控制
pitchEnable | Boolean | 是否允许设置俯仰角度, 3D 视图下为 true, 2D 视图下无效。。此属性可被setStatus/getStatus 方法控制
rotateEnable | Boolean | 地图是否可旋转, 图默认为true。此属性可被setStatus/getStatus 方法控制
animateEnable | Boolean | 地图平移过程中是否使用动画（如调用panBy、panTo、setCenter、setZoomAndCenter等函数, 将对地图产生平移操作, 是否使用动画平移的效果）, 默认为true, 即使用动画。此属性可被 setStatus/getStatus 方法控制
keyboardEnable | Boolean | 地图是否可通过键盘控制, 默认为true, 方向键控制地图平移，"+"和"-"可以控制地图的缩放, Ctrl+“→”顺时针旋转，Ctrl+“←”逆时针旋转。此属性可被setStatus/getStatus 方法控制
doubleClickZoom | Boolean | 地图是否可通过双击鼠标放大地图, 默认为true。此属性可被setStatus/getStatus 方法控制
scrollWheel | Boolean | 地图是否可通过鼠标滚轮缩放浏览，默认为true。此属性可被setStatus/getStatus 方法控制
showIndoorMap | Boolean | 是否自动展示室内地图，默认是 false。此属性可被setStatus/getStatus 方法控制
mapStyle	| String |	设置地图显示样式，目前支持normal（默认样式）、dark（深色样式）、light（浅色样式）、fresh(osm清新风格样式)四种
labelRejectMask | Boolean | 文字是否拒绝掩模图层进行掩模
mask | Array | 为 Map 实例指定掩模的路径，各图层将只显示路径范围内图像，3D视图下有效。 格式为一个经纬度的一维、二维或三维数组。
terrain | Boolean | 是否开启地形，默认false


## Events

| Event Name | Parameters                      | Description        |
|------------|-----------------------------------|------------------|
resize | |地图容器大小改变事件
complete | |地图图块加载完成后触发事件
click |MapsEvent |鼠标左键单击事件
dblclick |MapsEvent |鼠标左键双击事件
mapmove | |地图平移时触发事件
hotspotclick |  |鼠标点击热点时触发
hotspotover | |鼠标滑过热点时触发
hotspotout | |鼠标移出热点时触发
movestart | |地图平移开始时触发
moveend | |地图平移结束后触发。如地图有拖拽缓动效果，则在缓动结束后触发
zoomchange | |地图缩放级别更改后触发
zoomstart | |缩放开始时触发
zoomend | |缩放停止时触发
mousemove | MapsEvent |鼠标在地图上移动时触发
mousewheel | MapsEvent |鼠标滚轮开始缩放地图时触发
mouseover | MapsEvent |鼠标移入地图容器内时触发
mouseout | MapsEvent |鼠标移出地图容器时触发
mouseup | MapsEvent |鼠标在地图上单击抬起时触发
mousedown | MapsEvent |鼠标在地图上单击按下时触发
rightclick | MapsEvent |鼠标右键单击事件
dragstart | |开始拖拽地图时触发
dragging | |拖拽地图过程中触发
dragend | |停止拖拽地图时触发。如地图有拖拽缓动效果，则在拽停止，缓动开始前触发
touchstart | MapsEvent |触摸开始时触发事件，仅适用移动设备
touchmove	| MapsEvent	|触摸移动进行中时触发事件，仅适用移动设备
touchend | MapsEvent | 触摸结束时触发事件，仅适用移动设备
