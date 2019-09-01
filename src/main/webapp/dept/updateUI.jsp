<%@ page language="java"   pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>添加部门</title>
</head>
<body>
	<form action="dept_update">
		<input  name="did" type="hidden" value="${dept.did}">
		部门名称：<input  name="dname" value="${dept.dname}"><br/>
		<button type="submit">添加</button>
	</form>
</body>
</html>