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

public class Eliminar {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_delete, paneldelete, nom, ape, fecha, nom2, ape2, fecha2;
    private JButton noti, confi, eliminar, volver;
    private JLabel text_inicio, text_, user, text_nom, text_ape, text_fecha, text_nom2, text_ape2, text_fecha2;
    public User usuario;
    private UserController controlador;
    
    public Eliminar(Vista_GYM log,User usuario) {
        this.menu_inicio = log;
        this.usuario=usuario;
        UserModel userModel = new UserModel();
        PaymentModel paymentModel = new PaymentModel();
        ClassModel classModel = new ClassModel();
        controlador = new UserController(userModel, paymentModel, classModel);
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
  
        // ==
        
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2); 
        separador.setForeground(Color.BLACK);
        menu.add(separador);
        
        // ===
		panel_delete = new JPanel();
		panel_delete.setBackground(Color.WHITE);
		panel_delete.setBounds(300, 130, 400, 500);
		panel_delete.setLayout(null);
		menu.add(panel_delete);
		
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/usuario.png"));
		user = new JLabel(icono_user);
		user.setBounds(135, 25, 128, 128);
		panel_delete.add(user);
		
		text_inicio = new JLabel();
		text_inicio.setText(usuario.getFirst_name());
		text_inicio.setFont(new Font("Arial", Font.BOLD, 40));
		text_inicio.setForeground(Color.BLACK);
		text_inicio.setHorizontalAlignment(SwingConstants.CENTER);
		text_inicio.setBounds(0, 155, 400, 50);
		panel_delete.add(text_inicio);
        
        text_ = new JLabel("C l i e n t e");
        text_.setFont(new Font("Arial", Font.BOLD, 20));
        text_.setForeground(Color.GRAY);
        text_.setHorizontalAlignment(SwingConstants.CENTER);
        text_.setBounds(0, 190, 400, 50);
        panel_delete.add(text_);
        
		nom = new JPanel();
		nom.setBackground(colorGris);
		nom.setBounds(50, 270, 300, 50);
		nom.setLayout(null);
		panel_delete.add(nom);
		
        text_nom = new JLabel();
        text_nom.setText(usuario.getFirst_name());
        text_nom.setFont(new Font("Arial", Font.BOLD, 25));
		
        text_nom.setForeground(Color.black);
        text_nom.setBounds(10, 5, 400, 50);
        nom.add(text_nom);
		
		ape = new JPanel();
		ape.setBackground(colorGris);
		ape.setBounds(50, 330, 300, 50);
		ape.setLayout(null);
		panel_delete.add(ape);
		
        text_ape = new JLabel();
        text_ape.setText(usuario.getLast_name());
        text_ape.setFont(new Font("Arial", Font.BOLD, 25));
        text_ape.setForeground(Color.black);
        text_ape.setBounds(10, 5, 500, 50);
        ape.add(text_ape);
		
		fecha = new JPanel();
		fecha.setBackground(colorGris);
		fecha.setBounds(50, 390, 300, 50);
		fecha.setLayout(null);
		panel_delete.add(fecha);
		
        text_fecha = new JLabel();
        text_fecha.setText(usuario.getEmail());
        text_fecha.setFont(new Font("Arial", Font.BOLD, 25));
        text_fecha.setForeground(Color.black);
        text_fecha.setBounds(10, 5, 500, 50);
        fecha.add(text_fecha);
        
		// ===
		paneldelete = new JPanel();
		paneldelete.setBackground(Color.WHITE);
		paneldelete.setBounds(775, 135, 400, 500);
		paneldelete.setLayout(null);
		menu.add(paneldelete);

		nom2 = new JPanel();
		nom2.setBackground(colorGris);
		nom2.setBounds(50, 50, 300, 50);
		nom2.setLayout(null);
		paneldelete.add(nom2);
		
		int id = usuario.getId();
        text_nom2 = new JLabel(controlador.getUserDetails(id).getMembership_name());
        text_nom2.setFont(new Font("Arial", Font.BOLD, 25));
        text_nom2.setForeground(Color.black);
        text_nom2.setBounds(10, 5, 500, 50);
        nom2.add(text_nom2);
		
		ape2 = new JPanel();
		ape2.setBackground(colorGris);
		ape2.setBounds(50, 110, 300, 50);
		ape2.setLayout(null);
		paneldelete.add(ape2);
		
        text_ape2 = new JLabel("10 / 04 / 2025");
        text_ape2.setFont(new Font("Arial", Font.BOLD, 25));
        text_ape2.setForeground(Color.black);
        text_ape2.setBounds(10, 5, 500, 50);
        ape2.add(text_ape2);
		
		fecha2 = new JPanel();
		fecha2.setBackground(colorGris);
		fecha2.setBounds(50, 170, 300, 50);
		fecha2.setLayout(null);
		paneldelete.add(fecha2);
		
        text_fecha2 = new JLabel();
        text_fecha2.setText(usuario.getPhone_number());

        text_fecha2.setFont(new Font("Arial", Font.BOLD, 25));
        text_fecha2.setForeground(Color.black);
        text_fecha2.setBounds(10, 5, 500, 50);
        fecha2.add(text_fecha2);
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(50, 320, 300, 50);
        eliminar.setFont(new Font("Arial", Font.BOLD, 22));
        eliminar.setBackground(Color.BLACK);
        eliminar.setForeground(Color.WHITE);
        eliminar.setFocusPainted(false);
        eliminar.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas eliminar a este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {
                controlador.deleteUser(usuario.getControl_number());
                JOptionPane.showMessageDialog(
                    null,
                    "Usuario eliminado correctamente.",
                    "Eliminación exitosa",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel());

            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Se canceló la eliminación.",
                    "Operación cancelada",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        paneldelete.add(eliminar);
        
        volver = new JButton("Volver");
        volver.setBounds(50, 390, 300, 50);
        volver.setFont(new Font("Arial", Font.BOLD, 22));
        volver.setBackground(Color.lightGray);
        volver.setForeground(Color.black);
        volver.setFocusPainted(false);
        volver.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel());
        });
        paneldelete.add(volver);
        
        return menu;
    }
}
