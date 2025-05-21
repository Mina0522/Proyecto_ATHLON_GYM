package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Funciones_graficas.Graficos_fondo;

public class Pantalla_Inicio {

	// === Creamos nuestra ventana de tipo Vista_GYM
	private Vista_GYM menu_inicio;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public JPanel menu, panel_horario;
	public Graficos_fondo panel_negro,panel_clase;
	public JLabel text_inicio, img_logo, txt_horario;
	public JButton btn_entrar, noti, confi;
	public Color grisClaro = new Color(217, 217, 217);
	
	// === Constructor de Pantalla_Inicio 
	public Pantalla_Inicio(Vista_GYM log) {
		menu_inicio = log;
	}
	
	public JPanel getPanel() {
		
		menu = new JPanel();
		menu.setBackground(grisClaro);
		menu.setLayout(null);
		
		text_inicio = new JLabel("INICIO");
		text_inicio.setFont(new Font("Arial", Font.BOLD, 32));
		text_inicio.setBounds(255, 20, 290, 50);
		menu.add(text_inicio);
		
		// === Colocamos el panel negro este sera nuestro menu con los bontones.
		panel_negro = new Graficos_fondo();
		panel_negro.setBackground(Color.BLACK);
		panel_negro.setBounds(0, 0, 250, screenSize.height);
		panel_negro.setLayout(null);
		panel_negro.agregarImagen("files/logoATHLON_cb.png", 25, 40, 180, 75);
		menu.add(panel_negro);
		
		
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
        	menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel());
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
		menu.add(noti);
		
		ImageIcon icono_ajuste = new ImageIcon(getClass().getResource("/files/configuracion.png"));
		confi = new JButton(icono_ajuste);
		confi.setBounds(1200, 20, 57, 57);
		confi.setBorderPainted(false);
		confi.setContentAreaFilled(false);
		confi.setFocusPainted(false);
		confi.setOpaque(false);
		menu.add(confi);

		// === Aqui se crea el panel con la imagen y boton de crear clase.
		panel_clase = new Graficos_fondo("files/fondo_inicio.png");
		panel_clase.setBounds(305, 380, 570, 300);
		panel_clase.setLayout(null);
		menu.add(panel_clase);
		
		btn_entrar = new JButton("Crear clase");
        btn_entrar.setBounds(30, 230, 190, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 24));
        btn_entrar.setBackground(Color.white);
        btn_entrar.setForeground(Color.black);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        panel_clase.add(btn_entrar);
        
        // === Aqui se crea el panel del horario y se ponen labels con la hora y clase.
        panel_horario = new JPanel();
        panel_horario.setLayout(null);
        panel_horario.setBackground(Color.white);
        panel_horario.setOpaque(true);
        panel_horario.setBounds(905, 380, 400,300);
        menu.add(panel_horario);
        
        txt_horario = new JLabel("Horario");
        txt_horario.setFont(new Font("Arial", Font.BOLD, 35));
        txt_horario.setBounds(126, 20, 180, 50);
		panel_horario.add(txt_horario);
		
		JLabel txt_clase_1 = new JLabel("       10:00 am            Yoga ");
		txt_clase_1.setFont(new Font("Arial", Font.PLAIN, 28));
		txt_clase_1.setBounds(0, 80, 460, 50);
		panel_horario.add(txt_clase_1);
		
		JLabel txt_clase_2 = new JLabel("       11:00 am            Gym ");
		txt_clase_2.setFont(new Font("Arial", Font.PLAIN, 28));
		txt_clase_2.setBounds(0, 150, 460, 50);
		panel_horario.add(txt_clase_2);
		
		JLabel txt_clase_3 = new JLabel("       12:00 am             Box ");
		txt_clase_3.setFont(new Font("Arial", Font.PLAIN, 28));
		txt_clase_3.setBounds(0, 220, 460, 50);
		panel_horario.add(txt_clase_3);
		
		// === Aqui se crea los paneles de los widgets y se ponen labels.
		JPanel panel_widget_1 = new JPanel();
		panel_widget_1.setLayout(null);
		panel_widget_1.setBackground(Color.white);
		panel_widget_1.setOpaque(true);
		panel_widget_1.setBounds(305, 130, 300,220);
        menu.add(panel_widget_1);
        
        JLabel txt_widget_1 = new JLabel("Miembros activos");
        txt_widget_1.setFont(new Font("Arial", Font.BOLD, 30));
        txt_widget_1.setHorizontalAlignment(SwingConstants.LEFT);
        txt_widget_1.setBounds(20, 25, 280, 50);
        panel_widget_1.add(txt_widget_1);
        
        JLabel num_widget_1 = new JLabel("712");
        num_widget_1.setFont(new Font("Arial", Font.BOLD, 65));
        num_widget_1.setHorizontalAlignment(SwingConstants.LEFT);
        num_widget_1.setBounds(20, 125, 280, 50);
        panel_widget_1.add(num_widget_1);
        
        // ===
        
        JPanel panel_widget_2 = new JPanel();
        panel_widget_2.setLayout(null);
        panel_widget_2.setBackground(Color.white);
        panel_widget_2.setOpaque(true);
        panel_widget_2.setBounds(640, 130,300,220);
        menu.add(panel_widget_2);
        
        JLabel txt_widget_2 = new JLabel("Nuevos registros");
        txt_widget_2.setFont(new Font("Arial", Font.BOLD, 30));
        txt_widget_2.setHorizontalAlignment(SwingConstants.LEFT);
        txt_widget_2.setBounds(20, 25, 280, 50);
        panel_widget_2.add(txt_widget_2);
        
        JLabel num_widget_2 = new JLabel("102");
        num_widget_2.setFont(new Font("Arial", Font.BOLD, 65));
        num_widget_2.setHorizontalAlignment(SwingConstants.LEFT);
        num_widget_2.setBounds(20, 125, 280, 50);
        panel_widget_2.add(num_widget_2);
        
        // ===
        
        JPanel panel_widget_3 = new JPanel();
        panel_widget_3.setLayout(null);
        panel_widget_3.setBackground(Color.white);
        panel_widget_3.setOpaque(true);
        panel_widget_3.setBounds(970, 130,300,220);
        menu.add(panel_widget_3);
        
        JLabel txt_widget_3 = new JLabel("Pagos pendientes");
        txt_widget_3.setFont(new Font("Arial", Font.BOLD, 30));
        txt_widget_3.setHorizontalAlignment(SwingConstants.LEFT);
        txt_widget_3.setBounds(20, 25, 280, 50);
        panel_widget_3.add(txt_widget_3);
        
        JLabel num_widget_3 = new JLabel("12");
        num_widget_3.setFont(new Font("Arial", Font.BOLD, 65));
        num_widget_3.setHorizontalAlignment(SwingConstants.LEFT);
        num_widget_3.setBounds(20, 125, 280, 50);
        panel_widget_3.add(num_widget_3);
		
		return menu;
	}

}