<%@ page language="java"  pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	    Ext.get('formPanel');
	   });
	</script>
  <title>账单查询结果</title>
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
				  	<legend>账单查询</legend>
			  	 			<table border="0" width = "450">
			  	 				<tr>
			  	 					<td>信用卡号：</td>
			  	 					<td>
			  	 					<div class = "x-form-item">
			  	 					<input id = "creditCardId" name = "creditCardId" type = "text" value = "" size = "15">
			  	 					</div>
			  	 					</td>
			  	 					<td>月份：</td>
			  	 					<td>
			  	 					<div class = "x-form-item">
			  	 					<input id = "month" name = "month" type = "text" value = "" size = "15">
			  	 					</div>
			  	 					</td>
			  	 				</tr>
			  	 			</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
						    <div class="x-form-btn">
								<input type="submit" value="下载"  class="btn">
							</div> 
							<div class="x-form-btn">
								<input type="submit" value="打印"  class="btn">
							</div> 
							<div class="x-form-btn">
								<input type="submit" value="电邮"  class="btn">
							</div> 
							<div class="x-form-btn">
								<input type="submit" value="查询"  class="btn">
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
	
	
	<div id="tablePanel" class="datagrid">
    	<div id="title" class="title-panel">
			<div class="float-left"><b>账单查询结果</b></div>
			<div class="float-right"></div>   				
			<div style="clear:both"></div>
		</div>
		
		<div id="datagridPanel" class="data-panel">				
	        <img src="../../IMAGES/zhangdan.gif" width="400" />
		</div>
		<div id="pagingPanel" class="paging-panel">
		  <form>
		   <div class="paging-item-left">共有3页，当前为第1页</div>
		   <div class="paging-item-right"><img src="../../images/go.gif" width="16" height="16"/></div>
		   <div class="paging-item-right"><span>到第</span><input type="text" size="3" maxlength="10" class="box"/><span>页</span></div>
		   <div class="paging-item-right"><span>每页</span><input type="text" size="3" maxlength="10" class="box"/></div>
		   <div class="paging-item-right"><a href="#">末页</a></div>
		   <div class="paging-item-right"><a href="#">下一页</a></div>
		   <div class="paging-item-right"><a href="#">上一页</a></div>
		   <div class="paging-item-right"><a href="#">首页</a></div>
		 </form>
		  <div style="clear:both"></div>
		</div>
	</div>
	
  </body>
</html>
