package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.PaymentController;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;

public class Pantalla_Planes_Consultar {

    private Vista_GYM menu_inicio;
    private JPanel menu_user, panel, panel_negro, panel_botones, panel_negro1;
    private JButton noti, confi, btn_crear, btn_edit, btn_deta, btn_eliminar, btn;
    private JLabel text, text1, text2, text3, text4, text5, text_negro;
    private PaymentController controlador;
    
    public Pantalla_Planes_Consultar(Vista_GYM log) {
        this.menu_inicio = log;
        controlador= new PaymentController();
    }

    public JPanel getPanel() {
    	
    	try {
    	    UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
    	} catch (UnsupportedLookAndFeelException e1) {
    	    e1.printStackTrace();
    	}
    	
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
        ImageIcon agg = new ImageIcon(getClass().getResource("/files/agregar.png"));
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
        ImageIcon deta = new ImageIcon(getClass().getResource("/files/buscar_usuario_cb.png"));
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
        btn_deta.setBackground(Color.BLACK);
        btn_deta.setForeground(Color.WHITE);
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
		panel.setBounds(300, 365, 900, 250);
		panel.setLayout(null);
		menu_user.add(panel);
		
		JLabel text_clase = new JLabel("Consultar registros", SwingConstants.CENTER);
        text_clase.setOpaque(true);
        text_clase.setBackground(Color.BLACK);
        text_clase.setForeground(Color.WHITE);
        text_clase.setFont(new Font("Arial", Font.BOLD, 28));
        text_clase.setBounds(0, 0, 900, 50);
        panel.add(text_clase);

      
        
        DefaultTableModel modeloPagos = controlador.getPaymentsTable();

        JTable tabla2 = new JTable(modeloPagos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        tabla2.setRowHeight(45);
        tabla2.setForeground(Color.BLACK);
        tabla2.setBackground(Color.WHITE);

       
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tabla2.setDefaultRenderer(Object.class, centerRenderer);

        JScrollPane scroll2 = new JScrollPane(tabla2);
        scroll2.setBounds(0, 50, 900, 205);
        scroll2.setVisible(true);
        panel.add(scroll2);

        JTableHeader header2 = tabla2.getTableHeader();
        header2.setPreferredSize(new Dimension(scroll2.getWidth(), 35));
        header2.setFont(new Font("Arial", Font.BOLD, 24));  
        header2.setBackground(Color.BLACK);
        header2.setForeground(Color.WHITE);

     
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header2.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        
		return menu_user;
	}

}