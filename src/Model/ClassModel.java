package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassModel {
	
	//Método que regresa una lista de las clases en las que un usuario ha sido registrado
	public ArrayList<ClassDB> getClassDB (int id) {
		ArrayList<ClassDB> list = new ArrayList<>();
		//Obtener la id del usuario con el número de control proporcionado
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
				"SELECT type_name, registration_date\r\n"
				+ "FROM member_class_registration, class_session, class_type\r\n"
				+ "WHERE member_class_registration.id_class_session = class_session.id\r\n"
				+ "AND class_session.id_class_type = class_type.id AND id_member = ?")) {
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					list.add(new ClassDB(
							rs.getString("registration_date"),
							rs.getString("type_name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list; //Regresar la lista si se encontró el usuario
	}
	
	//Regresa una lista de las clases de el entrenador buscándolas con su id
	public ArrayList<ClassDB> getTrainerClasses (int id) {
		ArrayList<ClassDB> list;
		
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
		"SELECT c.session_date, j.type_name\r\n"
		+ "FROM class_session c \r\n"
		+ "INNER JOIN (\r\n"
		+ "SELECT ct.id, ct.type_name\r\n"
		+ "FROM class_type ct) j ON c.id_class_type = j.id \r\n"
		+ "WHERE\r\n"
		+ "c.id_instructor = ?")) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				list = new ArrayList<>();
				while (rs.next()) {
					list.add(new ClassDB(
						rs.getString("session_date"),
						rs.getString("type_name")));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
//	public static void main(String[] args) {
//		ClassModel model = new ClassModel();
//		
//		for (ClassDB clase : model.getClassDB(2)) {
//			System.out.println(clase);
//		}
//	}
	
}
