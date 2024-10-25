package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A {
	public static void main(String[] args) {
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_89","root","pavan");
		//System.out.println(con);
		//Execute Queries
		
		/*
		 * Statement stmnt = con.createStatement(); stmnt.
		 * executeUpdate("insert into registration values('ganav','sagar','ganav@gmail.com','8976546730')"
		 * ); con.close();
		 */
		
		
		 //Statement stmnt = con.createStatement(); st
		 //mnt.executeUpdate("Delete from registration where email='pavan@gmail.com'");
		
		Statement stmnt = con.createStatement();
		stmnt.executeUpdate("update registration set city='haya', mobile='6362383044'");
		con.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
