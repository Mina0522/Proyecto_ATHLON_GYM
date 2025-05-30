package View;

import javax.swing.*;
import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Menu;

public class Pantalla_Usuarios {

    private Vista_GYM menu_inicio;
    private JPanel         menu_user;

    private JPanel panel_botones;
    private JButton noti, confi, btn_agg, btn_eliminar, btn_deta;

    public Pantalla_Usuarios(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
        menu_user = new JPanel();
        menu_user.setLayout(null);
        menu_user.setBackground(Color.LIGHT_GRAY);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        menu_user.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Usuarios");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu_user.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel()));
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
        menu_user.add(noti);

        confi = new JButton(new ImageIcon(getClass().getResource("/files/configuracion.png")));
        confi.setBounds(1190, 20, 57, 57);
        confi.setBorderPainted(false);
        confi.setContentAreaFilled(false);
        confi.setFocusPainted(false);
        confi.setOpaque(false);
        menu_user.add(confi);
        
        // ==
        
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2); 
        menu_user.add(separador);

        // ==

		
		// === Aqui se haran los botones del panel de usuario.
//		btn_agg = new JButton("Agregar usuario  ");
//		btn_agg.setBounds(360,160, 420, 130);
//		btn_agg.setFont(new Font("Arial", Font.BOLD, 32));
//		btn_agg.setBorderPainted(false);
//		btn_agg.setHorizontalAlignment(SwingConstants.RIGHT);
//		btn_agg.setFocusPainted(false);
//		btn_agg.setOpaque(true);
//		btn_agg.setBackground(Color.white);
//		btn_agg.setForeground(Color.black);
//		btn_agg.addActionListener(e -> {
//        	menu_inicio.pintar_vista(new Pantalla_Usuarios_Agregar(menu_inicio).getPanel());
//        });
//		menu_user.add(btn_agg);
//		
//		btn_edit = new JButton("Editar usuario  ");
//		btn_edit.setBounds(840, 160, 420, 130);
//		btn_edit.setFont(new Font("Arial", Font.BOLD, 32));
//		btn_edit.setBorderPainted(false);
//		btn_edit.setHorizontalAlignment(SwingConstants.RIGHT);
//		btn_edit.setFocusPainted(false);
//		btn_edit.setOpaque(true);
//		btn_edit.setBackground(Color.white);
//		btn_edit.setForeground(Color.black);
//		btn_edit.addActionListener(e -> {
//        	menu_inicio.pintar_vista(new Pantalla_Usuarios_Editar(menu_inicio).getPanel());
//        });
//		menu_user.add(btn_edit);
//		
//		btn_detalles = new JButton("Detalles usuario  ");
//		btn_detalles.setBounds(360, 350, 420, 130);
//		btn_detalles.setFont(new Font("Arial", Font.BOLD, 32));
//		btn_detalles.setBorderPainted(false);
//		btn_detalles.setHorizontalAlignment(SwingConstants.RIGHT);
//		btn_detalles.setFocusPainted(false);
//		btn_detalles.setOpaque(true);
//		btn_detalles.setBackground(Color.white);
//		btn_detalles.setForeground(Color.black);
//		btn_detalles.addActionListener(e -> {
//        	menu_inicio.pintar_vista(new Pantalla_Usuarios_Detalles(menu_inicio).getPanel());
//        });
//		menu_user.add(btn_detalles);
//		
//		btn_eliminar= new JButton("Eliminar usuario  ");
//		btn_eliminar.setBounds(840, 350, 420, 130);
//		btn_eliminar.setFont(new Font("Arial", Font.BOLD, 32));
//		btn_eliminar.setBorderPainted(false);
//		btn_eliminar.setHorizontalAlignment(SwingConstants.RIGHT);
//		btn_eliminar.setFocusPainted(false);
//		btn_eliminar.setOpaque(true);
//		btn_eliminar.setBackground(Color.white);
//		btn_eliminar.setForeground(Color.black);
//		btn_eliminar.addActionListener(e -> {
//        	menu_inicio.pintar_vista(new Pantalla_Usuarios_Eliminar(menu_inicio).getPanel());
//        });
//		menu_user.add(btn_eliminar);
		
		return menu_user;
	}

}