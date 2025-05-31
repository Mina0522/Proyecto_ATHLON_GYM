package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {

	public boolean createUser(String first_name, String last_name, String phone_number) throws SQLException {
		
		String query = "INSERT INTO member (first_name, last_name, phone_number, control_num) VALUES (?,?,?,?)";
		PreparedStatement prepStatement = MyConnection.connect().prepareStatement(query);
		prepStatement.setString(1, first_name);
		prepStatement.setString(2, last_name);
		prepStatement.setString(3, phone_number);
		prepStatement.setInt(4,999);

		boolean flag = false;
	    
	    prepStatement.execute();
	    
		return false;
	}
	
	public static void main(String[] args) {
		UserModel model = new UserModel();
		try {
			model.createUser("ale", "jandro", "613777");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement stm;
//		try {
//			stm = MyConnection.connect().prepareStatement("SELECT * FROM member");
//			ResultSet rs = stm.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
