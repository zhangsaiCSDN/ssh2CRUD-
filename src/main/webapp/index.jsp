<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>员工管理系统</title>

<style type="text/css">
	
	body{
		margin: 0;
	}
	
	#container{
		width: 1100px;
		height: 600px;
		border: 1px black solid;
		margin: auto;
	}
	
	#top{
		font-size :30px;
		height: 15%;
		text-align: center;
		line-height: 90px;
		text-shadow: 5px 5px 5px 5px red;
	}
	
	#buttom{
		height: 85%;
	}
	
	#buttom-left{
		height: 100%;
		width:20%;
		float:left;
	}
	
	#buttom-right{
		height: 100%;
		width:80%;
		float:left;
	}
	li{
		list-style: none;
	}
</style>
</head>
<body>
	<div id="container">
		<div id="top">
			蜗牛学院员工管理系统
		</div>
		<div id="buttom">
			
			<div id="buttom-left">
				<ul>
					<li>部门管理
						<ul>
							<li>
								<a href="dept_find" target="mainFrame">查看部门</a>
							</li>
							<li>
								<a href="dept/saveUI.jsp" target="mainFrame">添加部门</a>
							</li>
						</ul>
					</li>
					<li>员工管理
						<ul>
							<li>
								<a href="emp_find" target="mainFrame">查看员工</a>
							</li>
							<li> 
								<a href="emp_saveUI" target="mainFrame">添加员工</a>
							</li>
							
						</ul>
					</li>
				</ul>
			</div>
			
			<div id="buttom-right">
			   	<iframe name="mainFrame" width="100%" height="100%" frameborder="0"></iframe>
			
			</div>
		</div>
	</div>
</body>
</html>