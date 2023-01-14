<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
 	<meta name="Keywords" content="your, keywords" />
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312"/>
	<meta name="Distribution" content="Global" />
	<meta name="Robots" content="index,follow" />

	<link rel="stylesheet" type="text/css" href="../../../styles/table.css" />
	<link rel="stylesheet" type="text/css" href="../.../../styles/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="../../../styles/cms.css" />
	<script type="text/javascript" src="../../../scripts/jquery/jquery.js"></script>
	<script type="text/javascript" src="../../../scripts/jquery/jquery-plugins.js"></script>
	<script type="text/javascript" src="../../../scripts/jquery/ext-jquery-adapter.js"></script>
	<script type="text/javascript" src="../../../scripts/ext-all.js"></script>
	
	<script type="text/javascript">
		Ext.onReady(function(){
			var sms1 = new Ext.form.TextField({
				width:150
			});
			sms1.applyTo('sms1');
			
			var sms2 = new Ext.form.TextField({
				width:150
			});
			sms2.applyTo('sms2');
			
			var sms3 = new Ext.form.TextField({
				width:150
			});
			sms3.applyTo('sms3');
			
			var sms4 = new Ext.form.TextField({
				width:150
			});
			sms4.applyTo('sms4');
			
			var sms5 = new Ext.form.TextField({
				width:150
			});
			sms5.applyTo('sms5');
			
			var sms6 = new Ext.form.TextField({
				width:150
			});
			sms6.applyTo('sms6');
	    Ext.get('formPanel');
	   });
	</script>
	<title>修改服务商</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  action="pintInstUpdate.action" method="post" class="x-form">
				<div id="formPanel" style="width:550px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>修改服务商</legend>
			  	 		<table width="500">
				  			<tr>
				  				<td align="right">服务商编号：</td>
				  				<td><input type="text" id = "sms1" name="institution_id" value="${printIns.institutionId}" /></td>
				  				<td align="right">服务商名称：</td>
				  				<td><input type="text" id = "sms2" name="institution_name" value="${printIns.institutionName}"></td>
				  			</tr>
				  			<tr>
				  			<td align="right">服务商状态：</td>
				  				<td><input type="text" id = "sms6" name="institution_state" value="${printIns.institutionState}"></td>
				  				<td align="right">FTP服务器：</td>
				  				<td><input type="text" id = "sms5" name="ftp_server" value="${printIns.ftpServer}"></td>
				  			</tr>
				  			<tr>
				  				<td align="right">服务商用户名：</td>
				  				<td><input type="text" id = "sms3" name="user_name" value="${printIns.userName}"></td>
				  				<td align="right">服务商密码：</td>
				  				<td><input type="text" id = "sms4" name="user_pws" value="${printIns.userPws}"></td>
				  			</tr>
				  		</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
				  				<input type="submit" value="确认"  class="btn">
							</div> 
							<div class="x-form-btn">
								<input type="button" value="取消"  class="btn">
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
