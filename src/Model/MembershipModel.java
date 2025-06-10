package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MembershipModel {
	
	public void createMembership (int branches_num, String promotions,
			boolean has_invitation_pass, int days, Double price,
			int id_trainer_type) {
		
			String query = "INSERT INTO membership "
					+ "(branches_number, promotions, has_invitation_pass, duration_days, price, name) "
					+ "VALUES (?,?,?,?,?,?)";
			try (PreparedStatement prepStatement = MyConnection.getConn().prepareStatement(query)){
				prepStatement.setInt(1, branches_num);
				prepStatement.setString(2, promotions);
				prepStatement.setBoolean(3, has_invitation_pass);
				prepStatement.setInt(4, days);
				prepStatement.setDouble(5, price);
				prepStatement.setInt(6, id_trainer_type);
			    
			    prepStatement.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
