package Controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import Model.ClassDB;
import Model.ClassModel;
import Model.Trainer;
import Model.TrainerModel;

public class TrainerController {
	TrainerModel trainerModel;
	ClassModel classModel;
	
	public TrainerController(Model.TrainerModel trainerModel, ClassModel classModel) {
		this.trainerModel = trainerModel;
		this.classModel = classModel;
	}

	//Recibue un table model y lo llena con las clases futuras o activas de un entrenador
	//REGRESA: ---
	//String con el nombre de la clase,
	//Un entero con el número de registros (miembros que se han registrado a la clase)
	//String con la fecha de la clase
	public void fillTrainerClassesTable (int id, DefaultTableModel tableModel) {
		ArrayList<ClassDB> list = classModel.getTrainerClasses(id);
		for (ClassDB tClass : list) {
			tableModel.addRow(new Object[] {
					tClass.getClassType(),
					tClass.getRegistrations(),
					tClass.getDate()});
		}
	}
	//Recibe un table model y lo llena con las clases que son anteriores a la fecha actual
	//REGRESA: ---
	//String con el nombre de la clase,
	//Un entero con el número de registros (miembros que se han registrado a la clase)
	//String con la fecha de la clase
	public void fillTrainerClassesHistoryTable (int id, DefaultTableModel tableModel) {
		ArrayList<ClassDB> list = classModel.getTrainerClassHistory(id);
		for (ClassDB tClass : list) {
			tableModel.addRow(new Object[] {
					tClass.getClassType(),
					tClass.getRegistrations(),
					tClass.getDate()});
		}
	}
	//Regresa un ArrayList de todos los entrenadores registrados
	public ArrayList<Trainer> getAllTrainers(){
		return trainerModel.getAllTrainers();
	}
	
	//Regresa un objeto tipo Entrenadr
	public Trainer getTrainer(int id) {
		return trainerModel.getTrainer(id);
	}
}
