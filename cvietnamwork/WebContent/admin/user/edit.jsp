<%@page import="model.bean.Role"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/left-bar.jsp" %>

				
			<div class="bodyAddCat">
				<div class="title"><h2>Sửa người người dùng</h2></div>
				<div class="addForm">
					<form action="" method="post"  id="form">
					<%
						String username = request.getParameter("username");
						String password = request.getParameter("password");
						String fullname = request.getParameter("fullname");
						String email = request.getParameter("email");
						String role = request.getParameter("role");
						
						String err = request.getParameter("err");
						
						User user = (User) request.getAttribute("user");
						if(user != null){
							username = user.getUsername();
							password = user.getPassword();
							fullname = user.getFullname();
							email = user.getEmail();
							role = String.valueOf( user.getRole().getId() );
						}
						
						
						if("1".equals(err)){
	        				out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Sửa người dùng thất bại </span>");
	        			}
					%>
						<div class="addNews">
							<label for="username">UserName</label>
							<input type="text" id="username" value="<%if(username != null){out.print(username);} %>" name=username"" disabled="disabled" />	
						</div>	
						<div class="addNews">
							<label for="password">PassWord</label>
							<input type="text" id="password" value="<%if(password != null){out.print(password);} %>" name="password" />
						</div>
						<div class="addNews">
							<label for="fullname">FullName</label>
							<input type="text" id="fullname" value="<%if(fullname != null){out.print(fullname);} %>" name="fullname" />
						</div>
						<div class="addNews">
							<label for="email">Email</label>
							<input type="text" id="email" value="<%if(email != null){out.print(email);} %>" name="email" />
						</div>
						<div class="addNews">
							<label for="role">Role</label> <br />
							<select name="role" >
							<% ArrayList<Role> roles = (ArrayList<Role>)request.getAttribute("roles"); 
								if(roles != null && roles.size() > 0){
									for(Role item: roles){
							%>
							<option value="<%=item.getId() %>" <%if(String.valueOf(item.getId()).equals(role)) out.print(" selected"); %> ><%=item.getName() %></option>
							<%}}else{ %>
								Không có dữ liệu
							<%} %>
<%-- 								<option value="1" <%if("1".equals(role_id)) out.print(" selected"); %> >1 (admin)</option> --%>
<%-- 								<option value="2" <%if("2".equals(role_id)) out.print(" selected"); %>>2 (suppermod)</option> --%>
<%-- 								<option value="3" <%if("3".equals(role_id)) out.print(" selected"); %>>3 (mod)</option> --%>
								
							</select>
						</div>
						<button type="submit" name="submit" >Sửa</button>
					</form>
				</div>	
			</div>
			<div class="clr"></div>
			<div class="footer">
				<span>Copyright 2021 © || Code by Tran Van Trinh </span>
			</div>
		</div>
	</body>
</html>