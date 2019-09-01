<%@ page language="java"   pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>查看员工</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<form action="emp_find" method="post" id="from">
		<input id="pz" type="hidden" name="pz" value="">
		<input id="keywords" name="ename" placeholder="关键字搜索" value="${page.keywords }">
		<button type="submit">搜索</button>
	</form>
	 <table width="100%">
	 	<tr>
	 		<td>员工id</td>
	 		<td>员工名称</td>
	 		<td>员工工资</td>
	 		<td>入职日期</td>
	 		<td>员工部门</td>
	 		<td>操作</td>
	 	</tr>
		<c:forEach items="${page.list }" var="emp">
			<tr>
				<td>${emp.eid }</td>
		 		<td>${emp.ename }</td>
		 		<td>${emp.sal }</td>
		 		<td>${emp.hiredate }</td>
		 		<td>${emp.dept.dname }</td>
		 		<td>
					<a href="emp_updateUI?eid=${emp.eid }&pz=${page.p}&ename=${page.keywords}">修改</a>
					<a href="emp_delete?eid=${emp.eid }&pz=${page.p}&ename=${page.keywords}">删除</a>
				</td>
			</tr>
		</c:forEach>	 	
 	
 		<tr>
			<td colspan="4">
				<font size="4" color="red">${page.p }</font>
				/${page.countPages }
				<a href="javascript:search(1)">首页</a>
				<a href="javascript:search(${page.prev })">上一页</a>
				
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="x">
					<c:if test="${x==page.p }">
						<font size="4" color="red">${x }</font>
					</c:if>
				
					<c:if test="${x!=page.p }">
						<a href="javascript:search(${x })">${x }</a>
					</c:if>
				</c:forEach>
				
				<a href="javascript:search(${page.next })">下一页</a>
				<a href="javascript:search(${page.countPages })">末页</a>
				跳转至<form action="emp_find" method="post" style="display: inline;">
						<input name="pz" size="1"><button>GO</button>
					</form>
				共${page.countRow }行数据
				
			</td>
		 	 
		</tr>
 	
 	
	 </table>
<script type="text/javascript">
	function search(page){
		
		var pobj=document.getElementById("pz");
		pobj.value=page;
		document.getElementById("from").submit();
		}
</script>
</body>
</html>