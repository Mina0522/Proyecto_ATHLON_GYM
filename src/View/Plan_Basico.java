package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;

public class Plan_Basico {

    private Vista_GYM menu_inicio;
    private JPanel menu_user, panel_planB, panel_botones;
    private JButton noti, confi, btn_crear, btn_edit, btn_deta, btn_eliminar, volver;
    private JLabel textB1, textB2, textB3, textB4, textB5, textB6, textB, textPrecio;
    
    public Plan_Basico(Vista_GYM log) {
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

        // == boton crear plan
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
//		
        // === 
		panel_planB = new JPanel();
		panel_planB.setBackground(Color.WHITE);
		panel_planB.setBounds(300, 120, 900, 500);
		panel_planB.setLayout(null);
		menu_user.add(panel_planB);
		
        ImageIcon basic = new ImageIcon(getClass().getResource("/files/fondo_planBasico.png"));
        Image plab = basic.getImage().getScaledInstance(900, 134, Image.SCALE_SMOOTH);
        ImageIcon icono_plab = new ImageIcon(plab);

        JLabel planbasico = new JLabel(icono_plab);
        planbasico.setBounds(0, 0, 900, 134);
        planbasico.setLayout(null);
        panel_planB.add(planbasico);
        
        textB = new JLabel("Plan basico");
        textB.setFont(new Font("Arial", Font.BOLD, 40));
        textB.setForeground(Color.white);
        textB.setBounds(345, 30, 500, 50);
        textB.setLayout(null);
        planbasico.add(textB);
        
        //
        textB1 = new JLabel("I N F O R M A C I O N");
        textB1.setFont(new Font("Arial", Font.BOLD, 25));
        textB1.setForeground(Color.black);
        textB1.setBounds(330, 160, 500, 50);
        textB1.setLayout(null);
        panel_planB.add(textB1);
        
        textB2 = new JLabel("- Acceso a una sede.");
        textB2.setFont(new Font("Arial", Font.BOLD, 18));
        textB2.setForeground(Color.black);
        textB2.setBounds(30, 210, 500, 50);
        textB2.setLayout(null);
        panel_planB.add(textB2);
        
        textB3 = new JLabel("- 5 clases por mes.");
        textB3.setFont(new Font("Arial", Font.BOLD, 18));
        textB3.setForeground(Color.black);
        textB3.setBounds(30, 250, 500, 50);
        textB3.setLayout(null);
        panel_planB.add(textB3);
        
        textB4 = new JLabel("- Instructor general.");
        textB4.setFont(new Font("Arial", Font.BOLD, 18));
        textB4.setForeground(Color.black);
        textB4.setBounds(30, 290, 500, 50);
        textB4.setLayout(null);
        panel_planB.add(textB4);
        
        textB5 = new JLabel("- No promociones.");
        textB5.setFont(new Font("Arial", Font.BOLD, 18));
        textB5.setForeground(Color.black);
        textB5.setBounds(30, 330, 500, 50);
        textB5.setLayout(null);
        panel_planB.add(textB5);
        
        textB6 = new JLabel("- No tarjeta de invitacion.");
        textB6.setFont(new Font("Arial", Font.BOLD, 18));
        textB6.setForeground(Color.black);
        textB6.setBounds(30, 370, 500, 50);
        textB6.setLayout(null);
        panel_planB.add(textB6);
        
        //
        textPrecio = new JLabel("$ 350/mes");
        textPrecio.setFont(new Font("Arial", Font.BOLD, 35));
        textPrecio.setForeground(Color.black);
        textPrecio.setBounds(610, 300, 500, 50);
        textPrecio.setLayout(null);
        panel_planB.add(textPrecio);
        
        volver = new JButton("Volver");
        volver.setBounds(550, 400, 290, 50);
        volver.setFont(new Font("Arial", Font.BOLD, 22));
        volver.setBackground(Color.BLACK);
        volver.setForeground(Color.WHITE);
        volver.setFocusPainted(false);
        volver.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes(menu_inicio).getPanel());
        });
        panel_planB.add(volver);
		
		return menu_user;
	}

}