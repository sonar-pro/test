<%@ page language="java"  pageEncoding="utf-8"%>

<html>
  <head>
 	<meta name="Keywords" content="your, keywords" />
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312"/>
	<meta name="Distribution" content="Global" />
	<meta name="Robots" content="index,follow" />

	<link rel="stylesheet" type="text/css" href="../../../styles/table.css" />
	<link rel="stylesheet" type="text/css" href="../../../styles/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="../../../styles/cms.css" />
	<script type="text/javascript" src="../../../scripts/jquery/jquery.js"></script>
	<script type="text/javascript" src="../../../scripts/jquery/jquery-plugins.js"></script>
	<script type="text/javascript" src="../../../scripts/jquery/ext-jquery-adapter.js"></script>
	<script type="text/javascript" src="../../../scripts/ext-all.js"></script>
	
	<script type="text/javascript">
		Ext.onReady(function(){
			
	    Ext.get('formPanel');
	   });
	</script>
	
	<title>电子账单生成</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form id="billSearch" action="#" method="post" class="x-form">
				<div id="formPanel" style="width:600px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>电子账单生成</legend>
				  			
			  	 			<table width = "550" border="1" cellpadding="1" cellspacing="1" bordercolor="#CCCCCC">
			  	 			
			  	 				<thead>
			  	 				<tr>
			  	 					<td><input id = "" name = "" type = "checkbox" value = "">全选</td>
			  	 					<td align="center">作业编号</td>
			  	 					<td align="center">产品编号</td>
			  	 					<td align="center">账单日</td>
			  	 					<td align="center">模板名称</td>
			  	 					<td align="center">数据处理</td>
			  	 					<td align="center">电子账单生成</td>
			  	 					<td align="center">处理日志</td>
			  	 				</tr>
			  	 				</thead>
			  	 				<tr>
			  	 					<td align="center"><input id = "" name = "" type = "checkbox" value = ""></td>
			  	 					<td align="center">000001</td>
			  	 					<td align="center">0022</td>
			  	 					<td align="center">20090206</td>
			  	 					<td align="center">普卡</td>
			  	 					<td align="center">完成</td>
			  	 					<td align="center">处理中</td>
			  	 					<td align="center"></td>
			  	 					</tr>
			  	 				<tr>
			  	 					<td align="center"><input id = "" name = "" type = "checkbox" value = ""></td>
			  	 					<td align="center">000002</td>
			  	 					<td align="center">0023</td>
			  	 					<td align="center">20090207</td>
			  	 					<td align="center">白金卡</td>
			  	 					<td align="center">完成</td>
			  	 					<td align="center">完成</td>
			  	 					<td align="center"><a href = "#">查询</a></td>
			  	 					<td></td>		  	 				
			  	 				</tr>			  	 			
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
								<input type="submit" value="电子账单生成"  class="btn">
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
