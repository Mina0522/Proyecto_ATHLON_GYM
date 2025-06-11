package Controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.Payment;
import Model.PaymentModel;
import Model.UserModel;

public class PaymentController {
	PaymentModel paymentModel;
	UserModel userModel;
	public PaymentController() {
		this.paymentModel = new PaymentModel();
		this.userModel = new UserModel();
	}
	
	//Registrar un pago con:
	//id del miembro que pagará
	//id de la membresía a pagar
	public boolean registerPayment (int id_member, int id_membership) {
		if (!userModel.hasActveMmebership(id_member))
			//No tiene un plan pagado activo: registrar pago
			return paymentModel.createPayment(id_member, id_membership);
		else 
			return false; //Tiene una membresía activa: no se pudo registrar el pago
	}
	
	public Payment getPayment (int id) { 
		return paymentModel.getPayment(id);
	}
	
	//Regresa un TableModel con:
	//Nombre del plan pagado | Nombre del usuario | Monto pagado
	public DefaultTableModel getPaymentTable () {
		DefaultTableModel tableModel = new DefaultTableModel();
		ArrayList<Payment> payments = paymentModel.getAllPayments();
		for (Payment p : payments) {
			tableModel.addRow(new Object[] {p.getMembership_name(), p.getMember_name(), p.getPrice()});
		}
		return tableModel;
	}
	
//	public static void main(String[] args) {
//		PaymentController con = new PaymentController(new PaymentModel());
//		System.out.println(con.registerPayment(1, 1));
//	}
	
}
