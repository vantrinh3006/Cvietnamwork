package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;
import util.AuthUtil;

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoryDAO categoryDAO ; 
    public AdminEditCatController() {
        super();
        categoryDAO = new CategoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin&active=2");
			return;		
		}
		
		int  id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=1&active=2");
			return;
		}
		Category category = categoryDAO.getItem(id);
		if(category != null) {
			request.setAttribute("category", category);
			request.getRequestDispatcher("/admin/cat/edit.jsp?active=2").forward(request, response);
		}else {				// không có dữ liệu
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=1&active=2");
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
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=1&active=2");
			return;
		}
		String name = request.getParameter("name");
		
		Category category = new Category(id, name);
		if(categoryDAO.editItem(category) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=1&active=2");
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=1&active=2");
			return;
		}
		
	}

}
