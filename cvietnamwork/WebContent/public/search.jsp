<%@page import="model.bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<%@ include file="/templates/public/inc/left-bar.jsp" %>
				
				
			<div class="body">
				<div class="searchframe">
				<%	
			         String searchtitle = (String)request.getAttribute("searchtitle");
					 String searchadress = (String)request.getAttribute("searchadress");
			         String seachtitleValue ="";
			         String searchadressValue  = "";
			         if(searchtitle != null){ 
			        	 seachtitleValue = searchtitle; 
			         }else{searchtitle = "";}
			         
			         if(searchadress != null){ 
			        	 searchadressValue = searchadress; 
			         }else{searchadressValue = "";}
			    %>
					<form action="<%=request.getContextPath() %>/search?active=0" method="post"  id="form">
						<input type="text" id="searchtitle" value="<%=seachtitleValue %>" name="searchtitle" placeholder="Tìm kiếm việc làm"/>
						<input type="text" id="searchadress" value="<%=searchadressValue %>" name="searchadress" placeholder="Tỉnh/Thành phố"/>
						<button type="submit" name="submit">Tìm kiếm</button>
					</form>	
				</div>
				<div class="allnews">
				<%
					ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
					if(news != null && news.size() > 0){
						for(News item: news){
				%>
					<div class="news">
						<div class="title"><a href="<%=request.getContextPath()%>/detail?id=<%=item.getId()%>&active=<%=item.getCategory().getId()%>"><%=item.getTitle() %><a></div>
						<div>
							<div class="right">
								<ul>
									<li class="info">Đăng ngày: <%=item.getDate() %></li>
									<li class="info">Tên công ty: <%=item.getCorporatename() %></li>
									<li class="info">Tỉnh/Thành phố: <%=item.getAdress() %></li>
									<li class="info">Lương: <%=item.getSalary() %></li>
									<li class="detail" >
										<a href="<%=request.getContextPath()%>/detail?id=<%=item.getId()%>&active=0" ><i class="fa fa-hand-o-right"> chi tiết</i> </a> 
									</li>
								</ul>
							</div>
							<div class="left">
							
							</div>
							<div class="clr"></div>	
						</div>	
					</div>	
				<%} }else{ %>
				<div class="news">
						<div class="title">Không có danh mục tuyển dụng nào !</div>
					</div>	
				<%} %>	
				</div>		
				<div class="page">
					<%
						int numberOfPages = (Integer) request.getAttribute("numberOfPages");
						int currentPage = (Integer) request.getAttribute("currentPage");
					%>
						<a href="<%=request.getContextPath()%>/search?page=<%=1 %>&searchtitle=<%=request.getAttribute("searchtitle")%>&searchadress=<%=request.getAttribute("searchadress")%>"> « </a>
						<%	if(currentPage + 1 <= numberOfPages){ //chạy từ 1-> n-1
								for(int i = currentPage -1 ; i <= currentPage + 1 ; i ++ ){
									if(i==0){i=1;}	%>
									<a class="<%if(currentPage == i ){out.print("active");} %>"  href="<%=request.getContextPath()%>/search?page=<%=i %>&searchtitle=<%=request.getAttribute("searchtitle")%>&searchadress=<%=request.getAttribute("searchadress")%>"> <%=i %> </a>
						<%} }else{	
								for(int i = currentPage - 1 ; i <= numberOfPages; i++){ 	if(i==0){i=1;}	%>
								<a class="<%if(currentPage == i ){out.print("active");} %>"  href="<%=request.getContextPath()%>/search?page=<%=i %>&searchtitle=<%=request.getAttribute("searchtitle")%>&searchadress=<%=request.getAttribute("searchadress")%>"> <%=i %> </a>
						<%} }%>
						<a href="<%=request.getContextPath()%>/search?page=<%=numberOfPages %>&searchtitle=<%=request.getAttribute("searchtitle")%>&searchadress=<%=request.getAttribute("searchadress")%>"> » </a>
				</div>		
			</div>
			<div class="clr"></div>
<%@ include file="/templates/public/inc/footer.jsp" %>