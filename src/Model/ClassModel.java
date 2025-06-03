package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassModel {
	
	public ArrayList<ClassDB> getClassDB (int control_num) {
		ArrayList<ClassDB> list = new ArrayList<>();
		int id;
		try (Connection conn = MyConnection.connect();
		PreparedStatement prepSt = conn.prepareStatement("SELECT id FROM member WHERE control_num = ?" )){
			prepSt.setInt(1, control_num);
			try (ResultSet rs1 = prepSt.executeQuery()){
				if (rs1.next()) {
					id = rs1.getInt("id");
					try (PreparedStatement prepSt2 = conn.prepareStatement("SELECT"
						+ " registration_date, id_class_session"
						+ " FROM member_class_registration WHERE id_member = ?")) {
						prepSt2.setInt(1, id);
						try (ResultSet rs2 = prepSt2.executeQuery()){
							while (rs2.next()) {
								list.add(new ClassDB(
										rs2.getString("registration_date"),
										rs2.getInt("id_class_session")));
							}
						}
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
//	public static void main(String[] args) {
//		ClassModel model = new ClassModel();
//		System.out.println(model.getClassDB(226576));
//	}
	
}
