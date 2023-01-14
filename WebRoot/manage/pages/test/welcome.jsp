<%@ page language="java" contentType="text/html; charset=utf-8"%>   
<%@taglib prefix="s" uri="/struts-tags"%>   
<html>   
    <head>   
        <title><s:text name="succPage" /></title>   
        <s:head />
    </head>   
    <body>   
        <s:text name="succTip" />   
        <br />   
        <!-- 欢迎，${sessionScope.user},您已经登录!   
        ${sessionScope.pass}-->   
        <p />   
        <s:a href="show.action">show</s:a>   
        <p />   
        <s:a href="add.action">add</s:a>   
        <p />   
        <s:a href="query.action">query</s:a>   
    </body>   
</html>