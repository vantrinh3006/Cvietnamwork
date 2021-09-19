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

public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoryDAO categoryDAO;   
    public AdminAddCatController() {
        super();
        categoryDAO = new CategoryDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin");
			return;		
		}
		
		request.getRequestDispatcher("/admin/cat/add.jsp?active=2").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => đến trang login
			response.sendRedirect(request.getContextPath() + "/login");
			return;		
		}
				
		String name = request.getParameter("name");
		Category category = new Category(0, name);
		if(categoryDAO.addItem(category) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=2&&active=2");
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/cats?err=2&&active=2");
			return;
		}
	
	}

}
