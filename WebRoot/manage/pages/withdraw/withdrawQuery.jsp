<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
 	<meta name="Keywords" content="your, keywords" />
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312"/>
	<meta name="Distribution" content="Global" />
	<meta name="Robots" content="index,follow" />

	<link rel="stylesheet" type="text/css" href="../../../styles/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="../../../styles/table.css" />
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
		  customerNo.applyTo('creditCardNo');
		  
		  var customerNo = new Ext.form.TextField({
		  	width:150
		  });
		  customerNo.applyTo('queryDate');
		  
	    Ext.get('formPanel');
	   });
	   
	   function query()
	   {
	   	  var o = document.getElementsByTagName('INPUT');   
          for(var i=0;i<o.length;i++)   
          {   
              if(o[i].type == 'radio' && o[i].checked)  
              var param = o[i].value;
              if (param == 'radioQuery1')
              {
              	document.all.from1.action = "";
	   			document.all.from1.action = "findById.action?method=findById";
	   			document.all.from1.submit();
              }
              if (param == 'radioQuery2')
              {
              	document.all.from1.action = "";
	   			document.all.from1.action = "findByDate.action?method=findByDate";
	   			document.all.from1.submit();
              }
          }   
	   }
	  
	</script>
	<title>退信账单查询</title>
  </head>
  
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
				  	<legend>查询条件</legend>
					  			<table>
					  				<tr>
					  					<td><input value = "radioQuery1" name = "radioQuery" type = "radio" checked = "checked" /></td>
					  					<td>信用卡卡号：</td>
					  					<td><input id = "creditCardNo" name = "card_no" type = "text" /></td>
					  				</tr>
					  				<tr>
					  					<td><input value ="radioQuery2" name = "radioQuery" type = "radio" /></td>
					  					<td>账期：</td>
					  					<td><input id = "queryDate" name = "bill_date" type = "text" /></td>
					  				</tr>
					  			</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="button" value="报表查询" class="btn" onclick="query();">
							</div> 
				  			<div class="x-form-btn">  
								<input type="button" value="报表导出"  class="btn">
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
	<hr width="500" align="left">
	<div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form id="billSearch" action="#" method="post" class="x-form">
				<div id="formPanel" style="width:500px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>退信账单查询结果</legend>
			  	 		<table border="1" width = "450" bordercolor="#CCCCCC" cellpadding="1" cellspacing="1">
			  	 			<thead>
			  	 			<tr>
			  	 				<td align="center" height="25px">卡号</td>
			  	 				<td align="center">账期</td>
			  	 				<td align="center">导入时间</td>
			  	 			</tr>
			  	 			</thead>
			  	 			<s:iterator value="%{#request.list}" status="st">
			  	 			<tr>
			  	 				<td align="center" bgcolor="#cccccc"><s:property value= "cardNo"/></td>
			  	 				<td align="center" bgcolor="#cccccc"><s:property value= "billDate"/></td>
			  	 				<td align="center" bgcolor="#cccccc"><s:property value= "exportTime"/></td>
			  	 			</tr>
			  	 			</s:iterator>
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
