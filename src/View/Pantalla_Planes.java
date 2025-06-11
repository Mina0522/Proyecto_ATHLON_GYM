package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.UserController;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.PaymentModel;
import Model.UserModel;

public class Pantalla_Planes {

    private Vista_GYM menu_inicio;
    private JPanel menu_user, panel_botones;
    private JButton noti, confi, btn_crear, btn_edit, btn_deta, btn_eliminar, plan_basico, plan_prem;
    private JLabel textP, textB;
      
    public Pantalla_Planes(Vista_GYM log) {
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
        separador.setBounds(250, 90, 1030, 2);
        separador.setForeground(Color.BLACK);
        menu_user.add(separador);

        // == boton crear plan
        ImageIcon agg = new ImageIcon(getClass().getResource("/files/agregar.png"));
        Image modi = agg.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(modi);

        btn_crear = new JButton("Crear plan");
        btn_crear.setIcon(icono);
        btn_crear.setBounds(300, 110, 420, 100);
        btn_crear.setFont(new Font("Arial", Font.BOLD, 32));
        btn_crear.setBorderPainted(false);
        btn_crear.setHorizontalAlignment(SwingConstants.LEFT);
        btn_crear.setIconTextGap(30);
        btn_crear.setFocusPainted(false);
        btn_crear.setOpaque(true);
        btn_crear.setBackground(Color.WHITE);
        btn_crear.setForeground(Color.BLACK);
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
        btn_edit.setBounds(775, 110, 420, 100);
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
        btn_deta.setBounds(775, 235, 420, 100);
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
        btn_eliminar.setBounds(300, 235, 420, 100);
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
        Graficos_fondo panel_planB = new Graficos_fondo();
		panel_planB.setBackground(Color.WHITE);
		panel_planB.setBounds(300, 355, 420, 280);
		panel_planB.setLayout(null);
		menu_user.add(panel_planB);
		panel_planB.agregarImagen("files/fondo_planBasico.png", 0, 0, 420, 132);


        textB = new JLabel("Plan basico");
        textB.setFont(new Font("Arial", Font.BOLD, 35));
        textB.setForeground(Color.black);
        textB.setHorizontalAlignment(SwingConstants.CENTER);

        textB.setBounds(0, 145, 420, 50);
        textB.setLayout(null);
        panel_planB.add(textB);
        
        plan_basico = new JButton("Detalles");
        plan_basico.setBounds(65, 210, 290, 50);
        plan_basico.setFont(new Font("Arial", Font.BOLD, 22));
        plan_basico.setBackground(Color.BLACK);
        plan_basico.setHorizontalAlignment(SwingConstants.CENTER);
        plan_basico.setForeground(Color.WHITE);
        plan_basico.setFocusPainted(false);
        plan_basico.addActionListener(e -> {
            menu_inicio.pintar_vista(new Plan_Basico(menu_inicio).getPanel());
        });
        panel_planB.add(plan_basico);
		
        // ===
        Graficos_fondo panel_planP = new Graficos_fondo();
		panel_planP.setBackground(Color.WHITE);
		panel_planP.setBounds(775, 355, 420, 280);
		panel_planP.setLayout(null);
		
		panel_planP.agregarImagen("files/fondo_planPrem.png", 0, 0, 420, 132);


		menu_user.add(panel_planP);
		
      
        
        textP = new JLabel("Plan premium");
        textP.setFont(new Font("Arial", Font.BOLD, 35));
        textP.setForeground(Color.black);
        textP.setBounds(0, 145, 420, 50);
		textP.setHorizontalAlignment(SwingConstants.CENTER);
        textP.setLayout(null);
        panel_planP.add(textP);


		plan_prem = new JButton("Detalles");
		plan_prem.setBounds(65, 210, 290, 50);
		plan_prem.setFont(new Font("Arial", Font.BOLD, 22));
		plan_prem.setBackground(Color.BLACK);
		plan_prem.setForeground(Color.WHITE);
		plan_prem.setHorizontalAlignment(SwingConstants.CENTER);
		plan_prem.setFocusPainted(false);
		plan_prem.addActionListener(e -> {
            menu_inicio.pintar_vista(new Plan_Premium(menu_inicio).getPanel());
        });
		panel_planP.add(plan_prem);

		return menu_user;
	}

}