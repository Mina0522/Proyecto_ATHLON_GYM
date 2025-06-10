package View;

import javax.swing.*;
import Controller.TrainerController;
import java.awt.*;
import java.util.List;
import java.util.Arrays;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.TrainerModel;

public class Pantalla_Instructores {

    private Vista_GYM menu_inicio;
    private JPanel panel_instructor;
    private TrainerController controller;
    private JButton noti, confi, crear_coach;

    public Pantalla_Instructores(Vista_GYM log) {
        this.menu_inicio = log;
        
        TrainerModel modelTrainer = new TrainerModel();
        ClassModel cTrainer = new ClassModel();
        controller = new TrainerController(modelTrainer, cTrainer);
    }

    public JPanel getPanel() {
        panel_instructor = new JPanel(null);
        panel_instructor.setBackground(Color.decode("#D9D9D9"));
        panel_instructor.setSize(Toolkit.getDefaultToolkit().getScreenSize());

        // === MENU ===
        Menu botones = new Menu("Personal");
        JPanel panel_botones = botones.obtenerPanel();
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

        // === Datos de instructores (nombre y posicion x, y)
        List<String> nombres = Arrays.asList("Ryan Garcia", "Felipe Ramos", "Elena Barrera", "El pepe", "Carlos Hernandes", "Sarah Diaz");
        int[][] posiciones = {
            {300, 150}, {600, 150}, {900, 150},
            {300, 350}, {600, 350}, {900, 350}
        };

        for (int i = 0; i < nombres.size(); i++) {
            crearPanelInstructor(nombres.get(i), posiciones[i][0], posiciones[i][1]);
        }
        
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

    private void crearPanelInstructor(String nombre, int x, int y) {
        JButton coach = new JButton();
        coach.setLayout(null);
        coach.setBackground(Color.WHITE);
        coach.setBounds(x, y, 290, 170);
        coach.setBorderPainted(false);
        coach.addActionListener(e -> menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel()));

        // Franja negra con nombre
        JPanel franja = new JPanel(null);
        franja.setBackground(Color.BLACK);
        franja.setBounds(0, 0, 290, 30);

        JLabel nombreLabel = new JLabel(nombre);
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setBounds(10, 5, 250, 20);
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        franja.add(nombreLabel);

        coach.add(franja);

        // Icono usuario
        ImageIcon icono = new ImageIcon(getClass().getResource("/files/user.png"));
        JButton btn_ver = new JButton(icono);
        btn_ver.setBounds(20, 90, 72, 72);
        btn_ver.setBorderPainted(false);
        btn_ver.setContentAreaFilled(false);
        btn_ver.setFocusPainted(false);
        btn_ver.setOpaque(false);
        btn_ver.addActionListener(e -> menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel()));
        coach.add(btn_ver);

        panel_instructor.add(coach);
    }

    private void agregarIcono(String path, int x, int y) {
        JButton boton = new JButton(new ImageIcon(getClass().getResource(path)));
        boton.setBounds(x, y, 57, 57);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setOpaque(false);
        panel_instructor.add(boton);
    }
   
}
