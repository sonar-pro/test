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
			 var templetIdList = new Ext.form.ComboBox({
	              typeAhead: true,
	              triggerAction: 'all',
	              transform:'templetId1',
	              width:150,
	              forceSelection:true            	
	        });
	        
	         var templetIdList = new Ext.form.ComboBox({
	              typeAhead: true,
	              triggerAction: 'all',
	              transform:'templetId2',
	              width:150,
	              forceSelection:true            	
	        });
	        
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
			
			<!-- 模板编号-->
			var sms3 = new Ext.form.NumberField({
				width:150
			});
			sms3.applyTo('sms3');
			
			<!-- 个性化活动编号-->
			var sms4 = new Ext.form.NumberField({
				width:150
			});
			sms4.applyTo('sms4');
			
			<!-- 个性化活动编号-->
			var sms5 = new Ext.form.NumberField({
				width:150
			});
			sms5.applyTo('sms5');
			<!-- 个性化活动编号-->
			var sms6 = new Ext.form.NumberField({
				width:150
			});
			sms6.applyTo('sms6');
			
	    Ext.get('formPanel');
	   });
	</script>
	<title>增加用户</title>
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
				  	<legend>增加用户</legend>
			  	 		<table width="450">
				  			<tr>
				  				<td align="right">编号：</td>
				  				<td><input id="sms1" name="sms1" type="text" /></td>
				  				<td align="right">姓名：</td>
				  				<td><input id="sms2" name="sms2" type="text" /></td>
				  			</tr>
				  			<tr>
				  				<td align="right">部门：</td>
				  				<td>
				  					<select id="templetId1">
						                <option value="1" selected = "selected">市场部</option>
						                <option value="2">作业部</option>
						                <option value="3" >销售部</option>
					                </select>
				  				</td>
				  				<td align="right">角色：</td>
				  				<td>
				  					<select id="templetId2">
						                <option value="1">设计配置人员</option>
						                <option value="2">日常操作人员</option>
						                <option value="3" selected = "selected">系统管理员</option>
					                </select>
				  				</td>
				  			</tr>
				  			<tr>
				  				<td align="right">密码：</td>
				  				<td><input id="sms3" name="sms5" type="text" /></td>
				  				<td align="right">确认密码：</td>
				  				<td><input id="sms4" name="sms6" type="text" /></td>
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
