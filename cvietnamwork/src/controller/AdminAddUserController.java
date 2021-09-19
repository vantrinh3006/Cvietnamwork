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
public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;   
    public AdminAddUserController() {
        super();
        userDAO = new UserDAO();
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
		
		request.getRequestDispatcher("/admin/user/add.jsp?active=3").forward(request, response);
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
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		int role_id =  Integer.parseInt(request.getParameter("role_id"));
		Role role = new Role(role_id, null);
		if(userDAO.hasUser(username) ) {																				// nếu TRÙNG username
			request.getRequestDispatcher("/admin/user/add.jsp?err=2&&active=3").forward(request, response);	// kèm mã lỗi là 2
			return;
		}
		
		password = StringUtil.md5(password);																			// mã hõa passwword thành 32 kí tự ngẫu nhiên
		
		User item = new User(0, username, password, fullname, email, role);
		if(userDAO.addItem(item) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=1&&active=3");
			return;
		}else {
			request.getRequestDispatcher("/admin/user/add.jsp?err=1&&active=3").forward(request, response);	
			// chuyển ngược về trang add, lấy lại dữ liệu mà người dùng đã nhập vào form,     dùng cái này để chuyển dữ liệu
			return;
		}
	
	}

}
