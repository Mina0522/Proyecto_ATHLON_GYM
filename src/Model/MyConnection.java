package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

public class MyConnection {
	
	private static final String url = "jdbc:mysql://uigskisxj0v53vyz:F1kWnWnAf6GapZoen7Vl@bna0qopo8smun5oybrpg-mysql.services.clever-cloud.com:3306/bna0qopo8smun5oybrpg";
	private static final String user = "uigskisxj0v53vyz";
	private static final String pass = "uigskisxj0v53vyz";
	
	static Connection conn = null;

	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			} catch (Exception e) {}
		}
		return conn;
	}
	
	public static Connection getConn() {
		return conn;
	}
	
}
