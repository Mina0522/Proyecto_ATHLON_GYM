package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MembershipModel {
	
	public void createMembership (int branches_num, String promotions,
			boolean has_invitation_pass, int days, Double price, String name,
			int id_trainer_type) {
		
			String query = "INSERT INTO membership "
					+ "(branches_number, promotions, has_invitation_pass, duration_days, price, name, id_instructor_type) "
					+ "VALUES (?,?,?,?,?,?,?)";
			try (PreparedStatement prepStatement = MyConnection.getConn().prepareStatement(query)){
				prepStatement.setInt(1, branches_num);
				prepStatement.setString(2, promotions);
				prepStatement.setBoolean(3, has_invitation_pass);
				prepStatement.setInt(4, days);
				prepStatement.setDouble(5, price);
				prepStatement.setString(6, name);
			    prepStatement.setInt(7, id_trainer_type);
			    prepStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public Membership getMembership (int id) {
		try (PreparedStatement pr = MyConnection.getConn().prepareStatement(
		"SELECT mship.*, type_name FROM membership mship "
		+ "INNER JOIN (instructor_type it) ON mship.id = it.id "
		+ "AND mship.id = ?")) {
			pr.setInt(1, id);
			try (ResultSet rs = pr.executeQuery()){
				if (rs.next()) {
					return new Membership(
							rs.getInt("id"),//id de la membresía (No se necesita mostrar)
							rs.getString("name"), //Nombre del plan (Premium, Básico)
							rs.getInt("branches_number"), //Número de sedes
							rs.getString("promotions"), //Promociones
							rs.getBoolean("has_invitation_pass"), //Tiene tarjeta de invitación
							rs.getInt("duration_days"), //Días que dura la suscripción
							rs.getDouble("price"), //Precio
							rs.getInt("id_instructor_type"), //Id del tipo de entrenador (para operaciones, no se necesita mostrar)
							rs.getString("type_name")); //Nombre del tipo del instructor (para mostrar)
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; //Error
	}
	
	public ArrayList<Membership> getAllMembership () {
		ArrayList<Membership> list;
		try (PreparedStatement pr = MyConnection.getConn().prepareStatement(
		"SELECT mship.*, type_name FROM membership mship "
		+ "INNER JOIN (instructor_type it) ON mship.id = it.id ")) {
			try (ResultSet rs = pr.executeQuery()){
				list = new ArrayList<>();
				while (rs.next()) {
					 list.add(new Membership(
								rs.getInt("id"),
								rs.getString("name"),
								rs.getInt("branches_number"),
								rs.getString("promotions"),
								rs.getBoolean("has_invitation_pass"),
								rs.getInt("duration_days"),
								rs.getDouble("price"),
								rs.getInt("id_instructor_type"),
								rs.getString("type_name")));
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; //Error
	}
	
	public boolean updateMembership (int id, String name, int branches_num, String promotions,
			boolean has_invitation_pass, int days, Double price, int id_trainer_type) {
		
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
				"UPDATE membership SET branches_number = ?, promotions = ?, \r\n"
				+ "has_invitation_pass = ?, duration_days = ?, \r\n"
				+ "price = ?, name = ?, id_instructor_type = ?\r\n"
				+ "WHERE id = ?")) {
			ps.setInt(1, branches_num);
			ps.setString(2, promotions);
			ps.setBoolean(3, has_invitation_pass);
			ps.setInt(4, days);
			ps.setDouble(5, price);
			ps.setString(6, name);
			ps.setInt(7, id_trainer_type);
			ps.setInt(8, id);
			
			int i = ps.executeUpdate();
			if (i > 0)
				return true; //Plan actualisado con éxito
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; //Error al actualiar el plan
	}
	
	public boolean deleteMembership (int id) {
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement("DELETE FROM membership WHERE id = ?")){
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return true; //Plan eliminado con éxito
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; //Error al eliminar el plan
	}
	public static void main(String[] args) {
		MembershipModel model = new MembershipModel();
		for (Membership hola: model.getAllMembership()) {
			System.out.println(hola);
		}
		
	}
}
