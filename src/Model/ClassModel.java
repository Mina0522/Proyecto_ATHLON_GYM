package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassModel {
	
	//Método que regresa una lista de las clases en las que un usuario se ha registrado
	public ArrayList<ClassDB> getClassDB (int control_num) {
		ArrayList<ClassDB> list = new ArrayList<>();
		int id;
		//Obtener la id del usuario con el número de control proporcionado
		try (PreparedStatement prepSt = MyConnection.getConn().prepareStatement("SELECT id FROM member WHERE control_num = ?" )){
			prepSt.setInt(1, control_num);
			try (ResultSet rs1 = prepSt.executeQuery()){
				if (rs1.next()) {
					id = rs1.getInt("id");
					//Obtener las clases que haya con el id del usuario encontrado
					try (PreparedStatement prepSt2 = MyConnection.getConn().prepareStatement("SELECT"
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
		return list; //Regresar la lista si se encontró el usuario
	}
	
//	public static void main(String[] args) {
//		ClassModel model = new ClassModel();
//		System.out.println(model.getClassDB(226576));
//	}
	
}
