<%@ page language="java"  pageEncoding="utf-8"%>

<html>
  <head>
 	<meta name="Keywords" content="your, keywords" />
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312"/>
	<meta name="Distribution" content="Global" />
	<meta name="Robots" content="index,follow" />

	<link rel="stylesheet" type="text/css" href="../../../styles/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="../../../styles/cms.css" />
	<script type="text/javascript" src="../../../scripts/jquery/jquery.js"></script>
	<script type="text/javascript" src="../../../scripts/jquery/jquery-plugins.js"></script>
	<script type="text/javascript" src="../../../scripts/jquery/ext-jquery-adapter.js"></script>
	<script type="text/javascript" src="../../../scripts/ext-all.js"></script>
	
	<script type="text/javascript">
		Ext.onReady(function(){
			
	    Ext.get('formPanel').center();
	   });
	</script>
	
	<title>账单数据流加载</title>
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
				  	<legend>账单数据流加载</legend>
				  			
			  	 			<table border = "1" width = "550" bordercolor="#CCCCCC" cellpadding="1" cellspacing="1" >
			  	 				<thead>
			  	 				<tr>
			  	 					<td><input id = "" name = "" type = "checkbox" value = "">全选</td>
			  	 					<td>作业编号</td>
			  	 					<td>产品编号</td>
			  	 					<td align="center">账单日</td>
			  	 					<td>数据处理</td>
			  	 					<td>合成/分发</td>
			  	 					<td>数据加载</td>
			  	 					<td>加载日志</td>
			  	 				</tr>
			  	 				</thead>
			  	 				<tr>
			  	 					<td><input id = "" name = "" type = "checkbox" value = ""></td>
			  	 					<td>0000001</td>
			  	 					<td>0022</td>
			  	 					<td>20090120</td>
			  	 					<td>完成</td>
			  	 					<td>完成</td>
			  	 					<td>处理中</td>
			  	 					<td></td>
			  	 				</tr>
			  	 				<tr>
			  	 					<td><input id = "" name = "" type = "checkbox" value = ""></td>
			  	 					<td>0000002</td>
			  	 					<td>0032</td>
			  	 					<td>20090122</td>
			  	 					<td>完成</td>
			  	 					<td>完成</td>
			  	 					<td>完成</td>
			  	 					<td>查询</td>
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
								<input type="submit" value="数据加载"  class="btn">
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
