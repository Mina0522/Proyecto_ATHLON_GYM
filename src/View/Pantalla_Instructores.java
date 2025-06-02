package View;

import javax.swing.*;
import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Menu;

public class Pantalla_Instructores {

    private Vista_GYM menu_inicio;
    private JPanel panel_instructor;

    private JPanel panel_botones, coach1, coach2, coach3, coach4, coach5, coach6, franja_negro;
    private JButton noti, confi, crear_coach, btn_ver, btn_ver1, btn_ver2,btn_ver3, btn_ver4, btn_ver5;
    private JLabel text_coach;

    public Pantalla_Instructores(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
    	panel_instructor = new JPanel();
    	panel_instructor.setLayout(null);
    	panel_instructor.setBackground(Color.LIGHT_GRAY);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        panel_instructor.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Personal");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        panel_instructor.add(panel_botones);

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
        panel_instructor.add(noti);

        confi = new JButton(new ImageIcon(getClass().getResource("/files/configuracion.png")));
        confi.setBounds(1190, 20, 57, 57);
        confi.setBorderPainted(false);
        confi.setContentAreaFilled(false);
        confi.setFocusPainted(false);
        confi.setOpaque(false);
        panel_instructor.add(confi);
        
        // ==
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2);
        separador.setForeground(Color.BLACK);
        panel_instructor.add(separador);

        // === Panel 1
        coach1 = new JPanel();
        coach1.setBackground(Color.white);
        coach1.setBounds(300, 150, 290, 170);
        coach1.setLayout(null);
        panel_instructor.add(coach1);

        franja_negro = new JPanel();
        franja_negro.setBackground(Color.black);
        franja_negro.setBounds(0, 0, 290, 30);
        coach1.add(franja_negro);
        
        text_coach = new JLabel("Ryan Garcia");
        text_coach.setForeground(Color.white);
        text_coach.setBounds(10, 5, 100, 20);
        text_coach.setFont(new Font("Arial", Font.BOLD, 20));
        franja_negro.add(text_coach);

		ImageIcon icono_noti = new ImageIcon(getClass().getResource("/files/user.png"));
		btn_ver = new JButton(icono_noti);
		btn_ver.setBounds(20, 90, 72, 72);
		btn_ver.setBorderPainted(false);
		btn_ver.setContentAreaFilled(false);
		btn_ver.setFocusPainted(false);
		btn_ver.setOpaque(false);
		btn_ver.addActionListener(e -> {
			menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel());
        });
		coach1.add(btn_ver);
        
        // === Panel 2
        coach2 = new JPanel();
        coach2.setBackground(Color.white);
        coach2.setBounds(600, 150, 290, 170);
        coach2.setLayout(null);
        panel_instructor.add(coach2);

        franja_negro = new JPanel();
        franja_negro.setBackground(Color.black);
        franja_negro.setBounds(0, 0, 290, 30);
        coach2.add(franja_negro);
        
        text_coach = new JLabel("Felipe Ramos");
        text_coach.setForeground(Color.white);
        text_coach.setBounds(10, 5, 100, 20);
        text_coach.setFont(new Font("Arial", Font.BOLD, 20));
        franja_negro.add(text_coach);

		ImageIcon icono_noti1 = new ImageIcon(getClass().getResource("/files/user.png"));
		btn_ver1 = new JButton(icono_noti1);
		btn_ver1.setBounds(20, 90, 72, 72);
		btn_ver1.setBorderPainted(false);
		btn_ver1.setContentAreaFilled(false);
		btn_ver1.setFocusPainted(false);
		btn_ver1.setOpaque(false);
		btn_ver1.addActionListener(e -> {
			menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel());
        });
		coach2.add(btn_ver1);
        
        // === Panel 3
        coach3 = new JPanel();
        coach3.setBackground(Color.white);
        coach3.setBounds(900, 150, 290, 170);
        coach3.setLayout(null);
        panel_instructor.add(coach3);

        franja_negro = new JPanel();
        franja_negro.setBackground(Color.black);
        franja_negro.setBounds(0, 0, 290, 30);
        coach3.add(franja_negro);
        
        text_coach = new JLabel("Elena Barrera");
        text_coach.setForeground(Color.white);
        text_coach.setBounds(10, 5, 100, 20);
        text_coach.setFont(new Font("Arial", Font.BOLD, 20));
        franja_negro.add(text_coach);

		ImageIcon icono_noti2 = new ImageIcon(getClass().getResource("/files/user.png"));
		btn_ver2 = new JButton(icono_noti2);
		btn_ver2.setBounds(20, 90, 72, 72);
		btn_ver2.setBorderPainted(false);
		btn_ver2.setContentAreaFilled(false);
		btn_ver2.setFocusPainted(false);
		btn_ver2.setOpaque(false);
		btn_ver2.addActionListener(e -> {
			menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel());
        });
		coach3.add(btn_ver2);
        
        // === Panel 4
        coach4 = new JPanel();
        coach4.setBackground(Color.white);
        coach4.setBounds(300, 350, 290, 170);
        coach4.setLayout(null);
        panel_instructor.add(coach4);

        franja_negro = new JPanel();
        franja_negro.setBackground(Color.black);
        franja_negro.setBounds(0, 0, 290, 30);
        coach4.add(franja_negro);
        
        text_coach = new JLabel("El pepe");
        text_coach.setForeground(Color.white);
        text_coach.setBounds(10, 5, 100, 20);
        text_coach.setFont(new Font("Arial", Font.BOLD, 20));
        franja_negro.add(text_coach);

		ImageIcon icono_noti4 = new ImageIcon(getClass().getResource("/files/user.png"));
		btn_ver3 = new JButton(icono_noti4);
		btn_ver3.setBounds(20, 90, 72, 72);
		btn_ver3.setBorderPainted(false);
		btn_ver3.setContentAreaFilled(false);
		btn_ver3.setFocusPainted(false);
		btn_ver3.setOpaque(false);
		btn_ver3.addActionListener(e -> {
			menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel());
        });
		coach4.add(btn_ver3);
        
        // === Panel 5
        coach5 = new JPanel();
        coach5.setBackground(Color.white);
        coach5.setBounds(600, 350, 290, 170);
        coach5.setLayout(null);
        panel_instructor.add(coach5);

        franja_negro = new JPanel();
        franja_negro.setBackground(Color.black);
        franja_negro.setBounds(0, 0, 290, 30);
        coach5.add(franja_negro);
        
        text_coach = new JLabel("Carlos Hernandes");
        text_coach.setForeground(Color.white);
        text_coach.setBounds(10, 5, 100, 20);
        text_coach.setFont(new Font("Arial", Font.BOLD, 20));
        franja_negro.add(text_coach);

		ImageIcon icono_noti5 = new ImageIcon(getClass().getResource("/files/user.png"));
		btn_ver4 = new JButton(icono_noti5);
		btn_ver4.setBounds(20, 90, 72, 72);
		btn_ver4.setBorderPainted(false);
		btn_ver4.setContentAreaFilled(false);
		btn_ver4.setFocusPainted(false);
		btn_ver4.setOpaque(false);
		btn_ver4.addActionListener(e -> {
			menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel());
        });
		coach5.add(btn_ver4);
        
        // === Panel 6
        coach6 = new JPanel();
        coach6.setBackground(Color.white);
        coach6.setBounds(900, 350, 290, 170);
        coach6.setLayout(null);
        panel_instructor.add(coach6);

        franja_negro = new JPanel();
        franja_negro.setBackground(Color.black);
        franja_negro.setBounds(0, 0, 290, 30);
        coach6.add(franja_negro);
        
        text_coach = new JLabel("Sarah Diaz");
        text_coach.setForeground(Color.white);
        text_coach.setBounds(10, 5, 100, 20);
        text_coach.setFont(new Font("Arial", Font.BOLD, 20));
        franja_negro.add(text_coach);

		ImageIcon icono_noti6 = new ImageIcon(getClass().getResource("/files/user.png"));
		btn_ver5 = new JButton(icono_noti6);
		btn_ver5.setBounds(20, 90, 72, 72);
		btn_ver5.setBorderPainted(false);
		btn_ver5.setContentAreaFilled(false);
		btn_ver5.setFocusPainted(false);
		btn_ver5.setOpaque(false);
		btn_ver5.addActionListener(e -> {
			menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel());
        });
		coach6.add(btn_ver5);
 
        // === 
		crear_coach = new JButton("Crear instructor");
		crear_coach.setFont(new Font("Arial", Font.BOLD, 20));
		crear_coach.setBounds(1020, 560, 200, 50); 
		crear_coach.setBackground(Color.BLACK);
		crear_coach.setForeground(Color.WHITE);
		crear_coach.setFocusPainted(false);
		crear_coach.setBorderPainted(false);
		crear_coach.addActionListener(e -> {
		    menu_inicio.pintar_vista(new Crear_Instructor(menu_inicio).getPanel());
		});
		panel_instructor.add(crear_coach);
        
		return panel_instructor;
	}

}