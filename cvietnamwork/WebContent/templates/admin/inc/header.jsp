<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
	<head> 
		<title>VIETNAMWORK</title>
		<meta charset="UTF-8"/>
		<link href="<%=request.getContextPath()%>/templates/admin/assets/css/style/style.css" rel="stylesheet" />
		<link href="<%=request.getContextPath()%>/templates/admin/assets/css/reset/reset.css" rel="stylesheet" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

	</head>
	<body>	
		<div class="wrapper">
			<div class="header">
				<span class="logo"><a href="<%=request.getContextPath() %>/admin/index" >VIETNAMWORK</a></span>
				<%
	            	User userLogin = (User) session.getAttribute("userLogin");
	            	if(userLogin != null){
         	    %>
					<span class="login"><span><%=userLogin.getFullname() %></span><a href="<%=request.getContextPath()%>/logout?display=admin">Đăng xuất</a></a></span>
				<%}else{ %>
					<span class="login"><span>Khách</span><a href="<%=request.getContextPath()%>/login?display=admin">Đăng nhập</a></span>
				<%} %>
			</div>