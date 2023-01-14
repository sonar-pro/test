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
      	function OK()
      	{
      		var o = document.getElementsByTagName('INPUT');   
            for(var i=0;i<o.length;i++)   
            {   
              if(o[i].type == 'checkbox' && o[i].checked)  
              var param = o[i].value;
            }   
      		alert(param);
      	}
     
    	function cancel()
      	{
      		window.location.href = "getAllBank.action";
      	}
      </script>
      
  </head>
  <body>
  	<div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  action="" method="post" class="x-form">
				<div id="formPanel" style="width:300px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>选择城市</legend>
						<table width="250" align="center">
					    	<s:iterator id = "citys" value="%{#request.list}" status="st">
						    	<tr>
						    		<s:iterator id = "city" value="citys" status="st">
						    		<td><input type = "checkbox" name="boxcity"  value="${city}"  onclick="OK();"><s:property value="city" /></td>
						    		</s:iterator>
						    	</tr>
					    	</s:iterator>
				   		</table>
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type = "button" name = "box" value = "确定"  class="btn">
							</div> 
				  			<div class="x-form-btn">  
								<input type = "reset" name = "box" value = "取消" onclick="javascript:history.go(-1);" class="btn">
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
