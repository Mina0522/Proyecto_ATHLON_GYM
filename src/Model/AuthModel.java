package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AuthModel {
//	Connection con;

	public AuthModel () {
	}
	
	public boolean auth (String email, String password) {
		String query = "select email, password from new_table";
		Connection conn = null;
		Statement stmt = null; 
		boolean flag = false;
		String dbEmail = "";
		String dbPassword = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://uigskisxj0v53vyz:F1kWnWnAf6GapZoen7Vl@bna0qopo8smun5oybrpg-mysql.services.clever-cloud.com:3306/bna0qopo8smun5oybrpg",
				"uigskisxj0v53vyz",
				"F1kWnWnAf6GapZoen7Vl");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				dbEmail = rs.getString(1);
				dbPassword = rs.getString(2);
				System.out.println("Email: " + dbEmail);
				System.out.println("Password: " + dbPassword);
			}
			rs.close();
			
			if (email.equals(dbEmail) && password.equals(dbPassword))
				flag = true;
			
			return flag;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		return flag;
	}
	
//	public static void main(String[] args) {
//	
//	}
	
}
