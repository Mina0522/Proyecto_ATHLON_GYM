package Controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import Model.ClassDB;
import Model.ClassModel;
import Model.ComboObject;
import Model.Trainer;
import Model.TrainerModel;

public class TrainerController {
	TrainerModel trainerModel;
	ClassModel classModel;
	
	public TrainerController(TrainerModel trainerModel, ClassModel classModel) {
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
	
	//Crea un usuario y regresa el número de control del usuario creado
		public int createTrainer (String name, String email, String phone_number, int type) {
			//Verficar los datos y regresar un error si hubiera una inconsistencia de datos
			if (name.isBlank() || email.isBlank() || phone_number.isBlank())
				return 1; //Campo vacío detectado
			else if (name.matches(".*\\d.*"))
				return 2; //Datos inválidos (El nombre contiene números)
			else if (phone_number.matches(".*[a-zA-Z].*"))
				return 3; //El número de teléfono contiene letras
			else {
				//El método createUser en el modelo regresa el número de control del usuario
				return trainerModel.createTrainer(name, email, phone_number, type);
			}
		}
		
		public int updateTrainer (int id, String name, String email, String phone_number, int type) {
			boolean nempty = false, emailempty = false, pnempty = false;

			if (!name.isBlank()) {
				if (name.matches(".*\\d.*"))
					return 2; //Datos inválidos (el campo name contiene números)
			} else
				nempty = true;
			
			if (email.isBlank())
				emailempty = true;
			
			if (!phone_number.isBlank()) {
				if (phone_number.matches(".*[a-zA-Z].*"))
					return 3; //Datos inválidos (el campo phone_number contiene letras)
			} else
				pnempty = true;
			
			if (nempty && emailempty && pnempty)
				return 1; //Todos los campos están vacíos
			
			trainerModel.updateTrainer(id, name, email, phone_number, nempty, emailempty, pnempty);
			return 0; //Éxito
		}
		
		public boolean deleteTrainer (int id) {
			return trainerModel.deleteTrainer(id);
		}
		
		public JComboBox<ComboObject> getTrainerCombo () {
			JComboBox<ComboObject> matenme = new JComboBox<>();
			matenme.addItem(new ComboObject(1, "General"));
			matenme.addItem(new ComboObject(2, "Personal"));
			
			return matenme;
		}
}
