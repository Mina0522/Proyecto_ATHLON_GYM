package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Funciones_graficas.Graficos_fondo;

public class Pantalla_Instructores {

	// === Creamos nuestra ventana de tipo Vista_GYM
	private Vista_GYM menu_inicio;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public JPanel panel_instructor;
	public Graficos_fondo panel_negro;
	public JLabel text_inicio, img_logo;
	public JButton btn_entrar, noti, confi, btn_crear;
	public Color grisClaro = new Color(217, 217, 217);
	
	// === Constructor de Pantalla_Inicio 
	public Pantalla_Instructores(Vista_GYM log) {
		menu_inicio = log;
	}
	
	public JPanel getPanel() {
		
		panel_instructor = new JPanel();
		panel_instructor.setBackground(grisClaro);
		panel_instructor.setLayout(null);
		
		text_inicio = new JLabel("INSTRUCTORES");
		text_inicio.setFont(new Font("Arial", Font.BOLD, 32));
		text_inicio.setBounds(255, 20, 290, 50);
		panel_instructor.add(text_inicio);
		
		// === Panel contenedor.
		JPanel panel_contenedor = new JPanel();
		panel_contenedor.setBackground(grisClaro);
		panel_contenedor.setBounds(270, 100, 950, 300);
		panel_contenedor.setLayout(new GridLayout(2, 3, 40, 30)); 

		// === Datos de los instructores.
		String[] nombres = {
		    "Ryan Garcia", "Felipe Ramos", "Elen Barrera",
		    "El Pepe", "Carlos Hernández", "Sarah Diaz"
		};

		// === Crear cada tarjeta y añadirla al panel contenedor.
		for (String nombre_instructor : nombres) {
		    JPanel tarjeta = new JPanel();
		    tarjeta.setLayout(null);
		    tarjeta.setBackground(Color.WHITE);

		    JPanel linea = new JPanel();
		    linea.setBackground(Color.BLACK);
		    linea.setBounds(0, 0, 300, 50);
		    tarjeta.add(linea);

		    // === Centrar nombre.
		    JLabel nombre = new JLabel(nombre_instructor);
		    nombre.setFont(new Font("Arial", Font.BOLD, 24));
		    nombre.setForeground(Color.white);
		    nombre.setBounds(0, 25, 200, 30);
		    linea.add(nombre);

		    panel_contenedor.add(tarjeta);
		}
		panel_instructor.add(panel_contenedor);
		
		// === 
		btn_crear = new JButton("Crear instructor");
		btn_crear.setFont(new Font("Arial", Font.BOLD, 18));
		btn_crear.setBounds(1050, 650, 200, 40); 
		btn_crear.setBackground(Color.BLACK);
		btn_crear.setForeground(Color.WHITE);
		btn_crear.setFocusPainted(false);
		btn_crear.setBorderPainted(false);
		btn_crear.addActionListener(e -> {
		    menu_inicio.pintar_vista(new Crear_Instructor(menu_inicio).getPanel());
		});
		panel_instructor.add(btn_crear);
		
		// === Colocamos el panel negro este sera nuestro menu con los bontones.
		panel_negro = new Graficos_fondo();
		panel_negro.setBackground(Color.BLACK);
		panel_negro.setBounds(0, 0, 250, screenSize.height);
		panel_negro.setLayout(null);
		panel_negro.agregarImagen("files/logoATHLON_cb.png", 25, 40, 180, 75);
		panel_instructor.add(panel_negro);
		
		// === Boton para el inicio.
        btn_entrar = new JButton("Inicio");
        btn_entrar.setBounds(10, 190, 225, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 33));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Boton que nos llevara a la pantalla de usuarios.
        btn_entrar = new JButton("Usuarios");
        btn_entrar.setBounds(10, 260, 225, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 33));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Boton que nos lleva a la pantalla de instructores.
        btn_entrar = new JButton("Instructores");
        btn_entrar.setBounds(10, 330, 225, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 33));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Boton que nos lleva a la pantalla de planes.
        btn_entrar = new JButton("Planes");
        btn_entrar.setBounds(10, 400, 225, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 33));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Planes(menu_inicio).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Boton que nos lleva a la pantalla de checado.
        btn_entrar = new JButton("Checador");
        btn_entrar.setBounds(10, 470, 225, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 33));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Checador(menu_inicio).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Nos regresa a la pantalla de inicio de sesion.
        btn_entrar = new JButton("Cerrar sesion");
        btn_entrar.setBounds(10, 650, 220, 25);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 25));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new View_loginGYM(menu_inicio).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // ========================================================================
        
        // === Iconos de notificaciones y ajustes. 
		ImageIcon icono_noti = new ImageIcon(getClass().getResource("/files/campana.png"));
		noti = new JButton(icono_noti);
		noti.setBounds(1100, 20, 57, 57);
		noti.setBorderPainted(false);
		noti.setContentAreaFilled(false);
		noti.setFocusPainted(false);
		noti.setOpaque(false);
		panel_instructor.add(noti);
		
		ImageIcon icono_ajuste = new ImageIcon(getClass().getResource("/files/configuracion.png"));
		confi = new JButton(icono_ajuste);
		confi.setBounds(1200, 20, 57, 57);
		confi.setBorderPainted(false);
		confi.setContentAreaFilled(false);
		confi.setFocusPainted(false);
		confi.setOpaque(false);
		panel_instructor.add(confi);
		
		return panel_instructor;
	}

}