package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.TrainerController;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.Trainer;
import Model.TrainerModel;

public class Info_Instructor {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_info, panelinfo, panelimg, panelinfo2;
    private JButton noti, confi, report, credencial, edit_info2, eli_info2, edit_info, eli_info, agregar, back;
    private JLabel text_inicio, text_, user, date, text_info, text_nom2, text;
    
    TrainerModel modelTrainer = new TrainerModel();
    ClassModel cTrainer = new ClassModel();
    
    TrainerController controller = new TrainerController(modelTrainer, cTrainer);
    
    private int trainerId;

    public Info_Instructor(Vista_GYM log, int trainerId) {
        this.menu_inicio = log;
        this.trainerId = trainerId;
        this.modelTrainer = new TrainerModel();
        this.cTrainer = new ClassModel();
        this.controller = new TrainerController(modelTrainer, cTrainer);
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
        
        back = new JButton("Volver");
        back.setBounds(300, 20, 150, 50);
        back.setFont(new Font("Arial", Font.BOLD, 22));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
        });
        menu.add(back);
        
        // ==
        
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2); 
        separador.setForeground(Color.BLACK);
        menu.add(separador);
        
        // ===
        panel_info = new JPanel();
        panel_info.setBackground(Color.WHITE);
        panel_info.setBounds(300, 110, 400, 520);
        panel_info.setLayout(null);
		menu.add(panel_info);
		
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/usuario.png"));
		user = new JLabel(icono_user);
		user.setBounds(135, 15, 128, 128);
		panel_info.add(user);
		
		text_inicio = new JLabel(); 
		Trainer trainer = controller.getTrainer(trainerId);
//		controller.fillTrainerClassesHistoryTable(trainerId, modelo);
//		controller.fillTrainerClassesTable(trainerId, modelo1);
		text_inicio = new JLabel(trainer.getName(), SwingConstants.CENTER);
		text_inicio.setFont(new Font("Arial", Font.BOLD, 40));
		text_inicio.setForeground(Color.BLACK);
		text_inicio.setBounds(0, 145, panel_info.getWidth(), 50);
		panel_info.add(text_inicio);

        
        text_ = new JLabel("I n s t r u c t o r");
        text_.setFont(new Font("Arial", Font.BOLD, 20));
        text_.setForeground(Color.GRAY);
        text_.setBounds(125, 180, 500, 50);
        panel_info.add(text_);
        
        //
        edit_info = new JButton("Editar");
        edit_info.setBounds(20, 230, 150, 40);
        edit_info.setFont(new Font("Arial", Font.BOLD, 22));
        edit_info.setBackground(Color.lightGray);
        edit_info.setForeground(Color.black);
        edit_info.setFocusPainted(false);
        edit_info.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Editar_Instructor(menu_inicio).getPanel());
        });
        panel_info.add(edit_info);
        
        eli_info = new JButton("Eliminar");
        eli_info.setBounds(220, 230, 150, 40);
        eli_info.setFont(new Font("Arial", Font.BOLD, 22));
        eli_info.setBackground(Color.BLACK);
        eli_info.setForeground(Color.WHITE);
        eli_info.setFocusPainted(false);
        panel_info.add(eli_info);
        
        text_info = new JLabel("Historial de clases", SwingConstants.CENTER);
        text_info.setOpaque(true);
        text_info.setBackground(Color.BLACK);
        text_info.setForeground(Color.WHITE);
        text_info.setFont(new Font("Arial", Font.BOLD, 18));
        text_info.setBounds(20, 285, 370, 25);
        panel_info.add(text_info);

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
        scroll.setBounds(20, 310, 370, 110);
        panel_info.add(scroll);
        
        report = new JButton("Descargar reporte (PDF)");
        report.setBounds(50, 430, 300, 30);
        report.setFont(new Font("Arial", Font.BOLD, 18));
        report.setBackground(Color.lightGray);
        report.setForeground(Color.black);
        report.setFocusPainted(false);
        report.setLayout(null);
        panel_info.add(report);
        
        credencial = new JButton("Descargar credencial (PDF)");
        credencial.setBounds(50, 470, 300, 30);
        credencial.setFont(new Font("Arial", Font.BOLD, 18));
        credencial.setBackground(Color.lightGray);
        credencial.setForeground(Color.black);
        credencial.setFocusPainted(false);
        panel_info.add(credencial);
        
		// ===
		panelinfo = new JPanel();
		panelinfo.setBackground(Color.WHITE);
		panelinfo.setBounds(775, 110, 400, 250);
		panelinfo.setLayout(null);
		menu.add(panelinfo);

        text_nom2 = new JLabel("Programar una clase");
        text_nom2.setFont(new Font("Arial", Font.BOLD, 25));
        text_nom2.setForeground(Color.black);
        text_nom2.setBounds(80, 5, 500, 50);
        text_nom2.setLayout(null);
        panelinfo.add(text_nom2);
        
        Graficos_texto campo_fecha = new Graficos_texto();
        campo_fecha.setPlaceholder(" DD/MM/AA");
        campo_fecha.setBounds(30, 55, 110, 35);
        campo_fecha.setBackground(Color.lightGray);
        campo_fecha.setFont(new Font("Arial", Font.PLAIN, 18));
        campo_fecha.setBorder(null);
        panelinfo.add(campo_fecha);
		panelimg = new JPanel();
		panelimg.setBackground(Color.lightGray);
		panelimg.setBounds(140, 55, 35, 35);
		panelimg.setLayout(null);
		panelinfo.add(panelimg);
		ImageIcon img_calendario = new ImageIcon(getClass().getResource("/files/calendario.png"));
		date = new JLabel(img_calendario);
		date.setBounds(0, 0, 32, 32);
		panelimg.add(date);
		
        Graficos_texto campo_clase = new Graficos_texto();
        campo_clase.setPlaceholder(" Clase");
        campo_clase.setBounds(30, 120, 290, 35);
        campo_clase.setBackground(Color.lightGray);
        campo_clase.setFont(new Font("Arial", Font.PLAIN, 18));
        campo_clase.setBorder(null);
        panelinfo.add(campo_clase);
        
		agregar = new JButton("Agregar");
		agregar.setBounds(30, 180, 350, 45);
		agregar.setFont(new Font("Arial", Font.BOLD, 22));
		agregar.setBackground(Color.BLACK);
		agregar.setForeground(Color.WHITE);
		agregar.setFocusPainted(false);
		panelinfo.add(agregar);

		// ===
		panelinfo2 = new JPanel();
		panelinfo2.setBackground(Color.WHITE);
		panelinfo2.setBounds(775, 390, 400, 250);
		panelinfo2.setLayout(null);
		menu.add(panelinfo2);
		
        text = new JLabel("Mis clases");
        text.setFont(new Font("Arial", Font.BOLD, 25));
        text.setForeground(Color.black);
        text.setBounds(140, 5, 500, 50);
        text.setLayout(null);
        panelinfo2.add(text);
        
        String[] columnas1 = {"Fecha", "Clase", "Usuarios"};
        Object[][] datos1 = {
              {"12/04/2025", "Zumba", "12"},
              {"8/04/2025", "Pesas", "8"},
              {"27/03/2025", "Pesas", "15"}
        };

        DefaultTableModel modelo1 = new DefaultTableModel(datos1, columnas1);
        JTable tabla1 = new JTable(modelo1);
        tabla1.setFont(new Font("Arial", Font.PLAIN, 16));
        tabla1.setRowHeight(28);
        tabla1.setForeground(Color.BLACK);
        tabla1.setBackground(Color.WHITE);

        JTableHeader header1 = tabla1.getTableHeader();
        header1.setFont(new Font("Arial", Font.BOLD, 15));
        header1.setBackground(Color.WHITE);
        header1.setForeground(Color.BLACK);

        JScrollPane scroll1 = new JScrollPane(tabla1);
        scroll1.setBounds(20, 50, 370, 110);
        panelinfo2.add(scroll1);
        
        edit_info2 = new JButton("Editar");
        edit_info2.setBounds(30, 180, 150, 40);
        edit_info2.setFont(new Font("Arial", Font.BOLD, 22));
        edit_info2.setBackground(Color.lightGray);
        edit_info2.setForeground(Color.black);
        edit_info2.setFocusPainted(false);
        edit_info2.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Editar_Instructor(menu_inicio).getPanel());
        });
        panelinfo2.add(edit_info2);
        
        eli_info2 = new JButton("Eliminar");
        eli_info2.setBounds(220, 180, 150, 40);
        eli_info2.setFont(new Font("Arial", Font.BOLD, 22));
        eli_info2.setBackground(Color.BLACK);
        eli_info2.setForeground(Color.WHITE);
        eli_info2.setFocusPainted(false);
        panelinfo2.add(eli_info2);
        

        return menu;
    }
}
