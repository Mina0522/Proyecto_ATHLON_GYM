package Controller;

import Model.MembershipModel;

public class MembershipController {
	MembershipModel membershipModel;
	
	
	public MembershipController(MembershipModel membershipModel) {
		this.membershipModel = membershipModel;
	}


	public void createMembership (int branches_num, String promotions,
			boolean has_invitation_pass, int days, Double price, String name,
			int id_trainer_type) {
		membershipModel.createMembership(branches_num, promotions, has_invitation_pass, days, price, name, id_trainer_type);
	}
	
	public boolean updateMembership (int id, String name, int branches_num, String promotions,
			boolean has_invitation_pass, int days, Double price, int id_trainer_type) {
		return membershipModel.updateMembership(id, name, branches_num, promotions, has_invitation_pass, days, price, id_trainer_type);
	}
	
	public boolean deleteMembership (int id) {
		return membershipModel.deleteMembership(id);
	}
}
