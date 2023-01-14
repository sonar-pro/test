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
			
			<!-- 模板编号-->
			var sms3 = new Ext.form.TextField({
				width:150
			});
			sms3.applyTo('sms3');
			
			<!-- 个性化活动编号-->
			var sms4 = new Ext.form.TextField({
				width:150
			});
			sms4.applyTo('sms4');
			
			<!-- 个性化活动编号-->
			var sms5 = new Ext.form.TextField({
				width:150
			});
			sms5.applyTo('sms5');
			
			<!-- 个性化活动编号-->
			var sms6 = new Ext.form.TextField({
				width:150
			});
			sms6.applyTo('sms6');
			
			<!-- 打印规则编号-->
			var sms7 = new Ext.form.TextField({
				width:150
			});
			sms7.applyTo('sms7');
			
			<!-- 打印规则名称-->
			var sms8 = new Ext.form.TextField({
				width:150
			});
			sms8.applyTo('sms8');
			
			<!-- 模板编号-->
			var sms9 = new Ext.form.TextField({
				width:150
			});
			sms9.applyTo('sms9');
			
			<!-- 个性化活动编号-->
			var sms10 = new Ext.form.TextField({
				width:150
			});
			sms10.applyTo('sms10');
			
			<!-- 个性化活动编号-->
			var sms11 = new Ext.form.TextField({
				width:150
			});
			sms11.applyTo('sms11');
			
			<!-- 个性化活动编号-->
			var sms12 = new Ext.form.TextField({
				width:150
			});
			sms12.applyTo('sms12');
			<!-- 个性化活动编号-->
			var sms12 = new Ext.form.TextField({
				width:150
			});
			sms12.applyTo('sms12');
			<!-- 个性化活动编号-->
			var sms13 = new Ext.form.TextField({
				width:150
			});
			sms13.applyTo('sms13');
			<!-- 个性化活动编号-->
			var sms14 = new Ext.form.TextField({
				width:150
			});
			sms14.applyTo('sms14');
			<!-- 个性化活动编号-->
			var sms15 = new Ext.form.TextField({
				width:150
			});
			sms15.applyTo('sms15');
			<!-- 个性化活动编号-->
			var sms16 = new Ext.form.TextField({
				width:150
			});
			sms16.applyTo('sms16');
			<!-- 个性化活动编号-->
			var sms17 = new Ext.form.TextField({
				width:200
			});
			sms17.applyTo('sms17');
			<!-- 个性化活动编号-->
			var sms18 = new Ext.form.TextField({
				width:150
			});
			sms18.applyTo('sms18');
			
	    Ext.get('formPanel');
	   });
	</script>
	
	<title>系统参数配置</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form action="saveParam.action" method="post" class="x-form">
				<div id="formPanel" style="width:580px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				 <fieldset>
				 <legend>系统参数配置</legend>
				  <fieldset>
				  	<legend>ORACLE服务器配置</legend>
				  		<table width="500" align="center">
				  			<tr>
				  				<td align="right">服务器地址：</td>
				  				<td><input id="sms1" name="oracleServerAddress" type="text" /></td>
				  				<td align="right">用户名：</td>
				  				<td><input id="sms2" name="oracleUserName" type="text" /></td>
				  			</tr>
				  			<tr>
				  				<td align="right">密码：</td>
				  				<td><input id="sms3" name="oracleUserPws" type="text" /></td>
				  				<td align="right">主机字符串：</td>
				  				<td><input id="sms4" name="oracleName" type="text" /></td>
				  			</tr>
				  		</table>
				  </fieldset>
				   <fieldset>
				  	<legend>账单存储服务器配置</legend>
				  	
				  	<table width="500" align="center">
				  			<tr>
				  				<td align="right">服务器地址：</td>
				  				<td><input id="sms5" name="stroageServerAddress" type="text" /></td>
				  				<td align="right">用户名：</td>
				  				<td><input id="sms6" name="billStroageName" type="text" /></td>
				  			</tr>
				  			<tr>
				  				<td align="right">密码：</td>
				  				<td><input id="sms7" name="billStroagePws" type="text" /></td>
				  				<td align="right">加载目录：</td>
				  				<td><input id="sms8" name="billStroageDB" type="text" /></td>
				  			</tr>
				  		</table>
				  </fieldset>
				   <fieldset>
				  	<legend>Sagent服务器配置</legend>
				  	
				  	<table  width="500" align="center">
				  			<tr>
				  				<td align="right">Sagent用户名：</td>
				  				<td><input id="sms10" name="sagentName" type="text" /></td>
				  				<td align="right">Sagent密码：</td>
				  				<td><input id="sms11" name="sagentPws" type="text" /></td>
				  			</tr>
				  			<tr>
				  				<td align="right">数据库用户名：</td>
				  				<td><input id="sms12" name="sagentDB" type="text" /></td>
				  				<td align="right">数据库密码：</td>
				  				<td><input id="sms18" name="sagentDBPsw" type="text" /></td>
				  			</tr>
				  			<tr>
				  				<td align="right">服务器地址：</td>
				  				<td><input id="sms9" name="sagentServerAddress" type="text" /></td>
				  				<td></td>
				  				<td></td>
				  			</tr>
				  		</table>
				  </fieldset>
				   <fieldset>
				  	<legend>EN/EA服务器配置</legend>
				  	
				  	<table  width="500" align="center">
				  			<tr>
				  				<td align="right">服务器地址：</td>
				  				<td><input id="sms13" name="enServerAddress" type="text" /></td>
				  				<td align="right">用户名：</td>
				  				<td><input id="sms14" name="enUserName" type="text" /></td>
				  			</tr>
				  			<tr>
				  				<td align="right">工作目录：</td>
				  				<td><input id="sms15" name="enUserPws" type="text" /></td>
				  				<td align="right">主机字符串：</td>
				  				<td><input id="sms16" name="enDB" type="text" /></td>
				  			</tr>
				  		</table>
				  	</fieldset>
				  </fieldset>
				  <fieldset>
				  	<legend>密钥配置</legend>
				  		<table width = "365">
				  			<tr>
				  				<td align="right">密钥配置：</td>
				  				<td ><input id="sms17" name="des" type="text" /></td>
				  			</tr>
				  		</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			
							<div class="x-form-btn">
								<input type="submit" value="提交"  class="btn">
							</div> 
							<div class="x-form-btn">
								<input type="submit" value="取消"  class="btn">
							</div> 
							<div class="x-form-btn">
								<input type="submit" value="重置"  class="btn">
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
