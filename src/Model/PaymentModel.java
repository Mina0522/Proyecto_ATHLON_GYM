package Model;

import java.nio.file.Path;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentModel {
	
	//Método que regresa la fecha y el monto del pago
	public ArrayList<Payment> getMemberPayments (int control_num) {
		ArrayList<Payment> list = new ArrayList<>();
		int id;
		try (PreparedStatement prepSt1 = MyConnection.getConn().prepareStatement(
		"SELECT id FROM member WHERE control_num = ?")){
			prepSt1.setInt(1, control_num);
			try (ResultSet rs1 = prepSt1.executeQuery()) {
				if (rs1.next()) {
					id = rs1.getInt("id");
					try (PreparedStatement prepSt2 = MyConnection.getConn().prepareStatement("SELECT transaction_date, price, id_membership FROM membership_payment WHERE id_member = ?")) {
						prepSt2.setInt(1, id);
						try (ResultSet rs = prepSt2.executeQuery()){
							while (rs.next()) {
								list.add(new Payment(
										rs.getString("transaction_date"),
										rs.getDouble("price"),
										rs.getInt("id_membership")));
							}
						}
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int countUsersWithoutPayments() {
	    int count = 0;
	    String sql = "SELECT COUNT(*) AS total FROM member m " +
	                 "LEFT JOIN membership_payment mp ON m.id = mp.id_member " +
	                 "WHERE mp.id_member IS NULL";
	    try (PreparedStatement ps = MyConnection.getConn().prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        if (rs.next()) {
	            count = rs.getInt("total");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}

	//Método que regresa el último pago de un user con el id proporcionado
	public Payment getLastUserPayment (int id) {
		Payment payment = null;
		try (PreparedStatement prepSt = MyConnection.getConn().prepareStatement("SELECT * FROM membership_payment WHERE id_member = ? ORDER BY transaction_date DESC LIMIT 1")) {
			prepSt.setInt(1, id);
			try (ResultSet rs = prepSt.executeQuery()) {
				if (rs.next())
					payment = new Payment(rs.getString("transaction_date"), rs.getDouble("price"), 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return payment;
	}
	
	public boolean createPayment (int id_member, int id_membership) {
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
				"INSERT INTO membership_payment (id_member, id_membership, price, transaction_date, days)\r\n"
				+ "SELECT \r\n"
				+ "    ?,\r\n"
				+ "    m.id,\r\n"
				+ "    m.price,\r\n"
				+ "    CURRENT_DATE,\r\n"
				+ "	m.duration_days\r\n"
				+ "FROM membership m\r\n"
				+ "WHERE m.id = ?;")){
			ps.setInt(1, id_member);
			ps.setInt(2, id_membership);
			
			int i = ps.executeUpdate();
			if (i > 0)
				return true; //Pago registrado exitosamente
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; //Error al registrar el pago
	}
	
	public Payment getPayment (int id) {
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement("SELECT * FROM membership_payment WHERE id = ?")) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()){
				if (rs.next())
					return new Payment(
							rs.getInt("id"),
							rs.getInt("id_member"),
							rs.getInt("id_membership"),
							rs.getString("transaction_date"),
							rs.getDouble("price"),
							rs.getInt("days"),
							rs.getString("m.first_name"),
							rs.getString("ms.name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; //Error al obtener el pago
	}
	
	//Regresa una lista con todos los pagos. Inculye el primer nombre del usuario que pagó y el nombre del plan pagado
	public ArrayList<Payment> getAllPayments () {
		ArrayList<Payment> list;
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
				"SELECT mp.*, m.first_name, ms.name FROM membership_payment mp\r\n"
				+ "INNER JOIN member m ON mp.id_member = m.id\r\n"
				+ "INNER JOIN membership ms ON mp.id_membership = ms.id");
				ResultSet rs = ps.executeQuery()) {
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Payment(
							rs.getInt("id"),
							rs.getInt("id_member"),
							rs.getInt("id_membership"),
							rs.getString("transaction_date"),
							rs.getDouble("price"),
							rs.getInt("days"),
							rs.getString("m.first_name"),
							rs.getString("ms.name")));
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		PaymentModel model = new PaymentModel();
//		
//		for (Payment pago : model.getAllPayments()) {
//			System.out.println(pago);
//		}
//	}
}
