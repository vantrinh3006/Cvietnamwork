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
			<div class="header">
				VIETNAMWORK	
			</div>	
			<div class="bodyLogin">
				<h1> Sign Up <h1>
				<%
					String err = request.getParameter("err");
					if("1".equals(err)){
	    				out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Đã tồn tại username </span>");
	    			}
					if("2".equals(err)){
	    				out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Đăng ký thất bại</span>");
	    			}
				%>
				<form action="" method="post" id="form">
					<div>
						<label for="username">Tên đăng nhập</label>
						<input type="text" id="username"  name="username" placeholder="username"/>
					</div>
					<div>
						<label for="password">Mật khẩu</label>
						<input type="text" id="password"  name="password" placeholder="password"/>
					</div>
					<div>
						<label for="fullname">Tên đầy đủ</label>
						<input type="text" id="fullname"  name="fullname" placeholder="fullname"/>
					</div>
					<div>
						<label for="email">Email</label>
						<input type="text" id="email"   name="email" placeholder="email"/>
					</div>
					<button type="submit" name="submit" >Sign Up</button>
				</form>
			</div>
		</div>
	</body>
</html>