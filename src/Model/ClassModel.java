package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassModel {
	
	public ClassDB[] getClassDB (int id_member) {
		ArrayList<ClassDB> list = new ArrayList<>();
		try (Connection conn = MyConnection.connect();
				PreparedStatement prepSt = conn.prepareStatement("SELECT"
						+ "registration_date, id_class_session"
						+ "FROM member_class_registration WHERE id_member = ?")){
			prepSt.setInt(1, id_member);
			try (ResultSet rs = prepSt.executeQuery()){
				while (rs.next()) {
					list.add(new ClassDB(
							rs.getString("registration_date"),
							rs.getInt("id_class_session")));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ClassDB[]) list.toArray();
	}
	
}
