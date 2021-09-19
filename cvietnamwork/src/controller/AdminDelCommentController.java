package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CategoryDAO;
import model.dao.CommentDAO;
import util.AuthUtil;

public class AdminDelCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommentDAO commentDAO;
    public AdminDelCommentController() {
        super();
        commentDAO = new CommentDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin");
			return;		
		}
		
		
		// qua url => truy cập ở doGet
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/comments?err=1");
			return;
		}
		if(commentDAO.DelItem(id) > 0) {	// thành công
			response.sendRedirect(request.getContextPath() + "/admin/comments?msg=3");
			return;
		}else {							//thất bại
			response.sendRedirect(request.getContextPath() + "/admin/comments?err=3");
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
