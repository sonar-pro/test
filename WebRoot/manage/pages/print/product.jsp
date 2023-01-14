<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <title>product.jsp</title>
 
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
		
		function product()
		{   
			document.all.from1.action = "";
	   		document.all.from1.action = "getAllPro.action?method=getAllPro";
	   		document.all.from1.submit();
		}
		
	</script>

  </head>
  
 
  <body> 
  <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form name = "from1" action="" method="post" class="x-form" >
				<div id="formPanel" style="width:400px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>产品类型</legend>
						<table  width="350" align="center">
				    	   <s:iterator id = "products" value="%{#request.list}" > 
				    		<tr>
				    			<s:iterator id = "product" value="products" >
									<td><input type = "checkbox" name = "boxbank" value = "${product}" /><s:property value= "product" /></td>
								</s:iterator>
				    		</tr>
				    	   </s:iterator>
				    	</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">  
								<input type = "button"  value = "返回" onclick="back();" class="btn">
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
