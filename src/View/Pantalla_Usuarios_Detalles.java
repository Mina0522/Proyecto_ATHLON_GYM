package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Funciones_graficas.Graficos_fondo;

public class Pantalla_Usuarios_Detalles {
	
	// === Creamos nuestra ventana de tipo Vista_GYM
	private Vista_GYM menu_inicio;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public JPanel menu_user;
	public Graficos_fondo panel_negro;
	public JLabel text_inicio, img_logo;
	public JButton btn_entrar, noti, confi, btn_buscar, btn_agg, btn_editar, btn_detalles, btn_eliminar;
	public Color grisClaro = new Color(217, 217, 217);
	public JTextField campo_nombre;
	
	// === Constructor de Pantalla_Inicio 
	public Pantalla_Usuarios_Detalles(Vista_GYM log) {
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
        
        // === Iconos de notificaciones y ajustes. 
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
		
		// === Aqui se haran los botones del panel de usuario.
		btn_agg = new JButton("Agregar usuario  ");
		btn_agg.setBounds(360,160, 420, 130);
		btn_agg.setFont(new Font("Arial", Font.BOLD, 32));
		btn_agg.setBorderPainted(false);
		btn_agg.setHorizontalAlignment(SwingConstants.RIGHT);
		btn_agg.setFocusPainted(false);
		btn_agg.setOpaque(true);
		btn_agg.setBackground(Color.white);
		btn_agg.setForeground(Color.black);
		btn_agg.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Usuarios_Agregar(menu_inicio).getPanel());
        });
		menu_user.add(btn_agg);
		
		btn_editar = new JButton("Editar usuario  ");
		btn_editar.setBounds(840, 160, 420, 130);
		btn_editar.setFont(new Font("Arial", Font.BOLD, 32));
		btn_editar.setBorderPainted(false);
		btn_editar.setHorizontalAlignment(SwingConstants.RIGHT);
		btn_editar.setFocusPainted(false);
		btn_editar.setOpaque(true);
		btn_editar.setBackground(Color.white);
		btn_editar.setForeground(Color.black);
		btn_editar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Usuarios_Editar(menu_inicio).getPanel());
        });
		menu_user.add(btn_editar);
		
		btn_detalles = new JButton("Detalles usuario  ");
		btn_detalles.setBounds(360, 350, 420, 130);
		btn_detalles.setFont(new Font("Arial", Font.BOLD, 32));
		btn_detalles.setBorderPainted(false);
		btn_detalles.setHorizontalAlignment(SwingConstants.RIGHT);
		btn_detalles.setFocusPainted(false);
		btn_detalles.setOpaque(true);
		btn_detalles.setBackground(Color.white);
		btn_detalles.setForeground(Color.black);
		menu_user.add(btn_detalles);
		
		btn_eliminar= new JButton("Eliminar usuario  ");
		btn_eliminar.setBounds(840, 350, 420, 130);
		btn_eliminar.setFont(new Font("Arial", Font.BOLD, 32));
		btn_eliminar.setBorderPainted(false);
		btn_eliminar.setHorizontalAlignment(SwingConstants.RIGHT);
		btn_eliminar.setFocusPainted(false);
		btn_eliminar.setOpaque(true);
		btn_eliminar.setBackground(Color.white);
		btn_eliminar.setForeground(Color.black);
		menu_user.add(btn_eliminar);
		
		// === Aqui se hara el panel de buscar.
		Color grisClaro = new Color(220, 220, 220);
	
		JPanel panelBuscar = new JPanel();
		panelBuscar.setLayout(null);
		panelBuscar.setBounds(360, 550, 885, 140);
		panelBuscar.setBackground(Color.WHITE);
		panelBuscar.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230))); 
		menu_user.add(panelBuscar);

		campo_nombre = new JTextField("Buscar usuario");
		campo_nombre.setBounds(20, 35, 680, 70);
		campo_nombre.setFont(new Font("Arial", Font.PLAIN, 18));
		campo_nombre.setBackground(grisClaro);
		panelBuscar.add(campo_nombre);

		btn_buscar = new JButton("Buscar");
		btn_buscar.setBounds(740, 35, 130, 70);
		btn_buscar.setFont(new Font("Arial", Font.BOLD, 16));
		btn_buscar.setBackground(Color.BLACK);
		btn_buscar.setForeground(Color.WHITE);
		btn_buscar.setFocusPainted(false); 
		panelBuscar.add(btn_buscar);
		
		return menu_user;
	}
}