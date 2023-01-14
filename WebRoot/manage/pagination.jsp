<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!--%@ page isELIgnored ="true" %-->
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pagination.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

  </head>
  
  <body>
  
    <s:actionerror/>
    
  <table>
     <tr> 
       <td>序号</td>
       <td>姓名</td>
       <td>密码</td>
     </tr>
     <s:iterator value="list" id="li">
      <tr>
          <td><s:property value="#li.id"/></td>
          <td><s:property value="#li.username"/></td> 
          <td><s:property value="#li.password"/></td>
      </tr>  
     </s:iterator>
    
  </table>   
    
    <!-- =================================分页================================ -->
    共<s:property value="rowCount"/>条记录     共<s:property value="pageCount"/>页          第<s:property value="pageNow"/>页  
   <s:if test="listSize!=1"> 
    <s:url action="pagination_user" id="homePage">
      <s:param name="pageNow">1</s:param>
    </s:url>
    <s:a href="%{homePage}">首页</s:a>

    <!-- 这是上一页的链接 --> 
    <s:url action="pagination_user" id="previousPage" >
       <s:param name="pageNow">${pageNow-1}</s:param>
    </s:url>
   <s:if test="pageNow!=1"> 
    <s:a href="%{previousPage}">上一页</s:a> 
   </s:if> 

     
     <s:bean name="org.apache.struts2.util.Counter" id="counter">  
     <s:param name="first">${pageNow}</s:param>  
     <s:param name="last">${pageNow+2}</s:param>
     <s:iterator>  
       <s:if test=" (pageNow!=pageCount)&&(pageNow = pageNow+1)">
         <s:url action="pagination_user" id="currentPage">
            <s:param name="pageNow">${pageNow}</s:param>
         </s:url>
         <s:a href="%{currentPage}">${pageNow}</s:a> 
       </s:if>
     </s:iterator>  
     </s:bean>  

   
    <!-- 下一页 --> 
     <s:url action="pagination_user" id="nextPage">
        <s:param name="pageNow">${pageNow+1}</s:param>
     </s:url>     
     <s:if test="pageNow!=pageCount">
        <s:a href="%{nextPage}">下一页</s:a>
     </s:if>
    
    <!-- 尾页 -->
    <s:url action="pagination_user" id="endPage">
      <s:param name="pageNow">${pageCount}</s:param>
    </s:url>
    <s:a href="%{endPage}">尾页</s:a>
    
    </s:if>
  </body>
</html>
