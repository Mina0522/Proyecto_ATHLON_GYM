package View;

import javax.swing.*;
import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;

public class Editar {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel, panelagg, nom, ape, fecha, nom2, ape2, fecha2;
    private JButton noti, confi, eliminar, volver;
    private JLabel text_inicio, text_, user, text_nom, text_ape, text_fecha, text_nom2, text_ape2, text_fecha2;

    public Editar(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(Color.LIGHT_GRAY);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        menu.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Usuarios");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(getPanel()));
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
        
        // ===
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(300, 130, 400, 500);
		panel.setLayout(null);
		menu.add(panel);
		
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/usuario.png"));
		user = new JLabel(icono_user);
		user.setBounds(135, 15, 128, 128);
		panel.add(user);
		
		text_inicio = new JLabel("Felipe Ramos");
		text_inicio.setFont(new Font("Arial", Font.BOLD, 40));
		text_inicio.setForeground(Color.BLACK);
		text_inicio.setBounds(75, 145, 500, 50);
		panel.add(text_inicio);
        
        text_ = new JLabel("C l i e n t e");
        text_.setFont(new Font("Arial", Font.BOLD, 20));
        text_.setForeground(Color.GRAY);
        text_.setBounds(155, 180, 500, 50);
        panel.add(text_);
        
		nom = new JPanel();
		nom.setBackground(Color.lightGray);
		nom.setBounds(50, 250, 300, 50);
		nom.setLayout(null);
		panel.add(nom);
		
        text_nom = new JLabel("Ian Karel");
        text_nom.setFont(new Font("Arial", Font.BOLD, 25));
        text_nom.setForeground(Color.black);
        text_nom.setBounds(10, 5, 500, 50);
        nom.add(text_nom);
		
		ape = new JPanel();
		ape.setBackground(Color.lightGray);
		ape.setBounds(50, 310, 300, 50);
		ape.setLayout(null);
		panel.add(ape);
		
        text_ape = new JLabel("De la Cruz Alvarado");
        text_ape.setFont(new Font("Arial", Font.BOLD, 25));
        text_ape.setForeground(Color.black);
        text_ape.setBounds(10, 5, 500, 50);
        ape.add(text_ape);
		
		fecha = new JPanel();
		fecha.setBackground(Color.lightGray);
		fecha.setBounds(50, 370, 300, 50);
		fecha.setLayout(null);
		panel.add(fecha);
		
        text_fecha = new JLabel("10 / 15 / 2005");
        text_fecha.setFont(new Font("Arial", Font.BOLD, 25));
        text_fecha.setForeground(Color.black);
        text_fecha.setBounds(10, 5, 500, 50);
        fecha.add(text_fecha);
        
		// ===
		panelagg = new JPanel();
		panelagg.setBackground(Color.WHITE);
		panelagg.setBounds(775, 130, 400, 500);
		panelagg.setLayout(null);
		menu.add(panelagg);

		nom2 = new JPanel();
		nom2.setBackground(Color.lightGray);
		nom2.setBounds(50, 30, 300, 50);
		nom2.setLayout(null);
		panelagg.add(nom2);
		
        text_nom2 = new JLabel("Basico");
        text_nom2.setFont(new Font("Arial", Font.BOLD, 25));
        text_nom2.setForeground(Color.black);
        text_nom2.setBounds(10, 5, 500, 50);
        nom2.add(text_nom2);
		
		ape2 = new JPanel();
		ape2.setBackground(Color.lightGray);
		ape2.setBounds(50, 90, 300, 50);
		ape2.setLayout(null);
		panelagg.add(ape2);
		
        text_ape2 = new JLabel("10 / 04 / 2025");
        text_ape2.setFont(new Font("Arial", Font.BOLD, 25));
        text_ape2.setForeground(Color.black);
        text_ape2.setBounds(10, 5, 500, 50);
        ape2.add(text_ape2);
		
		fecha2 = new JPanel();
		fecha2.setBackground(Color.lightGray);
		fecha2.setBounds(50, 150, 300, 50);
		fecha2.setLayout(null);
		panelagg.add(fecha2);
		
        text_fecha2 = new JLabel("6122309508");
        text_fecha2.setFont(new Font("Arial", Font.BOLD, 25));
        text_fecha2.setForeground(Color.black);
        text_fecha2.setBounds(10, 5, 500, 50);
        fecha2.add(text_fecha2);
        
        eliminar = new JButton("Confirmar cambios");
        eliminar.setBounds(50, 350, 300, 50);
        eliminar.setFont(new Font("Arial", Font.BOLD, 22));
        eliminar.setBackground(Color.BLACK);
        eliminar.setForeground(Color.WHITE);
        eliminar.setFocusPainted(false);
        panelagg.add(eliminar);
        
        volver = new JButton("Volver");
        volver.setBounds(50, 420, 300, 50);
        volver.setFont(new Font("Arial", Font.BOLD, 22));
        volver.setBackground(Color.lightGray);
        volver.setForeground(Color.black);
        volver.setFocusPainted(false);
        volver.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel());
        });
        panelagg.add(volver);
        
        return menu;
    }
}
