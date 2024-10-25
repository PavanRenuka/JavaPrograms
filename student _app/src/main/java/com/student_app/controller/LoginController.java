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

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			DAOservices service = new DAOserviceImpl();
			service.connectDB();
			
			boolean status = service.verifyCredentials(email, password);
			
			if(status=true) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				session.setMaxInactiveInterval(5);
				
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_registration.jsp");
				rd.forward(request, response);
			}else{
				request.setAttribute("email", "Invalid Username/Password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
	}

}
