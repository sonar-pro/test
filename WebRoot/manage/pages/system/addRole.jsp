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
			var sms1 = new Ext.form.NumberField({
				width:150
			});
			sms1.applyTo('sms1');
			
			<!-- 打印规则名称-->
			var sms2 = new Ext.form.NumberField({
				width:150
			});
			sms2.applyTo('sms2');
		
	    Ext.get('formPanel');
	   });
	</script>
	<title>增加角色</title>
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
				  	<legend>增加角色</legend>
			  	 		<table width="450">
				  			<tr>
				  				<td align="right">角色编号：</td>
				  				<td><input id="sms1" name="sms1" type="text" /></td>
				  				<td align="right">角色姓名：</td>
				  				<td><input id="sms2" name="sms2" type="text" /></td>
				  			</tr>
				  			<tr>
				  		</table>
				  </fieldset>
				  
				  <fieldset>
				  	<legend>权限选择</legend>
			  	 		<table width="450">
				  			<tr>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>用户管理</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>模板管理</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>打印规则设置</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>打印账单抽样</td>
				  			</tr>
				  			<tr>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>系统参数设置</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>个性化活动设置</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>打印作业管理</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>账单合成分发</td>
				  			</tr>
				  			<tr>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>EM参数配置</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>个性化活动审核</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>账单数据处理</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>电子账单发送</td>
				  			</tr>
				  			<tr>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>账单存储加载</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>账单查询下载</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>统计报表查询下载</td>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>账单补打</td>
				  			</tr>
				  			<tr>
				  				<td><input id = "" name = "" type = "checkbox" /></td>
				  				<td>退信管理</td>
				  				<td></td>
				  				<td></td>
				  				<td></td>
				  				<td></td>
				  				<td></td>
				  				<td></td>
				  			</tr>
				  		</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="submit" value="确认"  class="btn">
							</div> 
							<div class="x-form-btn">
								<input type="submit" value="取消"  class="btn">
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
