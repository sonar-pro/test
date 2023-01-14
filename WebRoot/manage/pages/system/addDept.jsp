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
			
	    Ext.get('formPanel');
	   });
	   
	   function Cancel()
	   {
	   		window.close();
	   }
	   
	</script>
	<title>增加部门</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form action="saveDept.action" method="post" class="x-form">
				<div id="formPanel" style="width:300px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>增加部门</legend>
				  		<div>
				  			<label for="x-form-item">部门编号：</label>
				  			<input id = "sms1" name = "dept_id" type = "text" />
				  			
				  		</div>
				  		<div>
				  			<label for="x-form-item">部门名称：</label>
				  			<input id = "sms2" name = "dept_name" type = "text" />
				  		</div>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="submit" value="增加"  class="btn"/>
							</div> 
							<div class="x-form-btn">
								<input type="button" value="取消"  class="btn" onclick="Cancel();"/>
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
