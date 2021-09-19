package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Role;
import model.bean.User;
import model.dao.UserDAO;
import util.AuthUtil;
import util.StringUtil;
public class AuthSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;   
    public AuthSignupController() {
        super();
        userDAO = new UserDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("/auth/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		int role_id =  3;
		Role role = new Role(role_id, null);
		if(userDAO.hasUser(username) ) {																				// nếu TRÙNG username
			request.getRequestDispatcher("/auth/signup.jsp?err=1").forward(request, response);	// kèm mã lỗi là 2
			return;
		}
		
		password = StringUtil.md5(password);																			// mã hõa passwword thành 32 kí tự ngẫu nhiên
		
		User item = new User(0, username, password, fullname, email, role);
		if(userDAO.addItem(item) > 0) {
			response.sendRedirect(request.getContextPath() + "/login?msg=1&display=public");
			return;
		}else {
			request.getRequestDispatcher("/signup?err=2").forward(request, response);	
			return;
		}
	
	}

}
