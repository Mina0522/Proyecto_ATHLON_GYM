package Model;

public class ComboObject {
	int id;
	String text;
	
	public ComboObject(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text; //La combobox muestra lo que se regrese en este método
	}
}
