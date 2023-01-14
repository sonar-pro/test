<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
 	<meta name="Keywords" content="your, keywords" />
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312"/>
	<meta name="Distribution" content="Global" />
	<meta name="Robots" content="index,follow" />
	
	  <link rel="stylesheet" type="text/css" href="../../../styles/ext-all.css" />
	  <link rel="stylesheet" type="text/css" href="../../../styles/table.css" />
      <link rel="stylesheet" type="text/css" href="../../../styles/cms.css" />
      <link rel="stylesheet" type="text/css" href="../../../styles/accordion.css" />
      <script type="text/javascript" src="../../../scripts/jquery/jquery.js"></script>
      <script type="text/javascript" src="../../../scripts/jquery/jquery-plugins.js"></script>
      <script type="text/javascript" src="../../../scripts/jquery/ext-jquery-adapter.js"></script>
      <script type="text/javascript" src="../../../scripts/ext-all.js"></script>
      <script type="text/javascript" src="../../../scripts/ext-accordion.js"></script>
	
<script type="text/javascript">
		Ext.onReady(function(){
			
	    Ext.get('formPanel').center();
	   });
	   
	//设置表格的行变色   
 	 var   color1="";   //这里设定tr的初始颜色   
 	 var   color2="#CCCCCC";   //这里设定tr的选中的颜色   
  	 var   aa;//选中的行对象   
   	 function  clicked()   
     {   
      if(aa!=null)   
          aa.style.backgroundColor   =   color1;     //恢复上次选中行的颜色   
        var   e   =   window.event.srcElement;   
        try   
        {   
            var   p   =   e.parentElement;   
            while   (p.tagName.toLowerCase()!=   "tr")   
                p   =   p.parentElement;   
            aa=p;   
            aa.style.backgroundColor   =   color2;//使当前选中行变色   
        }   
        catch(e)   
        {
        }   
      }   
  
  //选中表格行,单选按钮获取焦点
  function window.onload(){
	var coll=document.all.tags("TR");
	var collnum=coll.length
	var getTR=function(el){
		while(el.tagName!="TR"){el=el.parentElement}
		return el;
	}
	for(var i=0;i<collnum;i++){
		coll[i].attachEvent("onclick",function(){
			if (event.srcElement.tagName=="INPUT" 
				&& event) return event.cancelBubble=true
         //这里，根据你的checkbox所在的位置来修改，如果在最前面:
       getTR(event.srcElement).firstChild.firstChild
			var el= getTR(event.srcElement).firstChild.firstChild;
			el.checked=!el.checked
		})
	}
}
  
  //增加事件
 	function add()
	 {
	   	window.location.href = "pages/template/addTemplet.jsp";
	 }
  
  //删除事件
  function del()
  {
  	var con = confirm("确定是否删除!"); 
  	if (con == true)
  	{
  		  var o = document.getElementsByTagName('INPUT');   
          for(var i=0;i<o.length;i++)   
          {   
              if(o[i].type   ==   'radio'   &&   o[i].checked)  
              var param = o[i].value;
          }   
        document.all.from1.action = "";
	   	document.all.from1.action = "deleteTmpMg.action?method=delete&id="+param;
	   	document.all.from1.submit();
  	 }
  }
	 //修改事件
    function modity()
	{
		var o = document.getElementsByTagName('INPUT');   
          for(var i=0;i<o.length;i++)   
          {   
              if(o[i].type   ==   'radio'   &&   o[i].checked)  
              var param = o[i].value;
          }   
		document.all.from1.action = "";
	   	document.all.from1.action = "updateTmpMg.action?method=update&id="+param;
	   	document.all.from1.submit();
	}
	
	//刷新事件
	function refresh()
	{
		document.all.from1.action = "";
		document.all.from1.action = "tmpmgList.action";
		document.all.from1.submit();
	}
</script>
	
	<title>模板管理</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form action = "" method="post" class="x-form" name="from1">
				<div id="formPanel" style="width:750px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>模板管理</legend>
				  			
			  	 			<table border = "1" width = "700" bordercolor="#CCCCCC" cellpadding="1" cellspacing="1" align="center" >
			  	 				<thead>
			  	 				<tr>
			  	 					<td>操作</td>
			  	 					<td align="center" height="25px">模板编号</td>
			  	 					<td align="center">模板名称</td>
			  	 					<td align="center">模板格式</td>
			  	 					<td align="center">文本区域</td>
			  	 					<td align="center">图片区域</td>
			  	 					<td align="center">创建时间</td>
			  	 					<td align="center">修改时间</td>
			  	 					<td align="center">模板描述</td>
			  	 				</tr>
			  	 				</thead>
			  	 				<s:iterator id = "TmpMgs" value="%{#request.list}" status="st">
			  	 				<tr id = "aa" onclick="clicked();">
			  	 					<td ><input type = "radio"  name = "aa" value = "${templateId}"  /></td>
			  	 					<td align="center" ><s:property value= "templateId"/></td>
			  	 					<td align="center"><s:property value="templateName"/></td>
			  	 					<td align="center" ><s:property value="templateFormat"/></td>
			  	 					<td align="center"><s:property value="msgNumber"/></td>
			  	 					<td align="center" ><s:property value="picNumber"/></td>
			  	 					<td align="center" ><s:property value="crateDatetime"/></td>
			  	 					<td align="center" ><s:property value="chgDatetime"/></td>
			  	 					<td align="center" ><a href = "#">查询</a></td>
			  	 				</tr>
			  	 				</s:iterator>
			  	 			</table>
							 <div class = "x-form-item" align="right">
							    共1页2条记录，当前第1页
							   <a href="#">首页</a>
							   <a href="#">上一页</a>
							   <a href="#">下一页</a>
							   <a href="#">末页</a>
							 </div> 
							  
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  		 <div class="x-form-btn">
								<input type="button" value="增加"  class="btn" onclick="add();"/>
							</div> 
							<div class="x-form-btn">
								<input type="button" value="删除"  class="btn" onclick="del();"/>
							</div> 
							<div class="x-form-btn">
								<input type="button" value="修改"  class="btn" onclick="modity();"/>
							</div> 
							<div class="x-form-btn">
								<input type="button" value="刷新"  class="btn" onclick="refresh();"/>
							</div> 
							          
				  			<div style="clear:both"></div>
				  		</div> 
				  </div>
				  </div>
				  </div>
				<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>
			 </div>
			</form>
		   </div>
		<!-- foot -->		
		<!-- <div id="footer" class="footer"></div> -->
	</div>
  </body>
</html>
