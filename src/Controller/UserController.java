package Controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.ClassDB;
import Model.ClassModel;
import Model.Payment;
import Model.PaymentModel;
import Model.User;
import Model.UserModel;
import View.Pantalla_Usuarios_Agregar;

public class UserController {
	
	Pantalla_Usuarios_Agregar view;
	UserModel userModel;
	PaymentModel paymentModel;
	ClassModel classModel;
	
	public UserController(Pantalla_Usuarios_Agregar view, UserModel userModel, PaymentModel paymentModel,
			ClassModel classModel) {
		this.view = view;
		this.userModel = userModel;
		this.paymentModel = paymentModel;
		this.classModel = classModel;
	}

	public int createUser (String name, String lastName, String phone_number) {
		return userModel.createUser(name, name, phone_number);
	}
	
	public int updateUser (int control_num, String first_name, String last_name, String phone_number) {
		return userModel.updateUser(control_num, first_name, last_name, phone_number);
	}
	
	public int deleteUser (int id) {
		return userModel.deleteUser(id);
	}
	
	//Este método recibe la tabla que se le envía y le añade las filas de pagos del usuario que obtenga
	public void fillUserDetailsTable (int id, DefaultTableModel tableModel) {
		Payment array[] = paymentModel.getMemberPayments(id);
		for (Payment payment : array) {
			tableModel.addRow(new Object[] {
					payment.getDate(),
					payment.getPrice(),
					payment.getId_membership()});
		}
	}
	
	public void fillUserClassTable (int id, DefaultTableModel tableModel) {
		ClassDB array[] = classModel.getClassDB(id);
		for (ClassDB classDB : array) {
			tableModel.addRow(new Object[] {
					classDB.getDate(),
					classDB.getId_class_session()});
		}
	}
	
	public void fillUserHomeTable (DefaultTableModel tableModel) {
		ArrayList<User> users = userModel.getAllUsers();
		for (User user : users) {
			Payment lastPayment = paymentModel.getLastUserPayment(user.getId());
			double price;
			String date;
			if (lastPayment != null) {
				price = lastPayment.getPrice();
				date = lastPayment.getDate();
			} else {
				price = 0;
				date = "No";
			}
			tableModel.addRow(new Object[] {
					user.getFirst_name(),
					user.getLast_name(),
					user.getPhone_number(),
					lastPayment.getPrice(),
					lastPayment.getDate()
					});
		}
	}
}
