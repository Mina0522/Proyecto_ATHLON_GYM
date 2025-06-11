
package View;

import javax.swing.*;

import Controller.ClassController;
import Controller.TrainerController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.TrainerModel;

public class Crear_Clase {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_agg;
    private JButton noti, confi, crear_clase, cancelar;
    private JLabel user, text;
    private TrainerController controlador;
    TrainerModel trainerModel;
	ClassModel classModel;
	
	private ClassController controlador2;


    public Crear_Clase(Vista_GYM log) {
        this.menu_inicio = log;
        trainerModel = new TrainerModel();
        classModel = new ClassModel();
        controlador = new TrainerController(trainerModel,classModel);
        
        controlador2 = new ClassController();
    }

    public JPanel getPanel() {
    	
    	Color colorGris = Color.decode("#D9D9D9");
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(colorGris);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        menu.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Inicio");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Personal", e -> menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Planes", e -> menu_inicio.pintar_vista(new Pantalla_Planes(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Checador", e -> menu_inicio.pintar_vista(new Pantalla_Checador(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Salir", e -> menu_inicio.pintar_vista(new View_loginGYM(menu_inicio).getPanel()));

        // ==
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2); 
        separador.setForeground(Color.BLACK);
        menu.add(separador);
		
        // ===
		panel_agg = new JPanel();
		panel_agg.setBackground(Color.WHITE);
		panel_agg.setBounds(300, 125, 900, 510);
		panel_agg.setLayout(null);
		menu.add(panel_agg);
		
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/clase.png"));
		user = new JLabel(icono_user);
		user.setBounds(375, 15, 128, 128);
		panel_agg.add(user);
		
		text = new JLabel("Crear clase");
		text.setFont(new Font("Arial", Font.BOLD, 30));
		text.setForeground(Color.BLACK);
		text.setBounds(370, 140, 500, 50);
		panel_agg.add(text);
		
        Graficos_texto nombre = new Graficos_texto();
        nombre.setPlaceholder(" Nombre de clase");
        nombre.setBounds(225, 200, 415, 40);
        nombre.setBackground(Color.lightGray);
        nombre.setFont(new Font("Arial", Font.PLAIN, 18));
        nombre.setBorder(null);
        panel_agg.add(nombre);
        
        Graficos_texto hora = new Graficos_texto();
        hora.setPlaceholder(" Horario");
        hora.setBounds(225, 260, 415, 40);
        hora.setBackground(Color.lightGray);
        hora.setFont(new Font("Arial", Font.PLAIN, 18));
        hora.setBorder(null);
        panel_agg.add(hora);
        
        Graficos_texto max = new Graficos_texto();
        max.setPlaceholder(" Capacidad maxima de usuarios");
        max.setBounds(225, 320, 415, 40);
        max.setBackground(Color.lightGray);
        max.setFont(new Font("Arial", Font.PLAIN, 18));
        max.setBorder(null);
        panel_agg.add(max);
        
        Graficos_texto nom = new Graficos_texto();
        nom.setPlaceholder(" Nombre del instructor");
        nom.setBounds(225, 380, 415, 40);
        nom.setBackground(Color.lightGray);
        nom.setFont(new Font("Arial", Font.PLAIN, 18));
        nom.setBorder(null);
        panel_agg.add(nom);
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(30, 450, 330, 40);
        cancelar.setFont(new Font("Arial", Font.BOLD, 22));
        cancelar.setBackground(Color.lightGray);
        cancelar.setForeground(Color.black);
        cancelar.setFocusPainted(false);
        cancelar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel());
        });
        panel_agg.add(cancelar);
        
        crear_clase = new JButton("Crear clase");
        crear_clase.setBounds(520, 450, 330, 40);
        crear_clase.setFont(new Font("Arial", Font.BOLD, 22));
        crear_clase.setBackground(Color.BLACK);
        crear_clase.setForeground(Color.WHITE);
        crear_clase.setFocusPainted(false);
        crear_clase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String campo1 = nombre.getText().trim(); 
                String campo2 = hora.getText().trim();  
                String campo3 = max.getText().trim();    
                String campo4 = nom.getText().trim();   

                if (campo1.isEmpty() || campo2.isEmpty() || campo3.isEmpty() || campo4.isEmpty()) {
                    JOptionPane.showMessageDialog(menu,
                            "Rellena todos los campos.",
                            "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    int id_instructor = controlador.getTrainerIdByName(campo4);
                    int id_class_type = controlador2.getClassTypeIdByName((campo1));     
                    LocalDate fecha = LocalDate.now(); 

                    controlador2.createClass(id_instructor, id_class_type, fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());

                    JOptionPane.showMessageDialog(menu,
                            "Clase guardada correctamente!",
                            "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(menu,
                            "Capacidad debe ser un número.",
                            "Error de formato", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(menu,
                            "Error al guardar la clase: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel_agg.add(crear_clase);
 
		return menu;
	}
}