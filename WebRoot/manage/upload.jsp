<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>  
<%//@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>Struts2结合JQuery.uploadify实现带进度的多文件上传示例</title>  
    <link  href="scripts/jquery.upload/uploadify.css" rel="stylesheet" type="text/css"/>  
    <script type="text/javascript"  src="scripts/jquery.upload/jquery-1.4.2.min.js" ></script>     
    <script type="text/javascript"  src="scripts/jquery.upload/swfobject.js" ></script>     
    <script type="text/javascript"  src="scripts/jquery.upload/jquery.uploadify.v2.1.4.min.js" ></script>  
    <script type="text/javascript">
    <!--  
   
        $(function() {  
            $("#cancelBtn").hide();  
            $("#full").hide();  
            $('#strutsUploadFile').uploadify({  
                  'uploader'  : 'scripts/jquery.upload/uploadify.swf',  
                  'script'    : 'uploadFile.action',  
                  'cancelImg' : 'scripts/jquery.upload/cancel.png',  
                  'fileDataName':'fileName',  
                  //解决中文按钮名的好方式   
                  'buttonImg' : 'images/select.jpg',  
                  //可选   
                  'height'    : 20,  
                  //可选   
                  'width'     : 50,  
                  //设置允许上传的文件格式   
                  //'fileExt'   : '*.jpg;*.gif;*.png',   
                  //设置允许上传的文件格式后，必须加上下面这行代码才能帮你过滤   
                  //'fileDesc'    : 'Image Files',   
                  //允许连续上传多个文件   
                  'multi':'true',  
                  //一次性最多允许上传多少个,不设置的话默认为999个   
                  'queueSizeLimit' : 3,  
                  //每个文件允许上传的大小(字节)   
                  //'sizeLimit'   : 102400,   
                  'onComplete'  : function(event, ID, fileObj, response, data) {  
                        //当每个文件上传完成后的操作   
                        $("#cancel").hide();  
                        $("#full").hide();  
                        $("#show").append( "<a  href=/downloadFile.action?fileName="+fileObj.name+"/>"+fileObj.name+"</a><br/>");  
                        },  
                  'onAllComplete':function(event,data) {  
                        //当所有文件上传完成后的操作   
                        $("#cancelBtn").hide();  
                        if(data.errors==0){  
                            $("#allShow").append("所有文件已上传成功(本次共上传"+data.filesUploaded+"个),上传总大小:"+data.allBytesLoaded+"字节,平均传输速度："+data.speed+"KB/s");  
                        }else{  
                            $("#allShow").append("成功上传"+data.filesUploaded+"个文件，失败"+data.errors+"个,上传总大小:"+data.allBytesLoaded+"字节,平均传输速度："+data.speed+"KB/s");  
                        }  
                  },  
                  'onOpen': function(event,ID,fileObj) {  
                        //当有文件正在上传时的操作   
                        $("#cancelBtn").show();  
                  },  
                  'onQueueFull': function (event,queueSizeLimit) {  
                        //当添加待上传的文件数量达到设置的上限时的操作   
                        $("#full").append("<font color='red'><b>已经达到上传数量限制了,不能再添加了</b></color><br/>");  
                        $("#full").show();  
                        return false;  
                  },  
                  'onCancel': function(event,ID,fileObj,data) {  
                        //当取消所有正在上传文件后的操作   
                        $("#cancelBtn").hide();  
                  }  
            });               
        });      
// -->
</script>       
  </head>  
    
  <body>  
    <div id="full"></div>  
    <div id="allShow"></div>  
    <div id="show"></div>  
    <input type="file"  name="fileName" id="strutsUploadFile"/><br/>    
    <input type="button" onclick="javascript:$('#strutsUploadFile').uploadifyUpload()" value="确定上传"/>  
     <input type="button" id="cancelBtn" onclick="javascript:$('#strutsUploadFile').uploadifyClearQueue()" value="取消上传"/>  
  </body>  
</html> 