<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META content="MSHTML 6.00.6000.16674" name=GENERATOR>
<TITLE>网站系统后台-用户登录</TITLE>
<LINK href="../styles/login/Default.css" type=text/css rel=stylesheet>
<LINK href="../styles/login/xtree.css" type=text/css rel=stylesheet>
<LINK href="../styles/login/User_Login.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="../scripts/jquery/jquery.js"></script>
<script type="text/javascript" src="../scripts/json/json2.js"></script>
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
            		window.location.href = "manage/index.jsp";
            	}
            	if(json.msg=='error'){
            		window.location.href = "manage/error.jsp";
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

</HEAD>
<BODY id=userlogin_body>
<DIV></DIV>
<s:form id="login" action="login!exec.action" method="post" theme="simple">
<DIV id=user_login>
<DL>
  <DD id=user_top>
  <UL>
    <LI class=user_top_l></LI>
    <LI class=user_top_c></LI>
    <LI class=user_top_r></LI>
  </UL>
  </DD>
  <DD id=user_main>
  <UL>
    <LI class=user_main_l></LI>
    <LI class=user_main_c>
		<DIV class=user_main_box>
			<UL>
			  <LI class=user_main_text>用户名： </LI>
			  <LI class=user_main_input>
				<!--INPUT class=TxtUserNameCssClass id=TxtUserName maxLength=20 name=TxtUserName--> 
				<INPUT class=TxtUserNameCssClass id=username maxLength=20 name=username>
			  </LI>
			</UL>
			<UL>
			  <LI class=user_main_text>密&nbsp;&nbsp;&nbsp;&nbsp;码： </LI>
			  <LI class=user_main_input>
				<!--INPUT class=TxtPasswordCssClass id=TxtPassword type=password name=TxtPassword--> 
				<INPUT class=TxtPasswordCssClass id=password type=password name=password>
			  </LI>
			</UL>
			<UL>
			  <!--LI class=user_main_text></LI-->
			  <LI >
				<!--SELECT id=DropExpiration name=DropExpiration> 
				  <OPTION value=None selected>不保存</OPTION> 
				  <OPTION value=Day>保存一天</OPTION> 
				  <OPTION value=Month>保存一月</OPTION> 
				  <OPTION value=Year>保存一年</OPTION>
				</SELECT--> 
				验证码： &nbsp;&nbsp;<INPUT id=TxtCheck type=text name=TxtCheck size="10">
                &nbsp;&nbsp;<b> Q W E T</b>
			  </LI>
			</UL>
		</DIV>
    </LI>
    <LI class=user_main_r>
	    <!--INPUT class=IbtnEnterCssClass id=IbtnEnter style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" 
		onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("IbtnEnter", "", true, "", "", false, false))' 
		type=image src="images/login/user_botton.gif" name=IbtnEnter--> 
		<INPUT class=IbtnEnterCssClass id=submit style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" 
		onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("IbtnEnter", "", true, "", "", false, false))' 
		type=image src="../images/login/user_botton.gif" name=IbtnEnter>
	</LI>
  </UL>
  </DD>
  <DD id=user_bottom>
	  <UL>
		<LI class=user_bottom_l></LI>
		<LI class=user_bottom_c>
			<SPAN style="MARGIN-TOP: 40px"><!--如果您尚未在本站注册为用户，请先点此 <A href="http://www.huacker.com.cn">注册</A> 。--></SPAN> 
		</LI>
		<LI class=user_bottom_r></LI>
	  </UL>
  </DD>
 </DL>
</DIV>
<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>
<DIV></DIV>
<!--/FORM-->
</s:form>
</BODY>
</HTML>
