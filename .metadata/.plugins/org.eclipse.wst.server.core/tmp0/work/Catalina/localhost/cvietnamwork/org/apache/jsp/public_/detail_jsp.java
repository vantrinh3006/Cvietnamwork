/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.48
 * Generated at: 2021-09-11 10:09:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.dao.VoteDAO;
import util.AuthUtil;
import model.bean.Comment;
import model.bean.News;
import java.util.ArrayList;
import model.bean.User;
import model.bean.News;
import model.dao.NewsDAO;
import model.bean.Category;
import java.util.ArrayList;
import model.dao.CategoryDAO;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/templates/public/inc/footer.jsp", Long.valueOf(1629304332248L));
    _jspx_dependants.put("/templates/public/inc/left-bar.jsp", Long.valueOf(1630841516473L));
    _jspx_dependants.put("/templates/public/inc/header.jsp", Long.valueOf(1631354417976L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("model.bean.User");
    _jspx_imports_classes.add("model.dao.NewsDAO");
    _jspx_imports_classes.add("model.dao.CategoryDAO");
    _jspx_imports_classes.add("util.AuthUtil");
    _jspx_imports_classes.add("model.bean.Category");
    _jspx_imports_classes.add("model.dao.VoteDAO");
    _jspx_imports_classes.add("model.bean.News");
    _jspx_imports_classes.add("model.bean.Comment");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("	<head>\r\n");
      out.write("		<title>VIETNAMWORK</title>\r\n");
      out.write("		<meta charset=\"UTF-8\"/>\r\n");
      out.write("		<link href=\"");
      out.print(request.getContextPath());
      out.write("/templates/public/assets/css/style/style.css\" rel=\"stylesheet\" />\r\n");
      out.write("		<link href=\"");
      out.print(request.getContextPath());
      out.write("/templates/public/assets/css/reset/reset.css\" rel=\"stylesheet\" />\r\n");
      out.write("		<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("		\r\n");
      out.write("		<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/templates/public/assets/js/jquery.validate.min.js\" >	</script>\r\n");
      out.write("		\r\n");
      out.write("		<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("		\r\n");
      out.write("	</head>\r\n");
      out.write("	<style type=\"text/css\">	 \r\n");
      out.write("    	#form .addContact .error {color: red}\r\n");
      out.write("    	#form #form .addContact label  {\r\n");
      out.write("    		width: auto;\r\n");
      out.write("    		display: block;\r\n");
      out.write("    		float: none;\r\n");
      out.write("    	}\r\n");
      out.write("</style>\r\n");
      out.write("	<body>\r\n");
      out.write("		<div class=\"wrapper\">\r\n");
      out.write("			<div class=\"header\">\r\n");
      out.write("				<div>\r\n");
      out.write("				");

					String headerActive = request.getParameter("headerActive");
				
      out.write("<span class=\"logo\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/index?headerActive=1&page=1\">VIETNAMWORK</a></span>\r\n");
      out.write("<span class=\"index");
if("1".equals(headerActive)) out.print("-active");
      out.write("\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/index?headerActive=1&page=1\">Trang chủ</a></span>\r\n");
      out.write("\r\n");
      out.write("					<span class=\"contact");
if("2".equals(headerActive)) out.print("-active");
      out.write("\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/contact?headerActive=2\">Liên hệ</a></span>\r\n");
      out.write("\r\n");

	            	User userLogin = (User) session.getAttribute("userLogin");
	            	if(userLogin != null){
         	    
      out.write("<span class=\"login\">");
      out.print(userLogin.getFullname() );
      out.write("<span class=\"more\">	\r\n");
      out.write("									<a href=\"");
      out.print(request.getContextPath());
      out.write("/public/user/info\"><i class=\"fa fa-user\"></i> Thông tin tài khoản</a>\r\n");
      out.write("									<a href=\"");
      out.print(request.getContextPath());
      out.write("/public/user/voted?user_id=");
      out.print(userLogin.getId());
      out.write("&active=0\"><i class=\"fa fa-thumbs-up\"></i> Tin đã Like</a>\r\n");
      out.write("									<a href=\"");
      out.print(request.getContextPath());
      out.write("/public/user/commented?user_id=");
      out.print(userLogin.getId());
      out.write("&active=0\"><i class=\"fa fa-commenting\"></i> Tin đã bình luận</a>\r\n");
      out.write("									<a href=\"");
      out.print(request.getContextPath());
      out.write("/logout?display=public\"><i class=\"fa fa-sign-out\"></i> Đăng xuất</a>\r\n");
      out.write("							</span>\r\n");
      out.write("						</span>	\r\n");
      out.write("				");
}else{ 
      out.write("<span class=\"login\"><span>Khách</span><a href=\"");
      out.print(request.getContextPath());
      out.write("/login?display=public\">Đăng nhập</a></span>\r\n");
      out.write("				");
} 
      out.write("</div>	\r\n");
      out.write("				<div class=\"image\">\r\n");
      out.write("					<img id=\"img\" onclick=\"changeImage()\" src=\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/images/slide0.jpg\" alt=\"slide\" />\r\n");
      out.write("				</div>\r\n");
      out.write("				<script>\r\n");
      out.write("					var index = 1;\r\n");
      out.write("					changeImage = function(){\r\n");
      out.write("					var imgs = [\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/images/slide0.jpg\",\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/images/slide1.jpg\",\"");
      out.print(request.getContextPath() );
      out.write("/templates/public/images/slide2.jpg\" ];\r\n");
      out.write("					document.getElementById('img').src = imgs[index];\r\n");
      out.write("					index ++;\r\n");
      out.write("					if(index == 3){index = 0;}\r\n");
      out.write("					}\r\n");
      out.write("					setInterval(changeImage,1500);		//1000: đơn vị mili giây\r\n");
      out.write("				</script>				\r\n");
      out.write("			</div>\r\n");
      out.write("			");
      out.write("<div class=\"left-bar\">\r\n");
      out.write("<div style=\"background-color:red; height=20px; width:100px\"></div>	\r\n");
      out.write("				<div class=\"cat\">\r\n");
      out.write("					<span>Danh mục việc làm <span>\r\n");
      out.write("					<ul>\r\n");
      out.write("					");
	String active = request.getParameter("active");	
					  	CategoryDAO categoryDAO = new CategoryDAO();
					  	ArrayList<Category> categories = categoryDAO.getItems();
					  	if(categories != null && categories.size() > 0){
					  		for(Category item: categories){
					  
      out.write("<li class=\"");
if(!active.equals(String.valueOf(item.getId()))){ out.print("noactive");}else {out.print("active");} 
      out.write("\">\r\n");
      out.write("							<a href=\"");
      out.print(request.getContextPath());
      out.write("/cat?cat_id=");
      out.print(item.getId());
      out.write("&active=");
      out.print(item.getId());
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print(item.getName() );
      out.write("</a>\r\n");
      out.write("						</li>\r\n");
      out.write("					");
} }
      out.write("</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class= \"newjob\">\r\n");
      out.write("					<span>Tuyển dụng mới <span>\r\n");
      out.write("						<ul>\r\n");
      out.write("						");

							NewsDAO newsDAO = new NewsDAO();
							ArrayList<News> left_barnews = newsDAO.getItemsTop(4);
							if(left_barnews != null && left_barnews.size() > 0){
								for(News item: left_barnews){
						
      out.write("<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/detail?id=");
      out.print(item.getId());
      out.write("&active=");
      out.print(item.getCategory().getId());
      out.write('"');
      out.write('>');
      out.print(item.getTitle() );
      out.write("</a> <p>");
      out.print(item.getDate() );
      out.write("</p></li>\r\n");
      out.write("						");
} }else{ 
      out.write("<ul> Không có dữ liệu</ul>\r\n");
      out.write("						");
} 
      out.write("</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>");
      out.write("<div class=\"body\">\r\n");
      out.write("			");

				News news = (News) request.getAttribute("news");
				int like = (Integer) request.getAttribute("like");
				Integer check = (Integer) request.getAttribute("check");
			
      out.write("<div class=\"cat\">\r\n");
      out.write("					<span>Tuyển dụng ngành ");
      out.print(news.getCategory().getName() );
      out.write("</span>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"news\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"title\">\r\n");
      out.write("							<span>");
      out.print(news.getTitle() );
      out.write("</span>\r\n");
      out.write("							<span id=\"vote\"> \r\n");
      out.write("							");
if(0 == check ){
      out.write("<!--chưa like -->\r\n");
      out.write("								<a href=\"javascript:void(0)\" onclick=\"return getStatus(1)\"> \r\n");
      out.write("									<i class=\"fa fa-thumbs-o-up\"></i>\r\n");
      out.write("								</a>\r\n");
      out.write("								");
      out.print(like );
}else{ 
      out.write("<a href=\"javascript:void(0)\" onclick=\"return getStatus(0)\"> \r\n");
      out.write("									<i class=\"fa fa-thumbs-up\"></i>\r\n");
      out.write("								</a>\r\n");
      out.write("								");
      out.print(like );
} 
      out.write("</span>\r\n");
      out.write("						</li>\r\n");
      out.write("						<li class=\"info\"><span>Đăng ngày: </span> ");
      out.print(news.getDate() );
      out.write("</li>\r\n");
      out.write("						<li class=\"info\"><span>Công ty: </span> ");
      out.print(news.getCorporatename() );
      out.write("</li>\r\n");
      out.write("						<li class=\"info\"><span>Địa chỉ: </span>");
      out.print(news.getAdress() );
      out.write("</li>\r\n");
      out.write("						<li class=\"info\"><span>Yêu cầu: </span>");
      out.print(news.getJobrequest() );
      out.write("</li>\r\n");
      out.write("						<li class=\"info\"><span>Mô tả công việc: </span>");
      out.print(news.getJd() );
      out.write("</li>\r\n");
      out.write("						<li class=\"info\">\r\n");
      out.write("							<span>Lương: </span>\r\n");
      out.write("							");
if(userLogin != null){ 
								out.print(news.getSalary() + "$"); 
							  }else{
      out.write("<a href=\"");
      out.print(request.getContextPath());
      out.write("/login?display=public\" style=\"color:red\">Đăng nhập để xem lương</a>\r\n");
      out.write("							");
} 
      out.write("</li>\r\n");
      out.write("						<li class=\"info\"><span>Email: </span>");
      out.print(news.getEmail() );
      out.write("</li>\r\n");
      out.write("					</ul>\r\n");
      out.write("					\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"keyword\">\r\n");
      out.write("					<span>Từ khóa</span>\r\n");
      out.write("					");
if(news.getCategory().getId() == 1){ 
      out.write("<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=it&searchadress=\">It</a>\r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=java&searchadress=\">Java</a> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=php&searchadress=\">PHP</a> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=php&searchadress=\">Python</a> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=intern&searchadress=\">Intern</a> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=fresher&searchadress=\">Fresher</a> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=senior&searchadress=\">Senior</a> \r\n");
      out.write("					");
} 
if(news.getCategory().getId() == 2){ 
      out.write("<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=bác sĩ&searchadress=\">Bác sĩ</a>\r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=dược sĩ&searchadress=\">Dược sĩ</a> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=da liễu&searchadress=\">Da liễu</a> \r\n");
      out.write("					");
} 
if(news.getCategory().getId() == 6){ 
      out.write("<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=Marketing content&searchadress=\">Marketing content</a>\r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=sale&searchadress=\">Sale</a> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath() );
      out.write("/search?active=0&searchtitle=manager&searchadress=\">Kinh doanh</a> \r\n");
      out.write("					");
} 
      out.write("</div>\r\n");
      out.write(" <!-- ajax comment============================================= -->\r\n");
      out.write("<div>\r\n");
      out.write("	<form class=\"comment\">\r\n");
      out.write("			<input type=\"text\" value=\"");
if(userLogin != null){out.print(userLogin.getFullname());}
      out.write("\" name=\"fullname\" required=\"required\" id=\"fullname\"  disabled/> <br /> <br />\r\n");
      out.write("			<input type=\"text\" value=\"\" placeholder=\"Nhập bình luận\" name=\"message\" id=\"message\" required=\"required\" /> \r\n");
      out.write("			<a href=\"javascript:void(0)\" title=\"\" class=\"btn\" 	onclick=\"return getComment()\"  >Bình luận</a>\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");
      out.write("<br />\r\n");
      out.write("<div class=\"ajax-data\" >\r\n");
      out.write("	");

		if(request.getAttribute("listcmt") != null){
			ArrayList<Comment> listcmt =  (ArrayList<Comment>) request.getAttribute("listcmt");
			for(Comment item: listcmt){
	
      out.write("<div >\r\n");
      out.write("			<span class=\"name\" >");
      out.print(item.getUser().getFullname() );
      out.write("</span>\r\n");
      out.write("			<span class=\"mess\">");
      out.print(item.getMessage());
      out.write("</span>  \r\n");
      out.write("		</div>\r\n");
      out.write("	");
}}else{ 
      out.write("<p >Hãy bình luận</p>\r\n");
      out.write("	");
} 
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\"> \r\n");
      out.write("	function getComment(){\r\n");
      out.write("		var message = $('#message').val();\r\n");
      out.write("		var fullname = $('#fullname').val();\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: '");
      out.print(request.getContextPath());
      out.write("/comment?news_id=");
      out.print(news.getId());
      out.write("&user_id=");
 if(AuthUtil.checkLogin(request, response)) {
																								out.print(userLogin.getId());
																							   }else{out.print(0);}
      out.write("',\r\n");
      out.write("			type : 'POST',			 \r\n");
      out.write("			cache : false,\r\n");
      out.write("			data : {\r\n");
      out.write("				afullname: fullname,\r\n");
      out.write("				amessage: message\r\n");
      out.write("			},\r\n");
      out.write("			success : function(data) {\r\n");
      out.write("				$(\".ajax-data\").html(data);	\r\n");
      out.write("			},\r\n");
      out.write("			error: function() {\r\n");
      out.write("				alert('Có lỗi xảy ra!');\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	return false;\r\n");
      out.write("	}\r\n");
      out.write("		\r\n");
      out.write("	function getStatus(status){\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url: '");
      out.print(request.getContextPath());
      out.write("/vote?news_id=");
      out.print(news.getId());
      out.write("&user_id=");
 if(AuthUtil.checkLogin(request, response)) {
																								out.print(userLogin.getId());
																							   }else{out.print(0);}
      out.write("',\r\n");
      out.write("			type: 'POST',\r\n");
      out.write("			cache: false,\r\n");
      out.write("			data: {	\r\n");
      out.write("					astatus: status\r\n");
      out.write("			},\r\n");
      out.write("			success: function(data){			//sử lý thành công\r\n");
      out.write("				$(\"#vote\").html(data);\r\n");
      out.write("			},\r\n");
      out.write("			error: function (){					//xử lý lỗi\r\n");
      out.write("				alert('Có lỗi xảy ra');\r\n");
      out.write("			}\r\n");
      out.write("		});\r\n");
      out.write("	return false;\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("<!-- ============================================================== -->\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"clr\"></div>\r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("				<span>Copyright 2021 © || Code by Tran Van Trinh </span>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
