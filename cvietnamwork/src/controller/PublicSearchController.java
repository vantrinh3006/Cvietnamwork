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
import util.DefineUtil;

public class PublicSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private NewsDAO newsDAO;    
    public PublicSearchController() {
        super();
        newsDAO = new NewsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String searchtitle = request.getParameter("searchtitle");	 
		String searchadress = request.getParameter("searchadress"); 
		
		int currentPage = 1;
		 try {
				//ở đây em get parameter là page
				currentPage = Integer.parseInt(request.getParameter("page"));	 
			} catch (Exception e) {
				currentPage = 1;
			}
		
		int numberOfItems = newsDAO.numberOfItems(searchtitle, searchadress);	 
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		int Offset = (currentPage -1) * DefineUtil.NUMBER_PER_PAGE;	 
				
		ArrayList<News> news = newsDAO.getItemsPagination(Offset,searchtitle, searchadress);	
		request.setAttribute("news", news);
		
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		
		request.setAttribute("searchtitle", searchtitle);
		request.setAttribute("searchadress", searchadress);
		request.getRequestDispatcher("/public/search.jsp?active=0").forward(request, response);
		
	}

}
