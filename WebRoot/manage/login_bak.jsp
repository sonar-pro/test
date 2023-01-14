<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="loginPage" /></title>
<script type="text/javascript" src="scripts/jquery/jquery.js"></script>
<script type="text/javascript" src="scripts/json/json2.js"></script>
<script type="text/javascript">
    $(function(){
        $("#submit").click(function(){
            //var username1 = $("input[name='username']").val();    //获取账号
            //var password1 = $("input[name='password']").val();        //获取密码
            var username1 = $("#username").val();    //获取账号
            var password1 = $("#password").val();    //获取密码
            
            if(username1==''){
            	alert("请输入用户名！");
            	$("#username").focus();
            	return;
            }
            if(password1==''){
            	alert("请输入密码！");
            	$("#password").focus();
            	return;
            }
			//alert(username1);
            var jsonUser = {username:username1, password:password1};    //JSON对象
            
            //注意:jsonUser.toString()这种方法错误,javaScript中的toString是用于布尔型变量的,而应用以下方法
            var strUser = JSON.stringify(jsonUser);    //将JSON对象转变成JSON格式的字符串,
            $.post("login!valid.action", {json: strUser}, callback, "json");
        });
 

        function callback(json){
            alert(json.msg);    //显示反馈信息 

            if(json.suc == 1){    //如果返回"登录成功" 
				var username1 = $("#username").val();    //获取账号
            	var password1 = $("#password").val();    //获取密码
            	if(json.msg=='success'){
            		window.location.href = "index.jsp";
            	}
            	if(json.msg=='error'){
            		window.location.href = "error.jsp";
            	}
                //window.location.href = "login!exec.action?username="+username1+"&password="+password1;    //跳转到后台主页 
				//var f = document.forms[0];
				//f.action="login!exec.action?username="+username1+"&password="+password1; 
				//alert(f.action);
				//f.submit(); 
	//aaa();
            } 

        }
        
    });
    
    function aaa(){
    	var f = document.forms[0];
		f.action="/login!exec.action";
		alert(f.action);
		f.submit();
   	}
</script>





</head>
<body>
<%--
	<s:form action="login.action" method="post">
		<s:textfield name="usernames" id="usernames" label="username"></s:textfield>
		<s:password name="passwords" id="passwords"  label="password"></s:password>
		<s:submit label="submit"></s:submit>
	</s:form>--%>
	<!-- 使用form标签生成表单元素 -->   
	<!--${tip}  -->
	${4/2}
	<div style="color:red" align="left">${requestScope.tip}</div>
    <s:form id="login" action="login!exec.action" method="post" theme="simple">
    	<!--s:token /-->
        <s:textfield name="username" id="username" label="%{getText('user')}" />   
        <s:textfield name="password" id="password" label="%{getText('pass')}" />   
        <!--s:submit id="submit" value="%{getText('login')}" /-->  
        <input type="button" id="submit" value="登录"/>
    </s:form>
   <!-- 
    <form action="login.action" method="post"> 

    账号<input type="text" id="username" name="username"/><br/> 

    密码<input type="password" id="password" name="password"><br/> 

    <input type="button" id="submit" value="登录"/> 

</form> -->

</body>
</html>
