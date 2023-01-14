<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <title>My JSP 'MyJsp.jsp' starting page</title>

	<link rel="stylesheet" type="text/css" href="../../styles/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="../../styles/table.css" />
	<link rel="stylesheet" type="text/css" href="../../styles/cms.css" />
	<script type="text/javascript" src="../../scripts/jquery/jquery.js"></script>
	<script type="text/javascript" src="../../scripts/jquery/jquery-plugins.js"></script>
	<script type="text/javascript" src="../../scripts/jquery/ext-jquery-adapter.js"></script>
	<script type="text/javascript" src="../../scripts/ext-all.js"></script>
  </head>
  
  <body>
    <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
		<form action="findById.action">
				<div id="formPanel" style="width:500px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>退信账单查询结果</legend>
			  	 		<table border="1" width = "450" bordercolor="#CCCCCC" cellpadding="1" cellspacing="1" align="center">
			  	 			<thead>
			  	 			<tr>
			  	 				<td>卡号</td>
			  	 				<td>账期</td>
			  	 				<td>导入时间</td>
			  	 			</tr>
			  	 			</thead>
			  	 			<s:iterator id = "WithdrawManagers" value="%{#request.list}" status="st">
			  	 			<tr>
			  	 				<td><s:property value= "cardNo"/></td>
			  	 				<td><s:property value= "billDate"/></td>
			  	 				<td><s:property value= "exportTime"/></td>
			  	 			</tr>
			  	 			</s:iterator>
			  	 		</table>
			  	 		<div class = "x-form-item" align="right">
							    共1页3条记录，当前第1页
							   <a href="#">首页</a>
							   <a href="#">上一页</a>
							   <a href="#">下一页</a>
							   <a href="#">末页</a>
						</div>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			          
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
