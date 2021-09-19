<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/admin/inc/header.jsp"%>
<%@ include file="/templates/admin/inc/left-bar.jsp"%>


<div class="bodyAddCat">
	<div class="title">
		<h2>Sửa tin tuyển dụng</h2>
	</div>
	<div class="addForm">
		<form action="" method="post" id="form">
			<%	ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("categories");
				News news = (News) request.getAttribute("news");
				
				String title = request.getParameter("title");
				String corporatename = request.getParameter("corporatename");
				String adress = request.getParameter("adress");
				String jobrequest = request.getParameter("jobrequest");
				String jd = request.getParameter("jd");
				String salary = request.getParameter("salary");
				String email = request.getParameter("email");
				String cat_id = request.getParameter("category");  
			if (news != null) {
				title = news.getTitle();
				corporatename = news.getCorporatename();
				adress = news.getAdress();
				jobrequest = news.getJobrequest();
				jd = news.getJd();
				salary =  String.valueOf(news.getSalary());
				email = news.getEmail();
				cat_id = String.valueOf( news.getCategory().getId() );						 
			}
			
			String err = request.getParameter("err");
	    	if("1".equals(err)){
	    		out.print("<span style=\"background: yellow; color: red; font-weight: bold; padding: 5px; \">Lỗi khi sửa tin tuyển dụng </span>");
	    	}
			%>
			<div class="addNews">
				<label for="title">Tiêu đề</label> <br /> 
				<input type="text"	id="tile" value="<% if(title!=null) out.print(title);%>" name="title" />
			</div>
			<div class="addNews">
				<label for="corporatename">Tên công ty</label> <br />
				 <input	type="text" id="corporatename" value="<% if(corporatename!=null) out.print(corporatename);%>" name="corporatename" />
					
			</div>
			<div class="addNews">
				<label for="adress">Tỉnh/thành phố</label> <br /> 
				<input	type="text" id="adress" value="<% if(adress!=null) out.print(adress);%>" name="adress" />
					
			</div>
			<div class="addNews">
				<label for="jobrequest">Yêu cầu</label> <br /> 
				<input type="text"	id="jobrequest" value="<% if(jobrequest !=null) out.print(jobrequest);%>"	name="jobrequest" />
			</div>
			<div class="addNews">
				<label for="jd">Mô tả công việc</label> <br /> 
				<textarea type="text"	id="jd" value="" name="jd" style="font-size:20px;width:1150px;height:131px;"><% if(jd != null) out.print(jd);%> </textarea>
			</div>
			<div class="addNews">
				<label for="salary">Mức lương</label> <br /> 
				<input type="text"	id="salary" value="<% if(salary != null) out.print(salary);%>" name="salary" />
			</div>
			<div class="addNews">
				<label for="email">Email công ty</label> <br /> 
				<input type="text"	id="email" value="<% if(email != null) out.print(email);%>" name="email" />
			</div>
			<div class="addNews">
				<label for="category">Danh mục</label> <br /> 
				<select	id="category" name="category">
					<%	
						if (categories != null && categories.size() > 0) {
						for (Category item: categories) {
					%>
					<option value="<%=item.getId()%>" <%if (cat_id != null && cat_id.equals(String.valueOf(item.getId() ))) out.print(" selected");%>> 
						<%=item.getName()%>
					</option>
		
					<%}} else {%>
						
					 Không có dữ liệu
					<%}%>
				</select>
			</div>
			<button type="submit" name="submit">Sửa</button>
		</form>
	</div>
</div>
<div class="clr"></div>
<%@ include file="/templates/admin/inc/footer.jsp"%>