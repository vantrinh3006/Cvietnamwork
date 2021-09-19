package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Category;
import model.bean.News;
import model.bean.Role;
import model.bean.User;
import model.dao.CategoryDAO;
import model.dao.NewsDAO;
import model.dao.UserDAO;
import util.AuthUtil;
import util.StringUtil;
public class AdminAddNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO;   
    private CategoryDAO categoryDAO;
    public AdminAddNewsController() {
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
		
		ArrayList<Category> categories = categoryDAO.getItems();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/admin/news/add.jsp?active=4").forward(request, response);
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
		
		
		int cat_id = 0;
		try {
			cat_id = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/news?err=1&&active=4");
			return;
		}
				
		String title = request.getParameter("title");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = String.valueOf(sdf.format(new Date()));
		
		String corporatename = request.getParameter("corporatename");
		String adress = request.getParameter("adress");
		String jobrequest = request.getParameter("jobrequest");
		String jd = request.getParameter("jd");
		int salary =  Integer.parseInt(request.getParameter("salary"));
		String email = request.getParameter("email");
		Category category = new Category(cat_id, null);
		
		
		News item = new  News(0, title, date, corporatename, adress, jobrequest, jd, salary, email, category);
		if(newsDAO.addItem(item) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/news?msg=3&&active=4");
			return; 
		}else {
			ArrayList<Category> categories = categoryDAO.getItems();
			request.setAttribute("categories", categories);
			request.getRequestDispatcher("/admin/news/add.jsp?err=1&&active=4").forward(request, response);	
			// chuyển ngược về trang add, lấy lại dữ liệu mà người dùng đã nhập vào form,     dùng cái này để chuyển dữ liệu
			return;
		}
	
	}

}
