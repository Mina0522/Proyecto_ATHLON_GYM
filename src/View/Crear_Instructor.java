package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Funciones_graficas.Graficos_fondo;

public class Crear_Instructor {
	private Vista_GYM menu_inicio;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public JPanel panel_instructor;
	public Graficos_fondo panel_negro;
	public JLabel text_crear_instructor, img_logo,text_inicio;
	public JButton btn_entrar, noti, confi, btn_crear, btn_cancelar, crear;
	public Color grisClaro = new Color(217, 217, 217);
	public JTextField campo_nombre, campo_correo, campo_tel, campo_espe;

	
	// === Constructor de Pantalla_Inicio 
	public Crear_Instructor(Vista_GYM log) {
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
		
		text_crear_instructor = new JLabel("Crear Instructor");
		text_crear_instructor.setFont(new Font("Arial", Font.BOLD, 32));
		text_crear_instructor.setBounds(255, 100, 290, 50);
		panel_instructor.add(text_crear_instructor);	
		
		JPanel panel_formulario = new JPanel();
		panel_formulario.setLayout(null);
		panel_formulario.setBackground(Color.WHITE);
		panel_formulario.setBounds(450, 150, 400, 500); 

		JLabel iconoUsuario = new JLabel();
		iconoUsuario.setIcon(new ImageIcon(getClass().getResource("/files/usuario.png"))); 
		iconoUsuario.setBounds(170, 20, 64, 64);
		panel_formulario.add(iconoUsuario);

		JLabel titulo = new JLabel("Datos personales");
		titulo.setFont(new Font("Arial", Font.BOLD, 18));
		titulo.setBounds(130, 100, 200, 30);
		panel_formulario.add(titulo);

		campo_nombre = new JTextField();
		campo_nombre.setBounds(50, 150, 300, 35);
		campo_nombre.setFont(new Font("Arial", Font.PLAIN, 16));
		campo_nombre.setBackground(new Color(220, 220, 220));
		campo_nombre.setBorder(null);
		panel_formulario.add(campo_nombre);

		campo_correo = new JTextField();
		campo_correo.setBounds(50, 200, 300, 35);
		campo_correo.setFont(new Font("Arial", Font.PLAIN, 16));
		campo_correo.setBackground(new Color(220, 220, 220));
		campo_correo.setBorder(null);
		panel_formulario.add(campo_correo);

		campo_tel = new JTextField();
		campo_tel.setBounds(50, 250, 300, 35);
		campo_tel.setFont(new Font("Arial", Font.PLAIN, 16));
		campo_tel.setBackground(new Color(220, 220, 220));
		campo_tel.setBorder(null);
		panel_formulario.add(campo_tel);
		
		// === Campo Especialidad
		campo_espe = new JTextField();
		campo_espe.setBounds(50, 300, 300, 35);
		campo_espe.setFont(new Font("Arial", Font.PLAIN, 16));
		campo_espe.setBackground(new Color(220, 220, 220));
		campo_espe.setBorder(null);
		panel_formulario.add(campo_espe);

		// === Botón Crear
		btn_crear = new JButton("Crear");
		btn_crear.setFont(new Font("Arial", Font.BOLD, 18));
		btn_crear.setBounds(50, 360, 300, 35);
		btn_crear.setBackground(Color.BLACK);
		btn_crear.setForeground(Color.WHITE);
		btn_crear.setBorderPainted(false);
		panel_formulario.add(btn_crear);

		// === 
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setFont(new Font("Arial", Font.BOLD, 18));
		btn_cancelar.setBounds(50, 410, 300, 35);
		btn_cancelar.setBackground(new Color(180, 180, 180));
		btn_cancelar.setForeground(Color.BLACK);
		btn_cancelar.setBorderPainted(false);
		btn_cancelar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
        });
		panel_formulario.add(btn_cancelar);
		panel_instructor.add(panel_formulario);

		// === Colocamos el panel negro este sera nuestro menu con los bontones.
		panel_negro = new Graficos_fondo();
		panel_negro.setBackground(Color.BLACK);
		panel_negro.setBounds(0, 0, 250, screenSize.height);
		panel_negro.setLayout(null);
		panel_negro.agregarImagen("Files/logoATHLON_cb.png", 25, 40, 180, 75);
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