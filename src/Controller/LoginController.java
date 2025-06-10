package Controller;

import Model.AuthModel;
import View.View_loginGYM;

public class LoginController {
	
	AuthModel model;
	View_loginGYM view;
	
	public LoginController (View_loginGYM view, AuthModel model) {
		this.model = model;
		this.view = view;
	}
	
	public boolean auth (String email, String password) {
//		return model.auth(email, password);
		return true;
	}
}