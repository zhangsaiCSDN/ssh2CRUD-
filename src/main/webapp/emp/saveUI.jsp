<%@ page language="java"   pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>添加员工</title>
</head>
<body>
	<form action="emp_save" method="post">
		员工名称：<input name="ename" ><br/>
		员工工资：<input name="sal" ><br/>
		入职日期：<input type="date" name="hiredate" ><br/>
		部门名称：<select name="dept.did">
					<option>---选择部门---</option>
					<c:forEach items="${page.list }" var="d">
						<option value="${d.did }">${d.dname }</option>
					</c:forEach>
				</select><br/>
		<button type="submit">添加</button>
	</form>
</body>
</html>