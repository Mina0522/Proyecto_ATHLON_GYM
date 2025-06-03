package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentModel {
	
	//Método que regresa la fecha y el monto del pago
	public Payment[] getMemberPayments (int id_member) {
		ArrayList<Payment> list = new ArrayList<>();
		try (Connection conn = MyConnection.connect();
		PreparedStatement prepSt = conn.prepareStatement(
		"SELECT transaction_date, price, id_membership FROM membership_payment WHERE id_member = ?")){
			prepSt.setInt(1, id_member);
			try (ResultSet rs = prepSt.executeQuery()){
				while (rs.next()) {
					list.add(new Payment(
							rs.getString("transaction_date"),
							rs.getInt("price"),
							rs.getInt("id_membership")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (Payment[]) list.toArray();
	}
	
//	public static void main(String[] args) {
//		PaymentModel model = new PaymentModel();
//		ArrayList<Payment> array = model.getMemberPayments(3);
//		for (Payment payment : array) {
//			System.out.println("Fecha: " + payment.getDate());
//			System.out.println("Membresía: " + payment.getId_membership());
//			System.out.println("Monto: " + payment.getPrice());
//
//		}
//	}
}
