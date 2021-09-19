package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;

public class PublicContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;   
    public PublicContactController() {
        super();
        contactDAO = new ContactDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.getRequestDispatcher("/public/contact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String contactfullname = request.getParameter("contactfullname");
		String contactemail = request.getParameter("contactemail");
		String contactmessage = request.getParameter("contactmessage");
		
		Contact item = new Contact(0, contactfullname, contactemail, contactmessage);
		if(contactDAO.addItem(item) > 0) {
				response.sendRedirect(request.getContextPath() + "/contact?msg=1");
				return;
		}else {
		request.getRequestDispatcher("/public/contact.jsp?err=1").forward(request, response);
			return;
		}
	}	

}
