package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Comment;
import model.bean.User;
import model.dao.CommentDAO;
import util.AuthUtil;

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAO commentDAO;

	public CommentController() {
		super();
		commentDAO = new CommentDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String fullname = "" ; 		 
		try {
			fullname = request.getParameter("afullname");
		} catch (Exception e) {
			//check login
			if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
				response.getWriter().print("<script type=\"text/javascript\"> alert('Hãy đăng nhập!'); </script>");
			}
		}
		// String fullname = request.getParameter("afullname");	
		int user_id = Integer.parseInt(request.getParameter("user_id") );
		if( 0 == user_id) {
			response.getWriter().print("<script type=\"text/javascript\"> alert('Hãy đăng nhập!'); </script>");
			int news_id = Integer.parseInt(request.getParameter("news_id") );	
			ArrayList<Comment> listcmt = commentDAO.getItems(news_id); // lấy DB

			request.setAttribute("listcmt", listcmt);

				for (Comment item : listcmt) {
					response.getWriter().print("<div >\r\n"
							+ "			<span class=\"name\" >" + item.getUser().getFullname() + "</span>\r\n"
							+ "			<span class=\"mess\">" + item.getMessage() + "</span>  \r\n"
							+ "		</div>");
				}
			return;
		}
		
		String message = request.getParameter("amessage");
		
		int news_id = Integer.parseInt(request.getParameter("news_id") );	
		User user= new User(user_id, null, null, fullname, null, null);
		Comment obj = new Comment(0, message, news_id, user);
		
		if (commentDAO.addItem(obj) > 0) { // đây là số dòng được chèn vào database
			System.out.println("thêm thành công ");

			ArrayList<Comment> listcmt = commentDAO.getItems(news_id); // lấy DB
			request.setAttribute("listcmt", listcmt);
				for (Comment item : listcmt) {
					response.getWriter().print("<div >\r\n"
							+ "			<span class=\"name\" >" + item.getUser().getFullname() + "</span>\r\n"
							+ "			<span class=\"mess\">" + item.getMessage() + "</span>  \r\n"
							+ "		</div>");

				}
		} else {
			System.out.println("Comment thất bại");
		}
	}
}
