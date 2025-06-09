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

	public String getDate() {
		return date;
	}

	public String getClassType() {
		return type;
	}

	@Override
	public String toString() {
		return "ClassDB [date=" + date + ", class_type=" + type + ", asistencias=" + registrations + "]";
	}
	
}
