<%@page import="model.bean.News"%>
<%@page import="model.dao.NewsDAO"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<div class="left-bar">
<div style="background-color:red; height=20px; width:100px"></div>	
				<div class="cat">
					<span>Danh mục việc làm <span>
					<ul>
					<%	String active = request.getParameter("active");	
					  	CategoryDAO categoryDAO = new CategoryDAO();
					  	ArrayList<Category> categories = categoryDAO.getItems();
					  	if(categories != null && categories.size() > 0){
					  		for(Category item: categories){
					  %>
						<li class="<%if(!active.equals(String.valueOf(item.getId()))){ out.print("noactive");}else {out.print("active");} %>">
							<a href="<%=request.getContextPath()%>/cat?cat_id=<%=item.getId()%>&active=<%=item.getId()%>"> <%=item.getName() %> </a>
						</li>
					<%} }%>	
					</ul>
				</div>
				<div class= "newjob">
					<span>Tuyển dụng mới <span>
						<ul>
						<%
							NewsDAO newsDAO = new NewsDAO();
							ArrayList<News> left_barnews = newsDAO.getItemsTop(4);
							if(left_barnews != null && left_barnews.size() > 0){
								for(News item: left_barnews){
						%>
						<li><a href="<%=request.getContextPath()%>/detail?id=<%=item.getId()%>&active=<%=item.getCategory().getId()%>"><%=item.getTitle() %></a> <p><%=item.getDate() %></p></li>
						<%} }else{ %>
						<ul> Không có dữ liệu</ul>
						<%} %>
					</ul>
				</div>
			</div>