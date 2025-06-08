package Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.MyConnection;
import View.Vista_GYM;

public class Main_GYM {
	
	public static void main(String[] args) {
		MyConnection.connect();
		
//		//Estas dos consultas son para comprobar que la conexión funciona al iniciar el programa
//		try (PreparedStatement pr = MyConnection.getConn().prepareStatement("Select * FROM member");) {
//			ResultSet rs = pr.executeQuery();
//			System.out.println("1ra prueba de conexión exitosa");
//			while (rs.next()) {
//				System.out.println(rs.getString("first_name"));
//				System.out.println(rs.getInt("control_num"));
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			PreparedStatement pr = MyConnection.getConn().prepareStatement("Select * FROM member");
//			ResultSet rs = pr.executeQuery();
//			System.out.println("2da prueba de conexión exitosa");
//
//			while (rs.next()) {
//				System.out.println(rs.getString("first_name"));
//				System.out.println(rs.getInt("control_num"));
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		new Vista_GYM();
	}

}
