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

public class AdminDelNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private  NewsDAO newsDAO;  
    public AdminDelNewsController() {
        super();
        newsDAO = new NewsDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin");
			return;		
		}
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		}catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/news?err=1");
			return;
		}

		// get bài hát với id hiện tại
		News news = newsDAO.getItem(id);
		if (news == null) {
			response.sendRedirect(request.getContextPath() + "/admin/news?err=1");
			return;
		}
		if (newsDAO.delItem(id) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/news?msg=1");
			return;
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/news?err=2");
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
