package Model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
			+ "  AND cs.session_date <= CURDATE()\r\n"
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
		
		// --- CRUD
		//Crear una clase
		public void createClass (int id_instructor, int id_class_type, Date session_date) {
			try(PreparedStatement ps = MyConnection.getConn().prepareStatement(""
					+ "INSERT INTO class_session (id_instructor, id_class_type, session_date)"
					+ "VALUES (?, ?, ?)")){
				ps.setInt(1, id_instructor);
				ps.setInt(2, id_class_type);
				ps.setDate(3, session_date);
				
				ps.execute(); //Ejecutar query
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public ClassDB getTClass (int id_class) {
			try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
					"SELECT \r\n"
					+ "    cs.session_date,\r\n"
					+ "    ct.type_name,\r\n"
					+ "    COUNT(mcr.id_member) AS registrations\r\n"
					+ "FROM class_session cs\r\n"
					+ "JOIN class_type ct ON cs.id_class_type = ct.id\r\n"
					+ "LEFT JOIN member_class_registration mcr ON mcr.id_class_session = cs.id\r\n"
					+ "WHERE cs.id = ?\r\n"
					+ "GROUP BY cs.id, cs.session_date, ct.type_name\r\n"
					+ "ORDER BY cs.session_date ASC;")){
				ps.setInt(1, id_class);
				try (ResultSet rs = ps.executeQuery()){
					if (rs.next()) {
						return new ClassDB(
								rs.getString("cs.session_date"),
								rs.getString("ct.type_name"),
								rs.getInt("registrations"));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//Actualiza el tipo de clase y la fecha de la clase
		public void updateClass (int id, int id_class_type, Date session_date) {
			System.out.println("Actualizando clase...");
			
			try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
			"UPDATE class_session "
			+ "SET id_class_type = ?, session_date = ? "
			+ "WHERE id = ?")){
				ps.setInt(1, id_class_type);
				ps.setDate(2, session_date);
				ps.setInt(3, id);
				
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Clase actualizada.");
		}
		
		public boolean deleteClass (int id) {
			try (PreparedStatement ps = MyConnection.getConn().prepareStatement("DELETE FROM class_session WHERE id = ?")){
				ps.setInt(1, id);
				
				ps.execute();
				return true; //Clase eliminada exitosamente
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false; //Error al eliminar la clase
			}
		}
		
		public ArrayList<ClassDB> getAllClasses (){
			ArrayList<ClassDB> list = new ArrayList<>();
			try (PreparedStatement ps = MyConnection.getConn().prepareStatement("SELECT * FROM class_type");
			ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					list.add(new ClassDB(rs.getInt("id"),
							rs.getString("type_name")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
//	public static void main(String[] args) {
//		ClassModel model = new ClassModel();
//		System.out.println(model.getTClass(1));
//		for (ClassDB clase : model.getTrainerClassHistory(1)) {
//			System.out.println(clase);
//		}
//	}
	
}
