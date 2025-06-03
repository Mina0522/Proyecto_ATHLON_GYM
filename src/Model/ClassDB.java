package Model;

public class ClassDB {
	private String date;
	private int id_class_session;
	
	public ClassDB(String date, int id_class_session) {
		this.date = date;
		this.id_class_session = id_class_session;
	}

	public String getDate() {
		return date;
	}

	public int getId_class_session() {
		return id_class_session;
	}
	
}
