package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import com.mysql.cj.protocol.Resultset;

public class UserModel {

	
	//Método que crea un número de control que no exista en la DB
	private int createControlNum () throws SQLException  { 
		Random rand = new Random();
		int cnum; //Número de control
		HashSet<Integer> currentNums = new HashSet<>(); //Aquí se guardarán los números de control que ya existen
		
		try (Connection conn = MyConnection.connect();
			PreparedStatement prepStatement = conn.prepareStatement("SELECT control_num FROM member") //Obtener todos los números de control existentes
			) {
			ResultSet rs = prepStatement.executeQuery(); 
			while (rs.next()) { //Este ciclo añadirá todos los números existentes al HashSet
				currentNums.add(rs.getInt("control_num"));
				System.out.println("DB num: " + rs.getInt("control_num"));
			}
			
			do {
				cnum = rand.nextInt(100000,1000000); //Crear número de control aleatorio de seis dígitos entre 100000 y 999999
				System.out.println("Random num: " + cnum);
			} while (currentNums.contains(cnum));
			
			return cnum;
		}
	}
	//Método que verifica la consistencia de los datos ingresados para un miembro
	private int checkFields (String first_name, String last_name, String phone_number) { 
		//Verficar los datos y regresar un error si hubiera una inconsistencia de datos
		if (first_name.isEmpty() || last_name.isEmpty() || phone_number.isEmpty())
			return 1; //Campo vacío detectado
		else if (first_name.matches(".*\\d.*") || last_name.matches(".*\\d.*"))
			return 2; //Datos inválidos (El nombre o apellido contienen números)
		else if (phone_number.matches(".*[a-zA-Z].*"))
			return 3; //El número de teléfono contiene letras
		else
			return 0; //Éxito (no hubo inconsistencia)
	}
	
	//Método para crear un usuario nuevo, crea el número de control del usuario con el método createControlNum()
	public int createUser(String first_name, String last_name, String phone_number) {
		System.out.println("Creando usuario...");
		String query = "INSERT INTO member (control_num, first_name, last_name, phone_number) VALUES (?,?,?,?)";
		int error = checkFields(first_name, last_name, phone_number); //Guardar el caso en una variable
		if (error != 0)
			return error; //Regresar inconsistencai de datos si la hubiera
		
		try (
			Connection conn = MyConnection.connect();
			PreparedStatement prepStatement = conn.prepareStatement(query)
			){
			prepStatement.setString(2, first_name);
			prepStatement.setString(3, last_name);
			prepStatement.setString(4, phone_number);
			
			int cnum = createControlNum();
			prepStatement.setInt(1, cnum);
			
		    prepStatement.execute();
		    System.out.println("Usuario creado con número de control " + cnum);
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0; //Éxito
	}
	
	//Método para editar datos de un miembro
	public int updateUser (int id, String first_name, String last_name, String phone_number) {
		System.out.println("Actualizando usuarios...");
		ArrayList<Object> values = new ArrayList<>();
		ArrayList<String> fields = new ArrayList<>();
		StringBuilder query = new StringBuilder();
		query.append("UPDATE member SET ");
		boolean firstNameEmpty = false, lastNameEmpty = false, phoneNumberEmpty = false; 
		
		int error = checkFields(first_name, last_name, phone_number);
		
		if (!first_name.isEmpty()) {
			if (first_name.matches(".*\\d.*"))
				return 2; //Datos inválidos (el campo first_name contiene números)
			else {
				fields.add("first_name = ?");
				values.add(first_name);
			}
		} else
			firstNameEmpty = true;
		
		if (!last_name.isEmpty()) {
			if (last_name.matches(".*\\d.*"))
				return 2; //Datos inválidos (el campo last_name contiene números)
			else {
				fields.add("last_name = ?");
				values.add(last_name);
			}
		} else
			lastNameEmpty = true;
		
		if (!phone_number.isEmpty()) {
			if (phone_number.matches(".*[a-zA-Z].*"))
				return 2; //Datos inválidos (el campo phone_number contiene letras)
			else {
				fields.add("phone_number = ?");
				values.add(phone_number);
			}
		} else
			phoneNumberEmpty = true;
		
		if (firstNameEmpty && lastNameEmpty && phoneNumberEmpty)
			return 1; //Todos los campos están vacíos
		
		query.append(String.join(", ", fields));
		query.append(" WHERE id = ?");
		
		values.add(id);
		
		System.out.println(query);
		
		try (Connection conn = MyConnection.connect();
			PreparedStatement prepStatement = conn.prepareStatement(query.toString())){
			for (int i = 0; i < values.size(); i++) {
				prepStatement.setString(i+1, values.get(i).toString());
			}
			System.out.println(prepStatement);
			prepStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0; //Éxito
	}
	
	//Método que elimina al usuario con la id proporcionada
	public int deleteUser (int id) {
		try (Connection conn = MyConnection.connect()){
			try (PreparedStatement checkSt = conn.prepareStatement("SELECT 1 FROM member WHERE id = ?;")){
				checkSt.setInt(1, id);
				try (ResultSet checkRs = checkSt.executeQuery()){
					if (checkRs.next()) {
						try (PreparedStatement delSt = conn.prepareStatement("DELETE FROM member WHERE id = ?")){
							delSt.setInt(1, id);
							delSt.execute();
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0; //Éxito
	}
	
	//-----------------------------------------------------------------------------------------------
	//PRUEBAS: método que regresa los usuarios registrados actualmente
	private void showUsers () { 
		boolean hasResults = false;
		System.out.println("Consultando usuarios...");
		try (Connection conn = MyConnection.connect();
			PreparedStatement prepSt = conn.prepareStatement("SELECT * FROM member");
			ResultSet rs = prepSt.executeQuery()){
					while (rs.next()) {
						System.out.println("id: " + rs.getString("id"));
						System.out.println("control number: " + rs.getInt("control_num"));
						System.out.println("name: " + rs.getString("first_name"));
						System.out.println("last name: " + rs.getString("last_name"));
						System.out.println("phone number: " + rs.getString("phone_number"));
						hasResults = true;
					}
					if (!hasResults)
						System.out.println("No hay usuarios registrados");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
			
			
	//PRUEBAS: Borrar los usuarios y resetear el AutoIncremental a 1
	private void deleteUsers() { 
		System.out.println("Eliminando usuarios...");
		try (Connection conn = MyConnection.connect()) {
			try (PreparedStatement del = conn.prepareStatement("DELETE FROM member")){
				del.execute();
			}
			try (PreparedStatement resAI = conn.prepareStatement("ALTER TABLE member AUTO_INCREMENT = 1")){
				resAI.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
//	public static void main(String[] args) throws SQLException {
//		
//	}

}
