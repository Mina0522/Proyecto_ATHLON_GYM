package Controller;

import Model.ChekinModel;
import Model.UserWithLastPayment;

public class CheckinController {
	private ChekinModel checkinModel;
	
	public CheckinController () {
		checkinModel = new ChekinModel();
	}
	public UserWithLastPayment checkUser (int control_num) {
		return checkinModel.getUserDetailsCN(control_num);
	}
	
	public static void main(String[] args) {
		CheckinController con = new CheckinController();
		
		System.out.println(con.checkUser(226576));
	}
}
