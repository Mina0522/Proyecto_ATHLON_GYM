package Controller;

import Model.UserModel;
import View.Pantalla_Usuarios_Agregar;

public class UserController {
	
	Pantalla_Usuarios_Agregar view;
	UserModel model;
	
	public UserController (Pantalla_Usuarios_Agregar view, UserModel model) {
		this.view = view;
		this.model = model;
		
		
	}
	
	public boolean createUser (String name, String lastName, String phone_number) {
//		model.createUser();
		
		return false;
	}
	
}
