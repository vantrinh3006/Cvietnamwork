package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Role;
import model.bean.User;
import model.dao.RoleDAO;
import model.dao.UserDAO;
import util.AuthUtil;
import util.StringUtil;

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	public AdminEditUserController() {
		super();
		userDAO = new UserDAO();
		roleDAO = new RoleDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin");
			return;		
		}
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/users?err=1");
			return;
		}
		ArrayList<Role> roles = roleDAO.getItems();
		User user = userDAO.getItems(id);
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/admin/users?err=4");
			return;
		}
		request.setAttribute("roles", roles);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/admin/user/edit.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//check login
		if(!AuthUtil.checkLogin(request, response)) {	// dùng thư viện bên util		//chưa login => chuyển đến trang login
			response.sendRedirect(request.getContextPath() + "/login?display=admin");
			return;		
		}
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/users?err=1");
			return;
		}

		User item = userDAO.getItems(id); // lấy đối tượng này để có mất khẩu cũ
		if (item == null) {
			response.sendRedirect(request.getContextPath() + "/admin/users?err=4");
			return;
		}
		String password = request.getParameter("password"); // password mới
		if ("".equals(password)) {
			password = item.getPassword();
		} else {
			password = StringUtil.md5(password); // mã hóa mật khẩu
		}
		String fullname = request.getParameter("fullname"); // Đây là fullname mới
		String email = request.getParameter("email");
		int role_id = Integer.valueOf(request.getParameter("role"));
		Role role = new Role(role_id, null);
		User user = new User(id, null, password, fullname, email, role);

		
		if (userDAO.editItem(user) > 0) {	 
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=3");
			return;
		} else {
			request.getRequestDispatcher("/admin/user/edit.jsp?err=1").forward(request, response);
			return;
		}

	}

}
