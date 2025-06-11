package View;

import javax.swing.*;
import Controller.TrainerController;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.Trainer;
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

        // === Contenedor para scroll ===
        JPanel contenedor = new JPanel(null);
        contenedor.setPreferredSize(new Dimension(1030, 900));
        contenedor.setBackground(Color.decode("#D9D9D9"));

        int ancho = 290, alto = 170;
        int espacioX = 50, espacioY = 30;
        int columnas = 3;

        int contenedorAncho = 1030;

        int totalAnchura = columnas * ancho + (columnas - 1) * espacioX;
        int margenX = (contenedorAncho - totalAnchura) / 2;

        ArrayList<Trainer> entrenadores = controller.getAllTrainers();
//        System.out.println("Entrenadores encontrados: " + entrenadores.size());
//        for(Trainer t : entrenadores) {
//            System.out.println("Entrenador: " + t.getName());
//        }

        for (int i = 0; i < entrenadores.size(); i++) {
            Trainer t = entrenadores.get(i);

            int col = i % columnas;
            int fila = i / columnas;

            int posX = margenX + (col * (ancho + espacioX));
            int posY = 10 + (fila * (alto + espacioY));

            crearPanelInstructor(t, posX, posY, contenedor);
        }

        int totalFilas = (int) Math.ceil(entrenadores.size() / (double) columnas);
        int nuevaAltura = 150 + totalFilas * (alto + espacioY);

        crear_coach = new JButton("Crear instructor");
        crear_coach.setFont(new Font("Arial", Font.BOLD, 20));
        crear_coach.setBounds((1030 - 200) / 2, nuevaAltura, 200, 50);
        crear_coach.setBackground(Color.BLACK);
        crear_coach.setForeground(Color.WHITE);
        crear_coach.setFocusPainted(false);
        crear_coach.setBorderPainted(false);
        crear_coach.addActionListener(e -> {
            menu_inicio.pintar_vista(new Crear_Instructor(menu_inicio).getPanel());
        });
        contenedor.add(crear_coach);

        contenedor.setPreferredSize(new Dimension(1030, nuevaAltura + 100));

        JScrollPane scroll = new JScrollPane(contenedor);
        scroll.setBounds(250, 100, 1100, 600);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        panel_instructor.add(scroll);

        return panel_instructor;
    }

    private void crearPanelInstructor(Trainer entrenador, int x, int y, JPanel contenedor) {
        JButton coach = new JButton();
        coach.setLayout(null);
        coach.setBackground(Color.WHITE);
        coach.setBounds(x, y, 290, 170);
        coach.setBorderPainted(false);
        coach.addActionListener(e -> menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel())); // Puedes personalizar esto si quieres ver más info del entrenador

        // ==
        JPanel franja = new JPanel(null);
        franja.setBackground(Color.BLACK);
        franja.setBounds(0, 0, 290, 30);

        JLabel nombreLabel = new JLabel(entrenador.getName());
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setBounds(10, 5, 250, 20);
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        franja.add(nombreLabel);

        coach.add(franja);

        // ==
        ImageIcon icono = new ImageIcon(getClass().getResource("/files/user.png"));
        JButton btn_ver = new JButton(icono);
        btn_ver.setBounds(20, 90, 72, 72);
        btn_ver.setBorderPainted(false);
        btn_ver.setContentAreaFilled(false);
        btn_ver.setFocusPainted(false);
        btn_ver.setOpaque(false);
        btn_ver.addActionListener(e -> menu_inicio.pintar_vista(new Info_Instructor(menu_inicio).getPanel()));
        coach.add(btn_ver);

        contenedor.add(coach);
    }
}
