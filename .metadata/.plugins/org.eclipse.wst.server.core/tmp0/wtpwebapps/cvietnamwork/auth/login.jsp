<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>VIETNAMWORK</title>
		<meta charset="UTF-8"/>
		<link href="<%=request.getContextPath()%>/templates/admin/assets/css/style/styleLogin.css" rel="stylesheet" />
		<link href="<%=request.getContextPath()%>/templates/admin/assets/css/reset/reset.css" rel="stylesheet" />
	</head>
	<body>
		<div class="wrapper">
		<%
			String display = request.getParameter("display");
			if("public".equals(display)){
		%>
			<div class="header"> <a href="<%=request.getContextPath() %>/index?display=public" >VIETNAMWORK	</a></div>	
		<%}else{ %>
			<div class="header"> <a href="<%=request.getContextPath() %>/admin/index?display=admin" >VIETNAMWORK	</a></div>	
		<%} %>
			
			<div class="bodyLogin">
				<h1> Đăng nhập <h1>
				<%
					String err = request.getParameter("err");
					String msg = request.getParameter("msg");
					if("1".equals(err)){
	    				out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Đăng nhập thất bại </span>");
	    			}
					if("1".equals(msg)){
	    				out.print("<span style=\"background: yellow; color: green; font-weight: bold; font-size: 20px; padding: 5px; \">Đăng ký thành công, hãy đăng nhập !</span>");
	    			}
				%>
				<form action="" method="post" id="form">
					<div>
						<label for="username">Tên đăng nhập</label>
						<input type="text" id="username" value="" name="username" placeholder="username"/>
					</div>
					<div>
						<label for="password">Mật khẩu</label>
						<input type="password" id="password" value="" name="password" placeholder="password"/>
					</div>
					<button type="submit" name="submit" >Login</button>
				</form>	
				<%
					if("public".equals(display)){
				%>
					<div class="signup">Don't have an account yet? <a href="<%=request.getContextPath()%>/signup">Sign Up</a> </div>
				<%} %>	
			</div>

		</div>
	</body>
</html>