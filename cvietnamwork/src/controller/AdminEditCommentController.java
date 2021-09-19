package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Comment;
import model.dao.CategoryDAO;
import model.dao.CommentDAO;
import util.AuthUtil;

public class AdminEditCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CommentDAO commentDAO ; 
    public AdminEditCommentController() {
        super();
        commentDAO = new CommentDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin");
			return;		
		}
		
		int  id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/comments?err=1&active=6");
			return;
		}
		Comment comment = commentDAO.getItem(id);
		if(comment != null) {
			request.setAttribute("comment", comment);
			request.getRequestDispatcher("/admin/comment/edit.jsp?active=6").forward(request, response);
		}else {				// không có dữ liệu
			response.sendRedirect(request.getContextPath() + "/admin/comments?err=1&active=6");
			return;
		}	
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin");
			return;		
		}
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/admin/comments?err=1&active=6");
			return;
		}
		String message = request.getParameter("message");
		
		Comment comment = new Comment(id, message, 0, null);
		if(commentDAO.editItem(comment) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/comments?msg=1&active=6");
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/comments?err=1&active=6");
			return;
		}
		
	}

}
