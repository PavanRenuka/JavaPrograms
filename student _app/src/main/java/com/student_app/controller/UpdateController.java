package com.student_app.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.student_app.model.DAOserviceImpl;
import com.student_app.model.DAOservices;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		request.setAttribute("name", name);
		request.setAttribute("city", city);
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/update_registration.jsp");
		rd.forward(request, response);
		
		DAOservices service = new DAOserviceImpl();
		service.connectDB();
	
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
	
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		DAOservices service = new DAOserviceImpl();
		service.connectDB();
		
		service.updateReg(name, city, email, mobile);
		ResultSet result = service.getAllReg();
		
		request.setAttribute("result", result );
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/listAll.jsp");
		rd.include(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	}

}}
