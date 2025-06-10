package Model;

public class User {
	private int id, control_number;
	private String first_name, last_name, phone_number, email;
	
	public User(int id, int control_number, String first_name, String last_name, String phone_number, String email) {
		this.id = id;
		this.control_number = control_number;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.email = email;
	}
	
	public int getControl_number() {
		return control_number;
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

	public int getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
}
