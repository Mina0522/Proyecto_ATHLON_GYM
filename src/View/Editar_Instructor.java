
package View;

import javax.swing.*;

import Controller.TrainerController;

import java.awt.*;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.ComboObject;
import Model.Trainer;
import Model.TrainerModel;

public class Editar_Instructor {

    private Vista_GYM menu_inicio;
    private JPanel menu;

    private JPanel panel_botones, panel_agg;
    private JButton noti, confi, editar, cancelar;
    private JLabel user, text;
    
    TrainerModel modelTrainer = new TrainerModel();
    ClassModel cTrainer = new ClassModel();
    
    TrainerController controller = new TrainerController(modelTrainer, cTrainer);
    private int trainerId;

    public Editar_Instructor(Vista_GYM log, int trainerId) {
        this.menu_inicio = log;
        this.trainerId = trainerId;
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
		
		Trainer trainer = controller.getTrainer(trainerId);
		
        Graficos_texto nombre = new Graficos_texto();
        nombre.setText(trainer.getName());
        nombre.setBounds(225, 200, 415, 40);
        nombre.setBackground(Color.lightGray);
        nombre.setFont(new Font("Arial", Font.PLAIN, 18));
        nombre.setBorder(null);
        panel_agg.add(nombre);
        
        Graficos_texto correo = new Graficos_texto();
        correo.setText(trainer.getEmail());
        correo.setBounds(225, 260, 415, 40);
        correo.setBackground(Color.lightGray);
        correo.setFont(new Font("Arial", Font.PLAIN, 18));
        correo.setBorder(null);
        panel_agg.add(correo);
        
        Graficos_texto tel = new Graficos_texto();
        tel.setText(trainer.getPhone_number());
        tel.setBounds(225, 320, 415, 40);
        tel.setBackground(Color.lightGray);
        tel.setFont(new Font("Arial", Font.PLAIN, 18));
        tel.setBorder(null);
        panel_agg.add(tel);
        
        JComboBox<ComboObject> comboTipo = new JComboBox<>();
        comboTipo.addItem(new ComboObject(1, "General"));
        comboTipo.addItem(new ComboObject(2, "Personal"));
        comboTipo.setBounds(225, 380, 415, 40);
        comboTipo.setFont(new Font("Arial", Font.PLAIN, 18));
        comboTipo.setBackground(Color.lightGray);
        panel_agg.add(comboTipo);

        int tipo = trainer.getType();
        for (int i = 0; i < comboTipo.getItemCount(); i++) {
            ComboObject item = (ComboObject) comboTipo.getItemAt(i);
            if (item.getId() == tipo) {
                comboTipo.setSelectedIndex(i);
                break;
            }
        }

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