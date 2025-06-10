package Controller;

import java.sql.Date;
import java.time.LocalDate;

import Model.ClassDB;
import Model.ClassModel;

public class ClassController {
	ClassModel classModel;
	
	public ClassController (ClassModel classModel) {
		this.classModel = classModel;
	}
	
	//id_instructor = la id del instructor seleccionado en ese momento
	//id_class_type = la id que se seleccionará con una JComboBox
	//day = dia que se seleccionarár con ComboBox
	//moth = mes
	//year = año
	//Estos tres enteros serán formateados a fecha en este método
	public void createClass (int id_instructor, int id_class_type,
			int year, int month, int day) {
		Date date = Date.valueOf(LocalDate.of(year, month, day));
		classModel.createClass(id_instructor, id_class_type, date);
	}
	
	//Actualiza los campos de una clase:
	//Tipo de clase (id_class_type)
	//Fecha (session_date)
	public void updateClass (int id_class_session, int id_class_type, int year, int month, int day) {
		classModel.updateClass(id_class_session, id_class_type, Date.valueOf(LocalDate.of(year, month, day)));
	}
	
	//Obtiene la información de una clase, regresando un objeto tipo ClassDB.
	//Busca la clase con su id
	public ClassDB getClass (int id) {
		return classModel.getTClass(id);
	}
	
	//Elimina una clase. 
	//Busca la clase con su id
	public boolean deleteClass (int id) {
		return classModel.deleteClass(id);
	}
	
}
