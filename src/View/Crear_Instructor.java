package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;

public class Crear_Instructor {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_agg;
    private JButton noti, confi, crear, cancelar;
    private JLabel user, text;


    public Crear_Instructor(Vista_GYM log) {
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
        Menu botones = new Menu("Personal");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Personal", e -> menu_inicio.pintar_vista(getPanel()));
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
		panel_agg = new JPanel();
		panel_agg.setBackground(Color.WHITE);
		panel_agg.setBounds(490, 125, 490, 510);
		panel_agg.setLayout(null);
		menu.add(panel_agg);
		
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/usuario.png"));
		user = new JLabel(icono_user);
		user.setBounds(175, 15, 128, 128);
		panel_agg.add(user);
		
		text = new JLabel("Datos personales");
		text.setFont(new Font("Arial", Font.BOLD, 20));
		text.setForeground(Color.BLACK);
		text.setBounds(50, 145, 500, 50);
		panel_agg.add(text);
		
        Graficos_texto nombre = new Graficos_texto();
        nombre.setPlaceholder(" Nombre");
        nombre.setBounds(50, 195, 390, 40);
        nombre.setBackground(Color.lightGray);
        nombre.setFont(new Font("Arial", Font.PLAIN, 18));
        nombre.setBorder(null);
        panel_agg.add(nombre);
        
        Graficos_texto correo = new Graficos_texto();
        correo.setPlaceholder(" Correo");
        correo.setBounds(50, 245, 390, 40);
        correo.setBackground(Color.lightGray);
        correo.setFont(new Font("Arial", Font.PLAIN, 18));
        correo.setBorder(null);
        panel_agg.add(correo);
        
        Graficos_texto tel = new Graficos_texto();
        tel.setPlaceholder(" Telefono");
        tel.setBounds(50, 300, 390, 40);
        tel.setBackground(Color.lightGray);
        tel.setFont(new Font("Arial", Font.PLAIN, 18));
        tel.setBorder(null);
        panel_agg.add(tel);
        
        Graficos_texto especialidad = new Graficos_texto();
        especialidad.setPlaceholder(" Especialidad");
        especialidad.setBounds(50, 350, 390, 40);
        especialidad.setBackground(Color.lightGray);
        especialidad.setFont(new Font("Arial", Font.PLAIN, 18));
        especialidad.setBorder(null);
        panel_agg.add(especialidad);
        
        crear = new JButton("Crear");
        crear.setBounds(50, 400, 390, 40);
        crear.setFont(new Font("Arial", Font.BOLD, 22));
        crear.setBackground(Color.BLACK);
        crear.setForeground(Color.WHITE);
        crear.setFocusPainted(false);
        crear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String linea1= nombre.getText().trim();
                String linea2 = correo.getText().trim();
                String linea3= tel.getText().trim();
                String linea4 = especialidad.getText().trim();

                if (linea1.isEmpty() || linea2.isEmpty() || linea3.isEmpty() || linea4.isEmpty()) {
    	            JOptionPane.showMessageDialog(menu,
        	                "Rellena todos los campos.",
        	                "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Clase guardada corrrectamente!");
                    menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
                }
            }
        });
        panel_agg.add(crear);
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(50, 450, 390, 40);
        cancelar.setFont(new Font("Arial", Font.BOLD, 22));
        cancelar.setBackground(Color.lightGray);
        cancelar.setForeground(Color.black);
        cancelar.setFocusPainted(false);
        cancelar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
        });
        panel_agg.add(cancelar);
        
        

		return menu;
	}
}