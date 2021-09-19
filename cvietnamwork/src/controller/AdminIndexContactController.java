package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Contact;
import model.dao.CategoryDAO;
import model.dao.ContactDAO;
import util.AuthUtil;
import util.DefineUtil;

public class AdminIndexContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ContactDAO contactDAO;   
    public AdminIndexContactController() {
        super();
        contactDAO = new ContactDAO();
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
		
		int currentPage = 1 ;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int numberOfContacts = contactDAO.numberOfItems();
		int numberOfPages = (int) Math.ceil((float) numberOfContacts / DefineUtil.NUMBER_PER_PAGE );
		if (currentPage < 1) {
			response.sendRedirect(request.getContextPath() + "/admin/contacts?page=1&&active=5");
		}

		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Contact> contacts = contactDAO.getItemsPagination(offset);
		request.setAttribute("numberOfContacts", numberOfContacts);
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("/admin/contact/index.jsp?active=5").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
