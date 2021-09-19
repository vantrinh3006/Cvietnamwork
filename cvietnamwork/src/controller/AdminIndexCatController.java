package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CategoryDAO;
import util.AuthUtil;
import util.DefineUtil;

public class AdminIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;	  
    public AdminIndexCatController() {
        super();
        categoryDAO = new CategoryDAO();

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
		
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page")) ;
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int numberOfCats = categoryDAO.numberOfItems(); 
		int numberOfPages = (int) Math.ceil((float) numberOfCats / DefineUtil.NUMBER_PER_PAGE);
		if (currentPage < 1) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Category> categories = categoryDAO.getItemsPagination(offset);

		request.setAttribute("numberOfCats", numberOfCats);
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("categories", categories);
		
		request.getRequestDispatcher("/admin/cat/index.jsp?active=2").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
