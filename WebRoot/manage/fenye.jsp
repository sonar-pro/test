<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored ="true" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/style.css">
	
  </head>
  
  <body>
    <center><font size="+3" style="font:bold;">分页实例</font> </center><hr />
    <s:form>

    <s:iterator value="testlist">
			<s:property value="name" />
			<hr>
	</s:iterator>
	
	<div>

   <!-- 总页数 -->
    <s:set name="pageCount" value="pagecount" scope="session"/>
	
	<s:url id="url_pre" value="testdemo.action">   
         <s:param name="pageNumber" value="pageNumber-1"></s:param>   
     </s:url>   
  
     <s:url id="url_next" value="testdemo.action">   
         <s:param name="pageNumber" value="pageNumber+1"></s:param>   
     </s:url>     
     
     <s:url id="url_first" value="testdemo.action">   
         <s:param name="pageNumber" value="0"></s:param>   
     </s:url>   
  
     <s:url id="url_end" value="testdemo.action">   
         <s:param name="pageNumber" value="pagecount-1"></s:param>   
     </s:url>   
  
     
     ${pageNumber+1}/${pageCount}页
     <s:a href="%{url_first}" cssClass="pager">首页</s:a>&nbsp;&nbsp;&nbsp;
     
     <s:if test="pageNumber>0">
        <s:a href="%{url_pre}" cssClass="pager"><< 上一页</s:a>&nbsp;&nbsp;&nbsp;   
     </s:if>
     <s:elseif test="pageNumber<=0">
       <label style="color:gray"><< 上一页</label>&nbsp;&nbsp;&nbsp;
     </s:elseif>
     
     <s:if test="pageNumber+1<${pageCount}">
        <s:a href="%{url_next}" cssClass="pager">下一页 >></s:a>&nbsp;&nbsp;&nbsp;
     </s:if>
     <s:else>
       <label style="color:gray">下一页 >></label>&nbsp;&nbsp;&nbsp;
     </s:else>  
	 
	 <s:a href="%{url_end}" cssClass="pager">末页</s:a> 
	 
	</div>
	
	</s:form>
	
  </body>
</html>
