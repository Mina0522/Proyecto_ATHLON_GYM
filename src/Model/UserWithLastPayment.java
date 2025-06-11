package Model;

public class UserWithLastPayment {
	String first_name, last_name, membership_name, transaction_date,
	next_transaction_date;
	int control_num;
	 private String name;
	 private String lastname;
	 private String lastPaymentDate;
	 private String paymentStatus;

	
	public UserWithLastPayment(String first_name, String last_name, String membership_name, String transaction_date,
			String next_transaction_date, int control_num) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.membership_name = membership_name;
		this.transaction_date = transaction_date;
		this.next_transaction_date = next_transaction_date;
		this.control_num = control_num;
	}
    public UserWithLastPayment(String name, String lastname, String lastPaymentDate, String paymentStatus) {
        this.name = name;
        this.lastname = lastname;
        this.lastPaymentDate = lastPaymentDate;
        this.paymentStatus = paymentStatus;
    }
	
	String phone_number, email;
	
	public UserWithLastPayment(String first_name, String last_name, String membership_name, String transaction_date,
			String next_transaction_date, int control_num, String phone_number, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.membership_name = membership_name;
		this.transaction_date = transaction_date;
		this.next_transaction_date = next_transaction_date;
		this.control_num = control_num;
		this.phone_number = phone_number;
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getMembership_name() {
		return membership_name;
	}
	public void setMembershipName(String membershipName) {
	    this.membership_name = membershipName;
	}
	public String getTransaction_date() {
		return transaction_date;
	}

	public String getNext_transaction_date() {
		return next_transaction_date;
	}

	public int getControl_num() {
		return control_num;
	}

	@Override
	public String toString() {
		return "UserWithLastPayment [first_name=" + first_name + ", last_name=" + last_name + ", membership_name="
				+ membership_name + ", transaction_date=" + transaction_date + ", next_transaction_date="
				+ next_transaction_date + ", control_num=" + control_num + ", phone_number=" + phone_number + ", email="
				+ email + "]";
	}
	
}
