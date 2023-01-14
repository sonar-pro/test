<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

</head>
<body>
<div style="padding:20px;">
		<form action="flexGrid.action" id="form1"  method="post">
			<div>工作名称:</div>
			<div><input type="text" id="name" name="name"></div>
			<div>工作地址:</div>
			<div><input type="text" id="address" name="address"></div>
			<div>工资:</div>
			<div><input type="text" id="salary" name="salary"></div>
			<div>日期:</div>
			<div><input type="text" id="date"  name="date" maxlength="20"  onclick="selectDate(this,'yyyy-MM-dd')" readonly/></div>
			<div>语言:</div>
			<div>
				<select id="language" name="language">
					<option value="中文">中文</option>
					<option value="英文">英文</option>
				</select>
			</div>
		</form>
	</div>
</body>
</html>