<%@ page language="java" pageEncoding="utf-8"%>

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
		
		<!--账单统计类型 -->
			 var billTypeList = new Ext.form.ComboBox({
	              typeAhead: true,
	              triggerAction: 'all',
	              transform:'billDayStatType',
	              width:180,
	              forceSelection:true            	
	      });
	      
	      <!--账单日 -->
	       var account = new Ext.form.TextField({
		  	width:180
		  });
		  account.applyTo('billDayDate');
		  
	    Ext.get('formPanel');
	   });
	</script>
	
	<title>日统计报表查询</title>
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
				  	<legend>账单统计查询条件</legend>
			  	 		<div class = "x-form-item">
			  	 			<label for = "billDayDate"><div align="right">账单日：</div></label>
			  	 			<input id = "billDayDate" name = "billDayDate" type = "text" value = "">
			  	 		</div>
			  	 		<div class="x-form-item">					
						<label for="billDayStatType"><div align="right">账单统计类型：</div></label>
					    <select id="billDayStatType">
					    	<option value="0" selected>账单制作统计日报表</option>
							<option value="1">账单页数统计日报表</option>
							<option value="2">电子账单发送统计日报表</option>
							<option value="3">数据处理日报表</option>
						</select>
					</div>
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
  </body>
</html>
