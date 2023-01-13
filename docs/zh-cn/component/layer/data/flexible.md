---
title: 灵活切片图层
description: AMap.TileLayer.Flexible 灵活切片图层，继承自AMap.TileLayer，开发者可通过构造时传入给其传入createTile字段来指定每一个切片的内容
head:
  - - meta
    - name: keywords
      content: amap, 高德地图, vue3.0, 灵活切片图层, AMap.TileLayer.Flexible
---

# 灵活切片图层 (AMap.TileLayer.Flexible)
灵活切片图层，继承自AMap.TileLayer，开发者可通过构造时传入给其传入createTile字段来指定每一个切片的内容<br/>
[相关示例](https://lbs.amap.com/api/jsapi-v2/example/selflayer/flex-canvas/)

## 基础示例

::: demo
examples/layer/data/flexible
:::


## 静态属性
仅且可以初始化配置，不支持响应式。

名称 | 类型 | 说明
---|---|---|
cacheSize | Number | 缓存瓦片数量
createTile | Function | 由开发者实现，由API自动调用，xyz分别为切片横向纵向编号和层级，切片大小 256。假设每次创建的贴片为A(支持img或者canvas)，当创建或者获取成功时请回调success(A)，不需要显示或者失败时请回调fail()
tileSize | Number | 切片大小，取值： 256，表示切片大小为256 256， 128，表示切片大小为128 128， 64，表示切片大小为64*64。默认值为256

## 动态属性
支持响应式。

名称 | 类型 | 说明
---|---|---|
zooms | Array | 支持的缩放级别范围，默认范围 [2-30]
visible | Boolean | 是否显示，默认 true
zIndex | Number | 图层叠加的顺序值，1 表示最底层。默认 zIndex：4
opacity | Number | 透明度，默认 1

## ref 可用方法
提供无副作用的同步帮助方法

函数 | 返回 | 说明
---|---|---|
$$getInstance() | AMap.TileLayer.Flexible | 获取实例

## 事件

事件 | 参数 | 说明
---|---|---|
init | AMap.TileLayer.Flexible | 实例初始化结束
complete |  | 图块切片加载完成事件
