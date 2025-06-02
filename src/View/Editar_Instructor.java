
package View;

import javax.swing.*;
import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;

public class Editar_Instructor {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_agg;
    private JButton noti, confi, editar, cancelar;
    private JLabel user, text;


    public Editar_Instructor(Vista_GYM log) {
        this.menu_inicio = log;
    }

    public JPanel getPanel() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(Color.LIGHT_GRAY);
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
		panel_agg.setBounds(300, 125, 900, 510);
		panel_agg.setLayout(null);
		menu.add(panel_agg);
		
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/usuario.png"));
		user = new JLabel(icono_user);
		user.setBounds(375, 15, 128, 128);
		panel_agg.add(user);
		
		text = new JLabel("Datos personales del instructor");
		text.setFont(new Font("Arial", Font.BOLD, 22));
		text.setForeground(Color.BLACK);
		text.setBounds(275, 145, 500, 50);
		panel_agg.add(text);
		
        Graficos_texto nombre = new Graficos_texto();
        nombre.setPlaceholder(" Felipe Ramos");
        nombre.setBounds(225, 200, 415, 40);
        nombre.setBackground(Color.lightGray);
        nombre.setFont(new Font("Arial", Font.PLAIN, 18));
        nombre.setBorder(null);
        panel_agg.add(nombre);
        
        Graficos_texto correo = new Graficos_texto();
        correo.setPlaceholder(" feliperamos@gmail.com");
        correo.setBounds(225, 260, 415, 40);
        correo.setBackground(Color.lightGray);
        correo.setFont(new Font("Arial", Font.PLAIN, 18));
        correo.setBorder(null);
        panel_agg.add(correo);
        
        Graficos_texto tel = new Graficos_texto();
        tel.setPlaceholder(" 6121231231");
        tel.setBounds(225, 320, 415, 40);
        tel.setBackground(Color.lightGray);
        tel.setFont(new Font("Arial", Font.PLAIN, 18));
        tel.setBorder(null);
        panel_agg.add(tel);
        
        Graficos_texto especialidad = new Graficos_texto();
        especialidad.setPlaceholder(" Pesas");
        especialidad.setBounds(225, 380, 415, 40);
        especialidad.setBackground(Color.lightGray);
        especialidad.setFont(new Font("Arial", Font.PLAIN, 18));
        especialidad.setBorder(null);
        panel_agg.add(especialidad);
        
        cancelar = new JButton("Cancelar");
        cancelar.setBounds(30, 450, 330, 40);
        cancelar.setFont(new Font("Arial", Font.BOLD, 22));
        cancelar.setBackground(Color.lightGray);
        cancelar.setForeground(Color.black);
        cancelar.setFocusPainted(false);
        cancelar.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
        });
        panel_agg.add(cancelar);
        
        editar = new JButton("Editar");
        editar.setBounds(520, 450, 330, 40);
        editar.setFont(new Font("Arial", Font.BOLD, 22));
        editar.setBackground(Color.BLACK);
        editar.setForeground(Color.WHITE);
        editar.setFocusPainted(false);
        panel_agg.add(editar);
        
        

		return menu;
	}
}