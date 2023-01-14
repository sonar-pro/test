<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>注册-专业用户</title>
		
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<meta name="Description" content="美空是唯一一家致力于专业娱乐导向的网络平台。美空为广告/时装（男,女模特），歌/舞剧/影视演员，摄影/造型师，视觉设计等人选及相关专业机构提供展示与合作平台。"/>
		<meta name="Keywords" content="MOKO,美空,美空网,美空超级美女榜,MTG,美女,个人网站,型男,精英" />
		<script>
		window.mokosimg = 'http://html.moko.hk';
		</script>
		<!-- script type="text/javascript" src="http://html.moko.hk/script/2!tool1.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/16!jui.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/3!mokoutil.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/37!common.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/8!module.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/46!replaceface.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/81!blog.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/69!upload.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/13!mymoko.js"></script>
		<script type="text/javascript" src="http://html.moko.hk/script/3!partnerbind.js"></script-->
		<!--[if lt IE 7]><script type="text/javascript" src="http://html.moko.hk/script/14!wUnitpngfix.js"></script><![endif]-->
		<!--link href="http://html.moko.hk/css/66!login.css" rel="stylesheet" type="text/css" />
		<link href="http://html.moko.hk/css/35!dialog.css" rel="stylesheet" type="text/css" />
		<link href="http://html.moko.hk/css/2!footer.css" rel="stylesheet" type="text/css" />
		<link href="http://html.moko.hk/css/7!moko-nav.css" rel="stylesheet" type="text/css" />
		<link href="http://html.moko.hk/css/1!moko-dialog.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="http://html.moko.hk/script/68!register.js"></script>
		<link href="http://html.moko.hk/css/75!base1.css" rel="stylesheet" type="text/css" />
		<link href="http://html.moko.hk/css/6!register1.css" rel="stylesheet" type="text/css" />
		<link href="http://html.moko.hk/css/28!pop.css" rel="stylesheet" type="text/css" /-->


		<script type="text/javascript" src="scripts/moaoyo/tool1.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/jui.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/mokoutil.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/common.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/module.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/replaceface.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/blog.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/upload.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/mymoko.js"></script>
		<script type="text/javascript" src="scripts/moaoyo/partnerbind.js"></script>
		<!--[if lt IE 7]><script type="text/javascript" src="http://html.moko.hk/script/14!wUnitpngfix.js"></script><![endif]-->
		<link href="styles/moaoyo/login.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/dialog.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/footer.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/moko-nav.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/moko-dialog.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="scripts/moaoyo/register.js"></script>
		<link href="styles/moaoyo/base1.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/register1.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/pop.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="wrap">
			<div class="reg-header" id="topman"><a href="/" class="logo" title="MOKO!美空 | MOKO.CC 美空"></a></div>
			<div class="mokoman-bg">
				<div class="reg-step-1"></div>
				<div class="reg-second"></div>
				<form id="fmRegisterFirst" name="fmRegisterFirst" method="post" action="/register.action">
					<input type="hidden" name="registerType" value="Z"/>
					<div class="reg-box">
						<div id="input_nickname" class="reg-check-tip" style="display: none">
							<img class="arrow_4" src="http://html.moko.hk/images/n.gif">				
							<div>
								<p class="reg-check-tip-content">
									<img class="correct" src="http://html.moko.hk/images/n.gif" title="必须没问题!" />
									<img class="error" src="http://html.moko.hk/images/n.gif" title="哎呀,这里出错啦!" />
									<span class="reg-check-tip-text" id="input_nickname_s">填入<span class="mC">真实的中文姓名</span>,方便别人找到你.<br>如:吴依蔓</span>
								</p>
							</div>
						</div>
						<h3>昵称</h3>
						<input type="text" class="text" id="nickName" name="nickName" onblur="jQuery1.mk.register.checkNickName(this);" onfocus="jQuery1.mk.register.focusNickName(this);" maxlength="20" value=""/>
					</div>
					<div class="reg-box-sex">
						<h3>
						性别<label for="man">男</label><input type="radio" name="sex" id="man" value="1" checked="checked"/>
						<label for="woman">女</label><input type="radio" name="sex" id="woman" value="0"/>
						</h3>
					</div>
					<div class="reg-box">
						<div id="input_email"  class="reg-check-tip" style="display: none">
							<img class="arrow_4" src="http://html.moko.hk/images/n.gif">	
							<div>
								<p class="reg-check-tip-content">
									<img class="correct" src="http://html.moko.hk/images/n.gif" title="必须没问题!" />
									<img class="error" src="http://html.moko.hk/images/n.gif" title="哎呀,这里出错啦!" />
									<span class="reg-check-tip-text" id="input_email_s">
										填入<span class="mC">有效的邮箱地址</span>,以验证完成注册,<br>此邮箱就是你登录美空的帐号<br>如:mokoman@126.com
									</span>
								</p>
							</div>
						</div>
						<h3>登录邮箱</h3>
						<input type="text" class="text" id="email" name="email" onfocus="jQuery1.mk.register.focusEmail(this);return false;" onblur="jQuery1.mk.register.checkEmail(this);return false;" maxlength="40" value=""/>
					</div>
					<div class="reg-box">
						<div id="input_password"  class="reg-check-tip" style="display: none">
							<img class="arrow_4" src="http://html.moko.hk/images/n.gif">
							<div>				
								<p class="reg-check-tip-content">
									<img class="correct" src="http://html.moko.hk/images/n.gif" title="必须没问题!" />
									<img class="error" src="http://html.moko.hk/images/n.gif" title="哎呀,这里出错啦!" />
									<span class="reg-check-tip-text" id="input_password_s">
										密码由<span class="mC">6-24</span>位英文字母,数字,特殊符号组成<br>如:moko#123
										<span class="pswStrong2" id="password_L">
											<span class="weak">弱</span>
											<span>中</span>
											<span class="strong">强</span>
										</span>
									</span>
									<span class="reg-check-tip-text" id="input_password_s2"></span>
								</p>
							</div>
						</div>
						<h3>密码</h3>
						<input type="password" class="text" id="password" name="password" onfocus="jQuery1.mk.register.focusPassword(this);" onblur="jQuery1.mk.register.checkPw(this);" onkeyup="jQuery1.mk.register.showStrengthDiv();jQuery1.mk.common.pwStrength(this.value);" maxlength="24"/>
					</div>
					<div class="reg-box">
						<div id="input_passwordConfirm"  class="reg-check-tip" style="display: none">
							<img class="arrow_4" src="http://html.moko.hk/images/n.gif">				
							<div>
								<p class="reg-check-tip-content">
									<img class="correct" src="http://html.moko.hk/images/n.gif" title="必须没问题!" />
									<img class="error" src="http://html.moko.hk/images/n.gif" title="哎呀,这里出错啦!" />
									<span class="reg-check-tip-text" id="error_comfirm">再次确认密码!</span>
								</p>
							</div>
						</div>
						<h3>确认密码</h3>
						<input type="password" class="text" id="passwordConfirm" name="passwordConfirm" onfocus="jQuery1.mk.register.focusConfirmPwd(this);return false;"  onblur="jQuery1.mk.register.confirmPw(this);return false;" maxlength="24"/>
					</div>
					<div class="reg-box">
						<div id="input_verifycode"  class="reg-check-tip wrong" style="display: none">
							<img class="arrow_4" src="http://html.moko.hk/images/n.gif">				
							<div>
								<p class="reg-check-tip-content">
									<img class="correct" src="http://html.moko.hk/images/n.gif" title="必须没问题!" />
									<img class="error" src="http://html.moko.hk/images/n.gif" title="哎呀,这里出错啦!" />
									<span class="reg-check-tip-text" id="verifycodeErrorMsg">验证码输入有误,请重新输入!</span>
								</p>
							</div>
						</div>
						<h3>验证码</h3>
						<div class="code-pic">
							<input type="text" class="text" id="verifyCode" name="j_image_code_response" onblur="jQuery1.mk.register.checkVerifyCode(this);" maxlength="10"/>
							<img id="verifyImage" src="/kaptcha.jpg" title="点击切换" onclick="jQuery1.mk.register.changeVerifyCode();"/>
							<p><a href="javascript:void(0);" onclick="jQuery1.mk.register.changeVerifyCode();return false;" title="换一张">换一张</a></p>
						</div>
					</div>
					<div class="reg-submit">
						<p>
							<input type="checkbox" checked="checked" id="input_isCheck"> 已经阅读并同意
							<a href="http://html.moko.hk/html/about/reg.html" target="_blank" title="MOKO!服务条款">&lt;MOKO!服务条款&gt;</a>
						</p>
						<input type="button" class="btn" value="继续" id="btnRegisterSave" onclick="jQuery1.mk.register.saveRegisterFirst();" onfocus="blur()"/>
					</div>
				</form>
			</div>
			
<footer class="footer">
<!--[if lte IE 8]><div class="footer"><![endif]-->
	<div class="sitemap bd">
		<ul class="title">
			<li>关于</li>
			<li>合作</li>
			<li>服务/帮助</li>
			<li>更多</li>
		</ul>
		<ul class="cf">
			<li>
				<a class="g1mC hU" href="" target="_blank" title="什么是美空?" alt="什么是美空?" hidefocus="true" >什么是美空?</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="什么是MOKOMAN?" alt="什么是MOKOMAN?" hidefocus="true" >什么是MOKOMAN?</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="美空团队" alt="美空团队" hidefocus="true" >美空团队</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="媒体报道" alt="媒体报道" hidefocus="true" >媒体报道</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="加入我们" alt="加入我们" hidefocus="true" >加入我们</a><br /><br />
			</li>
			<li>
				<a class="g1mC hU" href="" target="_blank" title="市场/商业合作" alt="市场/商业合作" hidefocus="true" >市场/商业合作</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="合作链接" alt="合作链接" hidefocus="true" >合作链接</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="联络方式" alt="联络方式" hidefocus="true" >联络方式</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="投资与资本" alt="投资与资本" hidefocus="true" >投资与资本</a><br /><br />
			</li>
			<li>
				<a class="g1mC hU" href="" target="_blank" title="在线客服" alt="在线客服" hidefocus="true" >在线客服</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="美空升级内容" alt="美空升级内容" hidefocus="true" >美空升级内容</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="防骗说明" alt="防骗说明" hidefocus="true" >防骗说明</a><br /><br />
			</li>
			<li>
				<a class="g1mC hU" href="" target="_blank" title="商标声明" alt="商标声明" hidefocus="true" >商标声明</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="美空声明" alt="美空声明" hidefocus="true" >美空声明</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="产品设计保护" alt="产品设计保护" hidefocus="true" >产品设计保护</a><br /><br />
				<a class="g1mC hU" href="" target="_blank" title="隐私政策" alt="隐私政策" hidefocus="true" >隐私政策</a><br /><br />
			</li>
		</ul>
		
	</div>
	<div class="copy">
		
	</div>
<!--[if lte IE 8]></div><![endif]-->
</footer>
<!--百度统计-->
<script type="text/javascript">
	var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
	document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F8d82e75c6168ba4bc0135a08edae2a2e' type='text/javascript'%3E%3C/script%3E"));
</script>

		</div>
	</body>
</html>