package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;
import util.AuthUtil;
public class AdminDelContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;
	
    public AdminDelContactController() {
        super();
        contactDAO = new ContactDAO();
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

		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?err=1");
			return;
		}
		if(contactDAO.delItem(id) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?msg=1");
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?err=2");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
