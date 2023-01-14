<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@taglib uri="/struts-tags" prefix="s" %>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>分页显示</title>  
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!--<meta http-equiv="refresh" content="20">  
      
    <link rel="stylesheet" type="text/css" href="styles.css" mce_href="styles.css">  
    -->  
  
        
      共<s:property value="page.totalNum"/>条记录     共<s:property value="page.lastPage"/>页          第<s:property value="page.pageNow"/>页  
        <br/>  
        <s:url id="url_first" value="/Showfirst.action">  
        </s:url>  
  
           <s:url id="url_pre" value="/Showpre.action">     
            <s:param name="pageNow" value="pageNow-1"></s:param>     
          </s:url>     
    
         <s:url id="url_next" value="/Shownext.action">     
            <s:param name="pageNow" value="pageNow+1"></s:param>     
         </s:url>      
           
         <s:url id="url_last" value="admin/Showlast.action">  
         </s:url>  
         <s:a href="%{url_first}" >首页</s:a>  
         <s:a href="%{url_pre}" >上一页</s:a>  
       
         <s:iterator value="examinees" status="status">  
            <s:url id="url" value="/Student_list.action">  
            <s:param name="page.pageNow" value="page.pageNow"/>  
        </s:url>  
        </s:iterator>  
        <s:a href="%{url_next}" >下一页</s:a>   
        <s:a href="%{url_last}" >最后一页</s:a>   

     </body>  
  
</html> 