package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Model.ClassDB;
import Model.ClassModel;
import Model.ComboObject;
import Model.MyConnection;
import Model.PDFModel;
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
	public int createUser (String first_name, String last_name, String phone_number, String email) {
		//Verficar los datos y regresar un error si hubiera una inconsistencia de datos
		if (first_name.isBlank() || last_name.isBlank() || phone_number.isBlank())
			return 1; //Campo vacío detectado
		else if (first_name.matches(".*\\d.*") || last_name.matches(".*\\d.*"))
			return 2; //Datos inválidos (El nombre o apellido contienen números)
		else if (phone_number.matches(".*[a-zA-Z].*"))
			return 3; //El número de teléfono contiene letras
		else {
			//El método createUser en el modelo regresa el número de control del usuario
			return userModel.createUser(first_name, last_name, phone_number, email);
		}
	}
	
	public int updateUser (int control_num, String first_name, String last_name, String phone_number, String email, int id_membership) {
		boolean fnempty = false, lnempty = false, pnempty = false, emailempty = false;

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
		
		if (email.isBlank())
			emailempty = true;
		
		userModel.updateUser(control_num, first_name, last_name, phone_number, email, id_membership, fnempty, lnempty, pnempty, emailempty);
		return 0; //Éxito
	}
	
	public int deleteUser (int control_num) { //Eliminar el usuario con número de control
		return userModel.deleteUser(control_num);
	}
	
	public User getUser(int control_num) { //Obtener objecto User con información del usuario con su número de control
		return userModel.getUser(control_num);
	}
	
	public User getUserWId (int id) {
		return userModel.getUserWId(id);
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
	
	public int getActiveUsersCount() {
	    return userModel.countActiveUsers();
	}
	
	public int getFaltadPago() {
	    return paymentModel.countUsersWithoutPayments();
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
					user.getMembership_name(),
					user.getTransaction_date() == null? "N/A" : user.getTransaction_date(),
					user.getNext_transaction_date() == null? "N/A" : user.getNext_transaction_date(),
					user.getControl_num()
					});
		}
	}
	//Genera un combobox con todos los planes que haya registradoes en el sistema y el default es el plan que tenga el usuario
		public JComboBox<ComboObject> generateMembershipComboId (int id) {
			JComboBox<ComboObject> combo = new JComboBox<>();
			int id_current_membership = 0;
			try (PreparedStatement ps = MyConnection.getConn().prepareStatement(
					"SELECT m.id, m.name, p.id_membership\r\n"
					+ "FROM membership m\r\n"
					+ "LEFT JOIN (\r\n"
					+ "    SELECT id_membership\r\n"
					+ "    FROM membership_payment\r\n"
					+ "    WHERE id_member = ?\r\n"
					+ "    ORDER BY transaction_date DESC\r\n"
					+ "    LIMIT 1\r\n"
					+ ") p ON m.id = p.id_membership;\r\n"
					+ "");
					){
				ps.setInt(1, id);
				try (ResultSet rs = ps.executeQuery()){
					while (rs.next()) {
						combo.addItem(new ComboObject(rs.getInt("m.id"), rs.getString("m.name")));
						if (id_current_membership == 0)
							id_current_membership = rs.getInt("p.id_membership");
					}
					for (int i = 0; i < combo.getItemCount(); i++) {
						ComboObject cObject = combo.getItemAt(i);
						if (cObject.getId() == id_current_membership)
							combo.setSelectedIndex(i);
					}
					return combo;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	//Genera un combobox con todos los planes que haya registradoes en el sistema
	public JComboBox<ComboObject> generateMembershipCombo () {
		JComboBox<ComboObject> combo = new JComboBox<>();
		try (PreparedStatement ps = MyConnection.getConn().prepareStatement("SELECT id, name FROM membership");
				ResultSet rs = ps.executeQuery()){
			while (rs.next()) {
				combo.addItem(new ComboObject(rs.getInt("id"), rs.getString("name")));
			}
			return combo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public UserWithLastPayment getUserDetails (int id) {
		return userModel.getUserDetails(id);
	}
	
	public boolean isActive (int id) {
		return userModel.hasActveMmebership(id); //True si tiene un plan pagado vigente
	}
	
	public void generateUserIdPDF (int id) {
		User user = getUserWId(id);
		if (user != null)
			PDFModel.createIdPDF(
					user.getFirst_name(),
					user.getLast_name(),
					user.getControl_number());
	}
	
	public void geterateUserReportPDF (int id) {
		PDFModel.createUserReportPDF(paymentModel.getAllUserPayments(id));
	}
	
	public JComboBox<ComboObject> getPlanesCombo () {
		ArrayList<ClassDB> clases = classModel.getAllClasses();
		JComboBox<ComboObject> objetos = new JComboBox<>();
		for (ClassDB clase : clases) {
			objetos.addItem(new ComboObject(clase.getId_class(), clase.getType()));
		}
		return objetos;
	}
	
//	public static void main(String[] args) {
//		UserController con = new UserController(new UserModel(), new PaymentModel(), new ClassModel());
//		con.geterateUserReportPDF(3);
//	}
}
