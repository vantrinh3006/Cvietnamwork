package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.News;
import model.dao.CategoryDAO;
import model.dao.NewsDAO;
import util.AuthUtil;

public class AdminEditNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO; 
    private CategoryDAO categoryDAO;
    public AdminEditNewsController() {
        super();
        newsDAO = new NewsDAO();
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
		
		int  id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/news?err=1&active=4");			 
			return;
		}
		News news = newsDAO.getItem(id);
		
		if(news == null) {
			response.sendRedirect(request.getContextPath() + "/admin/songs?err=1&active=4");		 
			return;
		}
		ArrayList<Category> categories = categoryDAO.getItems();
		request.setAttribute("news", news);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/admin/news/edit.jsp?active=4").forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin");
			return;		
		}
		// get DATA
		int cat_id = 0;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			cat_id = Integer.parseInt(request.getParameter("category"));	
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/news?err=1&active=4");		 
			return;
		}
		String title = request.getParameter("title");					 
		String corporatename =request.getParameter("corporatename");	
		String adress =request.getParameter("adress");
		String jobrequest =request.getParameter("jobrequest");
		String jd = request.getParameter("jd");
		Integer salary = Integer.parseInt(request.getParameter("salary"));
		String email = request.getParameter("email");
		
		News news = newsDAO.getItem(id);
		if(news == null) {
			response.sendRedirect(request.getContextPath() + "/admin/news?err=3&active=4");
			return;
		}
		
		Category category = new Category(cat_id, null);			 // để null vì  ko cần dùng			
		News item = new News(id, title, null, corporatename, adress, jobrequest, jd, salary, email, category);	

		if (newsDAO.editItem(item) > 0) { // sửa thành công
			response.sendRedirect(request.getContextPath() + "/admin/news?msg=2&active=4");	 
			return;
			
		}else {		// sửa thất bại
			ArrayList<Category> categories = categoryDAO.getItems();
			request.setAttribute("categories", categories);					 
			request.setAttribute("news", news);														
			request.getRequestDispatcher("/admin/news/edit.jsp?err=1&active=4").forward(request, response);
			return;
			
		}

	}

}
