package Model;

import java.sql.*;
import Model.UserWithLastPayment;

public class ChecadorModel {
    private Connection conn;

    public ChecadorModel() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_basededatos", "usuario", "contraseña");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserWithLastPayment getUserDetailsCN(int controlNum) {
        String query = "SELECT name, lastname, last_payment_date, payment_status FROM member WHERE control_num = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, controlNum);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	return new UserWithLastPayment(
            		    rs.getString("name"),
            		    rs.getString("lastname"),
            		    rs.getString("last_payment_date"),
            		    rs.getString("payment_status")
            		);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
