package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.MembershipController;
import Controller.TrainerController;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;

import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Funciones_graficas.Menu;
import Model.ClassModel;
import Model.ComboObject;
import Model.TrainerModel;

public class Pantalla_Planes_Crear {

    private Vista_GYM menu_inicio;
    private JPanel menu_user, panel, panel_negro, panel_botones;
    private JButton noti, confi, btn_crear, btn_edit, btn_deta, btn_eliminar, btn, volver;
    private JLabel text;
    public MembershipController controladorMem;
    public TrainerController controladorTrainer;
    TrainerModel trainerModel;
	ClassModel classModel;

    
    public Pantalla_Planes_Crear(Vista_GYM log) {
        this.menu_inicio = log;
        trainerModel = new TrainerModel();
        classModel = new ClassModel();
        controladorMem = new MembershipController();
    	controladorTrainer = new TrainerController(trainerModel,classModel);
    }

    public JPanel getPanel() {
    	
    	try {
    	    UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
    	} catch (UnsupportedLookAndFeelException e1) {
    	    e1.printStackTrace();
    	}
    	
    	
    	Color colorGris = Color.decode("#D9D9D9");
        menu_user = new JPanel();
        menu_user.setLayout(null);
        menu_user.setBackground(colorGris);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        menu_user.setSize(pantalla);

        // === MENU ===
        Menu botones = new Menu("Planes");
        panel_botones = botones.obtenerPanel();
        panel_botones.setBounds(0, 0, 250, 1080);
        menu_user.add(panel_botones);

        botones.configurarBotonMenu("Inicio", e -> menu_inicio.pintar_vista(new Pantalla_Inicio(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Usuarios", e -> menu_inicio.pintar_vista(new Pantalla_Usuarios(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Personal", e -> menu_inicio.pintar_vista(new Pantalla_Instructores(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Planes", e -> menu_inicio.pintar_vista(getPanel()));
        botones.configurarBotonMenu("Checador", e -> menu_inicio.pintar_vista(new Pantalla_Checador(menu_inicio).getPanel()));
        botones.configurarBotonMenu("Salir", e -> menu_inicio.pintar_vista(new View_loginGYM(menu_inicio).getPanel()));

        // ==
        JSeparator separador = new JSeparator(SwingConstants.HORIZONTAL);
        separador.setBounds(250, 95, 1030, 2);
        separador.setForeground(Color.BLACK);
        menu_user.add(separador);

        // == boton crear plan
        ImageIcon agg = new ImageIcon(getClass().getResource("/files/agregar_cb.png"));
        Image modi = agg.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(modi);

        btn_crear = new JButton("Crear plan");
        btn_crear.setIcon(icono);
        btn_crear.setBounds(300, 120, 420, 90);
        btn_crear.setFont(new Font("Arial", Font.BOLD, 32));
        btn_crear.setBorderPainted(false);
        btn_crear.setHorizontalAlignment(SwingConstants.LEFT);
        btn_crear.setIconTextGap(30);
        btn_crear.setFocusPainted(false);
        btn_crear.setOpaque(true);
        btn_crear.setBackground(Color.BLACK);
        btn_crear.setForeground(Color.WHITE);
        btn_crear.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes_Crear(menu_inicio).getPanel());
        });
        menu_user.add(btn_crear);

		// == boton editar plan
        ImageIcon edit = new ImageIcon(getClass().getResource("/files/crear.png"));
        Image modi_edit = edit.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_edit = new ImageIcon(modi_edit);

        btn_edit = new JButton("Editar plan");
        btn_edit.setIcon(icono_edit);
        btn_edit.setBounds(775, 120, 420, 90);
        btn_edit.setFont(new Font("Arial", Font.BOLD, 32));
        btn_edit.setBorderPainted(false);
        btn_edit.setHorizontalAlignment(SwingConstants.LEFT);
        btn_edit.setIconTextGap(30);
        btn_edit.setFocusPainted(false);
        btn_edit.setOpaque(true);
        btn_edit.setBackground(Color.WHITE);
        btn_edit.setForeground(Color.BLACK);
        btn_edit.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes_Editar(menu_inicio).getPanel());
        });
        menu_user.add(btn_edit);
        
		// == boton consultar registro
        ImageIcon deta = new ImageIcon(getClass().getResource("/files/buscar_usuario.png"));
        Image modi_deta = deta.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_deta = new ImageIcon(modi_deta);

        btn_deta = new JButton("Consultar plan");
        btn_deta.setIcon(icono_deta);
        btn_deta.setBounds(775, 230, 420, 90);
        btn_deta.setFont(new Font("Arial", Font.BOLD, 32));
        btn_deta.setBorderPainted(false);
        btn_deta.setHorizontalAlignment(SwingConstants.LEFT);
        btn_deta.setIconTextGap(30);
        btn_deta.setFocusPainted(false);
        btn_deta.setOpaque(true);
        btn_deta.setBackground(Color.WHITE);
        btn_deta.setForeground(Color.BLACK);
        btn_deta.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes_Consultar(menu_inicio).getPanel());
        });
        menu_user.add(btn_deta);
		
		// == boton eliminar plan
        ImageIcon eliminar = new ImageIcon(getClass().getResource("/files/basura.png"));
        Image modi_eliminar = eliminar.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon icono_eliminar = new ImageIcon(modi_eliminar);

        btn_eliminar = new JButton("Eliminar plan");
        btn_eliminar.setIcon(icono_eliminar);
        btn_eliminar.setBounds(300, 230, 420, 90);
        btn_eliminar.setFont(new Font("Arial", Font.BOLD, 32));
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setHorizontalAlignment(SwingConstants.LEFT);
        btn_eliminar.setIconTextGap(30);
        btn_eliminar.setFocusPainted(false);
        btn_eliminar.setOpaque(true);
        btn_eliminar.setBackground(Color.WHITE);
        btn_eliminar.setForeground(Color.BLACK);
        btn_eliminar.addActionListener(e -> {
            menu_inicio.pintar_vista(new Pantalla_Planes_Eliminar(menu_inicio).getPanel());
        });
        menu_user.add(btn_eliminar);
		
        // === 
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(300, 335, 900, 300);
		panel.setLayout(null);
		menu_user.add(panel);
		
		panel_negro = new JPanel();
		panel_negro.setBackground(Color.black);
		panel_negro.setBounds(0, 0, 900, 60);
		panel_negro.setLayout(null);
		panel.add(panel_negro);
		
        text = new JLabel("Crear de plan");
        text.setFont(new Font("Arial", Font.BOLD, 35));
        text.setForeground(Color.white);
        text.setBounds(20, 5, 500, 45);
        text.setLayout(null);
        panel_negro.add(text);
        
        // ====
        Graficos_texto nombrePlan = new Graficos_texto();
        nombrePlan.setPlaceholder(" Nombre del plan");
        nombrePlan.setBounds(30, 80, 330, 50);
        nombrePlan.setBackground(colorGris);
        nombrePlan.setFont(new Font("Arial", Font.PLAIN, 18));
        nombrePlan.setBorder(null);
        panel.add(nombrePlan);
        
        Graficos_texto precio = new Graficos_texto();
        precio.setPlaceholder(" Precio");
        precio.setBounds(30, 150, 330, 50);
        precio.setBackground(colorGris);
        precio.setFont(new Font("Arial", Font.PLAIN, 18));
        precio.setBorder(null);
        panel.add(precio);
        
        
        
        Graficos_texto promo = new Graficos_texto();
        promo.setPlaceholder(" Dias que dura el plan");
        promo.setBounds(30, 220, 330, 50);
        promo.setBackground(colorGris);
        promo.setFont(new Font("Arial", Font.PLAIN, 18));
        promo.setBorder(null);
        panel.add(promo);
        
        
        JComboBox<ComboObject> comboBoxTrainer = controladorTrainer.getTrainerCombo();
        comboBoxTrainer.setForeground(Color.GRAY);
        comboBoxTrainer.insertItemAt(new ComboObject(-1, "Selecciona un entrenador"), 0);
        comboBoxTrainer.setSelectedIndex(0); 
        comboBoxTrainer.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ComboObject selected = (ComboObject) comboBoxTrainer.getSelectedItem();
                if (selected != null && selected.getId() != -1) {
                    comboBoxTrainer.setForeground(Color.BLACK);  
                } else {
                    comboBoxTrainer.setForeground(Color.GRAY);  
                }
            }
        });

        comboBoxTrainer.setBounds(500, 80, 330, 50);
        comboBoxTrainer.setBackground(colorGris);
        comboBoxTrainer.setFont(new Font("Arial", Font.PLAIN, 18));
        comboBoxTrainer.setBorder(null);
        comboBoxTrainer.setEditable(false);  
        panel.add(comboBoxTrainer);
        
       
        
        JComboBox<String> comboInvitacion = new JComboBox<>(new String[]{"Selecciona una opción", "Sí", "No"});
        comboInvitacion.setSelectedIndex(0); 
        comboInvitacion.setForeground(Color.GRAY);
        comboInvitacion.setBackground(colorGris);
        comboInvitacion.setFont(new Font("Arial", Font.PLAIN, 18));
        comboInvitacion.setEditable(false);
        comboInvitacion.setBounds(500, 150, 330, 50);
        panel.add(comboInvitacion);

        comboInvitacion.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selected = (String) comboInvitacion.getSelectedItem();
                if (!selected.equals("Selecciona una opción")) {
                    comboInvitacion.setForeground(Color.BLACK);  
                } else {
                    comboInvitacion.setForeground(Color.GRAY);  
                }
            }
        });

        
        volver = new JButton("Volver");
        volver.setBounds(500, 230, 150, 50);
        volver.setFont(new Font("Arial", Font.BOLD, 22));
        volver.setBackground(Color.GRAY);
        volver.setForeground(Color.black);
        volver.setBorderPainted(false);
        volver.setFocusPainted(false);
        volver.addActionListener(e -> {
        	menu_inicio.pintar_vista(new Pantalla_Planes(menu_inicio).getPanel());
        });
        panel.add(volver);
        
        btn = new JButton("Enviar");
        btn.setBounds(680, 230, 150, 50);
        btn.setFont(new Font("Arial", Font.BOLD, 22));
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.addActionListener(e -> {
            String nombreP     = nombrePlan.getText().trim();
            String textoPrecio = precio.getText().trim();
            String textoDias   = promo.getText().trim();

           
            if (nombreP.isEmpty()) {
                JOptionPane.showMessageDialog(menu_user, "Debes ingresar un nombre para el plan.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!nombreP.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
                JOptionPane.showMessageDialog(menu_user, "El nombre sólo puede contener letras y espacios.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            if (textoPrecio.isEmpty()) {
                JOptionPane.showMessageDialog(menu_user, "Debes ingresar un precio.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (textoDias.isEmpty()) {
                JOptionPane.showMessageDialog(menu_user, "Debes ingresar la duración en días.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
                return;
            }
 
            Object selObj = comboBoxTrainer.getSelectedItem();
            if (!(selObj instanceof ComboObject) || ((ComboObject) selObj).getId() == -1) {
                JOptionPane.showMessageDialog(menu_user,
                    "Debes seleccionar un entrenador válido de la lista.",
                    "Entrenador no seleccionado",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            int trainerId = ((ComboObject) selObj).getId();

            
            String selInv = (String) comboInvitacion.getSelectedItem();
            if (selInv.equals("Selecciona una opción")) {
                JOptionPane.showMessageDialog(menu_user,
                    "Debes seleccionar si deseas pase de invitación (Sí o No).",
                    "Pase de invitación no seleccionado",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }

           
            double precioP;
            try {
                precioP = Double.parseDouble(textoPrecio);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(menu_user, "El precio debe ser un número válido.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
                return;
            }

           
            int diasP;
            try {
                diasP = Integer.parseInt(textoDias);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(menu_user, "La duración debe ser un número entero válido.", "Formato incorrecto", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            boolean tienePase = selInv.equalsIgnoreCase("Sí");

           
            controladorMem.createMembership(
                nombreP,
                precioP,
                diasP,
                trainerId,
                tienePase
            );

            JOptionPane.showMessageDialog(menu_user, "Plan creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            menu_inicio.pintar_vista(new Pantalla_Planes(menu_inicio).getPanel());
        });


        panel.add(btn);
        
		return menu_user;
	}

}