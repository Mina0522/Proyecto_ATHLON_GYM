package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;

public class Plan_Premium {

    private Vista_GYM menu_inicio;
    private JPanel menu_user, panel_planP, panel_botones;
    private JButton noti, confi, btn_crear, btn_edit, btn_deta, btn_eliminar, volver;
    private JLabel textP1, textP2, textP3, textP4, textP5, textP6, textP, textPrecio;
    
    public Plan_Premium(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
    	
    	Color colorGris = Color.decode("#D9D9D9");
        menu_user = new JPanel();
        menu_user.setLayout(null);
        menu_user.setBackground(colorGris);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        menu_user.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Planes");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu_user.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Personal", e -> menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Planes", e -> menu_inicio.pintar_vista(getPanel()));
        botones.configurarBotonMenu("Checador", e -> menu_inicio.pintar_vista(new Pantalla_Checador(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Salir", e -> menu_inicio.pintar_vista(new View_loginGYM(menu_inicio).getPanel()));

        // ==
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2);
        separador.setForeground(Color.BLACK);
        menu_user.add(separador);

//        // == boton crear plan
//        ImageIcon agg = new ImageIcon(getClass().getResource("/files/agregar.png"));
//        Image modi = agg.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
//        ImageIcon icono = new ImageIcon(modi);
//
//        btn_crear = new JButton("Crear plan");
//        btn_crear.setIcon(icono);
//        btn_crear.setBounds(300, 120, 420, 90);
//        btn_crear.setFont(new Font("Arial", Font.BOLD, 32));
//        btn_crear.setBorderPainted(false);
//        btn_crear.setHorizontalAlignment(SwingConstants.LEFT);
//        btn_crear.setIconTextGap(30);
//        btn_crear.setFocusPainted(false);
//        btn_crear.setOpaque(true);
//        btn_crear.setBackground(Color.WHITE);
//        btn_crear.setForeground(Color.BLACK);
//        btn_crear.addActionListener(e -> {
//            menu_inicio.pintar_vista(new Pantalla_Usuarios_Agregar(menu_inicio).getPanel());
//        });
//        menu_user.add(btn_crear);
//
//		// == boton editar plan
//        ImageIcon edit = new ImageIcon(getClass().getResource("/files/crear.png"));
//        Image modi_edit = edit.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
//        ImageIcon icono_edit = new ImageIcon(modi_edit);
//
//        btn_edit = new JButton("Editar plan");
//        btn_edit.setIcon(icono_edit);
//        btn_edit.setBounds(775, 120, 420, 90);
//        btn_edit.setFont(new Font("Arial", Font.BOLD, 32));
//        btn_edit.setBorderPainted(false);
//        btn_edit.setHorizontalAlignment(SwingConstants.LEFT);
//        btn_edit.setIconTextGap(30);
//        btn_edit.setFocusPainted(false);
//        btn_edit.setOpaque(true);
//        btn_edit.setBackground(Color.WHITE);
//        btn_edit.setForeground(Color.BLACK);
//        btn_edit.addActionListener(e -> {
//            menu_inicio.pintar_vista(new Pantalla_Usuarios_Agregar(menu_inicio).getPanel());
//        });
//        menu_user.add(btn_edit);
//        
//		// == boton consultar registro
//        ImageIcon deta = new ImageIcon(getClass().getResource("/files/buscar_usuario.png"));
//        Image modi_deta = deta.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
//        ImageIcon icono_deta = new ImageIcon(modi_deta);
//
//        btn_deta = new JButton("Consultar plan");
//        btn_deta.setIcon(icono_deta);
//        btn_deta.setBounds(775, 230, 420, 90);
//        btn_deta.setFont(new Font("Arial", Font.BOLD, 32));
//        btn_deta.setBorderPainted(false);
//        btn_deta.setHorizontalAlignment(SwingConstants.LEFT);
//        btn_deta.setIconTextGap(30);
//        btn_deta.setFocusPainted(false);
//        btn_deta.setOpaque(true);
//        btn_deta.setBackground(Color.WHITE);
//        btn_deta.setForeground(Color.BLACK);
//        btn_deta.addActionListener(e -> {
//            menu_inicio.pintar_vista(new Pantalla_Usuarios_Agregar(menu_inicio).getPanel());
//        });
//        menu_user.add(btn_deta);
//		
//		// == boton eliminar plan
//        ImageIcon eliminar = new ImageIcon(getClass().getResource("/files/basura.png"));
//        Image modi_eliminar = eliminar.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
//        ImageIcon icono_eliminar = new ImageIcon(modi_eliminar);
//
//        btn_eliminar = new JButton("Eliminar plan");
//        btn_eliminar.setIcon(icono_eliminar);
//        btn_eliminar.setBounds(300, 230, 420, 90);
//        btn_eliminar.setFont(new Font("Arial", Font.BOLD, 32));
//        btn_eliminar.setBorderPainted(false);
//        btn_eliminar.setHorizontalAlignment(SwingConstants.LEFT);
//        btn_eliminar.setIconTextGap(30);
//        btn_eliminar.setFocusPainted(false);
//        btn_eliminar.setOpaque(true);
//        btn_eliminar.setBackground(Color.WHITE);
//        btn_eliminar.setForeground(Color.BLACK);
//        btn_eliminar.addActionListener(e -> {
//            menu_inicio.pintar_vista(new Pantalla_Usuarios_Agregar(menu_inicio).getPanel());
//        });
//        menu_user.add(btn_eliminar);

        // ===
		panel_planP = new JPanel();
		panel_planP.setBackground(Color.WHITE);
		panel_planP.setBounds(300, 120, 900, 500);
		panel_planP.setLayout(null);
		menu_user.add(panel_planP);
		
        ImageIcon prem = new ImageIcon(getClass().getResource("/files/fondo_planPrem.png"));
        Image pre = prem.getImage().getScaledInstance(900, 134, Image.SCALE_SMOOTH);
        ImageIcon icono_pre = new ImageIcon(pre);

        JLabel planpre = new JLabel(icono_pre);
        planpre.setBounds(0, 0, 900, 134);
        planpre.setLayout(null);
        panel_planP.add(planpre);
        
        textP = new JLabel("Plan premium");
        textP.setFont(new Font("Arial", Font.BOLD, 40));
        textP.setForeground(Color.white);
        textP.setBounds(345, 30, 500, 50);
        textP.setLayout(null);
        planpre.add(textP);
        
        //
        textP1 = new JLabel("I N F O R M A C I O N");
        textP1.setFont(new Font("Arial", Font.BOLD, 25));
        textP1.setForeground(Color.black);
        textP1.setBounds(330, 160, 500, 50);
        textP1.setLayout(null);
        panel_planP.add(textP1);
        
        textP2 = new JLabel("- Acceso a todas las clases.");
        textP2.setFont(new Font("Arial", Font.BOLD, 18));
        textP2.setForeground(Color.black);
        textP2.setBounds(30, 210, 500, 50);
        textP2.setLayout(null);
        panel_planP.add(textP2);
        
        textP3 = new JLabel("- Clases ilimitadas.");
        textP3.setFont(new Font("Arial", Font.BOLD, 18));
        textP3.setForeground(Color.black);
        textP3.setBounds(30, 250, 500, 50);
        textP3.setLayout(null);
        panel_planP.add(textP3);
        
        textP4 = new JLabel("- Instructor personalizado.");
        textP4.setFont(new Font("Arial", Font.BOLD, 18));
        textP4.setForeground(Color.black);
        textP4.setBounds(30, 290, 500, 50);
        textP4.setLayout(null);
        panel_planP.add(textP4);
        
        textP5 = new JLabel("- Promociones en suplementos.");
        textP5.setFont(new Font("Arial", Font.BOLD, 18));
        textP5.setForeground(Color.black);
        textP5.setBounds(30, 330, 500, 50);
        textP5.setLayout(null);
        panel_planP.add(textP5);
        
        textP6 = new JLabel("- Tarjeta de invitacion para un amigo.");
        textP6.setFont(new Font("Arial", Font.BOLD, 18));
        textP6.setForeground(Color.black);
        textP6.setBounds(30, 370, 500, 50);
        textP6.setLayout(null);
        panel_planP.add(textP6);
        
        //
        textPrecio = new JLabel("$ 550/mes");
        textPrecio.setFont(new Font("Arial", Font.BOLD, 35));
        textPrecio.setForeground(Color.black);
        textPrecio.setBounds(610, 300, 500, 50);
        textPrecio.setLayout(null);
        panel_planP.add(textPrecio);
        
        volver = new JButton("Volver");
        volver.setBounds(550, 400, 290, 50);
        volver.setFont(new Font("Arial", Font.BOLD, 22));
        volver.setBackground(Color.BLACK);
        volver.setForeground(Color.WHITE);
        volver.setFocusPainted(false);
        volver.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes(menu_inicio).getPanel());
        });
        panel_planP.add(volver);
		

		return menu_user;
	}

}