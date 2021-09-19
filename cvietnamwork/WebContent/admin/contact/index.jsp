<%@page import="model.bean.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/left-bar.jsp" %>
			
			<div class="bodyCat">
				<div class="title"><h2>Trang quản lý liên hệ</h2></div>
				 <%
		        	String err= request.getParameter("err");
		        	String msg = request.getParameter("msg");
		        	if("1".equals(err)){
		        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">	Không tồn tại ID </span>");
		        	}
		        	if("2".equals(err)){
		        		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">	Xóa contact thất bại </span>");
		        	}
		        	if("1".equals(msg)){
		        		out.print("<span style=\"background: yellow; color: green; font-weight: bold; padding: 5px; \">	Xóa contact thành công </span>");
		        	}
		        %>
				<div class="function">
					<div class="right">
						<form action="" method="post"  id="form">
							<input type="text" id="name"/>
							<button type="submit" name="submit">Tìm kiếm</button>
						</form>
					</div>
					<div class="clr"></div>
				</div>
				<div class="table">
					<table>
						<tr class="title">
							<th>ID</th>
							<th>Fullname</th>
							<th>Email</th>
							<th>Message</th>
							<th>Chức năng</th>
						</tr>
						<%
							ArrayList<Contact> contacts =(ArrayList<Contact>) request.getAttribute("contacts");
							if(contacts != null && contacts.size() > 0){
								for(Contact item: contacts){											
						%>
						<tr class="info">
							<td><%=item.getId() %></td>
							<td><%=item.getFullname() %></td>
							<td><%=item.getEmail() %></td>
							<td><%=item.getMessage() %></td>
							<td>
								<a href="<%=request.getContextPath() %>/admin/contact/del?id=<%=item.getId() %>" class="del" onclick =" return confirm('Bạn có chắc muốn xóa ?');">Xóa </a>
							</td>
						</tr>
						<%} }else{ %>
									<tr class="info">
										<td colspan="5">Không có liên hệ nào!</td>
									</tr>
						<%} %>

					</table>
				</div>
				<div class="page">
					<%
						int numberOfPages = (Integer) request.getAttribute("numberOfPages");
						int currentPage = (Integer) request.getAttribute("currentPage");
					%>
						<a href="<%=request.getContextPath()%>/admin/contacts?page=<%=1 %>"> « </a>
						<%	if(currentPage + 1 <= numberOfPages){ //chạy từ 1-> n-1
								for(int i = currentPage -1 ; i <= currentPage + 1 ; i ++ ){
									if(i==0){i=1;}	%>
									<a class="<%if(currentPage == i ){out.print("active");} %>"  href="<%=request.getContextPath()%>/admin/contacts?page=<%=i %>"> <%=i %> </a>
						<%} }else{	// đây là 2 trang cuối
								for(int i = currentPage - 1 ; i <= numberOfPages; i++){ %>
								<a class="<%if(currentPage == i ){out.print("active");} %>"  href="<%=request.getContextPath()%>/admin/contacts?page=<%=i %>"> <%=i %> </a>
						<%} }%>
						<a href="<%=request.getContextPath()%>/admin/contacts?page=<%=numberOfPages %>"> » </a>
					</div>		
			</div>
			<div class="clr"></div>
			<div class="footer">
				<span>Copyright 2021 © || Code by Tran Van Trinh </span>
			</div>
		</div>
	</body>
</html>