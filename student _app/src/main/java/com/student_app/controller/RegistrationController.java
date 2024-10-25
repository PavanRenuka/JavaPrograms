package com.student_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student_app.model.DAOserviceImpl;
import com.student_app.model.DAOservices;

@WebServlet("/newreg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public RegistrationController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		try {

			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(5);
			
			if(session.getAttribute("email")!=null) {
				
				DAOservices service= new DAOserviceImpl();
				service.connectDB();
				
				service.createRegistration(name,city,email,mobile);
				
				request.setAttribute("msg", "Registration Saved");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
				rd.include(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		
		} catch (Exception e) {
			request.setAttribute("error", "Session timed out please login again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			e.printStackTrace();
		}
}
}