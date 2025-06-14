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

public class Pantalla_Usuarios_Eliminar {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_delete;
    private JButton noti, confi, btn_agg, btn_eliminar, btn_deta, btn_edit, btn_buscar;
    UserModel userModel = new UserModel() ;
	PaymentModel paymentModel  = new PaymentModel() ;
	ClassModel classModel  = new ClassModel() ;
    
    UserController controlador = new UserController(userModel,paymentModel,classModel);


    public Pantalla_Usuarios_Eliminar(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
    	
    	Color colorGris = Color.decode("#D9D9D9");

        menu = new JPanel();
        menu.setLayout(null);
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
        
        // == boton agregar
        ImageIcon agg = new ImageIcon(getClass().getResource("/files/aggUsuario_cn.png"));
        Image modi = agg.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(modi);

        btn_agg = new JButton("Agregar usuario");
        btn_agg.setIcon(icono);
        btn_agg.setBounds(300, 130, 420, 115);
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
        menu.add(btn_agg);

		// == boton editar 
        ImageIcon edit = new ImageIcon(getClass().getResource("/files/user_edit.png"));
        Image modi_edit = edit.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_edit = new ImageIcon(modi_edit);

        btn_edit = new JButton("Editar usuario");
        btn_edit.setIcon(icono_edit);
        btn_edit.setBounds(775, 130, 420, 115);
        btn_edit.setFont(new Font("Arial", Font.BOLD, 32));
        btn_edit.setBorderPainted(false);
        btn_edit.setHorizontalAlignment(SwingConstants.LEFT);
        btn_edit.setIconTextGap(30);
        btn_edit.setFocusPainted(false);
        btn_edit.setOpaque(true);
        btn_edit.setBackground(Color.WHITE);
        btn_edit.setForeground(Color.BLACK);
        btn_edit.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Usuarios_Editar(menu_inicio).getPanel());
        });
        menu.add(btn_edit);
        
		// == boton detalles 
        ImageIcon deta = new ImageIcon(getClass().getResource("/files/buscar_registros.png"));
        Image modi_deta = deta.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_deta = new ImageIcon(modi_deta);

        btn_deta = new JButton("Detalles usuario");
        btn_deta.setIcon(icono_deta);
        btn_deta.setBounds(300, 270, 420, 115);
        btn_deta.setFont(new Font("Arial", Font.BOLD, 32));
        btn_deta.setBorderPainted(false);
        btn_deta.setHorizontalAlignment(SwingConstants.LEFT);
        btn_deta.setIconTextGap(30);
        btn_deta.setFocusPainted(false);
        btn_deta.setOpaque(true);
        btn_deta.setBackground(Color.WHITE);
        btn_deta.setForeground(Color.BLACK);
        btn_deta.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Usuarios_Detalles(menu_inicio).getPanel());
        });
        menu.add(btn_deta);
		
		// == boton eliminar 
        ImageIcon eliminar = new ImageIcon(getClass().getResource("/files/user_less_cb.png"));
        Image modi_eliminar = eliminar.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_eliminar = new ImageIcon(modi_eliminar);

        btn_eliminar = new JButton("Eliminar usuario");
        btn_eliminar.setIcon(icono_eliminar);
        btn_eliminar.setBounds(775, 270, 420, 115);
        btn_eliminar.setFont(new Font("Arial", Font.BOLD, 32));
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_eliminar.setIconTextGap(30);
        btn_eliminar.setFocusPainted(false);
        btn_eliminar.setOpaque(true);
        btn_eliminar.setBackground(Color.black);
        btn_eliminar.setForeground(Color.white);
        btn_eliminar.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Usuarios_Eliminar(menu_inicio).getPanel());
        });
        menu.add(btn_eliminar);
        
        panel_delete = new JPanel();
		panel_delete.setBackground(Color.WHITE);
		panel_delete.setBounds(300, 440, 900, 100);
		panel_delete.setLayout(null);
		menu.add(panel_delete);

		Graficos_texto buscar = new Graficos_texto();
        buscar.setPlaceholder(" Buscar usuario");
        buscar.setBounds(47, 25, 590, 45);
        buscar.setBackground(colorGris);
        buscar.setFont(new Font("Arial", Font.PLAIN, 18));
        buscar.setBorder(null);
        panel_delete.add(buscar);

        btn_buscar = new JButton("Buscar");
        btn_buscar.setBounds(650, 25, 200, 45);
        btn_buscar.setFont(new Font("Arial", Font.BOLD, 22));
        btn_buscar.setBackground(Color.BLACK);
        btn_buscar.setForeground(Color.WHITE);
        btn_buscar.setFocusPainted(false);
        btn_buscar.addActionListener(e -> {
            String texto = buscar.getText().trim();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Por favor, ingresa el número de control.",
                    "Campo vacío",
                    JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            int idUsuario;
            try {
                idUsuario = Integer.parseInt(texto);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    null,
                    "El número de control debe ser un valor numérico.",
                    "Error de formato",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            User usuario = controlador.getUser(idUsuario);
            if (usuario != null) {
                menu_inicio.pintar_vista(new Eliminar(menu_inicio, usuario).getPanel());
            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Usuario no encontrado.",
                    "Sin resultados",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
        panel_delete.add(btn_buscar);

        return menu;
    }
}
