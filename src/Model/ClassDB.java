package Model;

public class ClassDB {
	private String date, type;
	private int registrations;
//	private int id_class_session;
	
	public ClassDB(String date, String type, int registrations) {
		this.date = date;
		this.type = type;
		this.registrations = registrations;
	}
	
	private int id_class;
	private int id_trainer;
	
	public ClassDB(int id_class, String type) {
		this.type = type;
		this.id_class = id_class;
	}
	
	public String getType() {
		return type;
	}

	public int getId_class() {
		return id_class;
	}

	public int getId_trainer() {
		return id_trainer;
	}

	public String getDate() {
		return date;
	}

	public String getClassType() {
		return type;
	}
	
	public int getRegistrations() {
		return registrations;
	}

	@Override
	public String toString() {
		return "ClassDB [date=" + date + ", class_type=" + type + ", asistencias=" + registrations + "]";
	}
	
}
