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
			 var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('creditCardId');
		   var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('month');
		   var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('idCardNo');
		   var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('month1');
		  
	    Ext.get('formPanel');
	   });
	</script>
  <title>账单查询</title>
  </head>
  
  <body>
    <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form id="billSearch" action="#" method="post" class="x-form">
				<div id="formPanel" style="width:550px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>查询条件</legend>
			  	 			<table border="0" width = "500">
			  	 				<tr>
			  	 					<td><input id = "radioQuery1" name = "radioQuery" type = "radio" checked = "checked"></td>
			  	 					<td align="right">信用卡号：</td>
			  	 					<td><input id = "creditCardId" name = "creditCardId" type = "text" value = "" size = "15"></td>
			  	 					<td align="right">月份：</td>
			  	 					<td><input id = "month" name = "month" type = "text" value = "" size = "15"></td>
			  	 				</tr>
			  	 				<tr>
			  	 					<td><input id = "radioQuery2" name = "radioQuery" type = "radio" value = ""></td>
			  	 					<td align="right">身份证号：</td>
			  	 					<td><input id = "idCardNo" name = "idCardNo" type = "text" value = "" size = "15"></td>
			  	 					<td align="right">月份：</td>
			  	 					<td><input id = "month1" name = "month1" type = "text" value = "" size = "15"></td>
			  	 					
			  	 				</tr>
			  	 			</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="submit" value="查询"  class="btn">
							</div> 
				  			<div class="x-form-btn">  
								<input type="reset" value="重设"  class="btn">
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
	<hr width="550" align="left">
	<div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form id="billSearch" action="#" method="post" class="x-form">
				<div id="formPanel" style="width:550px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>身份证查询结果</legend>
			  	 			<table border="1" width = "500" bordercolor="#CCCCCC" cellpadding="1" cellspacing="1">
			  	 				<tr>
			  	 					<td align="center">序号</td>
			  	 					<td align="center">信用卡号</td>
			  	 					<td align="center">操作</td>
			  	 				</tr>
			  	 				<tr>
			  	 					<td align="center">1</td>
			  	 					<td align="center">1000000000000001</td>
			  	 					<td align="center"><a href = "#">查询</a></td>
			  	 				</tr>
			  	 				<tr>
			  	 					<td align="center">2</td>
			  	 					<td align="center">1000000000000002</td>
			  	 					<td align="center"><a href = "#">查询</a></td>
			  	 				</tr>
			  	 				<tr>
			  	 					<td align="center">3</td>
			  	 					<td align="center">1000000000000003</td>
			  	 					<td align="center"><a href = "#">查询</a></td>
			  	 				</tr>
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
