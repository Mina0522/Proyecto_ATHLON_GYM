package Main;

import Model.MyConnection;
import View.Vista_GYM;

public class Main_GYM {
	
	public static void main(String[] args) {
		
		MyConnection.connect(); //Iniciar conexión a la base de datos
		new Vista_GYM(); //Iniciar vista principal
	}

}
