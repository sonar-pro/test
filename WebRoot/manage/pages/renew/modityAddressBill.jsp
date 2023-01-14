<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <meta name="Keywords" content="your, keywords" />
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
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
			    <!--信用卡号-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('creditCardId');
		  
		  <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('month');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('oldPostalcode');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('newPostalcode');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('oldAddress1');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('newAddress1');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('oldAddress2');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('newAddress2');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('oldAddress3');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('newAddress3');
		  
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('oldAddress4');
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('newAddress4');
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('oldAddress5');
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('newAddress5');
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('oldConsignee');
		   <!--月份-->
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('newConsignee');
		 
		  
		  
	      Ext.get('formPanel');
	   });
	</script>
	
	<title>地址修改补寄账单</title>

  </head>
  
  <body>
    <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form id="billSearch" action="#" method="post" class="x-form">
				<div id="formPanel" style="width:500px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>查询条件</legend>
			  	 			<div class="x-form-item">
			  	 				信用卡号：<input id = "creditCardId" name="creditCardId" type = "text" value="">
			  	 				月份：<input id = "month" name = "month" type = "text" value = "" >
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
	<hr align="left" width="500">
	 <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form id="billSearch" action="#" method="post" class="x-form">
				<div id="formPanel" style="width:500px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>地址修改补寄</legend>
				  		<table width="450" border="0">
				  			<tr>
				  				<td colspan="2" align="center">当前账单地址</td>
				  				<td colspan="2" align="center">新账单地址</td>
				  				<td></td>
				  				<td></td>
				  			</tr>
				  			<tr>
				  				<td align="right">邮编：</td>
				  				<td><input id = "oldPostalcode"  name="oldPostalcode" type = "text" value="" size = "15">
				  				</td>
				  				<td align="right">邮编：</td>
				  				<td align="left">
				  				<input id = "newPostalcode" name="newPostalcode" type = "text" value="" size = "15">
				  				</td>
				  			</tr>
				  			<tr>
				  				<td align="right">地址1：</td>
				  				<td><input id = "oldAddress1" name="oldAddress1" type = "text" value="" size = "15"></td>
				  				<td align="right">地址1：</td>
				  				<td><input id = "newAddress1" name="newAddress1" type = "text" value="" size = "15"></td>
				  			</tr>
				  			<tr>
				  				<td align="right">地址2：</td>
				  				<td ><input id = "oldAddress2" name="oldAddress2" type = "text" value="" size = "15"></td>
				  				<td align="right">地址2：</td>
				  				<td><input id = "newAddress2" name="newAddress2" type = "text" value="" size = "15"></td>
				  			</tr>
				  			<tr>
				  				<td align="right">地址3：</td>
				  				<td><input id = "oldAddress3" name="oldAddress3" type = "text" value="" size = "15"></td>
				  				<td align="right">地址3：</td>
				  				<td><input id = "newAddress3" name="newAddress3" type = "text" value="" size = "15"></td>
				  			</tr>
				  			<tr>
				  				<td align="right">地址4：</td>
				  				<td><input id = "oldAddress4" name="oldAddress4" type = "text" value="" size = "15"></td>
				  				<td align="right">地址4：</td>
				  				<td><input id = "newAddress4" name="newAddress4" type = "text" value="" size = "15"></td>
				  			</tr>
				  			<tr>
				  				<td align="right">地址5：</td>
				  				<td><input id = "oldAddress5" name="oldAddress5" type = "text" value="" size = "15"></td>
				  				<td align="right">地址5：</td>
				  				<td><input id = "newAddress5" name="newAddress5" type = "text" value="" size = "15"></td>
				  			</tr>
				  			<tr>
				  				<td align="right">收件人：</td>
				  				<td><input id = "oldConsignee" name="oldConsignee" type = "text" value="" size = "15"></td>
				  				<td align="right">收件人：</td>
				  				<td><input id = "newConsignee" name="newConsignee" type = "text" value="" size = "15"></td>
				  			</tr>
				  		</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="submit" value="确定"  class="btn">
							</div> 
				  			<div class="x-form-btn">  
								<input type="reset" value="重设"  class="btn">
							</div>    
							<div class="x-form-btn">  
								<input type="submit" value="生成"  class="btn">
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
