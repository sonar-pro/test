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
                { id: 1, name: "����", sex: "��", birthday: "1953/01/12" },
                { id: 2, name: "����", sex: "Ů", birthday: "1949/01/12" },
                { id: 3, name: "����", sex: "��", birthday: "1961/12/12" },
                { id: 4, name: "����", sex: "��", birthday: "1985/01/12" },
                { id: 5, name: "����", sex: "Ů", birthday: "1967/01/12" },
                { id: 6, name: "����", sex: "��", birthday: "1989/11/23" },
                { id: 7, name: "����", sex: "Ů", birthday: "1919/04/12" },
                { id: 8, name: "����", sex: "��", birthday: "1909/05/15" },
                { id: 9, name: "����", sex: "��", birthday: "1969/02/21" },
                { id: 10, name: "�Կ�", sex: "��", birthday: "1999/01/12" },
                { id: 11, name: "����", sex: "��", birthday: "1979/01/12" },
                { id: 12, name: "�ſ�", sex: "��", birthday: "1949/01/12" },
                { id: 13, name: "����", sex: "��", birthday: "1969/01/12" },
                { id: 14, name: "Ҧ��", sex: "��", birthday: "1959/01/12" },
                { id: 15, name: "�ڿ�", sex: "��", birthday: "1929/01/12" }
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
                { display: '����', name: 'id', width: 50, type: 'int' },
                { display: '����', name: 'name', width: 50 },
                { display: '�Ա�', name: 'sex', width: 50, isSort: false
                },
                { display: '����', name: 'birthday', type: 'date', width: 100 },
                {
                    display: 'ģ����', isAllowHide: false,
                    render: function (row)
                    {
                        var html = '<a href="#" onclick="onedit(' + row.id + ')">�༭</a>';
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
            alert("��ѡ�е�ID��" + id);
        }
        function showalert(content)
        {
            $.ligerMessageBox.alert('��ʾ����', content);
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
            alert("��ѡ�����:" + row.name + " | " + row.birthday);
        }
    </script>
  </head>
  
  <body>
	<div id="maingrid"></div>
   		<br />
   		<a class="l-button" style="width:120px" onclick="getSelectedIds()">��ȡѡ�е�ֵ(��ѡ��)</a>
   		<br />
   		<a class="l-button" style="width:120px" onclick="getSelected()">��ȡѡ�е�ֵ(ѡ����)</a> <div style="display:none;">
   
	</div>
  </body>
</html>
