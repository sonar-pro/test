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
			<!-- 打印规则编号-->
			var sms1 = new Ext.form.TextField({
				width:150
			});
			sms1.applyTo('sms1');
			
			<!-- 打印规则名称-->
			var sms2 = new Ext.form.TextField({
				width:150
			});
			sms2.applyTo('sms2');
			
	    Ext.get('formPanel');
	   });
	</script>
	<title>用户管理</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  action="#" method="post" class="x-form">
				<div id="formPanel" style="width:620px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
					 <legend>用户管理</legend>
				  	 	 <fieldset>
					  		<legend>部门管理</legend>
				  	 			<table width = "550" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC" align="center">
				  				<tr>
				  					<td>
				  						<table width="100%">
				  							<tr>
				  								<td align="left"><a href = "pages/system/addDept.jsp">增加</a></td>
				  								<td align="right">
								  					
													    共1页2条记录，当前第1页
													   <a href="#">首页</a>
													   <a href="#">上一页</a>
													   <a href="#">下一页</a>
													   <a href="#">末页</a>			
				  								</td>
				  							</tr>
				  						</table>
				  					</td>
				  				</tr>
				  				<tr>
				  					<td>
				  						<table  width="100%"  border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC">
				  							<tr>
				  								<td align="center" height="25px">部门编号</td>
				  								<td align="center" height="25px">部门名称</td>
				  								<td align="center" height="25px">状态</td>
				  								<td align="center" height="25px">创建时间</td>
				  								<td align="center" height="25px">最近创建时间</td>
				  								<td align="center" height="25px">操作</td>
				  						  	</tr>
				  						  	<s:iterator id = "DepartmentMgs" value="%{#request.list}" status="st">
				  							<tr >
				  								<td align="center" bgcolor="#CCCCCC"><s:property value= "deptId"/></td>
				  								<td align="center" bgcolor="#CCCCCC"><s:property value= "deptName"/></td>
				  								<td align="center" bgcolor="#CCCCCC"><s:property value= "deptState"/></td>
				  								<td align="center" bgcolor="#CCCCCC"><s:property value= "createDate"/></td>
				  								<td align="center" bgcolor="#CCCCCC"><s:property value= "latelyDate"/></td>
				  								<td align="center" bgcolor="#CCCCCC">
				  									<table>
				  										<tr>
				  											<td><a href="updateDept.action?id=${deptId}">修改</a></td>
				  											<td ><a href="deleteDept.action?id=${deptId}">删除</a></td>
				  										</tr>
				  									</table>
				  								</td>
				  							</tr>
				  							</s:iterator>
				  						</table>
				  					</td>
				  				</tr>
				  			</table>
					  	 </fieldset>
					     <fieldset>
					  	    <legend>用户管理</legend>
				  	 			<table width = "550" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC" align="center">
				  				<tr>
				  					<td>
				  						<table width="100%">
				  							<tr>
				  								<td align="left"><a href = "#">增加</a></td>
				  								<td align="right">
								  					
													    共1页2条记录，当前第1页
													   <a href="#">首页</a>
													   <a href="#">上一页</a>
													   <a href="#">下一页</a>
													   <a href="#">末页</a>			
				  								</td>
				  							</tr>
				  						</table>
				  					</td>
				  				</tr>
				  				<tr>
				  					<td>
				  						<table  width="100%" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC" align="center">
				  							<tr>
				  								<td align="center" height="25px">用户编号</td>
				  								<td align="center">姓名</td>
				  								<td align="center">部门</td>
				  								<td align="center">状态</td>
				  								<td align="center">角色</td>
				  								<td align="center">创建时间</td>
				  								<td align="center">最近创建时间</td>
				  								<td align="center">操作</td>
				  						  	</tr>
				  							<tr>
				  								<td align="center">001</td>
				  								<td align="center">小王</td>
				  								<td align="center">市场部</td>
				  								<td align="center">登录</td>
				  								<td align="center">个性化配置人员</td>
				  								<td align="center">20090206</td>
				  								<td align="center"> 20090207</td>
				  								<td align="center">
				  									<table>
				  										<tr>
				  											<td ><a href = "#">修改</a></td>
				  											<td><a href = "#">删除</a></td>
				  										</tr>
				  									</table>
				  								</td>
				  							</tr>
				  							<tr>
				  								<td align="center">002</td>
				  								<td align="center">小赵</td>
				  								<td align="center">作业部</td>
				  								<td align="center">登录</td>
				  								<td align="center">操作人员</td>
				  								<td align="center">20090206</td>
				  								<td align="center">20090207</td>
				  								<td align="center">
				  									<table>
				  										<tr>
				  											<td><a href = "#">修改</a></td>
				  											<td><a href = "#">删除</a></td>
				  										</tr>
				  									</table>
				  								</td>
				  							</tr>
				  						</table>
				  					</td>
				  				</tr>
				  			</table>
					     </fieldset>
					     <fieldset>
					  	    <legend>角色管理</legend>
				  	 			<table width = "550" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC" align="center">
				  				<tr>
				  					<td>
				  						<table width="100%">
				  							<tr>
				  								<td align="left"><a href = "#">增加</a></td>
				  								<td align="right">
								  					
													    共1页2条记录，当前第1页
													   <a href="#">首页</a>
													   <a href="#">上一页</a>
													   <a href="#">下一页</a>
													   <a href="#">末页</a>			
				  								</td>
				  							</tr>
				  						</table>
				  					</td>
				  				</tr>
				  				<tr>
				  					<td>
				  						<table  width="100%" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC" align="center">
				  							<tr>
				  								<td align="center" height="25px">角色编号</td>
				  								<td align="center">角色名称</td>
				  								<td align="center">状态</td>
				  								<td align="center">创建时间</td>
				  								<td align="center">最近创建时间</td>
				  								<td align="center">操作</td>
				  						  	</tr>
				  							<tr>
				  								<td align="center">001</td>
				  								<td align="center">个性化配置人员</td>
				  								<td align="center">登录</td>
				  								<td align="center">20090206</td>
				  								<td align="center"> 20090207</td>
				  								<td align="center">
				  									<table>
				  										<tr>
				  											<td ><a href = "#">修改</a></td>
				  											<td><a href = "#">删除</a></td>
				  										</tr>
				  									</table>
				  								</td>
				  							</tr>
				  							<tr>
				  								<td align="center">002</td>
				  								<td align="center">操作人员</td>
				  								<td align="center">登录</td>
				  								<td align="center">20090206</td>
				  								<td align="center">20090207</td>
				  								<td align="center">
				  									<table>
				  										<tr>
				  											<td><a href = "#">修改</a></td>
				  											<td><a href = "#">删除</a></td>
				  										</tr>
				  									</table>
				  								</td>
				  							</tr>
				  						</table>
				  					</td>
				  				</tr>
				  			</table>
					     </fieldset>		
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
