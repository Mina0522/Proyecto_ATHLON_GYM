package View;

import javax.swing.*;

import Controller.UserController;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.PaymentModel;
import Model.User;
import Model.UserModel;
import Model.UserWithLastPayment;

public class Editar {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel, panelagg, nom, ape, fecha, nom2, ape2, fecha2;
    private JButton noti, confi, eliminar, volver;
    private JLabel text_inicio, text_, user, text_clase;
    private JTextField campoNombre;      
    private JTextField campoApellido;    
    private JTextField campoTelefono;
    private JTextField text_fecha2;
    
    private JLabel text_nom2, text_ape2;
    public User usuario;
    private UserController controlador;
    

    public Editar(Vista_GYM log,User usuario) {
        this.menu_inicio = log;
        this.usuario=usuario;
        UserModel userModel = new UserModel();
        PaymentModel paymentModel = new PaymentModel();
        ClassModel classModel = new ClassModel();
        this.controlador = new UserController(userModel, paymentModel, classModel);
    }
    

    public JPanel getPanel() {
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
		user.setBounds(135, 25, 128, 128);
		panel.add(user);
		
		text_inicio = new JLabel();
		text_inicio.setText(usuario.getFirst_name());
		text_inicio.setFont(new Font("Arial", Font.BOLD, 40));
        text_inicio.setHorizontalAlignment(SwingConstants.CENTER);

		text_inicio.setForeground(Color.BLACK);
		text_inicio.setBounds(0, 155, 400, 50);
		panel.add(text_inicio);
        
        text_ = new JLabel("C L I E N T E");
        text_.setHorizontalAlignment(SwingConstants.CENTER);
        text_.setFont(new Font("Arial", Font.BOLD, 20));
        text_.setForeground(Color.GRAY);
        text_.setBounds(0, 190, 400, 50);
        panel.add(text_);
      

        campoNombre = new JTextField(usuario.getFirst_name());
        campoNombre.setForeground(Color.BLACK);
        campoNombre.setFont(new Font("Arial", Font.BOLD, 25));
        campoNombre.setBackground(colorGris);
        campoNombre.setBounds(50, 270, 300, 50);
        panel.add(campoNombre);
		
		
		
		campoApellido = new JTextField(usuario.getLast_name());
		campoApellido.setBackground(colorGris);
		campoApellido.setForeground(Color.BLACK);
		campoApellido.setFont(new Font("Arial", Font.BOLD, 25));
        campoApellido.setBounds(50, 330, 300, 50);
        panel.add(campoApellido);
        
		
		
		
        text_fecha2 = new JTextField(usuario.getEmail());
        text_fecha2.setBackground(colorGris);
        text_fecha2.setForeground(Color.BLACK);
        text_fecha2.setFont(new Font("Arial", Font.BOLD, 25));
        text_fecha2.setForeground(Color.black);
        text_fecha2.setBounds(50, 390, 300, 50);
        panel.add(text_fecha2);
        
		// ===
		panelagg = new JPanel();
		panelagg.setBackground(Color.WHITE);
		panelagg.setBounds(775, 130, 400, 500);
		panelagg.setLayout(null);
		menu.add(panelagg);

		
		String[] opciones = {"Premium", "Básico"};
		JComboBox<String> comboBox = new JComboBox<>(opciones);
		comboBox.setBounds(50, 50, 300, 50);
		comboBox.setBackground(colorGris);
		comboBox.setFont(new Font("Arial", Font.BOLD, 25));
		String seleccion = (String) comboBox.getSelectedItem();
		int id = usuario.getId();
		controlador.getUserDetails(id).setMembershipName(seleccion);
		panelagg.add(comboBox);

		
		ape2 = new JPanel();
		ape2.setBackground(colorGris);
		ape2.setBounds(50, 110, 300, 50);
		ape2.setLayout(null);
		panelagg.add(ape2);
		
        text_ape2 = new JLabel(controlador.getUserDetails(id).getTransaction_date());
        text_ape2.setFont(new Font("Arial", Font.BOLD, 25));
        text_ape2.setForeground(Color.gray);
        text_ape2.setBounds(10, 5, 500, 50);
        ape2.add(text_ape2);
		
		
		
		campoTelefono = new JTextField(usuario.getPhone_number());
		campoTelefono.setBackground(colorGris);
		campoTelefono.setForeground(Color.black);

        campoTelefono.setFont(new Font("Arial", Font.BOLD, 25));
        campoTelefono.setBounds(50, 170, 300, 50);
        panelagg.add(campoTelefono);
        
        
        eliminar = new JButton("Confirmar cambios");
        eliminar.setBounds(50, 320, 300, 50);
        eliminar.setFont(new Font("Arial", Font.BOLD, 22));
        eliminar.setBackground(Color.BLACK);
        eliminar.setForeground(Color.WHITE);
        eliminar.setFocusPainted(false);
        eliminar.addActionListener(e -> {
        	 String nuevoNombre = campoNombre.getText().trim();
             String nuevoApellido = campoApellido.getText().trim();
             String nuevoTelefono = campoTelefono.getText().trim();
             String nuevoCorreo = text_fecha2.getText().trim();
             

             
             
             int controlNum = usuario.getControl_number();
             int resultado = controlador.updateUser(controlNum, nuevoNombre, nuevoApellido, nuevoTelefono,nuevoCorreo,1);
             switch (resultado) {
                 case 0:
                     JOptionPane.showMessageDialog(null, "Usuarios actualizados con éxito.", "Éxito",
                             JOptionPane.INFORMATION_MESSAGE);
                     menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel());
                     break;
                 case 1:
                     JOptionPane.showMessageDialog(null, "No se han modificado los campos.", "Advertencia",
                             JOptionPane.WARNING_MESSAGE);
                     break;
                 case 2:
                     JOptionPane.showMessageDialog(null, "Datos inválidos: nombres no deben contener números.",
                             "Error", JOptionPane.ERROR_MESSAGE);
                     break;
                 case 3:
                     JOptionPane.showMessageDialog(null, "Datos inválidos: Numero no deben contener letras.",
                             "Error", JOptionPane.ERROR_MESSAGE);
                     break;
                 default:
                     JOptionPane.showMessageDialog(null, "Error desconocido al actualizar.", "Error",
                             JOptionPane.ERROR_MESSAGE);
             }
        });
        panelagg.add(eliminar);
        
        volver = new JButton("Volver");
        volver.setBounds(50, 390, 300, 50);
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
