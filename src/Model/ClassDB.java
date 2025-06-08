package Model;

public class ClassDB {
	private String date, type;
//	private int id_class_session;
	
	public ClassDB(String date, String type) {
		this.date = date;
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public String getClassType() {
		return type;
	}

	@Override
	public String toString() {
		return "ClassDB [date=" + date + ", class_type=" + type + "]";
	}
	
}
