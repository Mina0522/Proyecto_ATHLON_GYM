package View;

import javax.swing.*;
import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Menu;

public class Pantalla_Inicio {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_w1, panel_w2, panel_w3;
    private JPanel panel_crearClase, panel_horario;
    private JButton noti, confi, crear;
    private JLabel miembros_activos, nuevos_registros, pagos_pendientes, horario;
    private JLabel clase1, clase2, clase3;

    public Pantalla_Inicio(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(Color.LIGHT_GRAY);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        menu.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Inicio");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Personal", e -> menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel()));
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
        menu.add(noti);

        confi = new JButton(new ImageIcon(getClass().getResource("/files/configuracion.png")));
        confi.setBounds(1190, 20, 57, 57);
        confi.setBorderPainted(false);
        confi.setContentAreaFilled(false);
        confi.setFocusPainted(false);
        confi.setOpaque(false);
        menu.add(confi);
        
        // ==
        
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2); 
        separador.setForeground(Color.BLACK);
        menu.add(separador);

        // ==
        panel_w1 = new JPanel();
        panel_w1.setBounds(290, 120, 290, 200);
        panel_w1.setBackground(Color.white);
        panel_w1.setLayout(null);
        
        miembros_activos = new JLabel("Miembros activos");
        miembros_activos.setFont(new Font("Arial", Font.BOLD, 30));
        miembros_activos.setBounds(20, 15, 280, 50);
        panel_w1.add(miembros_activos);
        
        JLabel cant1 = new JLabel("743");
        cant1.setFont(new Font("Arial", Font.BOLD, 65));
        cant1.setBounds(20, 125, 280, 50);
        panel_w1.add(cant1);
        menu.add(panel_w1);

        panel_w2 = new JPanel();
        panel_w2.setBounds(610, 120, 290, 200);
        panel_w2.setBackground(Color.white);
        panel_w2.setLayout(null);
        
        nuevos_registros = new JLabel("Nuevos registros");
        nuevos_registros.setFont(new Font("Arial", Font.BOLD, 30));
        nuevos_registros.setBounds(20, 15, 280, 50);
        panel_w2.add(nuevos_registros);
        
        JLabel cant2 = new JLabel("42");
        cant2.setFont(new Font("Arial", Font.BOLD, 65));
        cant2.setBounds(20, 125, 280, 50);
        panel_w2.add(cant2);
        menu.add(panel_w2);

        panel_w3 = new JPanel();
        panel_w3.setBounds(930, 120, 290, 200);
        panel_w3.setBackground(Color.white);
        panel_w3.setLayout(null);

        pagos_pendientes = new JLabel("Pagos pendientes");
        pagos_pendientes.setFont(new Font("Arial", Font.BOLD, 30));
        pagos_pendientes.setBounds(20, 15, 280, 50);
        panel_w3.add(pagos_pendientes);
        
        JLabel cant3 = new JLabel("12");
        cant3.setFont(new Font("Arial", Font.BOLD, 65));
        cant3.setBounds(20, 125, 280, 50);
        panel_w3.add(cant3);
        menu.add(panel_w3);

        // ===
        panel_crearClase = new Graficos_fondo("files/fondo_inicio.png");
        panel_crearClase.setLayout(null);
        panel_crearClase.setBounds(290, 340, 570, 300);
        
        crear = new JButton("Crear clase");
        crear.setBounds(30, 230, 190, 45);
        crear.setFont(new Font("Arial", Font.BOLD, 24));
        crear.setBackground(Color.white);
        crear.setForeground(Color.black);
        crear.setBorderPainted(false);
        crear.setFocusPainted(false);
        panel_crearClase.add(crear);
        menu.add(panel_crearClase);

        // ===
        panel_horario = new JPanel(null);
        panel_horario.setBackground(Color.white);
        panel_horario.setBounds(885, 340, 350, 300);
        
        horario = new JLabel("Horario");
        horario.setFont(new Font("Arial", Font.BOLD, 35));
        horario.setBounds(126, 20, 180, 50);
        panel_horario.add(horario);

        clase1 = new JLabel("     10:00 am          Yoga");
        clase1.setFont(new Font("Arial", Font.PLAIN, 28));
        clase1.setBounds(0, 80, 460, 50);
        panel_horario.add(clase1);

        clase2 = new JLabel("     11:00 am          Gym");
        clase2.setFont(new Font("Arial", Font.PLAIN, 28));
        clase2.setBounds(0, 150, 460, 50);
        panel_horario.add(clase2);

        clase3 = new JLabel("     12:00 am          Box");
        clase3.setFont(new Font("Arial", Font.PLAIN, 28));
        clase3.setBounds(0, 220, 460, 50);
        panel_horario.add(clase3);

        menu.add(panel_horario);

        return menu;
    }
}
