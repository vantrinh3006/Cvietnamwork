/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.48
 * Generated at: 2021-08-19 03:38:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.public_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class news_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/templates/public/inc/footer.jsp", Long.valueOf(1629304332248L));
    _jspx_dependants.put("/templates/public/inc/left-bar.jsp", Long.valueOf(1629304311467L));
    _jspx_dependants.put("/templates/public/inc/header.jsp", Long.valueOf(1629344267925L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("/templates/public/assets/css/style/stylePublic.css\" rel=\"stylesheet\" />\r\n");
      out.write("		<link href=\"");
      out.print(request.getContextPath());
      out.write("/templates/public/assets/css/reset/reset.css\" rel=\"stylesheet\" />\r\n");
      out.write("	</head>\r\n");
      out.write("	<body>\r\n");
      out.write("		<div class=\"wrapper\">\r\n");
      out.write("			<div class=\"header\">\r\n");
      out.write("				<div>\r\n");
      out.write("					<span class=\"logo\"><a href=\"\">VIETNAMWORK</a></span>\r\n");
      out.write("					<span class=\"index-active\"><a href=\"\">Trang chủ</a></span>\r\n");
      out.write("					<span class=\"postnews\"><a href=\"\">Đăng tin tuyển dụng</a></span>\r\n");
      out.write("					<span class=\"contact\"><a href=\"\">Liên hệ</a></span>\r\n");
      out.write("					<span class=\"login\"><a href=\"\">Đăng nhập</a></span>\r\n");
      out.write("				</div>	\r\n");
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
      out.write("				<div class=\"cat\">\r\n");
      out.write("					<span>Danh mục việc làm <span>\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"active\"><a href=\"\">Xây dựng</a></li>\r\n");
      out.write("						<li class=\" noactive\"><a href=\"\">Y tế</a></li>\r\n");
      out.write("						<li class=\"noactive\"><a href=\"\">Giáo dục</a></li>\r\n");
      out.write("						<li class=\"noactive\"><a href=\"\">Công nghệ thông tin</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>");
      out.write("<div class= \"newjob\">\r\n");
      out.write("					<span>Tuyển dụng mới <span>\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li><a href=\"\">Tuyển nhân viên sale</a></li>\r\n");
      out.write("						<li><a href=\"\">Tuyển chuyên viên chăm sóc khách hàng</a></li>\r\n");
      out.write("						<li><a href=\"\">Tuyển kỹ sư xây dựng cầu đường</a></li>\r\n");
      out.write("						<li><a href=\"\">Tuyển Intern Java</a></li>\r\n");
      out.write("					</ul>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"body\">\r\n");
      out.write("				<div class=\"cat\">\r\n");
      out.write("					<span>Tuyển dụng ngành<a href=\"\"> công nghệ thông tin</a></span>\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=\"news\">\r\n");
      out.write("					<ul>\r\n");
      out.write("						<li class=\"title\"><a href=\"\">Tuyển Java Developer</a></li>\r\n");
      out.write("						<li class=\"info\">Đăng ngày: 17/8/2021</li>\r\n");
      out.write("						<li class=\"info\">Công ty: FPT sofware</li>\r\n");
      out.write("						<li class=\"info\">Địa chỉ: 52 Nguyễn Lương Bằng,phường Hòa Khánh Bắc</li>\r\n");
      out.write("						<li class=\"info\">Yêu cầu: Java developer 1 năm kinh nghiệm</li>\r\n");
      out.write("						<li class=\"info\">Mô tả công việc: \r\n");
      out.write("							Tạo giao diện người dùng đẹp cho người dùng của chúng tôi\r\n");
      out.write("							Phát triển các tính năng giao diện người dùng mới dựa trên yêu cầu\r\n");
      out.write("							Tham gia động não và xác định lại các yêu cầu với PMs và các bên liên quan khác\r\n");
      out.write("							Cải thiện và cấu trúc lại các cơ sở mã hiện tại của chúng tôi\r\n");
      out.write("							Tìm ra giải pháp cho những thách thức công nghệ mà chúng ta phải đối mặt\r\n");
      out.write("							Đánh giá các công nghệ mới cho nền tảng </li>\r\n");
      out.write("						<li class=\"info\">Lương: 1000 $</li>\r\n");
      out.write("						<li class=\"info\">Email: fpt@gmail.com</li>\r\n");
      out.write("					</ul>\r\n");
      out.write("					\r\n");
      out.write("				</div>\r\n");
      out.write("				<div class=comment>\r\n");
      out.write("					<div>\r\n");
      out.write("						<span class=\"question\"><i class=\"fa fa-comment-o\"></i> Trần A: Vị trí này còn tuyển dụng không?(17/8/2021) </span> \r\n");
      out.write("						<span class=\"answer\"><i class=\"fa fa-comment\"></i> HR: Vẫn còn (17/8/2021)</span>\r\n");
      out.write("					</div>			\r\n");
      out.write("				</div>\r\n");
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
