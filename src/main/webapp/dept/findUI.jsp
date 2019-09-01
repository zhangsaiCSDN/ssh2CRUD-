<%@ page language="java"   pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>查看部门</title>

</head>
<body>
	<form action="dept_find" method="post" id="from">
		<input id="pz" type="hidden" name="pz" value="">
		<input id="keywords" name="dname" placeholder="关键字搜索" value="${page.keywords }"><button type="submit">搜索</button>
	</form>
	 <table width="100%">
	 	<tr>
	 		<td>部门id</td>
	 		<td>部门名称</td>
	 		<td>操作</td>
	 	</tr>
		<c:forEach items="${page.list }" var="dept">
			<tr>
				<td>${dept.did }</td>
		 		<td>${dept.dname }</td>
		 		<td>
					<a href="dept_updateUI?did=${dept.did }">修改</a>
					<a href="dept_delete?did=${dept.did }">删除</a>
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
				跳转至<form action="dept_find" method="post" style="display: inline;">
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