<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import = "java.util.*" %>

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
			
			<!-- 账单类型-->
	      	var billTypeList = new Ext.form.ComboBox({
	              typeAhead: true,
	              triggerAction: 'all',
	              transform:'bill_id',
	              width:150,
	              forceSelection:true            	
	      	});
	      	
	      	<!--个性化规则 -->
	      	var individuationRuleList = new Ext.form.ComboBox({
	              typeAhead: true,
	              triggerAction: 'all',
	              transform:'individuation_rule',
	              width:150,
	              forceSelection:true            	
	      	});
	      	
	      	<!--个性化规则 -->
	      	var sms5 = new Ext.form.ComboBox({
	              typeAhead: true,
	              triggerAction: 'all',
	              transform:'sms5',
	              width:150,
	              forceSelection:true            	
	      	});
	      
			<!-- 打印规则编号-->
			var sms1 = new Ext.form.NumberField({
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
			
	      Ext.get('formPanel');
	   });
	   
	  function add()
	   {
	   		document.all.from1.action = "";
	 		document.all.from1.action = "printRuleUpdate.action?method=printRuleUpdate";
	   		document.all.from1.submit();
	   }
	   
	</script>
	
	<title>打印规则添加</title>
  </head>
  
  <%
	  List list1 = (List)request.getAttribute("templetIds");
 	  List list2 = (List)request.getAttribute("activeIds");
  %>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form name = "from1" action="" method="post" class="x-form">
				<div id="formPanel" style="width:500px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				 <fieldset>
				  	<legend>打印规则修改</legend>
			  	 		<table align="center">
			  	 			<tr>
			  	 				<td align="right">打印规则编号：</td>
			  	 				<td><input id="sms1" name="prt_rule_id" type="text" size="12" value = "${printRule.prtRuleId}" />*</td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">打印规则名称：</td>
			  	 				<td><input id="sms2" name="prt_rule_name" type="text" size="12" value = "${printRule.prtRuleName}" /></td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">账单模板编号：</td>
			  	 				<td>
			  	 				<!-- onchange = "getBillId();" -->
					  	 			<select id="bill_id" name = "template_id" >
						  	 			<%
						  	 				if (list1 != null) {
										  		for (int i = 0;i<list1.size();i++){
										  		
						  	 			 %>
						  	 				<option value="<%=list1.get(i) %>"><%=list1.get(i) %></option>
						  	 			<%
						  	 				}
						  	 				}
						  	 			 %>
									</select>
			  	 				</td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">账单模板名称：</td>
			  	 				<td><input id="sms3" name="template_name" type="text" size="12" /></td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">插页广告规则编号：</td>
			  	 				<td>
			  	 					<select id="individuation_rule" name = "adv_action_id">
				  	 					<%
				  	 						if (list2 != null){
				  	 						for (int i = 0;i<list2.size();i++){
				  	 					 %>
											<option  value="<%=list2.get(i) %>"><%=list2.get(i) %></option>
										<%
											}
											}
										 %>
									</select>
			  	 				</td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">插页广告规则名称：</td>
			  	 				<td><input id="sms4" name="adv_action_name" type="text" size="12" /></td>
			  	 			</tr>
			  	 			<tr> 
			  	 				<td align="right">启用标志：</td>
			  	 				<td>
			  	 					<select id="sms5" name = "use_flag">
									<option value="1" selected = "selected">启用</option>
									<option value="0">禁用</option>
									</select>
			  	 				</td>
			  	 			</tr>
			  	 			<tr>
			  	 				<td align="right">产品代码：</td>
			  	 				<td><input type = "button" value = "查看" class = "btn"></td>
			  	 			</tr>
			  	 		</table>
				 	 </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="submit" value="修改"  class="btn" onclick="add();">
							</div> 
				  			<div class="x-form-btn">  
								<input type="reset" value="重置"  class="btn">
							</div>     
							<div class="x-form-btn">
								<input type="button" value="返回"  class="btn" onclick="javascript:history.go(-1);">
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
