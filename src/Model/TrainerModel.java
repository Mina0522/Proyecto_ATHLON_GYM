package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrainerModel {
	
	public void createTrainer (String name, String email, String phone_number, int type) {
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
		"INSERT INTO instructor (name, email, phone_number, id_instructor_type) VALUES (?, ?, ?, ?)")) {
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone_number);
			ps.setInt(4, type);
			
			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Trainer getTrainer (int id) {
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
		"SELECT * FROM instructor WHERE id = ?")) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new Trainer (
							rs.getInt("id"),
							rs.getString("name"),
							rs.getString("email"),
							rs.getString("phone_number"),
							rs.getInt("id_instructor_type"));
				}
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//Necesita del controlador para que le indique qué campos deben actualizarse
	public void updateTrainer (int id, String name, String email, String phone_number,
		boolean nempty, boolean emailempty, boolean pnempty) {
		
			System.out.println("Actualizando usuario...");
			ArrayList<Object> values = new ArrayList<>();
			ArrayList<String> fields = new ArrayList<>();
			StringBuilder query = new StringBuilder();
			query.append("UPDATE instructor SET ");
			
			if (!nempty){//Si el campo name no está vacío
				fields.add("name = ?");
				values.add(name);
			}
			
			if (!emailempty){//Si el campo last_name no está vacío
				fields.add("email = ?");
				values.add(email);
			}
			
			if (!pnempty){//Si el campo phone_number no está vacío
				fields.add("phone_number = ?");
				values.add(phone_number);
			}
			
			query.append(String.join(", ", fields));
			query.append(" WHERE id = ?");
			
			values.add(id);
			
			System.out.println(query);
			
			try (PreparedStatement prepStatement = MyConnection.getConn().prepareStatement(query.toString())){
				for (int i = 0; i < values.size(); i++) {
					prepStatement.setString(i+1, values.get(i).toString());
				}
				System.out.println(prepStatement);
				prepStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public boolean deleteTrainer (int id) {
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement("DELETE FROM instructor WHERE id = ?")) {
			ps.setInt(1, id);
			ps.execute();
			return true; //Eliminación exitosa
		} catch (SQLException e) {
			e.printStackTrace();
			return false; //Eliminación fallida
		}
		
	}
	
	public ArrayList<Trainer> getAllTrainers() {
		ArrayList<Trainer> list;
			try (PreparedStatement pr = MyConnection.getConn().prepareStatement("SELECT * FROM instructor");
			ResultSet rs = pr.executeQuery()) {
				list = new ArrayList<>();
				while (rs.next()) {
					list.add(new Trainer(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone_number"),
					rs.getInt("id_instructor_type")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
		}
		return list;
	}

//	public static void main(String[] args) {
//		TrainerModel model = new TrainerModel();
//		for (Trainer trainer : model.getAllTrainers()) {
//			System.out.println(trainer);
//		}
//	}
}
