package Controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.ClassDB;
import Model.ClassModel;
import Model.Payment;
import Model.PaymentModel;
import Model.User;
import Model.UserModel;
import Model.UserWithLastPayment;

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
	
	//Crea un usuario y regresa el número de control del usuario creado
	public int createUser (String first_name, String last_name, String phone_number) {
		//Verficar los datos y regresar un error si hubiera una inconsistencia de datos
		if (first_name.isBlank() || last_name.isBlank() || phone_number.isBlank())
			return 1; //Campo vacío detectado
		else if (first_name.matches(".*\\d.*") || last_name.matches(".*\\d.*"))
			return 2; //Datos inválidos (El nombre o apellido contienen números)
		else if (phone_number.matches(".*[a-zA-Z].*"))
			return 3; //El número de teléfono contiene letras
		else {
			//El método createUser en el modelo regresa el número de control del usuario
			return userModel.createUser(first_name, last_name, phone_number);
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
	
	public int deleteUser (int control_num) { //Eliminar el usuario con número de control
		return userModel.deleteUser(control_num);
	}
	
	public User getUser(int control_num) { //Obtener objecto User con información del usuario con su número de control
		return userModel.getUser(control_num);
	}
	
//	Método que recibe el id del usuario y el modelo de la tabla a llenar (para llenar la tabla "Historial de pagos"
	public void fillUserDetailsTable (int id, DefaultTableModel tableModel) {
		ArrayList<Payment> list = paymentModel.getMemberPayments(id); //Llama al método del modelo de pagos que regresa un objeto Payment
		for (Payment payment : list) {
			tableModel.addRow(new Object[] {
					payment.getDate(),
					payment.getPrice(),
					payment.getId_membership()});
		}
	}
	//Método que recibe el id del usuario y el modelo de la tabla a llenar (para llenar la tabla "Historial de clase"
	public void fillUserClassTable (int id, DefaultTableModel tableModel) {
		ArrayList<ClassDB> list = classModel.getUserClasses(id); //Llama al método de modelo de clases, que regresa un objeto ClaseDB
		for (ClassDB classDB : list) {
			tableModel.addRow(new Object[] {
					classDB.getDate(),
					classDB.getClassType()});
		}
	}
	//Método que recibe el modelo de la tabla de usuarios general y si dios es muy grande la tabla se llenará de información correcta
	public void fillUserHomeTable (String first_name, DefaultTableModel tableModel) {
		ArrayList<UserWithLastPayment> users;

		if (!first_name.isBlank()) //Si el campo de no está en blanco
			users = userModel.getUsersWithLastPaymentWithName(first_name); //Busca usuarios con ese nombre
		else 
			users = userModel.getUsersWithLastPayment(); //Busca todos los usuarios
		
		for (UserWithLastPayment user : users) { //Por cada usuario, añadir su información a una lista de usuarios
			tableModel.addRow(new Object[] {
					user.getFirst_name(),
					user.getLast_name(),
					user.getPhone_number(),
					user.getPrice(),
					user.getTransaction_date() == null? "N/A" : user.getTransaction_date(),
					user.getControl_num()
					});
		}
	}
}
