<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <head>
    <title>card.jsp</title>
    
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
		function cancel()
		{
			window.location.href = "getAllPro.action";
		}
	</script>
  </head>
  <body>
  	<div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  action="" method="post" class="x-form">
				<div id="formPanel" style="width:630px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>请选择卡种</legend>
						<table  width="580">
					    	<s:iterator id = "cards" value="%{#request.list}" status="st">
						    	<tr>
						    		<s:iterator id = "card" value="cards" status="st">
						    		<td><br><input type = "checkbox" name="boxcard" value="${card}"><s:property value="card" /></td>
						    		</s:iterator>
						    	</tr>
					    	</s:iterator>
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
