package Model;

//Esta clase representa a un entrenador
public class Trainer {
	int id;
	String name, email, phone_number;
	int type; // El tipo de entrenador (general o personal)
	String type_name;
	public Trainer(int id, String name, String email, String phone_number, int type, String type_name) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.type = type;
		this.type_name = type_name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public int getType() {
		return type;
	}
	public String getType_name() {
		return type_name;
	}
	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", email=" + email + ", phone_number=" + phone_number
				+ ", type=" + type + ", type_name=" + type_name + "]";
	}
	
}
