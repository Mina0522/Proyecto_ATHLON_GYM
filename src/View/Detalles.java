package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.ClassController;
import Controller.PaymentController;
import Controller.UserController;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.ComboObject;
import Model.PaymentModel;
import Model.User;
import Model.UserModel;

public class Detalles {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel, panelagg;
    private JButton noti, confi, eliminar, volver, edit, eli, pdf;
    private JLabel text_inicio, text_, user, text_clase;
    private User usuario;
    
    public DefaultTableModel modeloPagos;
    
    private UserController controlador;

    public Detalles(Vista_GYM log,User usuario) {
        this.menu_inicio = log;
        this.usuario = usuario;
        
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
        menu = new JPanel();
        menu.setLayout(null);
        Color colorGris = Color.decode("#D9D9D9");
        menu.setBackground(colorGris);
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
		user.setBounds(135, 25, 128, 128);
		panel.add(user);
		
		text_inicio = new JLabel();
		text_inicio.setText(usuario.getFirst_name());
		text_inicio.setFont(new Font("Arial", Font.BOLD, 40));
		text_inicio.setForeground(Color.BLACK);
		text_inicio.setHorizontalAlignment(SwingConstants.CENTER);
		text_inicio.setBounds(0, 155, 400, 50);
		panel.add(text_inicio);
        
		text_ = new JLabel("C L I E N T E");
        text_.setFont(new Font("Arial", Font.BOLD, 20));
        text_.setForeground(Color.GRAY);
		text_.setHorizontalAlignment(SwingConstants.CENTER);

        text_.setBounds(0, 190, 400, 50);
        panel.add(text_);
        
        //
        edit = new JButton("Registrar pago");
        edit.setBounds(20, 240, 170, 50);
        edit.setFont(new Font("Arial", Font.BOLD, 18));
        edit.setBackground(Color.lightGray);
        edit.setForeground(Color.black);
        edit.setFocusPainted(false);
        edit.addActionListener(e -> {
        	mostrarModalPago(controlador,usuario);
        });
        panel.add(edit);
        
        eli = new JButton("Añadir a clase");
        eli.setBounds(215, 240, 170, 50);
        eli.setFont(new Font("Arial", Font.BOLD, 18));
        eli.setBackground(Color.BLACK);
        eli.setForeground(Color.WHITE);
        eli.setFocusPainted(false);
        eli.addActionListener(e -> {
        	mostrarModalClases(controlador,usuario);
        });
        panel.add(eli);
        
        text_clase = new JLabel("Historial de clases", SwingConstants.CENTER);
        text_clase.setOpaque(true);
        text_clase.setBackground(Color.BLACK);
        text_clase.setForeground(Color.WHITE);
        text_clase.setFont(new Font("Arial", Font.BOLD, 22));
        text_clase.setBounds(20, 315, 365, 35);
        panel.add(text_clase);

        String[] columnas = {"Fecha", "Clase"};
        

        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 16));
        tabla.setRowHeight(28);
        
        tabla.setForeground(Color.BLACK);
        tabla.setBackground(Color.WHITE);

        JTableHeader header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(header.getWidth(), 30));
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 350, 365, 130);
        panel.add(scroll);
        controlador.fillUserClassTable(usuario.getControl_number(), modelo);
        
        
		// ===
		panelagg = new JPanel();
		panelagg.setBackground(Color.WHITE);
		panelagg.setBounds(775, 130, 400, 500);
		panelagg.setLayout(null);
		menu.add(panelagg);
		
		text_clase = new JLabel("Historial de pagos", SwingConstants.CENTER);
        text_clase.setOpaque(true);
        text_clase.setBackground(Color.BLACK);
        text_clase.setForeground(Color.WHITE);
        text_clase.setFont(new Font("Arial", Font.BOLD, 22));
        text_clase.setBounds(20, 33, 370, 35);
        panelagg.add(text_clase);

        String[] columnas2 = {"Fecha", "Pagos", "Plan"};
        
        
        
        modeloPagos = new DefaultTableModel(null, columnas2) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        
        JTable tabla2 = new JTable(modeloPagos);
        tabla2.setFont(new Font("Arial", Font.PLAIN, 16));
        tabla2.setRowHeight(39);
        tabla2.setForeground(Color.BLACK);
        tabla2.setBackground(Color.WHITE);

        

        JScrollPane scroll2 = new JScrollPane(tabla2);
        scroll2.setBounds(20, 69, 370, 150);
        panelagg.add(scroll2);
        
        JTableHeader header2 = tabla2.getTableHeader();
        header2.setPreferredSize(new Dimension(scroll2.getWidth(), 30));
        header2.setFont(new Font("Arial", Font.BOLD, 20));
        header2.setBackground(Color.BLACK);
        header2.setForeground(Color.WHITE);

        controlador.fillUserDetailsTable(usuario.getControl_number(), modeloPagos);
        
        
        // ===
        eliminar = new JButton("Descargar reporte (PDF)");
        eliminar.setBounds(50, 280, 300, 50);
        eliminar.setFont(new Font("Arial", Font.BOLD, 22));
        eliminar.setBackground(Color.lightGray);
        eliminar.setForeground(Color.BLACK);
        eliminar.setFocusPainted(false);
        panelagg.add(eliminar);
        
        pdf = new JButton("Descargar credecial (PDF)");
        pdf.setBounds(50, 350, 300, 50);
        pdf.setFont(new Font("Arial", Font.BOLD, 22));
        pdf.setBackground(Color.GRAY);
        pdf.setForeground(Color.WHITE);
        pdf.setFocusPainted(false);
        pdf.addActionListener(e -> {
        	 
    	        controlador.generateUserIdPDF(usuario.getId()); 
    	        JOptionPane.showMessageDialog(null,
    	            "El reporte se descargó correctamente.",
    	            "Éxito",
    	            JOptionPane.INFORMATION_MESSAGE);
        	   
        });
        panelagg.add(pdf);
        
        volver = new JButton("Volver");
        volver.setBounds(50, 420, 300, 50);
        volver.setFont(new Font("Arial", Font.BOLD, 22));
        volver.setBackground(Color.BLACK);
        volver.setForeground(Color.white);
        volver.setFocusPainted(false);
        volver.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel());
        });
        panelagg.add(volver);
        
        return menu;
    }
    public void mostrarModalPago(UserController controlador,User usuario) {
        
    	
    	if (controlador.isActive(usuario.getId())) {
            JOptionPane.showMessageDialog(
                null,
                "El usuario ya tiene un plan activo. No puede registrar otro hasta que venza.",
                "Plan activo",
                JOptionPane.WARNING_MESSAGE
            );
            return;
            }
    	PaymentController controladorPago = new PaymentController();
        JDialog dialogo = new JDialog();
        dialogo.setModal(true);
        dialogo.setSize(350, 300);
        dialogo.setLayout(null);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(Color.black);
        panelTitulo.setBounds(0,0,350,50);
        dialogo.add(panelTitulo);
        
        JLabel titulo = new JLabel("Registrar pago");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.white);
        titulo.setBounds(0, 5,350,45);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        panelTitulo.add(titulo);

        
        JLabel plan = new JLabel("Tipo de plan");
        plan.setHorizontalAlignment(SwingConstants.CENTER);
        plan.setBounds(0, 70,350,45);
        plan.setFont(new Font("Arial", Font.BOLD, 23));
        dialogo.add(plan);
        
		JComboBox<ComboObject> comboBox = controlador.generateMembershipComboId(usuario.getId());
		comboBox.setBounds(50, 120, 250, 50);
		
		comboBox.setBackground( Color.decode("#D9D9D9"));
		comboBox.setFont(new Font("Arial", Font.BOLD, 20));
		dialogo.add(comboBox);
		
        
        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setFont(new Font("Arial", Font.BOLD, 22));
        botonCancelar.setBounds(20,200,130,50);
        dialogo.add(botonCancelar);
        
        botonCancelar.addActionListener(e -> {
        	dialogo.dispose();
        });
        
        
        JButton botonGuardar = new JButton("Pagar");
        botonGuardar.setForeground(Color.white);
        botonGuardar.setBackground(Color.black);
        botonGuardar.setFont(new Font("Arial", Font.BOLD, 22));
        botonGuardar.setBounds(195,200,130,50);
        dialogo.add(botonGuardar);
        
        botonGuardar.addActionListener(e -> {
        	ComboObject objeto = (ComboObject)comboBox.getSelectedItem();
        	if(objeto !=null) {
        		
        		int id_plan =objeto.getId();
        		JOptionPane.showMessageDialog(dialogo,
                        "Pago registrado con exito");
        		controladorPago.registerPayment(usuario.getId(), id_plan);
        		dialogo.dispose();
        		modeloPagos.setRowCount(0);
                controlador.fillUserDetailsTable(usuario.getControl_number(), modeloPagos);
                
                
                
        	}
        	else {
        		JOptionPane.showMessageDialog(dialogo,
                        "Registra un plan");
        	}
        	
            
           
        });
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);

        
    }
    
public  void mostrarModalClases(UserController controlador,User usuario) {
        
    	
        JDialog dialogo = new JDialog();
        dialogo.setModal(true);
        dialogo.setSize(350, 300);
        dialogo.setLayout(null);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(Color.black);
        panelTitulo.setBounds(0,0,350,50);
        dialogo.add(panelTitulo);
        
        JLabel titulo = new JLabel("Apuntar a clase");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.white);
        titulo.setBounds(0, 5,350,45);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        panelTitulo.add(titulo);

        
        JLabel plan = new JLabel("Clases disponibles");
        plan.setHorizontalAlignment(SwingConstants.CENTER);
        plan.setBounds(0, 70,350,45);
        plan.setFont(new Font("Arial", Font.BOLD, 23));
        dialogo.add(plan);
        
        String[] opciones = {"Box", "Hit"};
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		comboBox.setBounds(50, 120, 250, 50);
		comboBox.setBackground( Color.decode("#D9D9D9"));
		comboBox.setFont(new Font("Arial", Font.BOLD, 20));
		dialogo.add(comboBox);
		
        
        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setFont(new Font("Arial", Font.BOLD, 22));
        botonCancelar.setBounds(20,200,130,50);
        dialogo.add(botonCancelar);
        
        botonCancelar.addActionListener(e -> {
        	dialogo.dispose();
        });
        
        
        JButton botonGuardar = new JButton("Apuntar");
        botonGuardar.setForeground(Color.white);
        botonGuardar.setBackground(Color.black);
        botonGuardar.setFont(new Font("Arial", Font.BOLD, 22));
        botonGuardar.setBounds(195,200,130,50);
        dialogo.add(botonGuardar);
        
        botonGuardar.addActionListener(e -> {
        	String seleccion = (String) comboBox.getSelectedItem();
        	if(!seleccion.isEmpty()) {
        		JOptionPane.showMessageDialog(dialogo,
                        "El usuario se ha apuntado a la clase");
        		
                dialogo.dispose();
        	}
        	else {
        		JOptionPane.showMessageDialog(dialogo,
                        "Registra un plan");
        	}
        	
            
           
        });
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);

        
    }
}