package com.student_app.model;

import java.sql.ResultSet;

public interface DAOservices {

	public void connectDB();

	public boolean verifyCredentials(String email, String password);

	public void createRegistration(String name, String city, String email, String mobile);

	public ResultSet getAllReg();

	public void deleteReg(String email);

	public void updateReg(String name, String city, String email, String mobile);

	
}
