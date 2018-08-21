<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String username =request.getParameter("username");
	application.setAttribute("user",username);
%>
<head>
	<title>登陆</title>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	 <div class="main">
		<div class="login-form">
			<h1>用户登陆</h1>
					<div class="head">
						<img src="images/user.png" alt=""/>
					</div>
				<form action="LoadFilterServlet" method="post">
						<input type="text" id="username" class="text" value="用户名" name="username">
						<input type="text" id="password" name="password" value="密码">
						<input type="password" id="password1" name="password1" value="password" style="display: none;">
						<div class="submit">
						<input type="submit" value="登陆">
					</div>	
					<p>
						<a href="#">忘记密码 ?</a> &nbsp;&nbsp;&nbsp;
						<a href="login.jsp">注册</a>
					</p>
				</form>
			</div>
			<!--//End-login-form-->
   			<div class="copy-right">
				<p><a> &nbsp;&nbsp;&nbsp;Copyright &copy; 2018</a></p>
			</div>
		</div>
			 <!-----//end-main---->
</body>
</html>