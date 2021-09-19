<%@page import="model.bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/left-bar.jsp" %>

				
			<div class="bodyCat">
				<div class="title"><h2>Trang quản lý tin tuyển dụng</h2></div>
				<%	String err = request.getParameter("err");
					String msg = request.getParameter("msg");
					if("1".equals(err)){
        				out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">ID không tồn tại - Không tồn tại đối tượng </span>");
        			}
					if("2".equals(err)){
        				out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Xóa tin tuyển dụng thất bại </span>");
        			}
					if("3".equals(err)){
        				out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Sửa tin tuyển dụng thất bại </span>");
        			}
					if("1".equals(msg)){
        				out.print("<span style=\"background: yellow; color: blue; font-weight: bold; padding: 5px; \">Xóa tin tuyển dụng thành công </span>");
        			}
					if("2".equals(msg)){
        				out.print("<span style=\"background: yellow; color: blue; font-weight: bold; padding: 5px; \">Sửa tin tuyển dụng thành công </span>");
        			}
					if("3".equals(msg)){
        				out.print("<span style=\"background: yellow; color: blue; font-weight: bold; padding: 5px; \">Thêm tin tuyển dụng thành công </span>");
        			}
					
        		%>
				<div class="function">
					<div class="left"><a href="<%=request.getContextPath()%>/admin/news/add"><i class="fa fa-plus"></i>Thêm</a></div>
					<div class="right">
						<form action="<%=request.getContextPath()%>/admin/news/search?active=4" method="post"  id="form">
						<%	
                        	String keyWord = (String) request.getAttribute("keyWord");
                        	String value = "";
                       		 if(keyWord != null){ value = keyWord; 
                       		 }else{keyWord = "";}
                       	%>
							<input type="text" id="keyWord" name="keyWord"  placeholder="Nhập tên tiêu đề tìm kiếm" value="<%=keyWord%>"/>
							<button type="submit" name="submit" >Tìm kiếm</button>
						</form>
					</div>
					<div class="clr"></div>
				</div>
				<div class="table">
					<table>
						<tr class="title">
							<th>ID</th>
							<th>Tiêu đề</th>
							<th>Đăng ngày</th>
							<th>Tên Công ty</th>
							<th>Địa chỉ</th>
							<th>Yêu cầu</th>
							<th>Mô tả công việc</th>
							<th>Mức lương</th>
							<th>Email</th>
							<th>Danh mục</th>
							<th>Chức năng</th>
						</tr>
						<%
							ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
							if(news != null && news.size() > 0){
								for(News item: news){
						%>
							<tr class="info">
								<td><%=item.getId() %></td>
								<td><%=item.getTitle() %></td>
								<td><%=item.getDate() %></td>
								<td><%=item.getCorporatename() %></td>
								<td><%=item.getAdress() %></td>
								<td><%=item.getJobrequest() %></td>
								<td>
									<%=item.getJd() %>
								</td>
								<td><%=item.getSalary() %></td>
								<td><%=item.getEmail() %></td>
								<td><%=item.getCategory().getName() %></td>
								<td>
									<a href="<%=request.getContextPath() %>/admin/news/edit?id=<%=item.getId() %>" class="edit">Sửa </a>
									<a href="<%=request.getContextPath() %>/admin/news/del?id=<%=item.getId() %>" class="del" onclick =" return confirm('Bạn có chắc muốn xóa ?');">Xóa </a>
								</td>
							</tr>
						<%} }else{%>
									<td colspan="11">Chưa có tin tuyển dụng nào</td>
						<%} %>
					</table>
				</div>
				<div class="page">
					<%
						int numberOfPages = (Integer) request.getAttribute("numberOfPages");
						int currentPage = (Integer) request.getAttribute("currentPage");
					%>
						<a href="<%=request.getContextPath()%>/admin/news?page=<%=1 %>"> « </a>
						<%	if(currentPage + 1 <= numberOfPages){ //chạy từ 1-> n-1
								for(int i = currentPage -1 ; i <= currentPage + 1 ; i ++ ){
									if(i==0){i=1;}	%>
									<a class="<%if(currentPage == i ){out.print("active");} %>"  href="<%=request.getContextPath()%>/admin/news?page=<%=i %>"> <%=i %> </a>
						<%} }else{	// đây là 2 trang cuối
								for(int i = currentPage - 1 ; i <= numberOfPages; i++){ %>
								<a class="<%if(currentPage == i ){out.print("active");} %>"  href="<%=request.getContextPath()%>/admin/news?page=<%=i %>"> <%=i %> </a>
						<%} }%>
						<a href="<%=request.getContextPath()%>/admin/news?page=<%=numberOfPages %>"> » </a>
				</div>		
			</div>
			<div class="clr"></div>
			<div class="footer">
				<span>Copyright 2021 © || Code by Tran Van Trinh </span>
			</div>
		</div>
	</body>
</html>
