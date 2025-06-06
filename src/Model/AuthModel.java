package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

public class AuthModel {

	public AuthModel () {
	}
	
	public boolean auth (String user, String password) {
	    String query = "SELECT password FROM adminTable WHERE user = ?"; // Tomar la contraseña del usuario ingresado
		boolean flag = false;
		String dbPassword = "";
	    ResultSet rs = null;
		
		try (PreparedStatement pstmt = MyConnection.getConn().prepareStatement(query)) {
			pstmt.setString(1, user); // Establecer el valor "?" en el query
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbPassword = rs.getString("password"); // Aquí se toma la contraseña desde la columna contraseña en la base de datos
			}
			rs.close();
			System.out.println("Resultset del login cerrada");
			
			if (!dbPassword.isEmpty())
				if (BCrypt.checkpw(password, dbPassword)) // Si ambas contraseñas encriptadas con BCrypt coinciden
					flag = true;
			
			return flag;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// Método para encriptar la contraseña (si se necesitaran registros)
	public static String hashPassword (String plainPassword) {
		return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
	}
	

}
