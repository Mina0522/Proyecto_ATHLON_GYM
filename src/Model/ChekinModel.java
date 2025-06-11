package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ChekinModel {
	
	public UserWithLastPayment getUserDetailsCN (int control_num) {
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
				"SELECT \r\n"
				+ "    m.*, \r\n"
				+ "    ms.name AS membership_name,\r\n"
				+ "    p.transaction_date,\r\n"
				+ "    DATE_ADD(p.transaction_date, INTERVAL ms.duration_days DAY) AS next_transaction_date,\r\n"
				+ "    p.price\r\n"
				+ "FROM member m\r\n"
				+ "LEFT JOIN (\r\n"
				+ "    SELECT mp.*\r\n"
				+ "    FROM membership_payment mp\r\n"
				+ "    INNER JOIN (\r\n"
				+ "        SELECT id_member, MAX(transaction_date) AS last_date\r\n"
				+ "        FROM membership_payment\r\n"
				+ "        GROUP BY id_member\r\n"
				+ "    ) latest ON mp.id_member = latest.id_member AND mp.transaction_date = latest.last_date\r\n"
				+ ") p ON m.id = p.id_member\r\n"
				+ "LEFT JOIN membership ms ON p.id_membership = ms.id\r\n"
				+ "WHERE m.control_num = ?")) {
			ps.setInt(1, control_num);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return new UserWithLastPayment(
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("membership_name"),
							rs.getString("transaction_date"),
							rs.getString("next_transaction_date"),
							rs.getInt("control_num"),
							rs.getString("phone_number"),
							rs.getString("email"));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null; //Error
	}
}
