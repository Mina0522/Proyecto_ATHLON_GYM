package Model;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Random;

public class UserModel {

	private int createControlNum () throws SQLException { //Método que crea un número de control que no exista en la DB
		Random rand = new Random();
		int cnum; //Número de control
		HashSet<Integer> currentNums = new HashSet<>(); //Aquí se guardarán los números de control que ya existen
		PreparedStatement prepStatement = MyConnection.connect().prepareStatement("SELECT control_num FROM member"); //Obtener todos los números de control existentes
		ResultSet rs = prepStatement.executeQuery();
		while (rs.next()) { //Este ciclo añadirá todos los números existentes al HashSet
			currentNums.add(rs.getInt("control_num"));
			System.out.println("DB num: " + rs.getInt("control_num"));
		}
		rs.close();
		prepStatement.close();
		
		do {
			cnum = rand.nextInt(100000,1000000); //Crear número de control aleatorio de seis dígitos entre 100000 y 999999
			System.out.println("Random num: " + cnum);
		} while (currentNums.contains(cnum));
		
		return cnum;
	}
	
	public boolean createUser(String first_name, String last_name, String phone_number) throws SQLException {
		
		String query = "INSERT INTO member (control_num, first_name, last_name, phone_number) VALUES (?,?,?,?)";
		PreparedStatement prepStatement = MyConnection.connect().prepareStatement(query);
		prepStatement.setString(2, first_name);
		prepStatement.setString(3, last_name);
		prepStatement.setString(4, phone_number);
		
		int cnum = createControlNum();
		prepStatement.setInt(1, cnum);
		
	    prepStatement.execute();
	    System.out.println("Usuario creado con número de control " + cnum);
	    prepStatement.close();
	    
		return true;
	}
	
	public static void main(String[] args) throws SQLException {
		
		UserModel model = new UserModel();
//		model.createUser("Ale", "Prueba", "6131000598");
		
		MyConnection.connect().prepareStatement("DELETE FROM member").execute();
	}

}
