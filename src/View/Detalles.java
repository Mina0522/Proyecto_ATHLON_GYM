package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.User;

public class Detalles {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel, panelagg;
    private JButton noti, confi, eliminar, volver, edit, eli, pdf;
    private JLabel text_inicio, text_, user, text_clase;
    private User usuario;

    public Detalles(Vista_GYM log,User usuario) {
        this.menu_inicio = log;
        this.usuario = usuario;
    }

    public JPanel getPanel() {
        menu = new JPanel();
        menu.setLayout(null);
        menu.setBackground(Color.LIGHT_GRAY);
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
		user.setBounds(135, 15, 128, 128);
		panel.add(user);
		
		text_inicio = new JLabel();
		text_inicio.setText(usuario.getFirst_name());
		text_inicio.setFont(new Font("Arial", Font.BOLD, 40));
		text_inicio.setForeground(Color.BLACK);
		text_inicio.setBounds(75, 145, 500, 50);
		panel.add(text_inicio);
        
        text_ = new JLabel("C l i e n t e");
        text_.setFont(new Font("Arial", Font.BOLD, 20));
        text_.setForeground(Color.GRAY);
        text_.setBounds(155, 180, 500, 50);
        panel.add(text_);
        
        //
        edit = new JButton("Editar");
        edit.setBounds(20, 230, 150, 40);
        edit.setFont(new Font("Arial", Font.BOLD, 22));
        edit.setBackground(Color.lightGray);
        edit.setForeground(Color.black);
        edit.setFocusPainted(false);
        edit.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Editar(menu_inicio).getPanel());
        });
        panel.add(edit);
        
        eli = new JButton("Eliminar");
        eli.setBounds(220, 230, 150, 40);
        eli.setFont(new Font("Arial", Font.BOLD, 22));
        eli.setBackground(Color.BLACK);
        eli.setForeground(Color.WHITE);
        eli.setFocusPainted(false);
        panel.add(eli);
        
        text_clase = new JLabel("Historial de clases", SwingConstants.CENTER);
        text_clase.setOpaque(true);
        text_clase.setBackground(Color.BLACK);
        text_clase.setForeground(Color.WHITE);
        text_clase.setFont(new Font("Arial", Font.BOLD, 18));
        text_clase.setBounds(20, 337, 370, 25);
        panel.add(text_clase);

        String[] columnas = {"Fecha", "Clase", "Asistentes"};
        Object[][] datos = {
              {"12/04/2025", "Zumba", "12"},
              {"8/04/2025", "Pesas", "8"},
              {"27/03/2025", "Pesas", "15"}
        };

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        JTable tabla = new JTable(modelo);
        tabla.setFont(new Font("Arial", Font.PLAIN, 16));
        tabla.setRowHeight(28);
        tabla.setForeground(Color.BLACK);
        tabla.setBackground(Color.WHITE);

        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 15));
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20, 360, 370, 110);
        panel.add(scroll);
        
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
        text_clase.setFont(new Font("Arial", Font.BOLD, 18));
        text_clase.setBounds(20, 20, 370, 25);
        panelagg.add(text_clase);

        String[] columnas2 = {"Fecha", "Pagos", "Asistentes"};
        Object[][] datos2 = {
              {"12/04/2025", "Efectivo", "12"},
              {"8/04/2025", "Tarjeta", "8"},
              {"27/03/2025", "Efectivo", "15"}
        };

        DefaultTableModel modelo2 = new DefaultTableModel(datos2, columnas2);
        JTable tabla2 = new JTable(modelo2);
        tabla2.setFont(new Font("Arial", Font.PLAIN, 16));
        tabla2.setRowHeight(28);
        tabla2.setForeground(Color.BLACK);
        tabla2.setBackground(Color.WHITE);

        JTableHeader header2 = tabla2.getTableHeader();
        header2.setFont(new Font("Arial", Font.BOLD, 15));
        header2.setBackground(Color.WHITE);
        header2.setForeground(Color.BLACK);

        JScrollPane scroll2 = new JScrollPane(tabla2);
        scroll2.setBounds(20, 42, 370, 110);
        panelagg.add(scroll2);
        
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
}