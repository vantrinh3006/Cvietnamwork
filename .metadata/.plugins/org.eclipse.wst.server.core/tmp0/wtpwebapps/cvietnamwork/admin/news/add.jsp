<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/left-bar.jsp" %>

			<div class="bodyAddCat">
				<div class="title"><h2>Thêm tin tuyển dụng</h2></div>
				<%	ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories");
				
					String title = request.getParameter("title");
					String corporatename = request.getParameter("corporatename");
					String adress = request.getParameter("adress");
					String jobrequest = request.getParameter("jobrequest");
					String jd = request.getParameter("jd");
					String salary =  request.getParameter("salary");
					String email = request.getParameter("email");
					String cat_id =  request.getParameter("category");
					
					String err = request.getParameter("err");
					if("1".equals(err)){
        				out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Thêm user thất bại</span>");
        			}
        		%>
				<div class="addForm">
					<form action="" method="post"  id="form">
						<div class="addNews">
							<label for="title">Tiêu đề</label> <br />
							<input type="text" id="tile" value="<%if(title != null) out.print(title); %>" name="title" />	
						</div>	
						<div class="addNews">
							<label for="corporatename">Tên công ty</label> <br />
							<input type="text" id="name" value="<%if(corporatename != null) out.print(corporatename); %>" name="corporatename" />	
						</div>	
						<div class="addNews">
							<label for="adress">Tỉnh/thành phố</label> <br />
							<input type="text" id="adress" value="<%if(adress != null) out.print(adress); %>" name="adress" />
						</div>
						<div class="addNews">
							<label for="jobrequest">Yêu cầu</label> <br />
							<input type="text" id="jobrequest" value="<%if(jobrequest != null) out.print(jobrequest); %>" name="jobrequest" />
						</div>
						<div class="addNews">
							<label for="jd">Mô tả công việc</label> <br />
							<input type="text" id="jd" value="<%if(jd != null) out.print(jd); %>" name="jd" />
						</div>
						<div class="addNews">
							<label for="salary">Mức lương</label> <br />
							<input type="text" id="salary" value="<%if(salary != null) out.print(salary); %>" name="salary" />
						</div>
						<div class="addNews">
							<label for="email">Email công ty</label> <br />
							<input type="text" id="email" value="<%if(email != null) out.print(email); %>" name="email" />
						</div>
						<div class="addNews">
							<label for="category">Danh mục</label> <br />
							<select name="category" >
								<%
									if(categories != null && categories.size() >0){
										for(Category item: categories){
								%>
								<option value="<%=item.getId() %>" <%if(cat_id != null && cat_id.equals(item.getId()))out.print(" selected"); %>><%=item.getName() %></option>
								<%} }else{%>
											Không có dữ liệu
								<%} %>
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