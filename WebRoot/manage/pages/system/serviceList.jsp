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
	</script>
	
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  action="pintInstList.action" method="post" class="x-form">
				<div id="formPanel" style="width:600px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				 
				 <fieldset>
				  	<legend>服务商配置</legend>
				  			
				  			<table width = "550" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC">
				  				<tr>
				  					<td>
				  						<table width="100%">
				  							<tr>
				  								<td align="left"><a href = "pages/system/addService.jsp">增加</a></td>
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
				  						<table  width="100%" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC">
				  							<tr>
				  								<td align="center">打印服务商编号</td>
				  								<td align="center">服务商名称</td>
				  								<td align="center">状态</td>
				  								<td align="center">FTP服务器</td>
				  								<td align="center">用户名</td>
				  								<td align="center">密码</td>
				  								<td align="center">操作</td>
				  							</tr>
				  							<s:iterator id = "printInst" value="%{#request.list}" status="st">
				  							<tr>
				  								<td align="center"><s:property value= "institutionId"/></td>
				  								<td align="center"><s:property value= "institutionName"/></td>
				  								<td><s:property value= "institutionState"/></td>
				  								<td><s:property value= "ftpServer"/></td>
				  								<td><s:property value= "userName"/></td>
				  								<td><s:property value= "userPws"/></td>
				  								<td align="center">
				  									<table>
				  										<tr>
				  											<td ><a href="deletePrint.action?id=${institutionId}">删除</a></td>
				  											<td><a href="updatePrint.action?id=${institutionId}">修改</a></td>
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
				 
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="submit" value="确认"  class="btn">
							</div> 
				  			<div class="x-form-btn">  
								<input type="reset" value="重置"  class="btn">
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
