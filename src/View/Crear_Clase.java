
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;

public class Crear_Clase {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_agg;
    private JButton noti, confi, crear_clase, cancelar;
    private JLabel user, text;


    public Crear_Clase(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(Color.LIGHT_GRAY);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        menu.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Inicio");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
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
		panel_agg = new JPanel();
		panel_agg.setBackground(Color.WHITE);
		panel_agg.setBounds(300, 125, 900, 510);
		panel_agg.setLayout(null);
		menu.add(panel_agg);
		
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/clase.png"));
		user = new JLabel(icono_user);
		user.setBounds(375, 15, 128, 128);
		panel_agg.add(user);
		
		text = new JLabel("Crear clase");
		text.setFont(new Font("Arial", Font.BOLD, 30));
		text.setForeground(Color.BLACK);
		text.setBounds(370, 140, 500, 50);
		panel_agg.add(text);
		
        Graficos_texto nombre = new Graficos_texto();
        nombre.setPlaceholder(" Nombre de clase");
        nombre.setBounds(225, 200, 415, 40);
        nombre.setBackground(Color.lightGray);
        nombre.setFont(new Font("Arial", Font.PLAIN, 18));
        nombre.setBorder(null);
        panel_agg.add(nombre);
        
        Graficos_texto hora = new Graficos_texto();
        hora.setPlaceholder(" Horario");
        hora.setBounds(225, 260, 415, 40);
        hora.setBackground(Color.lightGray);
        hora.setFont(new Font("Arial", Font.PLAIN, 18));
        hora.setBorder(null);
        panel_agg.add(hora);
        
        Graficos_texto max = new Graficos_texto();
        max.setPlaceholder(" Capacidad maxima de usuarios");
        max.setBounds(225, 320, 415, 40);
        max.setBackground(Color.lightGray);
        max.setFont(new Font("Arial", Font.PLAIN, 18));
        max.setBorder(null);
        panel_agg.add(max);
        
        Graficos_texto nom = new Graficos_texto();
        nom.setPlaceholder(" Nombre del instructor");
        nom.setBounds(225, 380, 415, 40);
        nom.setBackground(Color.lightGray);
        nom.setFont(new Font("Arial", Font.PLAIN, 18));
        nom.setBorder(null);
        panel_agg.add(nom);
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(30, 450, 330, 40);
        cancelar.setFont(new Font("Arial", Font.BOLD, 22));
        cancelar.setBackground(Color.lightGray);
        cancelar.setForeground(Color.black);
        cancelar.setFocusPainted(false);
        cancelar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel());
        });
        panel_agg.add(cancelar);
        
        crear_clase = new JButton("Crear clase");
        crear_clase.setBounds(520, 450, 330, 40);
        crear_clase.setFont(new Font("Arial", Font.BOLD, 22));
        crear_clase.setBackground(Color.BLACK);
        crear_clase.setForeground(Color.WHITE);
        crear_clase.setFocusPainted(false);
        crear_clase.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String campo1= nombre.getText().trim();
                String campo2 = hora.getText().trim();
                String campo3= max.getText().trim();
                String campo4 = nom.getText().trim();

                if (campo1.isEmpty() || campo2.isEmpty() || campo3.isEmpty() || campo4.isEmpty()) {
    	            JOptionPane.showMessageDialog(menu,
        	                "Rellena todos los campos.",
        	                "Datos incompletos", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "¡Clase guardada corrrectamente!");
                    menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel());
                }
            }
        });
        panel_agg.add(crear_clase);
 
		return menu;
	}
}