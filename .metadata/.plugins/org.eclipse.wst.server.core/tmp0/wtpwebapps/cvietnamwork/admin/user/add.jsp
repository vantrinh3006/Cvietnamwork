<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/left-bar.jsp" %>

			
			<div class="bodyAddCat">
				<div class="title"><h2>Thêm người người dùng</h2></div>
				<%
					String err = request.getParameter("err");
		        	if("1".equals(err)){
		        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Thêm user thất bại </span>");
		        	}
		        	if("2".equals(err)){
		        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Đã tồn tại username</span>");
		        	}
				%>
				<div class="addForm">
					<form action="" method="post"  id="form">
						<div class="addNews">
							<label for="username">UserName</label>
							<input type="text" id="username" value="" name="username" />	
						</div>	
						<div class="addNews">
							<label for="password">PassWord</label>
							<input type="text" id="password" value="" name="password" />
						</div>
						<div class="addNews">
							<label for="fullname">FullName</label>
							<input type="text" id="fullname" value="" name="fullname" />
						</div>
						<div class="addNews">
							<label for="email">Email</label>
							<input type="text" id="email" value="" name="email" />
						</div>
						<div class="addNews">
							<label for="role_id">Role_id</label> <br />
							<select name="role_id" >
								<option value="1" >1 (admin)</option>
								<option value="2" >2 (suppermod)</option>
								<option value="3" >3 (mod)</option>
							</select>
						</div>
						<button type="submit" name="submit" >Thêm</button>
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