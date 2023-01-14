<%@ page language="java" pageEncoding="utf-8"%>

<html>
  <head>
    <title>My JSP 'birthday.jsp' starting page</title>
 
	<link rel="stylesheet" type="text/css" href="../../../styles/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="../../../styles/table.css" />
	<link rel="stylesheet" type="text/css" href="../../../styles/cms.css" />
	<script type="text/javascript" src="../../../scripts/jquery/jquery.js"></script>
	<script type="text/javascript" src="../../../scripts/jquery/jquery-plugins.js"></script>
	<script type="text/javascript" src="../../../scripts/jquery/ext-jquery-adapter.js"></script>
	<script type="text/javascript" src="../../../scripts/ext-all.js"></script>
	
	<script type="text/javascript">
	
		function OK()
		{
			
		}
		function cancel()
		{
			window.close();
		}
	</script>

  </head>
  
  <body>
	<div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  action="saveWithdraw.action" method="post" class="x-form">
				<div id="formPanel" style="width:300px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>选择生日</legend>
					    <table align = "center" width="250">
							<tr>
								<td><input type = "checkbox" name = "boxbirthday"  value = "01">01</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "02">02</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "03">03</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "04">04</td>	
						   </tr>
						   <tr>
								<td><input type = "checkbox" name = "boxbirthday"  value = "05">05</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "06">06</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "07">07</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "08">08</td>	
						   </tr>
						   <tr>
								<td><input type = "checkbox" name = "boxbirthday"  value = "09">09</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "10">10</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "11">11</td>	
								<td><input type = "checkbox" name = "boxbirthday"  value = "12">12</td>	
						   </tr>
					   </table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type = "button" name = "box" value = "确定" onclick="OK();" class="btn">
							</div> 
				  			<div class="x-form-btn">  
								<input type = "reset" name = "box" value = "取消" onclick="cancel();" class="btn">
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
