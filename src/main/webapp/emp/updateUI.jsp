<%@ page language="java"   pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>添加员工</title>
</head>
<body>
	<form action="emp_update" method="post">
		<input type="hidden" name="eid" value="${emp.eid }">
		员工名称：<input name="ename" value="${emp.ename }"><br/>
		员工工资：<input name="sal" value="${emp.sal }" ><br/>
		入职日期：<input type="date" name="hiredate" value="${emp.hiredate }" ><br/>
		部门名称：<select name="dept.did">
					<option value="${emp.dept.did }">${emp.dept.dname }</option>
					<c:forEach items="${deptlist }" var="d">
						<option value="${d.did }">${d.dname }</option>
					</c:forEach>
				</select><br/>
		<button type="submit">添加</button>
	</form>
</body>
</html>