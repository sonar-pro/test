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
      <link rel="stylesheet" type="text/css" href="../../../styles/accordion.css" />
      <script type="text/javascript" src="../../../scripts/jquery/jquery.js"></script>
      <script type="text/javascript" src="../../../scripts/jquery/jquery-plugins.js"></script>
      <script type="text/javascript" src="../../../scripts/jquery/ext-jquery-adapter.js"></script>
      <script type="text/javascript" src="../../../scripts/ext-all.js"></script>
      <script type="text/javascript" src="../../../scripts/ext-accordion.js"></script>
	
	<script type="text/javascript">
		Ext.onReady(function(){
			
	    Ext.get('formPanel');
	   });
	   
	   function add()
	   {
	   		window.location.href = "pages/individuation/indivduationSetting.jsp";
	   }
	   
	   function del()
	   {
	   		var con = confirm("确定是否删除!"); 
  			if (con == true)
  			{
  			  var o = document.getElementsByTagName('INPUT');   
        	  for(var i=0;i<o.length;i++)   
        	  {   
             	 if(o[i].type   ==   'radio'   &&   o[i].checked)  
             	 var param = o[i].value;
         	  }   
         	  alert(param);
       		 document.all.from1.action = "";
	   		 document.all.from1.action = "deleteActionRule.action?method=delete&id="+param;
	   	     document.all.from1.submit();
  	 		}
	   }
	   
	   function modity()
	   {
	   		var o = document.getElementsByTagName('INPUT');   
	          for(var i=0;i<o.length;i++)   
	          {   
	              if(o[i].type   ==   'radio'   &&   o[i].checked)  
	              var param = o[i].value;
	          }   
			document.all.from1.action = "";
		   	document.all.from1.action = "updateActionRule.action?method=update&id="+param;
		   	document.all.from1.submit();
	   }
	   
	   function refresh()
	   {
	   
	   }
	   
	</script>
	
	<title>插页广告活动查询</title>
  </head>
  
  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form  name = "from1" action="#" method="post" class="x-form">
				<div id="formPanel" style="width:640px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>插页广告活动查询</legend>
				  		<table>
				  			<tr>
				  				<td>
				  					<table border = "1" width = "580" bordercolor="#CCCCCC" cellpadding="1" cellspacing="1" >
					  	 				<thead>
					  	 				<tr>
					  	 					<td align="center">操作</td>
					  	 					<td align="center" height="25px">活动编号</td>
					  	 					<td align="center">活动名称</td>
					  	 					<td align="center">创建时间</td>
					  	 					<td align="center">最近修改时间</td>
					  	 					<td align="center">活动设置查询</td>
					  	 				</tr>
					  	 				</thead>
					  	 				<s:iterator id = "ActionRules" value="%{#request.list}" status="st">
					  	 				<tr>
					  	 					<td align="center" bgcolor="#CCCCCC"><input type = "radio" name = "aa" value = "${advActionId}"/></td>
					  	 					<td align="center" bgcolor="#CCCCCC"><s:property value= "advActionId"/></td>
					  	 					<td align="center" bgcolor="#CCCCCC"><s:property value= "advActionName"/></td>
					  	 					<td align="center" bgcolor="#CCCCCC"><s:property value= "crateDatetime"/></td>
					  	 					<td align="center" bgcolor="#CCCCCC"><s:property value= "chgDatetime"/></td>
					  	 					<td align="center" bgcolor="#CCCCCC"><a href = "#">查询</a></td>
					  	 				</tr>
					  	 			  </s:iterator>	
			  	 					</table>
				  				</td>
				  			</tr>
				  				
				  			<tr>
				  				<td align="left" width="100%">
				  					<table width="100%">
				  						<tr>
				  							<td> 
				  								<div class = "x-form-item" align="right">
												   共1页2条记录，当前第1页
												    <a href="#">首页</a>
												    <a href="#">上一页</a>
												    <a href="#">下一页</a>
												    <a href="#">末页</a>
												</div>
				  							</td>
				  						</tr>
				  					</table>
				  				</td>
				  			</tr>
				  		</table>	  
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  		 	<div class="x-form-btn">
								<input type="button" value="增加"  class="btn" onclick="add();"/>
							</div> 
							<div class="x-form-btn">
								<input type="button" value="删除"  class="btn" onclick="del();"/>
							</div> 
							<div class="x-form-btn">
								<input type="button" value="修改"  class="btn" onclick="modity();"/>
							</div> 
							<div class="x-form-btn">
								<input type="button" value="刷新"  class="btn" onclick="refresh();"/>
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
