<%@ page language="java"  pageEncoding="utf-8"%>

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
			
			<!-- 模板格式-->
	      	var sms3 = new Ext.form.ComboBox({
	              typeAhead: true,
	              triggerAction: 'all',
	              transform:'sms3',
	              width:150,
	              forceSelection:true            	
	      	});
	      
	      	
			<!-- 模板编号-->
			var sms1 = new Ext.form.NumberField({
				width:150
			});
			sms1.applyTo('sms1');
			
			<!-- 模板名称-->
			var sms2 = new Ext.form.TextField({
				width:150
			});
			sms2.applyTo('sms2');
		
			
			<!-- 图片数量-->
			var sms4 = new Ext.form.NumberField({
				width:150
			});
			sms4.applyTo('sms4');
			
			<!-- 模板描述-->
			var sms5 = new Ext.form.TextField({
				width:150
			});
			sms5.applyTo('sms5');
			<!-- 模板描述-->
			var sms6 = new Ext.form.TextField({
				width:150
			});
			sms6.applyTo('sms6');
			
	      Ext.get('formPanel');
	   });
	   
	</script>
	
	<title>修改模板</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  action="tmpmgUpdate.action" method="post" class="x-form">
				<div id="formPanel" style="width:600px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				 <fieldset>
				  	<legend>修改模板</legend>
			  	 		<table width = "550">
			  	 			<tr>
			  	 				<td align="right">模板编号：</td>
			  	 				<td><input type="text" id="sms1" name="template_id" value = "${tmpmg.templateId}" />*</td>
			  	 				<td align="right">模板文件：</td>
			  	 				<td><input type="file" name="template_fname" value = "${tmpmg.templateFname}" /></td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">模板名称：</td>
			  	 				<td><input id="sms2" name="template_name" type="text" value = "${tmpmg.templateName}" /></td>
			  	 				<td align="right">校验文件：</td>
			  	 				<td><input type="file" name = "check_tmp_file" value = "${tmpmg.checkTmpFile}" /></td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">模板格式：</td>
			  	 				<td>
			  	 					<select id="sms3" name="template_format" >
									<option>AFP</option>
									<option>PDF</option>
									<option>PS</option>
									</select>
			  	 				</td>
			  	 				<td align="right">关联CA文件：</td>
			  	 				<td><input type="file"  name="ca_file" value = "${tmpmg.caFile}" /></td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">文本数量：</td>
			  	 				<td><input type="text" id="sms4" name="msg_number" value = "${tmpmg.msgNumber}" /></td>
			  	 				<td align="right">账单存储文件：</td>
			  	 				<td><input type="file" name="vault_tmp_file" value = "${tmpmg.vaultTmpFile}" /></td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">图片数量：</td>
			  	 				<td><input id="sms5" name="pic_number" type="text" value = "${tmpmg.picNumber}" /></td>
			  	 				<td align="right">电子账单存储文件：</td>
			  	 				<td><input type="file" name = "mail_tmp_file" value = "${tmpmg.mailTmpFile}" /></td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">模板描述：</td>
			  	 				<td><input id="sms6" name="tmp_desc" type="text" value = "${tmpmg.tmpDesc}" /></td>
			  	 			</tr>
			  	 		</table>
                  </fieldset>
						<div class="x-form-buttons" align="center">  
							<div class="x-form-btn">
								<input type="submit" value="修改"  class="btn">
							</div> 
				  			<div class="x-form-btn">  
								<input type="button" value="重置"  class="btn">
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
