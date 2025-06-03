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
	
	UserModel userModel;
	PaymentModel paymentModel;
	ClassModel classModel;
	
	public UserController(UserModel userModel, PaymentModel paymentModel,
			ClassModel classModel) {
		this.userModel = userModel;
		this.paymentModel = paymentModel;
		this.classModel = classModel;
	}

	public int createUser (String first_name, String last_name, String phone_number) {
		//Verficar los datos y regresar un error si hubiera una inconsistencia de datos
				if (first_name.isBlank() || last_name.isBlank() || phone_number.isBlank())
					return 1; //Campo vacío detectado
				else if (first_name.matches(".*\\d.*") || last_name.matches(".*\\d.*"))
					return 2; //Datos inválidos (El nombre o apellido contienen números)
				else if (phone_number.matches(".*[a-zA-Z].*"))
					return 3; //El número de teléfono contiene letras
				else {
					userModel.createUser(first_name, last_name, phone_number);
					return 0;
				}
	}
	
	public int updateUser (int control_num, String first_name, String last_name, String phone_number) {
		boolean fnempty = false, lnempty = false, pnempty = false;

		if (!first_name.isBlank()) {
			if (first_name.matches(".*\\d.*"))
				return 2; //Datos inválidos (el campo first_name contiene números)
		} else
			fnempty = true;
		
		if (!last_name.isBlank()) {
			if (last_name.matches(".*\\d.*"))
				return 2; //Datos inválidos (el campo last_name contiene números)
		} else
			lnempty = true;
		
		if (!phone_number.isBlank()) {
			if (phone_number.matches(".*[a-zA-Z].*"))
				return 3; //Datos inválidos (el campo phone_number contiene letras)
		} else
			pnempty = true;
		
		if (fnempty && lnempty && pnempty)
			return 1; //Todos los campos están vacíos
		
		userModel.updateUser(control_num, first_name, last_name, phone_number, fnempty, lnempty, pnempty);
		return 0; //Éxito
	}
	
	public int deleteUser (int control_num) {
		return userModel.deleteUser(control_num);
	}
	
	public User getUser(int control_num) {
		return userModel.getUser(control_num);
	}
	
//	Método que recibe el id del usuario y el modelo de la tabla a llenar (para llenar la tabla "Historial de pagos"
	public void fillUserDetailsTable (int id, DefaultTableModel tableModel) {
		ArrayList<Payment> list = paymentModel.getMemberPayments(id);
		for (Payment payment : list) {
			tableModel.addRow(new Object[] {
					payment.getDate(),
					payment.getPrice(),
					payment.getId_membership()});
		}
	}
	//Método que recibe el id del usuario y el modelo de la tabla a llenar (para llenar la tabla "Historial de clase"
	public void fillUserClassTable (int id, DefaultTableModel tableModel) {
		ArrayList<ClassDB> list = classModel.getClassDB(id);
		for (ClassDB classDB : list) {
			tableModel.addRow(new Object[] {
					classDB.getDate(),
					classDB.getId_class_session()});
		}
	}
	//Método que recibe el modelo de la tabla de usuarios general y si dios es muy grande la tabla se llenará de información correcta
	public void fillUserHomeTable (String first_name, DefaultTableModel tableModel) {
		ArrayList<User> users;

		if (!first_name.isBlank())
			users = userModel.getUsersWithName(first_name);
		else 
			users = userModel.getAllUsers();
		
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
					price,
					date,
					user.getControl_number()
					});
		}
	}
}
