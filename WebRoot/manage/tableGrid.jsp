<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tableGrid.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="styles/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="scripts/ligerUI/jquery/jquery-1.3.2.min.js" type="text/javascript"></script>
    <script src="scripts/ligerUI/plugins/ligerGrid.js" type="text/javascript"></script>
    <script src="scripts/ligerUI/plugins/ligerCheckBox.js" type="text/javascript"></script>
    
    <script type="text/javascript">
        $(function ()
        {
            var jsonObj = {};
            jsonObj.Rows = [
                { id: 1, name: "林三", sex: "男", birthday: "1953/01/12" },
                { id: 2, name: "陈丽", sex: "女", birthday: "1949/01/12" },
                { id: 3, name: "啊三", sex: "男", birthday: "1961/12/12" },
                { id: 4, name: "表三", sex: "男", birthday: "1985/01/12" },
                { id: 5, name: "陈丽", sex: "女", birthday: "1967/01/12" },
                { id: 6, name: "成三", sex: "男", birthday: "1989/11/23" },
                { id: 7, name: "都三", sex: "女", birthday: "1919/04/12" },
                { id: 8, name: "鄂三", sex: "男", birthday: "1909/05/15" },
                { id: 9, name: "林三", sex: "男", birthday: "1969/02/21" },
                { id: 10, name: "赵开", sex: "男", birthday: "1999/01/12" },
                { id: 11, name: "王开", sex: "男", birthday: "1979/01/12" },
                { id: 12, name: "张开", sex: "男", birthday: "1949/01/12" },
                { id: 13, name: "刘开", sex: "男", birthday: "1969/01/12" },
                { id: 14, name: "姚开", sex: "男", birthday: "1959/01/12" },
                { id: 15, name: "黑开", sex: "男", birthday: "1929/01/12" }
            ];
            $("#maingrid").ligerGrid({
                columns: [
                { display: '', width: 30, isAllowHide: false, name: 'checkbox', isSort: false,
                    render: function (row)
                    {
                        var html = '<input type ="checkbox" rowid ="' + row.id + '">';
                        return html;
                    },
                    headerRender: function (column)
                    {
                        var html = '<input type ="checkbox" onclick="selectAll(this)">';
                        return html;
                    }
                },
                { display: '主键', name: 'id', width: 50, type: 'int' },
                { display: '名字', name: 'name', width: 50 },
                { display: '性别', name: 'sex', width: 50, isSort: false
                },
                { display: '生日', name: 'birthday', type: 'date', width: 100 },
                {
                    display: '模板列', isAllowHide: false,
                    render: function (row)
                    {
                        var html = '<a href="#" onclick="onedit(' + row.id + ')">编辑</a>';
                        return html;
                    }
                }
                ],width:'100%',
                data: jsonObj,
                url: "../Default.aspx", pkName: 'id',
                pageSizeOptions: [5, 10, 15, 20],
                onAfterShowData: function (grid)
                {
                    if ($.fn.ligerCheckBox)
                        $(".l-grid-body input:checkbox,.l-grid-hd-cell input:checkbox", grid).ligerCheckBox({ css: { marginTop: 3} })
                }
            });
        });
        function selectAll(obj)
        {
            $("#maingrid td[columnname=checkbox]").find(":checkbox").each(function ()
            {
                this.checked = obj.checked;
                $(this).trigger("change");
            });
        }
        function onedit(id)
        {
            alert("您选中的ID是" + id);
        }
        function showalert(content)
        {
            $.ligerMessageBox.alert('提示内容', content);
        }
        function getSelectedIds()
        {
            var rowids = "";
            $("#maingrid .l-grid-row td[columnindex=0]").find(":checkbox").each(function ()
            {
                if (this.checked)
                    rowids += $(this).attr("rowid") + ",";
            });
            if (rowids.length > 0) rowids = rowids.substr(0, rowids.length - 1);
            alert(rowids);
        }
        function getSelected()
        {
            var manager = $("#maingrid").ligerGetGridManager();
            var row = manager.getSelectedRow();
            alert("您选择的是:" + row.name + " | " + row.birthday);
        }
    </script>
  </head>
  
  <body>
	<div id="maingrid"></div>
   		<br />
   		<a class="l-button" style="width:120px" onclick="getSelectedIds()">获取选中的值(复选框)</a>
   		<br />
   		<a class="l-button" style="width:120px" onclick="getSelected()">获取选中的值(选择行)</a> <div style="display:none;">
   
	</div>
  </body>
</html>
