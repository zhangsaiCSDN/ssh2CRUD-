<%@ page language="java"   pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>添加部门</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<form  action="dept_save"  >
		部门名称：<input id="dname" name="dname" ><br/>
		<button id="sb" type="submit">添加</button>
	</form>
</body>
<script type="text/javascript">

	$(function(){
		$("#dname").blur(function(){
				var str = $("#dname").val();
				$.ajax({
					type:'post',
					url:'dept_checkName',
					data:{"dname":str},
					success:function(data){
						alert(data);
						var d =JSON.parse(data);
						if(d=="用户名已存在"){
							$("#sb").attr("disabled", true);
						}else{
							$("#sb").attr("disabled", false);
							}
					}
				})

			});
		});
</script>
</html>