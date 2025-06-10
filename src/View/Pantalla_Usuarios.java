package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.UserController;

import java.awt.*;

import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.PaymentModel;
import Model.User;
import Model.UserModel;
import Model.ClassModel;

public class Pantalla_Usuarios {

    private Vista_GYM menu_inicio;
    private JPanel menu_user, panel_tabla, panel_botones;
    private JButton noti, confi, btn_agg, btn_eliminar, btn_deta, btn_edit, btn_buscar;
    private UserController controlador;
    JTable tabla;
    String nombreUsuario = " ";

    public Pantalla_Usuarios(Vista_GYM log) {
        this.menu_inicio = log;
        
        UserModel userModel = new UserModel();
        PaymentModel paymentModel = new PaymentModel();
        ClassModel classModel = new ClassModel();
        controlador = new UserController(userModel, paymentModel, classModel);
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
        separador.setBounds(250, 90, 1030, 2); 
        separador.setForeground(Color.BLACK);
        menu_user.add(separador);

        // == boton agregar
        ImageIcon agg = new ImageIcon(getClass().getResource("/files/aggUsuario_cn.png"));
        Image modi = agg.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(modi);

        btn_agg = new JButton("Agregar usuario");
        btn_agg.setIcon(icono);
        btn_agg.setBounds(300, 110, 420, 100);
        btn_agg.setFont(new Font("Arial", Font.BOLD, 32));
        btn_agg.setBorderPainted(false);
        btn_agg.setHorizontalAlignment(SwingConstants.LEFT);
        btn_agg.setIconTextGap(30);
        btn_agg.setFocusPainted(false);
        btn_agg.setOpaque(true);
        btn_agg.setBackground(Color.WHITE);
        btn_agg.setForeground(Color.BLACK);
        btn_agg.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Usuarios_Agregar(menu_inicio).getPanel());
        });
        menu_user.add(btn_agg);

		// == boton editar 
        ImageIcon edit = new ImageIcon(getClass().getResource("/files/user_edit.png"));
        Image modi_edit = edit.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_edit = new ImageIcon(modi_edit);

        btn_edit = new JButton("Editar usuario");
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
            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(
                    menu_user,
                    "Selecciona primero un usuario de la tabla.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int num_control = (int) modelo.getValueAt(fila, 5);

            User usuario = controlador.getUser(num_control);
            menu_inicio.pintar_vista(new Editar(menu_inicio, usuario).getPanel());
        });
        menu_user.add(btn_edit);
        
		// == boton detalles 
        ImageIcon deta = new ImageIcon(getClass().getResource("/files/buscar_registros.png"));
        Image modi_deta = deta.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_deta = new ImageIcon(modi_deta);

        btn_deta = new JButton("Detalles usuario");
        btn_deta.setIcon(icono_deta);
        btn_deta.setBounds(300, 235, 420, 100);
        btn_deta.setFont(new Font("Arial", Font.BOLD, 32));
        btn_deta.setBorderPainted(false);
        btn_deta.setHorizontalAlignment(SwingConstants.LEFT);
        btn_deta.setIconTextGap(30);
        btn_deta.setFocusPainted(false);
        btn_deta.setOpaque(true);
        btn_deta.setBackground(Color.WHITE);
        btn_deta.setForeground(Color.BLACK);
        btn_deta.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(
                    menu_user,
                    "Selecciona primero un usuario de la tabla.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int num_control = (int) modelo.getValueAt(fila, 5);

            User usuario = controlador.getUser(num_control);
            menu_inicio.pintar_vista(new Detalles(menu_inicio, usuario).getPanel());
        });
        menu_user.add(btn_deta);
		
		// == boton eliminar 
        ImageIcon eliminar = new ImageIcon(getClass().getResource("/files/user_less.png"));
        Image modi_eliminar = eliminar.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_eliminar = new ImageIcon(modi_eliminar);

        btn_eliminar = new JButton("Eliminar usuario");
        btn_eliminar.setIcon(icono_eliminar);
        btn_eliminar.setBounds(775, 235, 420, 100);
        btn_eliminar.setFont(new Font("Arial", Font.BOLD, 32));
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_eliminar.setIconTextGap(30);
        btn_eliminar.setFocusPainted(false);
        btn_eliminar.setOpaque(true);
        btn_eliminar.setBackground(Color.WHITE);
        btn_eliminar.setForeground(Color.BLACK);
        btn_eliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(
                    menu_user,
                    "Selecciona primero un usuario de la tabla.",
                    "Sin selección",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int num_control = (int) modelo.getValueAt(fila, 5);

            User usuario = controlador.getUser(num_control);
            menu_inicio.pintar_vista(new Eliminar(menu_inicio, usuario).getPanel());
        });
        menu_user.add(btn_eliminar);
		
        // === TABLA T.T
		panel_tabla = new JPanel();
		panel_tabla.setBackground(Color.WHITE);
		panel_tabla.setBounds(300, 355, 900, 290);
		panel_tabla.setLayout(null);
		menu_user.add(panel_tabla);

        Graficos_texto buscar = new Graficos_texto();
        buscar.setPlaceholder(" Buscar usuario");
        buscar.setBounds(50, 18, 590, 45);
        buscar.setBackground(colorGris);
        buscar.setFont(new Font("Arial", Font.PLAIN, 18));
        buscar.setBorder(null);
        panel_tabla.add(buscar);

        btn_buscar = new JButton("Buscar");
        btn_buscar.setBounds(650, 18, 200, 45);
        btn_buscar.setFont(new Font("Arial", Font.BOLD, 22));
        btn_buscar.setBackground(Color.BLACK);
        btn_buscar.setForeground(Color.WHITE);
        btn_buscar.setFocusPainted(false);
        
        
        
        btn_buscar.addActionListener(e -> {
            nombreUsuario = buscar.getText().trim();

            modelo.setRowCount(0);
            controlador.fillUserHomeTable(nombreUsuario, modelo);

            if (modelo.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron usuarios con ese nombre.", "Sin resultados",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            
        });

        panel_tabla.add(btn_buscar);
		
        String[] columnas = { "Nombre", "Apellido", "Plan", "Fecha pago", "Fecha prox. pago", "No. de control" };

        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };  
        this.modelo=modelo;
        controlador.fillUserHomeTable(nombreUsuario, modelo);
        

        tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 17));
        tabla.setRowHeight(39);
        
        tabla.setForeground(Color.BLACK);
        tabla.setBackground(Color.WHITE);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 39));
        header.setFont(new Font("Arial", Font.BOLD, 22));
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 80, 800, 195);
        panel_tabla.add(scroll);
        
        scroll.setColumnHeaderView(tabla.getTableHeader());


        

		return menu_user;
	}
    private DefaultTableModel modelo;

}