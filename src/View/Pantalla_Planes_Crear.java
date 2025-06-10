package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;

public class Pantalla_Planes_Crear {

    private Vista_GYM menu_inicio;
    private JPanel menu_user, panel, panel_negro, panel_botones;
    private JButton noti, confi, btn_crear, btn_edit, btn_deta, btn_eliminar, btn, volver;
    private JLabel text;
    
    public Pantalla_Planes_Crear(Vista_GYM log) {
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
        separador.setForeground(Color.BLACK);
        menu_user.add(separador);

        // == boton crear plan
        ImageIcon agg = new ImageIcon(getClass().getResource("/files/agregar_cb.png"));
        Image modi = agg.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(modi);

        btn_crear = new JButton("Crear plan");
        btn_crear.setIcon(icono);
        btn_crear.setBounds(300, 120, 420, 90);
        btn_crear.setFont(new Font("Arial", Font.BOLD, 32));
        btn_crear.setBorderPainted(false);
        btn_crear.setHorizontalAlignment(SwingConstants.LEFT);
        btn_crear.setIconTextGap(30);
        btn_crear.setFocusPainted(false);
        btn_crear.setOpaque(true);
        btn_crear.setBackground(Color.BLACK);
        btn_crear.setForeground(Color.WHITE);
        btn_crear.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes_Crear(menu_inicio).getPanel());
        });
        menu_user.add(btn_crear);

		// == boton editar plan
        ImageIcon edit = new ImageIcon(getClass().getResource("/files/crear.png"));
        Image modi_edit = edit.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_edit = new ImageIcon(modi_edit);

        btn_edit = new JButton("Editar plan");
        btn_edit.setIcon(icono_edit);
        btn_edit.setBounds(775, 120, 420, 90);
        btn_edit.setFont(new Font("Arial", Font.BOLD, 32));
        btn_edit.setBorderPainted(false);
        btn_edit.setHorizontalAlignment(SwingConstants.LEFT);
        btn_edit.setIconTextGap(30);
        btn_edit.setFocusPainted(false);
        btn_edit.setOpaque(true);
        btn_edit.setBackground(Color.WHITE);
        btn_edit.setForeground(Color.BLACK);
        btn_edit.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes_Editar(menu_inicio).getPanel());
        });
        menu_user.add(btn_edit);
        
		// == boton consultar registro
        ImageIcon deta = new ImageIcon(getClass().getResource("/files/buscar_usuario.png"));
        Image modi_deta = deta.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_deta = new ImageIcon(modi_deta);

        btn_deta = new JButton("Consultar plan");
        btn_deta.setIcon(icono_deta);
        btn_deta.setBounds(775, 230, 420, 90);
        btn_deta.setFont(new Font("Arial", Font.BOLD, 32));
        btn_deta.setBorderPainted(false);
        btn_deta.setHorizontalAlignment(SwingConstants.LEFT);
        btn_deta.setIconTextGap(30);
        btn_deta.setFocusPainted(false);
        btn_deta.setOpaque(true);
        btn_deta.setBackground(Color.WHITE);
        btn_deta.setForeground(Color.BLACK);
        btn_deta.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes_Consultar(menu_inicio).getPanel());
        });
        menu_user.add(btn_deta);
		
		// == boton eliminar plan
        ImageIcon eliminar = new ImageIcon(getClass().getResource("/files/basura.png"));
        Image modi_eliminar = eliminar.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_eliminar = new ImageIcon(modi_eliminar);

        btn_eliminar = new JButton("Eliminar plan");
        btn_eliminar.setIcon(icono_eliminar);
        btn_eliminar.setBounds(300, 230, 420, 90);
        btn_eliminar.setFont(new Font("Arial", Font.BOLD, 32));
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_eliminar.setIconTextGap(30);
        btn_eliminar.setFocusPainted(false);
        btn_eliminar.setOpaque(true);
        btn_eliminar.setBackground(Color.WHITE);
        btn_eliminar.setForeground(Color.BLACK);
        btn_eliminar.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes_Eliminar(menu_inicio).getPanel());
        });
        menu_user.add(btn_eliminar);
		
        // === 
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(300, 335, 900, 300);
		panel.setLayout(null);
		menu_user.add(panel);
		
		panel_negro = new JPanel();
		panel_negro.setBackground(Color.black);
		panel_negro.setBounds(0, 0, 900, 60);
		panel_negro.setLayout(null);
		panel.add(panel_negro);
		
        text = new JLabel("Propuesta de plan");
        text.setFont(new Font("Arial", Font.BOLD, 35));
        text.setForeground(Color.white);
        text.setBounds(20, 5, 500, 50);
        text.setLayout(null);
        panel_negro.add(text);
        
        // ====
        Graficos_texto sede = new Graficos_texto();
        sede.setPlaceholder(" Numero de sedes");
        sede.setBounds(30, 80, 330, 50);
        sede.setBackground(Color.lightGray);
        sede.setFont(new Font("Arial", Font.PLAIN, 18));
        sede.setBorder(null);
        panel.add(sede);
        
        Graficos_texto acceso = new Graficos_texto();
        acceso.setPlaceholder(" Clase de acceso");
        acceso.setBounds(30, 150, 330, 50);
        acceso.setBackground(Color.lightGray);
        acceso.setFont(new Font("Arial", Font.PLAIN, 18));
        acceso.setBorder(null);
        panel.add(acceso);
        
        Graficos_texto instructor = new Graficos_texto();
        instructor.setPlaceholder(" Tipo de instructor");
        instructor.setBounds(30, 220, 330, 50);
        instructor.setBackground(Color.lightGray);
        instructor.setFont(new Font("Arial", Font.PLAIN, 18));
        instructor.setBorder(null);
        panel.add(instructor);
        
        Graficos_texto promo = new Graficos_texto();
        promo.setPlaceholder(" Tipo de promociones");
        promo.setBounds(500, 80, 330, 50);
        promo.setBackground(Color.lightGray);
        promo.setFont(new Font("Arial", Font.PLAIN, 18));
        promo.setBorder(null);
        panel.add(promo);
        
        Graficos_texto invitacion = new Graficos_texto();
        invitacion.setPlaceholder(" Tarjeta de invitacion");
        invitacion.setBounds(500, 150, 330, 50);
        invitacion.setBackground(Color.lightGray);
        invitacion.setFont(new Font("Arial", Font.PLAIN, 18));
        invitacion.setBorder(null);
        panel.add(invitacion);
        
        volver = new JButton("Volver");
        volver.setBounds(500, 230, 150, 50);
        volver.setFont(new Font("Arial", Font.BOLD, 22));
        volver.setBackground(Color.GRAY);
        volver.setForeground(Color.black);
        volver.setBorderPainted(false);
        volver.setFocusPainted(false);
        volver.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Planes(menu_inicio).getPanel());
        });
        panel.add(volver);
        
        btn = new JButton("Enviar");
        btn.setBounds(680, 230, 150, 50);
        btn.setFont(new Font("Arial", Font.BOLD, 22));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        panel.add(btn);
        
		return menu_user;
	}

}