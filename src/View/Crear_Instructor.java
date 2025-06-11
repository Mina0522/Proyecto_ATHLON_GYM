package View;

import javax.swing.*;

import Controller.TrainerController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.ComboObject;
import Model.Trainer;
import Model.TrainerModel;

public class Crear_Instructor {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_agg;
    private JButton noti, confi, crear, cancelar;
    private JLabel user, text;
    private JComboBox<ComboObject> comboTipo;


    TrainerModel modelTrainer = new TrainerModel();
    ClassModel cTrainer = new ClassModel();
    
    TrainerController controller = new TrainerController(modelTrainer, cTrainer);
    
    public Crear_Instructor(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
    	
    	Color colorGris = Color.decode("#D9D9D9");
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(colorGris);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        menu.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Personal");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Personal", e -> menu_inicio.pintar_vista(getPanel()));
        botones.configurarBotonMenu("Planes", e -> menu_inicio.pintar_vista(new Pantalla_Planes(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Checador", e -> menu_inicio.pintar_vista(new Pantalla_Checador(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Salir", e -> menu_inicio.pintar_vista(new View_loginGYM(menu_inicio).getPanel()));


        // === iconos de notificaciones
        noti = new JButton(new ImageIcon(getClass().getResource("/files/campana.png")));
        noti.setBounds(1100, 20, 57, 57);
        noti.setBorderPainted(false);
        noti.setContentAreaFilled(false);
        noti.setFocusPainted(false);
        noti.setOpaque(false);
        menu.add(noti);

        confi = new JButton(new ImageIcon(getClass().getResource("/files/configuracion.png")));
        confi.setBounds(1190, 20, 57, 57);
        confi.setBorderPainted(false);
        confi.setContentAreaFilled(false);
        confi.setFocusPainted(false);
        confi.setOpaque(false);
        menu.add(confi);
        
        // ==
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2); 
        separador.setForeground(Color.BLACK);
        menu.add(separador);
		
        // ===
		panel_agg = new JPanel();
		panel_agg.setBackground(Color.WHITE);
		panel_agg.setBounds(490, 125, 490, 510);
		panel_agg.setLayout(null);
		menu.add(panel_agg);
		
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/usuario.png"));
		user = new JLabel(icono_user);
		user.setBounds(175, 15, 128, 128);
		panel_agg.add(user);
		
		text = new JLabel("Datos personales");
		text.setFont(new Font("Arial", Font.BOLD, 20));
		text.setForeground(Color.BLACK);
		text.setBounds(50, 145, 500, 50);
		panel_agg.add(text);
		
        Graficos_texto nombre = new Graficos_texto();
        nombre.setPlaceholder(" Nombre");
        nombre.setBounds(50, 195, 390, 40);
        nombre.setBackground(Color.lightGray);
        nombre.setFont(new Font("Arial", Font.PLAIN, 18));
        nombre.setBorder(null);
        panel_agg.add(nombre);
        
        Graficos_texto correo = new Graficos_texto();
        correo.setPlaceholder(" Correo");
        correo.setBounds(50, 245, 390, 40);
        correo.setBackground(Color.lightGray);
        correo.setFont(new Font("Arial", Font.PLAIN, 18));
        correo.setBorder(null);
        panel_agg.add(correo);
        
        Graficos_texto tel = new Graficos_texto();
        tel.setPlaceholder(" Telefono");
        tel.setBounds(50, 300, 390, 40);
        tel.setBackground(Color.lightGray);
        tel.setFont(new Font("Arial", Font.PLAIN, 18));
        tel.setBorder(null);
        panel_agg.add(tel);
        
        comboTipo = new JComboBox<>();
        comboTipo.addItem(new ComboObject(1, "General"));
        comboTipo.addItem(new ComboObject(2, "Personal"));
        comboTipo.setBounds(50, 350, 390, 40);
        comboTipo.setFont(new Font("Arial", Font.PLAIN, 18));
        comboTipo.setBackground(Color.lightGray);
        panel_agg.add(comboTipo);

        crear = new JButton("Crear");
        crear.setBounds(50, 400, 390, 40);
        crear.setFont(new Font("Arial", Font.BOLD, 22));
        crear.setBackground(Color.BLACK);
        crear.setForeground(Color.WHITE);
        crear.setFocusPainted(false);
        crear.addActionListener(e -> {
            ComboObject tipoSeleccionado = (ComboObject) comboTipo.getSelectedItem();
            String nombreU = nombre.getText().trim();
            String correoU = correo.getText().trim();
            String telU = tel.getText().trim();
            int tipo = tipoSeleccionado.getId();

            int controlNum = controller.createTrainer(nombreU, correoU, telU, tipo);

            switch (controlNum) {
                case 1:
                    JOptionPane.showMessageDialog(menu, 
                    		"Rellena todos los campos.",
                    		"Datos incompletos", JOptionPane.WARNING_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(menu,
                    		"El nombre no puede contener numeros.",
                    		"Datos invalidos", JOptionPane.WARNING_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(menu,
                    		"El telefono no puede contener letras.", 
                    		"Datos invalidos", JOptionPane.WARNING_MESSAGE);
                    break;
                case -1:
                case 0:
                    JOptionPane.showMessageDialog(menu,
                    		"Ocurrio un error al registrar el instructor.", 
                    		"Error", JOptionPane.ERROR_MESSAGE);
                    break;
                default:
                    Trainer t = controller.getTrainer(controlNum);
                    if (t != null) {
                        JOptionPane.showMessageDialog(menu,
                        		"¡Instructor creado exitosamente!");
                        menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
                    } else {
                        JOptionPane.showMessageDialog(menu, 
                        		"Instructor creado, pero no se pudo recuperar su informacion.",
                        		"Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                    break;
            }
        });
        panel_agg.add(crear);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(50, 450, 390, 40);
        cancelar.setFont(new Font("Arial", Font.BOLD, 22));
        cancelar.setBackground(Color.lightGray);
        cancelar.setForeground(Color.black);
        cancelar.setFocusPainted(false);
        cancelar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
        });
        panel_agg.add(cancelar);

		return menu;
	}
}