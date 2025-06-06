package Model;

public class UserWithLastPayment {
	int control_num;
	String first_name, last_name, phone_number;
	Double price;
	String transaction_date;
	public UserWithLastPayment(int control_num, String first_name, String last_name, String phone_number,
			Double price, String transaction_date) {
		this.control_num = control_num;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.price = price;
		this.transaction_date = transaction_date;
	}
	public int getControl_num() {
		return control_num;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public Double getPrice() {
		return price;
	}
	public String getTransaction_date() {
		return transaction_date;
	}
	
}
