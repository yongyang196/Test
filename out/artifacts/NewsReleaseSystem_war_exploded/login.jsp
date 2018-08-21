<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
	<title>注册</title>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	 <div class="main">
		<div class="login-form">
			<h1>用户注册</h1>
					<div class="head">
						<img src="images/user.png" alt=""/>
					</div>
				<form action="LoginServlet" method="post">
						<input type="text" id="username" class="text" value="用户名" name="username">
						<input type="text" id="password" name="password" value="密码">
						<input type="password" id="password1" name="password1" style="display: none;">
						<input type="text" id="password2" name="password2" value="确认密码">
						<input type="password" id="password3" name="password3" style="display: none;">
						<input type="text" name="tel" value="手机号" id="tel">
						<p class="p1">性别：
							<input type="radio" name="sex" class="sex" value="男">男
							<input type="radio" name="sex" class="sex" value="女">女
						</p>
						<div class="submit">
							<input type="submit" value="注册">
						</div>	
					<p>
						<a href="#">忘记密码 ?</a> &nbsp;&nbsp;&nbsp;
						<a href="load.jsp">登陆</a>
					</p>
				</form>
			</div>
			<!--//End-login-form-->
   			<div class="copy-right">
				<p> &nbsp;&nbsp;&nbsp;Copyright &copy; 2018</a></p> 
			</div>
		</div>
			 <!-----//end-main---->
</body>
</html>