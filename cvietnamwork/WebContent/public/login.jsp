<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>VIETNAMWORK</title>
		<meta charset="UTF-8"/>
		<link href="<%=request.getContextPath()%>/templates/public/assets/css/style/styleLogin.css" rel="stylesheet" />
		<link href="<%=request.getContextPath()%>/templates/public/assets/css/reset/reset.css" rel="stylesheet" />
	</head>
	<body>
		<div class="wrapper">
			<div class="header">
				<a href="<%=request.getContextPath()%>/index?headerActive=1&page=1" >VIETNAMWORK	</a>
			</div>	
			<div class="bodyLogin">
				<h1> Đăng nhập <h1>
				<form action="" method="post">
					<div>
						<label for="username">Tên đăng nhập</label>
						<input type="text" id="username" value="" name="" placeholder="username"/>
					</div>
					<div>
						<label for="password">Mật khẩu</label>
						<input type="text" id="password" value="" name="" placeholder="password"/>
					</div>
					<button type="submit" name="submit" >Login</button>
				</form>
				<%
					String display = request.getParameter("display");
					if("public".equals(display)){
				%>
					<div class="signup">Don't have an account yet? <a href="<%=request.getContextPath()%>/signup">Sign Up</a> </div>
				<%} %>	
			</div>

		</div>
	</body>
</html>