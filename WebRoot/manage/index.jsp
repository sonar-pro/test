<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	if((session.getAttribute("user"))==null){
		//System.out.println(session.getAttribute("user"));
		response.sendRedirect("manage/login.jsp");
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
      <title>网站系统管理平台</title>
     
      <link rel="stylesheet" type="text/css" href="../styles/ext-all.css" />
      <link rel="stylesheet" type="text/css" href="../styles/cms.css" />
      <link rel="stylesheet" type="text/css" href="../styles/accordion.css" />
      <script type="text/javascript" src="../scripts/jquery/jquery.js"></script>
      <script type="text/javascript" src="../scripts/jquery/jquery-plugins.js"></script>
      <script type="text/javascript" src="../scripts/jquery/ext-jquery-adapter.js"></script>
      <script type="text/javascript" src="../scripts/ext-all.js"></script>
      <script type="text/javascript" src="../scripts/ext-accordion.js"></script>
     
      <script type="text/javascript">
        Ext.BLANK_IMAGE_URL = '../images/default/s.gif';
        
        var loadDoc = function(url){
          var mainPanel = Ext.get('main');
          mainPanel.dom.src = url;          
        }
        
        var menuClicked = function(e, target){
          loadDoc(target.href);
          document.title = target.title;
        };
        
        var layout,center;
        Ext.onReady(function(){
          // initialize state manager, we will use cookies
          Ext.state.Manager.setProvider(new Ext.state.CookieProvider());
          
          // create the main layout
          layout = new Ext.BorderLayout(document.body, {
              north: {
                  split:false,
                  initialSize: 60,
                  titlebar: false
              },
              west: {
                  split:true,
                  initialSize: 250,
                  minSize: 175,
                  maxSize: 400,
                  titlebar: true,
                  collapsible: true,
                  animate: true,
                  useShim:true,
                  cmargins: {top:2,bottom:2,right:2,left:2}
              },
              center: {
                  titlebar: true,
                  title: '工作区',
                  autoScroll:false,
                  tabPosition: 'top',
                  closeOnTab: true,
                  //alwaysShowTabs: true,
                  resizeTabs: true
              }
          });
          // tell the layout not to perform layouts until we're done adding everything
          layout.beginUpdate();
          layout.add('north', new Ext.ContentPanel('header'));          
          layout.add('west', new Ext.ContentPanel('main-menu', {title: '系统导航菜单', fitToFrame:true}));
          
          center = layout.getRegion('center');
          center.add(new Ext.ContentPanel('main', {fitToFrame:true}));
          
          layout.restoreState();
          layout.endUpdate();
          
          // safari and opera have iframe sizing issue, relayout fixes it
          if(Ext.isSafari || Ext.isOpera){
              layout.layout();
          }
          
          // 创建一个Accordion
          var acc = new Ext.ux.Accordion('acc-menu', {fitHeight: true});
         
         // 创建 panel-project-manage
	  	  var panel = acc.add(new Ext.ux.InfoPanel('pannel-project-manage', {}));
	  	  
	      // 创建 panel-template-manage
          var panel = acc.add(new Ext.ux.InfoPanel('panel-template-manage', {}));

          // 创建 panel-individuation-rule
          var panel = acc.add(new Ext.ux.InfoPanel('panel-individuation-rule', {}));

	      // 创建 panel-sample-rule
          var panel = acc.add(new Ext.ux.InfoPanel('panel-sample-rule', {}));

	      // 创建 panel-print-build
          var panel = acc.add(new Ext.ux.InfoPanel('panel-print-build', {}));

          // 创建 panel-bill-send
          var panel = acc.add(new Ext.ux.InfoPanel('panel-bill-send', {}));
          
          // 创建 panel-bill-storage
          var panel = acc.add(new Ext.ux.InfoPanel('panel-bill-storage', {}));
          
          // 创建 panel-bill-query
          var panel = acc.add(new Ext.ux.InfoPanel('panel-bill-query', {}));
          
          // 创建 panel-address-modity-send
          var panel = acc.add(new Ext.ux.InfoPanel('panel-address-modity-send', {}));

          // 创建 panel-statistic
          var panel = acc.add(new Ext.ux.InfoPanel('panel-statistic', {}));
         
          // 创建 panel-backletter-manage
          var panel = acc.add(new Ext.ux.InfoPanel('panel-backletter-manage', {}));
          
          // 创建 panel-test-manage
          var panel = acc.add(new Ext.ux.InfoPanel('panel-test-manage', {}));
          		  
		  // 创建 panel-person-manage
	  	  var panel = acc.add(new Ext.ux.InfoPanel('pannel-person-manage', {}));
	  	  
	  	  // 创建 panel-finance-manage
	  	  var panel = acc.add(new Ext.ux.InfoPanel('pannel-finance-manage', {}));
          
          // 创建 panel-system-manage
	  	  var panel = acc.add(new Ext.ux.InfoPanel('pannel-system-manage', {}));
	  	  
	  	  // 创建 panel-help-manage
	  	  var panel = acc.add(new Ext.ux.InfoPanel('pannel-help-manage', {}));

          // 创建 panel
          var mainMenu = Ext.get('main-menu');
          mainMenu.on('click', menuClicked, null, {delegate: 'a', stopEvent:true});
        });
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		.STYLE1 {
			color: #43860c;
			font-size: 12px;
		}
		-->
	</style>
</head>
<body id="portal">
<div id="header" class="x-layout-active-content">
	<div style="padding:0;marging:0;">
    	<!--a href="http://www.spdb.com.cn"><img src="./images/logo.gif"/></a-->
        <!--a href="http://www.brztkj.com"><img src="./images/logos.jpg"/></a-->
        <table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
			<tr>
			    <td height="9" style="line-height:9px; background-image:url(../images/top/main_04.gif)">
			    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			      		<tr>
			        		<td width="97" height="9" background="../images/top/main_01.gif">&nbsp;</td>
			        		<td>&nbsp;</td>
			        		<td>&nbsp;</td>
			      		</tr>
			    	</table>
			    </td>
			</tr>
			<tr>
			    <td height="47" background="../images/top/main_09.gif">
			    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			      		<tr>
			        		<td width="38" height="47" background="../images/top/main_06.gif">&nbsp;</td>
			        		<td width="59">
			        			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			          				<tr>
			            				<td height="29" background="../images/top/main_07.gif">&nbsp;</td>
			          				</tr>
			          				<tr>
			            				<td height="18" background="../images/top/main_14.gif">
			            					<table width="100%" border="0" cellspacing="0" cellpadding="0" style="table-layout:fixed;">
			              						<tr>
			                						<td  style="width:1px;">&nbsp;</td>
			                						<td ><span class="STYLE1">Admin</span></td>
			              						</tr>
			            					</table>
			            				</td>
			          				</tr>
			        			</table>
			        		</td>
			        		<td width="155" background="../images/top/main_08.gif">&nbsp;</td>
			        		<td>
			        			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			          				<tr>
			            				<td height="23" valign="bottom">
			            					<img src="../images/top/main_12.gif" width="367" height="23" border="0" usemap="#Map" />
			            				</td>
			          				</tr>
			        			</table>
			        		</td>
			        		<td width="200" background="../images/top/main_11.gif">
			        			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			          				<tr>
			            				<td width="11%" height="23">&nbsp;</td>
			            				<td width="89%" valign="bottom"><span class="STYLE1">日期：2008年7月22日 星期二</span></td>
			          				</tr>
			        			</table>
			        		</td>
			      		</tr>
			    	</table>
			    </td>
			</tr>
			<tr>
			    <td height="5" style="line-height:5px; background-image:url(../images/top/main_18.gif)">
			    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
			      		<tr>
			        		<td width="180" background="../images/top/main_16.gif"  style="line-height:5px;">&nbsp;</td>
			        		<td>&nbsp;</td>
			      			</tr>
			    	</table>
			    </td>
			</tr>
		</table>
	</div>
</div>
    
<div id="main-menu" class="x-layout-inactive-content">
	<div id="acc-menu">	
	<!--panel start-->
		<div id="pannel-project-manage">
        	<div><img src="../images/list.jpg"/>&nbsp;项目工程管理</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="pages/system/parameterSetting.jsp" title="系统参数设置" class="menu-item">系统参数设置</a></li>
	                  <li><a href="deptList.action" title="用户管理" class="menu-item">用户管理</a></li>
	               	  <li><a href="pintInstList.action" title="打印服务商设置" class="menu-item">打印服务商设置</a></li>
	                </ul>
              	</div>
            </div>
		</div>
	<!--panel end-->
	<!--panel start-->
        <div id="panel-template-manage">
            <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;模板管理</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="tmpmgList.action" title="模板管理" class="menu-item">模板管理</a></li>
	                  <li><a href="pages/template/addTemplet.jsp" title="添加模板" class="menu-item">添加模板</a></li>
	                </ul>
              	</div>
            </div>
        </div>
	<!--panel end-->

	<!--panel start-->
        <div id="panel-individuation-rule">
      	  	<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个性化规则</div>
           	<div>
                <div class="text-content">
                  	<ul>
                   	  <li><a href="getAllActionRule.action" title="插页广告活动查询" class="menu-item">插页广告活动查询</a></li> 
                      <li><a href="getAllBank.action" title="个性化规则信息管理" class="menu-item">个性化规则信息管理</a></li>
				  	</ul>
              	</div>
	      	</div>
		</div>
	<!--panel end-->

	<!--panel start-->
	    <div id="panel-sample-rule">
      		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;抽样规则</div>
            <div>
                <div class="text-content">
                  	<ul>
                      <li><a href="pages/sample/bill_template_version_manager.html" title="账单模板管理" class="menu-item">账单模板管理</a></li>
		     		  <li><a href="pages/sample/template_list.html" title="模板列表一览" class="menu-item">模板列表一览</a></li>
		     		  <li><a href="pages/sample/template_upload.html" title="上传模板" class="menu-item">上传模板</a></li>
				  	</ul>
             	</div>
	    	</div>
		</div>
	<!--panel end-->

	<!--panel start-->
        <div id="panel-print-build">
            <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账单打印</div>
            <div>
              	<div class="text-content">
	                <ul>
	                 <li><a href="printRuleList.action" title="打印规则设定" class="menu-item">打印规则管理</a></li>
	                </ul>
             	</div>
            </div>
        </div>
	<!--panel end-->

	<!--panel start-->
        <div id="panel-bill-send">
            <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电子账单发送</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/send/bill_print_query.html" title="账单文件查询及下载" class="menu-item">账单文件查询及下载</a></li>
	                  <li><a href="./pages/send/history_bill_print_email.html" title="补打账单邮寄信息录入" class="menu-item">补打账单邮寄信息录入</a></li>
	                  <li><a href="./pages/send/history_bill_email_query.html" title="补打账单邮寄结果查询" class="menu-item">补打账单邮寄结果查询</a></li>
	                  <li><a href="./pages/send/history_bill_handcraft.html" title="手工生成补打账单" class="menu-item">手工生成补打账单</a></li>
	                  <li><a href="./pages/send/history_bill_Statistic_query.html" title="补打账单统计数据查询" class="menu-item">补打账单统计数据查询			</a></li>
	                </ul>
             	</div>
            </div>
        </div>
	<!--panel end-->
	
	<!--panel start-->
		<div id="panel-bill-storage">
            <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账单存储加载</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="jobMgList.action" title="账单数据加载" class="menu-item">账单数据加载</a></li>
	                </ul>
              	</div>
            </div>
        </div>
	<!--panel end-->

	<!--panel start-->
		<div id="panel-bill-query">
            <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账单查询</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/query/queryBill.jsp" title="账单查询" class="menu-item">账单查询</a></li>
	                </ul>
              	</div>
            </div>
        </div>
	<!--panel end-->

	<!--panel start-->
		<div id="panel-address-modity-send">
            <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址修改补寄</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/renew/modityAddressBill.jsp" title="地址修改补寄" class="menu-item">地址修改补寄</a></li>
	                </ul>
              	</div>
            </div>
        </div>
	<!--panel end-->

	<!--panel start-->
		<div id="panel-statistic">
            <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;统计报表查询</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/report/dayReportStat.jsp" title="日报表统计" class="menu-item">日报表统计</a></li>
			 		  <li><a href="./pages/report/monthReportStat.jsp" title="月报表统计" class="menu-item">月报表统计</a></li>
	                </ul>
              	</div>
            </div>
        </div>
	<!--panel end-->

	<!--panel start-->
    	<div id="panel-backletter-manage">
            <div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;退信管理</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/withdraw/withdrawBill.jsp" title="退信管理" class="menu-item">退信管理</a></li>
	                  <li><a href="./pages/withdraw/withdrawQuery.jsp" title="退信记录查询" class="menu-item">退信记录查询</a></li>
	                </ul>
              	</div>
            </div>
        </div>
	<!--panel end-->
	<!--panel start-->
		<div id="panel-test-manage">
        	<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;测试管理</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/test/welcome.jsp" title="测试拦截器" class="menu-item">测试拦截器</a></li>
	             	  <li><a href="./page.jsp" title="测试分页" class="menu-item">测试分页</a></li>
	             	  <li><a href="./upload.jsp" title="测试上传" class="menu-item">测试上传</a></li>
	             	  <li><a href="./tableGrid.jsp" title="测试表格插件" class="menu-item">表格插件</a></li>
	             	  <li><a href="./flexiGrid.jsp" title="AJAX表格插件" class="menu-item">AJAX表格插件</a></li>
	                </ul>
              	</div>
        	</div>
        </div>
	<!--panel end-->
	<!--panel start-->
		<div id="pannel-finance-manage">
        	<div><img src="../images/list.jpg"/>&nbsp;公司财务管理</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/system/parameterSetting.jsp" title="系统参数设置" class="menu-item">系统参数设置</a></li>
	                  <li><a href="deptList.action" title="用户管理" class="menu-item">用户管理</a></li>
	               	  <li><a href="pintInstList.action" title="打印服务商设置" class="menu-item">打印服务商设置</a></li>
	                </ul>
              	</div>
            </div>
		</div>
	<!--panel end-->
	<!--panel start-->
		<div id="pannel-person-manage">
        	<div><img src="../images/list.jpg"/>&nbsp;人力资源管理</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/system/parameterSetting.jsp" title="系统参数设置" class="menu-item">系统参数设置</a></li>
	                  <li><a href="deptList.action" title="用户管理" class="menu-item">用户管理</a></li>
	               	  <li><a href="pintInstList.action" title="打印服务商设置" class="menu-item">打印服务商设置</a></li>
	                </ul>
              	</div>
            </div>
		</div>
	<!--panel end-->
	
	<!--panel start-->
		<div id="pannel-system-manage">
        	<div><img src="../images/list.jpg"/>&nbsp;系统平台管理</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/system/parameterSetting.jsp" title="系统参数设置" class="menu-item">系统参数设置</a></li>
	                  <li><a href="deptList.action" title="用户管理" class="menu-item">用户管理</a></li>
	               	  <li><a href="pintInstList.action" title="打印服务商设置" class="menu-item">打印服务商设置</a></li>
	                </ul>
              	</div>
            </div>
		</div>
	<!--panel end-->
	<!--panel start-->
		<div id="pannel-help-manage">
        	<div><img src="../images/help.jpg"/>&nbsp;帮助</div>
            <div>
              	<div class="text-content">
	                <ul>
	                  <li><a href="./pages/system/parameterSetting.jsp" title="系统操作帮助" class="menu-item">操作帮助</a></li>
	               	  <li><a href="pintInstList.action" title="系统地图" class="menu-item">系统地图</a></li>
	               	  <li><a href="pintInstList.action" title="系统版本说明" class="menu-item">版本说明</a></li>
	                </ul>
              	</div>
            </div>
		</div>
	<!--panel end-->
	</div>
</div>
<iframe id="main" src="page.jsp"></iframe>
<map name="Map" id="Map">
	<area shape="rect" coords="3,1,49,22" href="#" />
	<area shape="rect" coords="52,2,95,21" href="#" />
	<area shape="rect" coords="102,2,144,21" href="#" />
	<area shape="rect" coords="150,1,197,22" href="#" />
	<area shape="rect" coords="210,2,304,20" href="#" />
	<area shape="rect" coords="314,1,361,23" href="#" />
</map>
</body>
</html>

