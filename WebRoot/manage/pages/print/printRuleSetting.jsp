<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
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
		Ext.get('formPanel');
	   });
	    //增加事件
 	function add()
	 {
	 	document.all.from1.action = "";
	 	document.all.from1.action = "getAllTempletId.action?method=getAllTempletId";
	   	document.all.from1.submit();
	   	
	   <!--	window.location.href = "pages/print/addPrintRule.jsp";-->
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
	   	document.all.from1.action = "deletePrintRule.action?method=delete&id="+param;
	   	document.all.from1.submit();
  	 }
  }
	 //修改事件
    function modity()
	{
		var o = document.getElementsByTagName('INPUT');   
          for(var i=0;i<o.length;i++)   
          {   
              if(o[i].type   ==   'radio' && o[i].checked)  
              var param = o[i].value;
          }   
		document.all.from1.action = "";
	   	document.all.from1.action = "updatePrintRule.action?method=update&id="+param;
	   	document.all.from1.submit();
	}
	
	//刷新事件
	function refresh()
	{
		document.all.from1.action = "";
		document.all.from1.action = "printRuleList.action";
		document.all.from1.submit();
	}
	
	
	</script>
	
	<title>打印规则设定</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form name = "from1" action="" method="post" class="x-form">
				<div id="formPanel" style="width:750px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>打印规则设定</legend>
				  			
			  	 			<table width = "700" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC">
			  	 			
			  	 				<thead>
			  	 				<tr>
			  	 					<td height="25px" align="center">操作</td>
			  	 					<td align="center">打印规则编号</td>
			  	 					<td align="center">打印规则名称</td>
			  	 					<td align="center">账单模板编号</td>
			  	 					<td align="center">插页活动编号</td>
			  	 					<td align="center">产品代码</td>
			  	 					<td align="center">创建时间</td>
			  	 					<td align="center">修改时间</td>
			  	 					<td align="center">启用标志</td>
			  	 				</tr>
			  	 				</thead>
			  	 				<s:iterator id = "PrintRules" value="%{#request.list}" status="st">
			  	 				<tr>
			  	 					<td align="center"><input  type = "radio"  name = "aa" value = "${prtRuleId}"></td>
			  	 					<td bgcolor="#cccccc" align="center"><s:property value= "prtRuleId"/></td>
			  	 					<td bgcolor="#cccccc" align="center"><s:property value= "prtRuleName"/></td>
			  	 					<td bgcolor="#cccccc" align="center"><s:property value= "templateId"/></td>
			  	 					<td bgcolor="#cccccc" align="center"><s:property value= "advActionId"/></td>
			  	 					<td bgcolor="#cccccc" align="center"><a href = "#">查看</a></td>
			  	 					<td bgcolor="#cccccc" align="center"><s:property value= "createDatetime"/></td>
			  	 					<td bgcolor="#cccccc" align="center"><s:property value= "chgDatetime"/></td>
			  	 					<td bgcolor="#cccccc" align="center"><s:property value= "useFlag"/></td>
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
