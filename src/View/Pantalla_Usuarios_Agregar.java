package View;

import javax.swing.*;

import Controller.UserController;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.PaymentModel;
import Model.User;
import Model.UserModel;

public class Pantalla_Usuarios_Agregar {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_agg;
    private JButton noti, confi, crear, cancelar;
    private JLabel user, text;
    
    UserModel userModel = new UserModel() ;
	PaymentModel paymentModel  = new PaymentModel() ;
	ClassModel classModel  = new ClassModel() ;
    
    UserController controlador = new UserController(userModel,paymentModel,classModel);


    public Pantalla_Usuarios_Agregar(Vista_GYM log) {
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
        Menu botones = new Menu("Usuarios");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(getPanel()));
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
        nombre.setBackground(colorGris);
        nombre.setFont(new Font("Arial", Font.PLAIN, 18));
        nombre.setBorder(null);
        panel_agg.add(nombre);
        
        Graficos_texto apellido = new Graficos_texto();
        apellido.setPlaceholder(" Apellido");
        apellido.setBounds(50, 245, 390, 40);
        apellido.setBackground(colorGris);
        apellido.setFont(new Font("Arial", Font.PLAIN, 18));
        apellido.setBorder(null);
        panel_agg.add(apellido);
        
        Graficos_texto tel = new Graficos_texto();
        tel.setPlaceholder(" Telefono");
        tel.setBounds(50, 300, 390, 40);
        tel.setBackground(colorGris);
        tel.setFont(new Font("Arial", Font.PLAIN, 18));
        tel.setBorder(null);
        panel_agg.add(tel);
        
        Graficos_texto correo = new Graficos_texto();
        correo.setPlaceholder(" Correo");
        correo.setBounds(50, 350, 390, 40);
        correo.setBackground(colorGris);
        correo.setFont(new Font("Arial", Font.PLAIN, 18));
        correo.setBorder(null);
        panel_agg.add(correo);
        
        crear = new JButton("Crear");
        crear.setBounds(50, 400, 390, 40);
        crear.setFont(new Font("Arial", Font.BOLD, 22));
        crear.setBackground(Color.BLACK);
        crear.setForeground(Color.WHITE);
        crear.setBorderPainted(false);
        crear.setFocusPainted(false);
        panel_agg.add(crear);
        crear.addActionListener(e -> {
    	    String nomU  = nombre.getText();
    	    String apeU  = apellido.getText();
    	    String telU  = tel.getText();
    	    String corrU = correo.getText(); 

    	    int controlNum = controlador.createUser(nomU, apeU, telU,corrU);

    	    switch (controlNum) {
    	        case 0:
    	            JOptionPane.showMessageDialog(menu,
    	                "Ocurrió un error al acceder a la base de datos.",
    	                "Error", JOptionPane.ERROR_MESSAGE);
    	            break;
    	        case 1:
    	            JOptionPane.showMessageDialog(menu,
    	                "Rellena todos los campos.",
    	                "Datos incompletos", JOptionPane.WARNING_MESSAGE);
    	            break;
    	        case 2:
    	            JOptionPane.showMessageDialog(menu,
    	                "El nombre y apellido no pueden contener números.",
    	                "Datos inválidos", JOptionPane.WARNING_MESSAGE);
    	            break;
    	        case 3:
    	            JOptionPane.showMessageDialog(menu,
    	                "El teléfono no puede contener letras.",
    	                "Datos inválidos", JOptionPane.WARNING_MESSAGE);
    	            break;
    	        default:
    	            User user = controlador.getUser(controlNum);
    	            if (user != null) {
    	                menu_inicio.pintar_vista(new Detalles(menu_inicio, user).getPanel());
    	            } else {
    	                JOptionPane.showMessageDialog(menu,
    	                    "No se pudo recuperar al usuario recién creado.",
    	                    "Error", JOptionPane.ERROR_MESSAGE);
    	            }
    	            break;
    	    }
    	});
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(50, 450, 390, 40);
        cancelar.setFont(new Font("Arial", Font.BOLD, 22));
        cancelar.setBackground(Color.GRAY);
        cancelar.setForeground(Color.black);
        cancelar.setBorderPainted(false);
        cancelar.setFocusPainted(false);
        cancelar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel());
        });
        panel_agg.add(cancelar);
        
        

		return menu;
	}
}