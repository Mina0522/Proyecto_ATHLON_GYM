package Controller;

import javax.swing.table.DefaultTableModel;

import Model.PaymentModel;
import Model.UserModel;
import View.Pantalla_Usuarios_Agregar;

public class UserController {
	
	Pantalla_Usuarios_Agregar view;
	UserModel userModel;
	PaymentModel paymentModel;
	
	public UserController (Pantalla_Usuarios_Agregar view, UserModel model) {
		this.view = view;
		this.userModel = model;
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
		tableModel.addRow(paymentModel.memberPaymentToArray(id));
	}
	
}
