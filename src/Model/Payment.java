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

	public String getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}

	public int getId_membership() {
		return id_membership;
	}
	
	
}
