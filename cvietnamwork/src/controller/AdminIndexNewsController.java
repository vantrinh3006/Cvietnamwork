package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.News;
import model.dao.NewsDAO;
import util.AuthUtil;
import util.DefineUtil;

public class AdminIndexNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  NewsDAO newsDAO;  
    public AdminIndexNewsController() {
        super();
        newsDAO = new NewsDAO();
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
		
		
		int numberOfNews = newsDAO.numberOfItems();
		int numberOfPages = (int) Math.ceil((float) numberOfNews / DefineUtil.NUMBER_PER_PAGE);

		int currentPage = 1;	//khởi đầu trang là 1
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int offset = ( (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE );
		
		ArrayList<News> news = newsDAO.getItemsPagination(offset);	
		
		request.setAttribute("numberOfNews", numberOfNews);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("news", news);
		request.getRequestDispatcher("/admin/news/index.jsp?active=4").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
