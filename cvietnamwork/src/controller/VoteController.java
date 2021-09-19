package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Comment;
import model.dao.VoteDAO;

public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoteDAO voteDAO;

	public VoteController() {
		super();
		voteDAO = new VoteDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		int user_id = Integer.parseInt(request.getParameter("user_id")); 							 
		int news_id = Integer.parseInt(request.getParameter("news_id"));  							 
		int like = 0;

		int status = Integer.parseInt(request.getParameter("astatus")); 
		if (0 == user_id) {	// 		chưa đăng nhập		
																								 
			response.getWriter().print("<script type=\"text/javascript\"> alert('Hãy đăng nhập!'); </script>");
			if (1 == status) {
				like = voteDAO.numberOfLikes(news_id); 
				request.setAttribute("like", like);
				response.getWriter().print("<a href=\"javascript:void(0)\" onclick=\"return getStatus(1)\"> \r\n"
						+ "									<i class=\"fa fa-thumbs-o-up\"></i>\r\n"
						+ "								</a>\r\n"
						+ "								" + like + "");
			} else {
				like = voteDAO.numberOfLikes(news_id);
				request.setAttribute("like", like);
				response.getWriter().print("<a href=\"javascript:void(0)\" onclick=\"return getStatus(1)\"> \r\n"
						+ "									<i class=\"fa fa-thumbs-o-up\"></i>\r\n"
						+ "								</a>\r\n"
						+ "								" + like + "");
			}
			return;
		}else {			
				if (1 == status) {
					voteDAO.addItem(user_id,news_id);
					like = voteDAO.numberOfLikes(news_id);  
					request.setAttribute("like", like);
					response.getWriter().print("<a href=\"javascript:void(0)\" onclick=\"return getStatus(0)\"> \r\n"
							+ "									<i class=\"fa fa-thumbs-up\"></i>\r\n"
							+ "								</a>\r\n"
							+ "								" + like + "");
				} else {
					voteDAO.dellItem(user_id,news_id);
					like = voteDAO.numberOfLikes(news_id);	 
					request.setAttribute("like", like);
					response.getWriter().print("<a href=\"javascript:void(0)\" onclick=\"return getStatus(1)\"> \r\n"
							+ "									<i class=\"fa fa-thumbs-o-up\"></i>\r\n"
							+ "								</a>\r\n"
							+ "								" + like + "");
				}
				return;
		}
	}
}
