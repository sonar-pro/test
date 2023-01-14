<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>MOKO!美空 | MOKO搜索</title>
		
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
		<link href="http://html.moko.hk/css/75!base1.css" rel="stylesheet" type="text/css" />
		<link href="http://html.moko.hk/css/69!layout1.css" rel="stylesheet" type="text/css" />
		<link href="http://html.moko.hk/css/20!work1.css" rel="stylesheet" type="text/css" />
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
		<link href="styles/moaoyo/base1.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/layout1.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/work1.css" rel="stylesheet" type="text/css" />
		<link href="styles/moaoyo/pop.css" rel="stylesheet" type="text/css" />

	</head>
<body>
	<input type="hidden" id="sendMessageTime" value="120000"/>
	<input type="hidden" id="musicDomain" value="http://html.moko.hk"/>

	<div id="topman" class="moko-nav">
		<div class="moko-nav-width">
			<div class="left-nav">
				<ul>			
					<li><a id="nav_homepage" href="/" hidefocus="true">首页</a></li>
					<li><a id="nav_post" href="/moko/today/post.html" hidefocus="true">展示</a></li>
					<li class="hot"><a id="nav_mtg" href="/mtg/index.html" hidefocus="true">MTG</a>
						<img src="http://html.moko.hk/images/n.gif" />
					</li>
					<li><a id="nav_mokostar" href="/mokostar/index.html" hidefocus="true">行业明星</a></li>
					<li><a id="nav_company" href="/company.html" hidefocus="true">机构</a></li>
					<li><a id="nav_catalog" href="/catalog/index.html" hidefocus="true">专业人才库</a></li>
					<li><a id="nav_event" href="/mokoevent.html" hidefocus="true">事件</a></li>
					<li><a id="nav_recruit" href="/recruit.html" hidefocus="true">招募MRC</a></li>
					<li><a id="nav_project" href="/projectlist/page/1.html" hidefocus="true">工作机会</a></li>
					<li><a id="nav_msp" href="/20110506/index/event.html" hidefocus="true">明星计划MSP</a></li>
				</ul>
			</div>
			<div class="right-nav">
				<ul>

						<li id="logout_title"><a href="/mokofind.html" hidefocus="true">搜索</a></li>
						<li><a href="/register/first.html" hidefocus="true">注册</a></li>
						<li><a href="javascript:void(0);" onclick="jQuery1.mk.login.login();return false;" hidefocus="true">登录</a></li>
						<li class="other-login">其他帐号登录：</li>
						<li class="sina"><a href="javascript:void(0);" onclick="jQuery1.mk.bd.bindSina('pop');return false;" hidefocus="true">&nbsp;</a></li>
						<li class="qq"><a href="javascript:void(0);" onclick="jQuery1.mk.bd.bindQQ('https://graph.qq.com/oauth2.0/authorize?scope=get_user_info,add_share,add_weibo&response_type=code&client_id=100226571&redirect_uri=http://www.moko.cc/qq/callback&state=pop');return false;" hidefocus="true">&nbsp;</a></li>
						
				</ul>
			</div>
			<script type="text/javascript">jQuery1.setCss("nav_search","active",true);</script>
			
		</div>
	</div>
	<div class="container wBC">

	<div class="header">
		<a href="/" title="MOKO!美空 | MOKO.CC 美空" hidefocus="true" class="small-logo">
			<img src="http://html.moko.hk/images/small_logo.jpg">
		</a>
			&nbsp;
		
		<div id="label" style="display:inline"></div>
	</div>
	<div class="content bd">
				
		<input type="hidden" id="findUser" value="/catalog/searchUser.html"/>
		<input type="hidden" id="findPost" value="/catalog/searchPost.html"/>

		<form action="/catalog/searchUser.html" method="post" id="findForm" onsubmit="return jQuery1.enterBindClick('aLinksearch');">
			<div class="search">
				<a class="sBt" id="aLinksearch" href="javascript:void(0);" onclick="jQuery1.popNotLogin();return false;" title="搜索" hidefocus="true"></a><p class="sText bd"><input type="text" value="" name="findName" id="findName" /></p>
				<p class="choose gC c">
					<input type="radio" name="findType" value="0" onclick="jQuery1.checkRadio('findForm', 'findUser');" checked="checked" />用户名&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="findType" value="1" onclick="jQuery1.checkRadio('findForm', 'findPost');"  />展示标题
				</p>
			</div>
			  
		</form>
		<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
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
