package com.student_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class DAOserviceImpl implements DAOservices {

	private Connection con;
	private Statement stmnt;
	@Override
	public void connectDB(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_login", "root", "pavan");
			stmnt=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean verifyCredentials(String email, String password) {
        try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and '"+password+"'");
		return result.next();
        } catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public void createRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
		
	}
	@Override
	public ResultSet getAllReg() {
		 try {
				ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
	        } catch (Exception e) {
				e.printStackTrace();
			}
			return null;
	}
	@Override
	public void deleteReg(String email) {
		try {
			stmnt.executeUpdate("Delete from registration vales where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	@Override
	public void updateReg(String name, String city,String email, String mobile) {
		try {
			stmnt.executeUpdate("Update registration set name='"+name+"', city='"+city+"', mobile='"+mobile+"' where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
