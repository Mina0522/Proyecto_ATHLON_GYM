package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

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
	
	//Método para crear un usuario nuevo, crea el número de control del usuario con el método createControlNum()
	public void createUser(String first_name, String last_name, String phone_number) {
		System.out.println("Registrando usuario...");
		String query = "INSERT INTO member (control_num, first_name, last_name, phone_number) VALUES (?,?,?,?)";
		
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
	}
	
	//Método para editar datos de un miembro
	public void updateUser (int id, String first_name, String last_name, String phone_number,
			boolean fnempty, boolean lnempty, boolean pnempty) {
		System.out.println("Actualizando usuario...");
		ArrayList<Object> values = new ArrayList<>();
		ArrayList<String> fields = new ArrayList<>();
		StringBuilder query = new StringBuilder();
		query.append("UPDATE member SET ");
		
		if (!fnempty){//Si el campo first_name no está vacío
			fields.add("first_name = ?");
			values.add(first_name);
		}
		
		if (!lnempty){//Si el campo last_name no está vacío
			fields.add("last_name = ?");
			values.add(last_name);
		}
		
		if (!pnempty){//Si el campo phone_number no está vacío
			fields.add("phone_number = ?");
			values.add(phone_number);
		}
		
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
			e.printStackTrace();
		}
		
	}
	
	//Método que elimina al usuario con la id proporcionada
	public int deleteUser (int control_num) {
		System.out.println("Eliminando usuario...");
		try (Connection conn = MyConnection.connect()){
			try (PreparedStatement checkSt = conn.prepareStatement("SELECT 1 FROM member WHERE control_num = ?;")){
				checkSt.setInt(1, control_num);
				try (ResultSet checkRs = checkSt.executeQuery()){
					if (checkRs.next()) {
						try (PreparedStatement delSt = conn.prepareStatement("DELETE FROM member WHERE control_num = ?")){
							delSt.setInt(1, control_num);
							delSt.execute();
							System.out.println("Usuario eliminado");
						}
					}
					else {
						System.out.println("Usuario no encontrado");
						return 1; //No existe un usuario con esa id
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0; //Éxito (usuario eliminado)
	}
	
	//Método para obtener los datos de un usuario consultandolo por su nombre, regresa un objeto tipo User
	public User getUser (String first_name) {
		System.out.println("Buscando usuario...");
		try (Connection conn = MyConnection.connect();
		PreparedStatement prepSt = conn.prepareStatement("SELECT * FROM member WHERE  first_name = ?")){
			prepSt.setString(1, first_name);
			try (ResultSet rs = prepSt.executeQuery()){
				if (rs.next()) {
					System.out.println("Usuario encontrado");
					User member = new User
							(rs.getInt("id"),
							rs.getInt("control_num"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("phone_number"));
					return member; //Regresar un objeto User con los datos del miembro encontrado
				} else {
					System.out.println("Usuario no encontrado");
					return null; //No se encontró al usuario
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<User> getUsersWithName(String first_name) {
		ArrayList<User> list;
		try (Connection conn = MyConnection.connect();
		PreparedStatement prepSt = conn.prepareStatement("SELECT * FROM member WHERE first_name = ?")) {
			prepSt.setString(1, first_name);
			try (ResultSet rs = prepSt.executeQuery()) {				
				list = new ArrayList<>();
				while (rs.next()) {
					list.add(new User(rs.getInt("id"), rs.getInt("control_num"), rs.getString("first_name"), rs.getNString("last_name"), rs.getString("phone_number")));
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("first_name"));
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	//-----------------------------------------------------------------------------------------------
//	//PRUEBAS: método que regresa los usuarios registrados actualmente
//	private void showUsers () { 
//		boolean hasResults = false;
//		System.out.println("Consultando usuarios...");
//		try (Connection conn = MyConnection.connect();
//			PreparedStatement prepSt = conn.prepareStatement("SELECT * FROM member");
//			ResultSet rs = prepSt.executeQuery()){
//					while (rs.next()) {
//						System.out.println("id: " + rs.getString("id"));
//						System.out.println("control number: " + rs.getInt("control_num"));
//						System.out.println("name: " + rs.getString("first_name"));
//						System.out.println("last name: " + rs.getString("last_name"));
//						System.out.println("phone number: " + rs.getString("phone_number"));
//						hasResults = true;
//					}
//					if (!hasResults)
//						System.out.println("No hay usuarios registrados");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//	
//	//PRUEBAS: Borrar los usuarios y resetear el AutoIncrement a 1
//	private void deleteUsers() { 
//		System.out.println("Eliminando usuarios...");
//		try (Connection conn = MyConnection.connect()) {
//			try (PreparedStatement del = conn.prepareStatement("DELETE FROM member")){
//				del.execute();
//			}
//			try (PreparedStatement resAI = conn.prepareStatement("ALTER TABLE member AUTO_INCREMENT = 1")){
//				resAI.execute();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//		
//	public static void main(String[] args) throws SQLException {
//		UserModel model = new UserModel();
//		model.getAllUsers();
//	}

}
