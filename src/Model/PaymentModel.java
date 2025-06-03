package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentModel {
	
	//Método que regresa la fecha y el monto del pago
	public ArrayList<Payment> getMemberPayments (int control_num) {
		ArrayList<Payment> list = new ArrayList<>();
		int id;
		try (Connection conn = MyConnection.connect();
		PreparedStatement prepSt1 = conn.prepareStatement(
		"SELECT id FROM member WHERE control_num = ?")){
			prepSt1.setInt(1, control_num);
			try (ResultSet rs1 = prepSt1.executeQuery()) {
				if (rs1.next()) {
					id = rs1.getInt("id");
					try (PreparedStatement prepSt2 = conn.prepareStatement("SELECT transaction_date, price, id_membership FROM membership_payment WHERE id_member = ?")) {
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
	//Método que regresa el último pago de un user con el id proporcionado
	public Payment getLastUserPayment (int id) {
		Payment payment = null;
		try (Connection conn = MyConnection.connect();
		PreparedStatement prepSt = conn.prepareStatement("SELECT * FROM membership_payment WHERE id_member = ? ORDER BY transaction_date DESC LIMIT 1")) {
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
	public static void main(String[] args) {
		PaymentModel model = new PaymentModel();
	}
}
