package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassModel {
	
	//Método que regresa una lista de las clases en las que un usuario ha sido registrado
	public ArrayList<ClassDB> getUserClasses (int id) {
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
							rs.getString("type_name"),
							0));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list; //Regresar la lista si se encontró el usuario
	}
	
	//Regresa las clases activas o futuras de un entrenador, buscándolo con su id
	public ArrayList<ClassDB> getTrainerClasses (int id) {
		ArrayList<ClassDB> list;
		
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
		"SELECT \r\n"
		+ "    cs.session_date,\r\n"
		+ "    ct.type_name,\r\n"
		+ "    COUNT(mcr.id_member) AS registrations\r\n"
		+ "FROM class_session cs\r\n"
		+ "JOIN class_type ct ON cs.id_class_type = ct.id\r\n"
		+ "LEFT JOIN member_class_registration mcr ON mcr.id_class_session = cs.id\r\n"
		+ "WHERE cs.id_instructor = ?\r\n"
		+ "  AND cs.session_date >= CURDATE()\r\n"
		+ "GROUP BY cs.id, cs.session_date, ct.type_name\r\n"
		+ "ORDER BY cs.session_date ASC;\r\n"
		+ "")) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				list = new ArrayList<>();
				while (rs.next()) {
					list.add(new ClassDB(
						rs.getString("session_date"),
						rs.getString("type_name"),
						rs.getInt("registrations")));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	//Regresa el historial de clases de un entrenador (las clases anteriores a la fecha actual)
		public ArrayList<ClassDB> getTrainerClassHistory (int id) {
			ArrayList<ClassDB> list;
			
			try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
			"SELECT \r\n"
			+ "    cs.session_date,\r\n"
			+ "    ct.type_name,\r\n"
			+ "    COUNT(mcr.id_member) AS registrations\r\n"
			+ "FROM class_session cs\r\n"
			+ "JOIN class_type ct ON cs.id_class_type = ct.id\r\n"
			+ "LEFT JOIN member_class_registration mcr ON mcr.id_class_session = cs.id\r\n"
			+ "WHERE cs.id_instructor = ?\r\n"
			+ "  AND cs.session_date <= CURDATE()  -- o < para historial\r\n"
			+ "GROUP BY cs.id, cs.session_date, ct.type_name\r\n"
			+ "ORDER BY cs.session_date ASC;\r\n")) {
				ps.setInt(1, id);
				try (ResultSet rs = ps.executeQuery()) {
					list = new ArrayList<>();
					while (rs.next()) {
						list.add(new ClassDB(
							rs.getString("cs.session_date"),
							rs.getString("ct.type_name"),
							rs.getInt("registrations")));
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return list;
		}
	
	public static void main(String[] args) {
		ClassModel model = new ClassModel();
		
		for (ClassDB clase : model.getTrainerClassHistory(1)) {
			System.out.println(clase);
		}
	}
	
}
