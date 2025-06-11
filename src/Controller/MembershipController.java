package Controller;

import java.util.ArrayList;

import Model.Membership;
import Model.MembershipModel;

public class MembershipController {
	MembershipModel membershipModel;
	
	
	public MembershipController() {
		this.membershipModel = new MembershipModel();
	}


	public void createMembership (String name, Double price, int days, int id_trainer_type, boolean has_invitation_pass) {
		membershipModel.createMembership(name, price, days, id_trainer_type, has_invitation_pass);
	}
	
	public boolean updateMembership (String name, Double price, int days, int id_trainer_type, boolean has_invitation_pass) {
		return membershipModel.updateMembership(name, price, days, id_trainer_type, has_invitation_pass);
	}
	
	public boolean deleteMembership (int id) {
		return membershipModel.deleteMembership(id);
	}
	
	public ArrayList<Membership> getAllMemberships (){
		return membershipModel.getAllMembership();
	}
}
