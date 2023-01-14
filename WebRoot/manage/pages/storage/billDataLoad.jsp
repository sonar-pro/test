<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.*" %>
<%@ page import="com.cib.model.JobMg" %>

<html>
  <head>
 	<title>账单数据加载</title>
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
			
	    Ext.get('formPanel').center();
	   });
	   //读取exe文件
	   function readEXE()
	   {
	   		document.all.from1.action = "";
		   	document.all.from1.action = "ReadEXE.action?method=ReadEXE";
		   	document.all.from1.submit();
	   }
	   //全选按钮
	  function selectAll(obj)
	  {
	  		for (var i = 0;i<obj.elements.length;i++)
	  		{
	  			if (obj.elements[i].type == "checkbox")
	  			{
	  				if (!obj.elements[i].checked)
	  				obj.elements[i].checked = true;
	  				else
	  				obj.elements[i].checked = false;
	  			}
	  		}
	  }
	   
	</script>
	
  </head>

<%
	List JobMgs = (List)request.getAttribute("JobMgs");

 %>

  <body>
   <div id="content">
	<!-- <div id="banner"></div> -->
		<!--banner-->
		<div id="zhuti">
			<form name = "form1" action="#" method="post" class="x-form">
				<div id="formPanel" style="width:700px;">
					<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>
					<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc">
				  <fieldset>
				  	<legend>账单数据加载</legend>
				  			
			  	 			<table border = "1" width = "650" bordercolor="#CCCCCC" cellpadding="1" cellspacing="1" align="center">
			  	 				<thead>
			  	 				<tr>
			  	 					<td align="center" height="25px"><input type = "button"  name = "boxJob" value="全/反选" onclick="selectAll(document.form1);" class = "btn"></td>
			  	 					<td align="center">作业编号</td>
			  	 					<td align="center">产品编号</td> 
			  	 					<td align="center">账单日</td>
			  	 					<td align="center">数据处理</td>
			  	 					<td align="center">合成/分发</td>
			  	 					<td align="center">数据加载</td>
			  	 					<td align="center">数据流加载</td>
			  	 					<td align="center">加载日志</td>
			  	 				</tr>
			  	 				</thead>
			  	 						<%
			  	 							if (JobMgs != null){
			  	 							for (int i = 0;i< JobMgs.size();i++){
			  	 							JobMg jobMg = (JobMg)JobMgs.get(i);
			  	 						 %>
					  	 				<tr>
					  	 					<td align="center" bgcolor="#cccccc"><input type = "checkbox"  name = "boxJob"  value = "${jobId}" ></td>
					  	 					
					  	 					<td align="center" bgcolor="#cccccc"><%=jobMg.getJobId()%></td>
					  	 					<td align="center" bgcolor="#cccccc"><%=jobMg.getCardType() %></td>
					  	 					<td align="center" bgcolor="#cccccc"><%=jobMg.getStatementDate() %></td>
					  	 					<td align="center" bgcolor="#cccccc"><% if (jobMg.getConsolStatus().equals("0")) {%>等待<%} if (jobMg.getConsolStatus().equals("1")) {%>数据校验中<%} if (jobMg.getConsolStatus().equals("2")) {%>数据入库个性化加载<%}%></td>
					  	 					<td align="center" bgcolor="#cccccc"><% if (jobMg.getEstatementStatus().equals("0")) {%>等待<%} if (jobMg.getEstatementStatus().equals("1")) {%>处理中<%} if (jobMg.getEstatementStatus().equals("2")) {%>完成<%} if (jobMg.getEstatementStatus().equals("3")) {%>失败<%} %></td>
					  	 					<!-- <td align="center" bgcolor="#cccccc"><s:property value="genStatus" /></td> -->
					  	 					<td align="center" bgcolor="#cccccc"><% if (jobMg.getDataloadStatus().equals("0")) {%>等待<%} if (jobMg.getDataloadStatus().equals("1")) {%>处理中<%} if (jobMg.getDataloadStatus().equals("2")) {%>完成<%} if (jobMg.getDataloadStatus().equals("3")) {%>失败<%} %></td>
					  	 					<td align="center" bgcolor="#cccccc"><% if (jobMg.getStreamloadStatus().equals("0")) {%>等待<%} if (jobMg.getStreamloadStatus().equals("1")) {%>处理中<%} if (jobMg.getStreamloadStatus().equals("2")) {%>完成<%} if (jobMg.getStreamloadStatus().equals("3")) {%>失败<%} %></td>
					  	 					<td align="center" bgcolor="#cccccc"><a href = "#">查询</a></td>
					  	 					</tr>
					  	 					<%
					  	 						}
					  	 						}
					  	 					 %>
			  	 			</table>
							  <div class = "x-form-item" align="right"> 
							    共1页2条记录，当前第1页
							   <a href="#">首页</a>
							   <a href="#">上一页</a>
							   <a href="#">下一页</a>
							   <a href="#">末页</a>
							 </div>
							  
				  </fieldset>
						<div class="x-form-buttons" align="center">  
				  			<div class="x-form-btn">
								<input type="button" value="数据加载"  class="btn" onclick="readEXE();">
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
