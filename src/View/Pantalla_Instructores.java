package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Pantalla_Instructores {

	// === Creamos nuestra ventana de tipo Vista_GYM.
	private Vista_GYM instructores;
	
	public JPanel panel_instructor, panel_negro;
	public JLabel img, text_inicio, img_logo;
	public JButton btn_entrar, noti, confi;
	
	// === Constructor de View_loginGYM.
	public Pantalla_Instructores(Vista_GYM log) {
		instructores = log;
	}
	// === Metodo que construye y lo devuelve a la ventana principal.
	public JPanel getPanel() {
		
		panel_instructor = new JPanel();
		panel_instructor.setBackground(Color.lightGray);
		panel_instructor.setLayout(null);
		
		text_inicio = new JLabel("INSTRUCTORES");
		text_inicio.setFont(new Font("Arial", Font.BOLD, 32));
		text_inicio.setBounds(255, 20, 290, 50);
		panel_instructor.add(text_inicio);
		
		// === Colocamos el panel negro este sera nuestro menu con los bontones.
		panel_negro = new JPanel();
		panel_negro.setBackground(Color.BLACK);
		panel_negro.setBounds(0, 0, 200, 832);
		panel_negro.setLayout(null);
		panel_instructor.add(panel_negro);
		
		ImageIcon fondo_logo = new ImageIcon(getClass().getResource("/files/logoATHLON_cb.png"));
		img_logo = new JLabel(fondo_logo);
		img_logo.setBounds(10, 25, 170, 67);
		panel_negro.add(img_logo);
		
		// === Boton para el inicio.
        btn_entrar = new JButton("Inicio");
        btn_entrar.setBounds(5, 130, 160, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 22));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	instructores.pintar_vista(new Pantalla_Inicio(instructores).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Boton que nos llevara a la pantalla de usuarios.
        btn_entrar = new JButton("Usuarios");
        btn_entrar.setBounds(5, 200, 160, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 22));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	instructores.pintar_vista(new Pantalla_Usuarios(instructores).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Boton que nos lleva a la pantalla de instructores.
        btn_entrar = new JButton("Instructores");
        btn_entrar.setBounds(5, 270, 160, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 22));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	instructores.pintar_vista(new Pantalla_Instructores(instructores).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Boton que nos lleva a la pantalla de planes.
        btn_entrar = new JButton("Planes");
        btn_entrar.setBounds(5, 340, 160, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 22));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	instructores.pintar_vista(new Pantalla_Planes(instructores).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Boton que nos lleva a la pantalla de checado.
        btn_entrar = new JButton("Checador");
        btn_entrar.setBounds(5, 410, 160, 45);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 22));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	instructores.pintar_vista(new Pantalla_Checador(instructores).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // === Nos regresa a la pantalla de inicio de sesion.
        btn_entrar = new JButton("Cerrar sesion");
        btn_entrar.setBounds(5, 590, 150, 25);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 12));
        btn_entrar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
        	instructores.pintar_vista(new View_loginGYM(instructores).getPanel());
        });
        panel_negro.add(btn_entrar);
        
        // ========================================================================
        // === Iconoces de notificaciones y ajustes. 
		ImageIcon icono_noti = new ImageIcon(getClass().getResource("/files/campana.png"));
		noti = new JButton(icono_noti);
		noti.setBounds(1090, 20, 57, 57);
		noti.setBorderPainted(false);
		noti.setContentAreaFilled(false);
		noti.setFocusPainted(false);
		noti.setOpaque(false);
		panel_instructor.add(noti);
		
		ImageIcon icono_ajuste = new ImageIcon(getClass().getResource("/files/configuracion.png"));
		confi = new JButton(icono_ajuste);
		confi.setBounds(1170, 20, 57, 57);
		confi.setBorderPainted(false);
		confi.setContentAreaFilled(false);
		confi.setFocusPainted(false);
		confi.setOpaque(false);
		panel_instructor.add(confi);
		
		return panel_instructor;
	}
}
