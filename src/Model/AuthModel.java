package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

public class AuthModel {

	public AuthModel () {
	}
	
	public boolean auth (String user, String password) {
	    String query = "SELECT password FROM adminTable WHERE user = ?"; // Tomar la contraseña del usuario ingresado
		Connection conn = null;
		PreparedStatement pstmt = null; 
		boolean flag = false;
		String dbPassword = "";
	    ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://uigskisxj0v53vyz:F1kWnWnAf6GapZoen7Vl@bna0qopo8smun5oybrpg-mysql.services.clever-cloud.com:3306/bna0qopo8smun5oybrpg",
				"uigskisxj0v53vyz",
				"F1kWnWnAf6GapZoen7Vl");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user); // Establecer el valor "?" en el query
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPassword = rs.getString("password"); // Aquí se toma la contraseña desde la columna contraseña en la base de datos
			}
			rs.close();
			
			if (!dbPassword.isEmpty())
				if (BCrypt.checkpw(password, dbPassword)) // Si ambas contraseñas encriptadas con BCrypt coinciden
					flag = true;
			
			return flag;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {}
		}
		return flag;
	}

	// Método para encriptar la contraseña (si se necesitaran registros)
	public static String hashPassword (String plainPassword) {
		return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
	}
	
//	public static void main(String[] args) {
//		AuthModel model = new AuthModel();
//		System.out.println(model.auth("", ""));
//	}

}
