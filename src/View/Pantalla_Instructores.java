package View;

import javax.swing.*;
import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Menu;

public class Pantalla_Instructores {

    private Vista_GYM menu_inicio;
    private JPanel panel_instructor;

    private JPanel panel_botones, coach1, coach2, coach3, coach4, coach5, coach6, franja_negro;
    private JButton noti, confi, crear_coach;
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

        ImageIcon icono_1 = new ImageIcon(getClass().getResource("/files/user.png"));
        Image entrenador1 = icono_1.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon icono_coach1 = new ImageIcon(entrenador1);

        JLabel img1 = new JLabel(icono_coach1);
        img1.setBounds(20, 80, 72, 72);
        coach1.add(img1);
        
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

        ImageIcon icono_2 = new ImageIcon(getClass().getResource("/files/user.png"));
        Image entrenador2 = icono_2.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon icono_coach2 = new ImageIcon(entrenador2);

        JLabel img2 = new JLabel(icono_coach2);
        img2.setBounds(20, 80, 72, 72);
        coach2.add(img2);
        
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

        ImageIcon icono_3 = new ImageIcon(getClass().getResource("/files/user.png"));
        Image entrenador3 = icono_3.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon icono_coach3 = new ImageIcon(entrenador3);

        JLabel img3 = new JLabel(icono_coach3);
        img3.setBounds(20, 80, 72, 72);
        coach3.add(img3);
        
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

        ImageIcon icono_4 = new ImageIcon(getClass().getResource("/files/user.png"));
        Image entrenador4 = icono_4.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon icono_coach4 = new ImageIcon(entrenador4);

        JLabel img4 = new JLabel(icono_coach4);
        img4.setBounds(20, 80, 72, 72);
        coach4.add(img4);
        
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

        ImageIcon icono_5 = new ImageIcon(getClass().getResource("/files/user.png"));
        Image entrenador5 = icono_5.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon icono_coach5 = new ImageIcon(entrenador5);

        JLabel img5 = new JLabel(icono_coach5);
        img5.setBounds(20, 80, 72, 72);
        coach5.add(img5);
        
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

        ImageIcon icono_6 = new ImageIcon(getClass().getResource("/files/user.png"));
        Image entrenador6 = icono_6.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
        ImageIcon icono_coach6 = new ImageIcon(entrenador6);

        JLabel img6 = new JLabel(icono_coach6);
        img6.setBounds(20, 80, 72, 72);
        coach6.add(img6);
 
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