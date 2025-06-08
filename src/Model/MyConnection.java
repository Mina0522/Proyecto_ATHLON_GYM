package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

public class MyConnection {
	
	private static final String url = "jdbc:mysql://uigskisxj0v53vyz:F1kWnWnAf6GapZoen7Vl@bna0qopo8smun5oybrpg-mysql.services.clever-cloud.com:3306/bna0qopo8smun5oybrpg";
	private static final String user = "uigskisxj0v53vyz";
	private static final String pass = "uigskisxj0v53vyz";
	
	static Connection conn = null;

	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,pass);
			
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			    try {
			        if (conn != null && !conn.isClosed()) {
			        	conn.close();
			            System.out.println("Conexión cerrada desde shutdown hook");
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			} catch (Exception e) {}
		}
	}
	
	public static Connection getConn() {
		try {
			if (conn == null || conn.isClosed())
				connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
}
