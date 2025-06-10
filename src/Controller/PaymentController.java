package Controller;

import Model.Payment;
import Model.PaymentModel;

public class PaymentController {
	PaymentModel paymentModel;

	public PaymentController(PaymentModel paymentModel) {
		this.paymentModel = paymentModel;
	}
	
	//Registrar un pago con:
	//id del miembro que pagará
	//id de la membresía a pagar
	public boolean registerPayment (int id_member, int id_membership) {
		return paymentModel.createPayment(id_member, id_membership);
	}
	
	public Payment getPayment (int id) { 
		return paymentModel.getPayment(id);
	}
	
}
