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

public class Pantalla_Usuarios_Agregar {
	
	// === Creamos nuestra ventana de tipo Vista_GYM
	private Vista_GYM menu_inicio;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public JPanel menu_user;
	public Graficos_fondo panel_negro;
	public JLabel text_inicio, img_logo;
	public JButton btn_entrar, noti, confi, btn_crear, btn_cancelar;
	public Color grisClaro = new Color(217, 217, 217);
	public JTextField campo_nombre, campo_correo, campo_tel, campo_espe;
	
	// === Constructor de Pantalla_Inicio 
	public Pantalla_Usuarios_Agregar(Vista_GYM log) {
		menu_inicio = log;
	}
	
	public JPanel getPanel() {
		
		menu_user = new JPanel();
		menu_user.setBackground(grisClaro);
		menu_user.setLayout(null);
		
		text_inicio = new JLabel("USUARIOS");
		text_inicio.setFont(new Font("Arial", Font.BOLD, 32));
		text_inicio.setBounds(255, 20, 290, 50);
		menu_user.add(text_inicio);
		
		// === Colocamos el panel negro este sera nuestro menu con los bontones.
		panel_negro = new Graficos_fondo();
		panel_negro.setBackground(Color.BLACK);
		panel_negro.setBounds(0, 0, 250, screenSize.height);
		panel_negro.setLayout(null);
		panel_negro.agregarImagen("files/logoATHLON_cb.png", 25, 40, 180, 75);
		menu_user.add(panel_negro);
		
		
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
        	menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel());
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
        
        // === Iconoces de notificaciones y ajustes. 
		ImageIcon icono_noti = new ImageIcon(getClass().getResource("/files/campana.png"));
		noti = new JButton(icono_noti);
		noti.setBounds(1100, 20, 57, 57);
		noti.setBorderPainted(false);
		noti.setContentAreaFilled(false);
		noti.setFocusPainted(false);
		noti.setOpaque(false);
		menu_user.add(noti);
		
		ImageIcon icono_ajuste = new ImageIcon(getClass().getResource("/files/configuracion.png"));
		confi = new JButton(icono_ajuste);
		confi.setBounds(1200, 20, 57, 57);
		confi.setBorderPainted(false);
		confi.setContentAreaFilled(false);
		confi.setFocusPainted(false);
		confi.setOpaque(false);
		menu_user.add(confi);
		
		// === Aquí se hará el panel de agregar usuario y sus textFields
		Graficos_fondo panel_Agregar = new Graficos_fondo();
		panel_Agregar.setLayout(null);
		panel_Agregar.setBounds(550, 120, 600, 620);
		menu_user.add(panel_Agregar);

		JLabel titulo = new JLabel("Datos personales");
		titulo.setFont(new Font("Arial", Font.BOLD, 28));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(30, 30, 540, 30); 
		panel_Agregar.add(titulo);

		campo_nombre = new JTextField("Nombre");
		campo_nombre.setBounds(30, 100, 540, 40);
		campo_nombre.setFont(new Font("Arial", Font.PLAIN, 18));
		campo_nombre.setBackground(grisClaro);
		campo_nombre.setBorder(null);
		panel_Agregar.add(campo_nombre);

		campo_correo = new JTextField("Correo");
		campo_nombre.setBounds(30, 180, 540, 40);
		campo_nombre.setFont(new Font("Arial", Font.PLAIN, 18));
		campo_nombre.setBackground(grisClaro);
		campo_nombre.setBorder(null);
		panel_Agregar.add(campo_nombre);

		campo_tel = new JTextField("Telefono");
		campo_tel.setBounds(30, 260, 540, 40); 
		campo_tel.setFont(new Font("Arial", Font.PLAIN, 18));
		campo_tel.setBackground(grisClaro);
		campo_tel.setBorder(null);
		panel_Agregar.add(campo_tel);

		campo_espe = new JTextField("Especialidad");
		campo_espe.setBounds(30, 340, 540, 40); 
		campo_espe.setFont(new Font("Arial", Font.PLAIN, 18));
		campo_espe.setBackground(grisClaro);
		campo_espe.setBorder(null);
		panel_Agregar.add(campo_espe);

		btn_crear = new JButton("Crear");
		btn_crear.setBounds(30, 420, 540, 40); 
		btn_crear.setFont(new Font("Arial", Font.BOLD, 20));
		btn_crear.setBackground(Color.BLACK);
		btn_crear.setForeground(Color.WHITE);
		panel_Agregar.add(btn_crear);

		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(30, 500, 540, 40); 
		btn_cancelar.setFont(new Font("Arial", Font.BOLD, 20));
		btn_cancelar.setBackground(Color.GRAY);
		btn_cancelar.setForeground(Color.BLACK);
		panel_Agregar.add(btn_cancelar);

		return menu_user;
	}
}