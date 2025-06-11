package Model;

public class Payment {
	private String date;
	private double price;
	private int id_membership;
	
	public Payment(String date, double price, int id_membership) {
		this.date = date;
		this.price = price;
		this.id_membership = id_membership;
	}
	
	int id_member;
	int days;
	int id;
	String membership_name;
	String member_name;
	
	public Payment(int id, int id_member, int id_membership, String date, Double price, int days,
			String membership_name, String member_name) {
		this.date = date;
		this.price = price;
		this.id_membership = id_membership;
		this.id_member = id_member;
		this.days = days;
		this.id = id;
		this.member_name = member_name;
		this.membership_name = membership_name;
	}

	public String getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}

	public int getId_membership() {
		return id_membership;
	}
	
	public int getId_member() {
		return id_member;
	}

	public int getDays() {
		return days;
	}

	public int getId() {
		return id;
	}

	public String getMembership_name() {
		return membership_name;
	}

	public String getMember_name() {
		return member_name;
	}

	@Override
	public String toString() {
		return "Payment [date=" + date + ", price=" + price + ", id_membership=" + id_membership + ", id_member="
				+ id_member + ", days=" + days + ", id=" + id + ", membership_name=" + membership_name
				+ ", member_name=" + member_name + "]";
	}
	
	
}
