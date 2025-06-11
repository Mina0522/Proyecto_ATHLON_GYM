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

    private JPanel panel_botones, panel_info, panelinfo2;
    private JButton noti, confi, report, credencial,  edit_info, eli_info, back;
    private JLabel text_inicio, text_, user, text_nom2, text_report;
    
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
        
        // ==
        edit_info = new JButton("Editar");
        edit_info.setBounds(20, 230, 150, 40);
        edit_info.setFont(new Font("Arial", Font.BOLD, 22));
        edit_info.setBackground(Color.lightGray);
        edit_info.setForeground(Color.black);
        edit_info.setFocusPainted(false);
        edit_info.addActionListener(e -> {
            menu_inicio.pintar_vista(new Editar_Instructor(menu_inicio, trainer.getId()).getPanel());
        });

        panel_info.add(edit_info);
        
        eli_info = new JButton("Eliminar");
        eli_info.setBounds(220, 230, 150, 40);
        eli_info.setFont(new Font("Arial", Font.BOLD, 22));
        eli_info.setBackground(Color.BLACK);
        eli_info.setForeground(Color.WHITE);
        eli_info.setFocusPainted(false);
        eli_info.addActionListener(e -> {
            int opcion = JOptionPane.showConfirmDialog(
                null,
                "¿Estás seguro de que deseas eliminar a este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if (opcion == JOptionPane.YES_OPTION) {
                controller.deleteTrainer(trainer.getId());
                JOptionPane.showMessageDialog(
                    null,
                    "Usuario eliminado correctamente.",
                    "Eliminación exitosa",
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());

            } else {
                JOptionPane.showMessageDialog(
                    null,
                    "Se canceló la eliminación.",
                    "Operación cancelada",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        panel_info.add(eli_info);
      
		// ===
        text_nom2 = new JLabel("Historial de clases", SwingConstants.CENTER);
        text_nom2.setOpaque(true);
        text_nom2.setBackground(Color.BLACK);
        text_nom2.setForeground(Color.WHITE);
        text_nom2.setFont(new Font("Arial", Font.BOLD, 22));
        text_nom2.setBounds(20, 315, 365, 35);
        panel_info.add(text_nom2);

        String[] columnas2 = {"Fecha", "Clase"};

        DefaultTableModel modelo2 = new DefaultTableModel(null, columnas2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable tabla2 = new JTable(modelo2);
        tabla2.setFont(new Font("Arial", Font.PLAIN, 16));
        tabla2.setRowHeight(28);
        tabla2.setForeground(Color.BLACK);
        tabla2.setBackground(Color.WHITE);

        JTableHeader header2 = tabla2.getTableHeader();
        header2.setPreferredSize(new Dimension(header2.getWidth(), 30));
        header2.setFont(new Font("Arial", Font.BOLD, 20));
        header2.setBackground(Color.BLACK);
        header2.setForeground(Color.WHITE);

        JScrollPane scroll2 = new JScrollPane(tabla2);
        scroll2.setBounds(20, 350, 365, 130);
        panel_info.add(scroll2);
        controller.fillTrainerClassesTable(trainer.getId(), modelo2);
        
		// ===
		panelinfo2 = new JPanel();
		panelinfo2.setBackground(Color.WHITE);
		panelinfo2.setBounds(775, 110, 400, 520);
		panelinfo2.setLayout(null);
		menu.add(panelinfo2);
		
        text_report = new JLabel("Documentacion", SwingConstants.CENTER);
        text_report.setFont(new Font("Arial", Font.BOLD, 25));
        text_report.setForeground(Color.black);
        text_report.setBounds(0, 20, panel_info.getWidth(), 50);
        panelinfo2.add(text_report);
		
        report = new JButton("Descargar reporte (PDF)");
        report.setBounds(50, 100, 300, 50);
        report.setFont(new Font("Arial", Font.BOLD, 18));
        report.setBackground(Color.lightGray);
        report.setForeground(Color.black);
        report.setFocusPainted(false);
        report.setLayout(null);
        report.addActionListener(e -> {
	        controller.generateTrainerReportPDF(trainer.getId()); 
	        JOptionPane.showMessageDialog(null,
	            "El reporte se descargó correctamente.",
	            "Éxito",
	            JOptionPane.INFORMATION_MESSAGE);
    	   
        });
        panelinfo2.add(report);
        
        credencial = new JButton("Descargar credencial (PDF)");
        credencial.setBounds(50, 200, 300, 50);
        credencial.setFont(new Font("Arial", Font.BOLD, 18));
        credencial.setBackground(Color.lightGray);
        credencial.setForeground(Color.black);
        credencial.setFocusPainted(false);
        credencial.addActionListener(e -> {
	        controller.generateTrainerPDF(trainer.getId()); 
	        JOptionPane.showMessageDialog(null,
	            "El reporte se descargó correctamente.",
	            "Éxito",
	            JOptionPane.INFORMATION_MESSAGE);
    	   
        });
        panelinfo2.add(credencial);
		
        back = new JButton("Volver");
        back.setBounds(220, 440, 150, 50);
        back.setFont(new Font("Arial", Font.BOLD, 22));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel());
        });
        panelinfo2.add(back);
        
        return menu;
    }
}
