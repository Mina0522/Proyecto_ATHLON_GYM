package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MembershipModel {
	
	public boolean createMembership (String name, Double price, int days,
			int id_trainer_type, boolean has_invitation_pass) {
		
			String query = "INSERT INTO membership "
					+ "(name, price, duration_days, id_instructor_type, has_invitation_pass, branches_number) "
					+ "VALUES (?,?,?,?,?, 0)";
			try (PreparedStatement prepStatement = MyConnection.getConn().prepareStatement(query)){
				prepStatement.setString(1, name);
				prepStatement.setDouble(2, price);
				prepStatement.setInt(3, days);
				prepStatement.setInt(4, id_trainer_type);
			    prepStatement.setBoolean(5, has_invitation_pass);
			    
			    int nosejeje = prepStatement.executeUpdate();
			    if (nosejeje > 0)
			    	return true; //Éxito
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; //Error
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
		+ "LEFT JOIN (instructor_type it) ON mship.id = it.id ")) {
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
	
	public boolean updateMembership (int id, Double price, int days, int id_trainer_type, boolean has_invitation_pass) {
		
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
				"UPDATE membership SET price = ?, duration_days = ?, id_instructor_type = ?, has_invitation_pass = ? "
				+ "WHERE id = ?")) {
			ps.setDouble(1, price);
			ps.setInt(2, days);
			ps.setInt(3, id_trainer_type);
			ps.setBoolean(4, has_invitation_pass);
			
			ps.setInt(5, id);
			
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
		model.updateMembership(1, 500.0, 30, 1, false);
		for (Membership hola: model.getAllMembership()) {
			System.out.println(hola);
		}
		
	}
}
