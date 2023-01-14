<%@ page language="java"  pageEncoding="utf-8"%>



<html>
  <head>
  <meta name="Keywords" content="your, keywords" />
	<meta http-equiv="Content-Type" content="text/html; charset=GB2312" />
	<meta name="Distribution" content="Global" />
	<meta name="Robots" content="index,follow" />
	<link rel="stylesheet" type="text/css" href="styles/ext-all.css" />
	<link rel="stylesheet" type="text/css" href="styles/cms.css" />
	<link rel="stylesheet" type="text/css" href="styles/table.css" />
	<script type="text/javascript" src="scripts/jquery/jquery.js"></script>
	<script type="text/javascript" src="scripts/jquery/jquery-plugins.js"></script>
	<script type="text/javascript" src="scripts/jquery/ext-jquery-adapter.js"></script>
	<script type="text/javascript" src="scripts/ext-all.js"></script>

	<title>补打账单查询</title>
  </head>
  
  <body>
    <div id="tablePanel" class="datagrid">
	        	<div id="title" class="title-panel">
					<div class="float-left"><b>查询结果</b>目前共有3条记录符合查询条件</div>  		
					
	  				<div style="clear:both"></div>
				</div>
				<div id="datagridPanel" class="data-panel">
			        <table id="id-table" cellpadding=0 width="100%" border="0" class="tableStyle">
			          <thead>
					      <tr class="headerStyle">
					        <th class="headerStyle">开始时间</th>
							<th class="headerStyle">用户ID</th>
							<th class="headerStyle">机能分类</th>
							<th class="headerStyle">机能名</th>	
							<th class="headerStyle">执行状态</th>								
					      </tr>
					  </thead>
			          <tbody> 			          
			          <tr class="rowStyle"> 
			            <td class="cellOdd">2002-02-03 12:40:30</td>
						<td class="cellOdd">1001</td>
						<td class="cellOdd"><a href="SystemState_Detail.htm">账单管理</a></td>
						<td class="cellOdd">账单管理</td>
						<td class="cellOdd">成功</td>
			          </tr>
			          
			          <tr class="rowStyle"> 
			            <td class="cellOdd">2002-02-03 12:40:30</td>
						<td class="cellOdd">1001</td>
						<td class="cellOdd"><a href="SystemState_Detail.htm">账单管理</a></td>
						<td class="cellOdd">账单管理</td>
						<td class="cellOdd">成功</td>
			          </tr>
			          <tr class="rowStyle"> 
			            <td class="cellOdd">2002-02-03 12:40:30</td>
						<td class="cellOdd">1001</td>
						<td class="cellOdd"><a href="SystemState_Detail.htm">账单管理</a></td>
						<td class="cellOdd">账单管理</td>
						<td class="cellOdd">成功</td>
			          </tr>			          
			          </tbody> 
			        </table>
				</div>
				<div id="pagingPanel" class="paging-panel">
				  <form>
				   <div class="paging-item-left">共有1页3条记录，当前为第1页</div>
				   <div class="paging-item-right"><img src="images/go.gif" width="16" height="16"/></div>
				   <div class="paging-item-right"><span>到第</span><input type="text" size="3" maxlength="10" class="box"/><span>页</span></div>
				   <div class="paging-item-right"><span>每页</span><input type="text" size="3" maxlength="10" class="box"/></div>
				   <div class="paging-item-right"><a href="#">末页</a></div>
				   <div class="paging-item-right"><a href="#">下一页</a></div>
				   <div class="paging-item-right"><a href="#">上一页</a></div>
				   <div class="paging-item-right"><a href="#">首页</a></div>
				 </form>
				  <div style="clear:both"></div>
				</div>	        	
	       </div>
  </body>
</html>
