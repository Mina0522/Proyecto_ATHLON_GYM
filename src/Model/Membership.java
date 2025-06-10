package Model;

public class Membership {
	int id; //Llave primaria
	int branches_num; //Número de sedes
	String promotions; //Promociones
	boolean has_invitation_pass; //Tiene tarjeta de invitación
	int days; //Días que dura el plan
	Double price; //Precio de la suscripción
	int id_trainer_type; //Id del tipo de entrenador
	
	public Membership(int branches_num, String promotions, boolean has_invitation_pass, int days, Double price,
			int id_trainer_type) {
		
		this.branches_num = branches_num;
		this.promotions = promotions;
		this.has_invitation_pass = has_invitation_pass;
		this.days = days;
		this.price = price;
		this.id_trainer_type = id_trainer_type;
	}
	
	public int getId() {
		return id;
	}
	public int getBranches_num() {
		return branches_num;
	}
	public String getPromotions() {
		return promotions;
	}
	public boolean isHas_invitation_pass() {
		return has_invitation_pass;
	}
	public int getDays() {
		return days;
	}
	public Double getPrice() {
		return price;
	}
	public int getId_trainer_type() {
		return id_trainer_type;
	}
	
}
