package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.CheckinController;
import Controller.LoginController;
import Controller.UserController;
import Funciones_graficas.Graficos;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Model.AuthModel;
import Model.ClassModel;
import Model.PaymentModel;
import Model.User;
import Model.UserModel;
import Model.UserWithLastPayment;

public class Pantalla_Checador {
	
	private Graficos_texto campo_usuario;

	// === Creamos nuestra ventana de tipo Vista_GYM.
	private Vista_GYM checador;
	private CheckinController controlador;
	private UserController  controlador2;

	// === Aqui se crean los elementos que utilizaremos
	public JPanel panel_inicio;
	public Graficos_fondo panel_login;
	public JLabel img, text_inicio, img_logo;
	public JButton btn_entrar, btn_comentario, btn_volver;
	
	// === Constructor de View_loginGYM.
	public Pantalla_Checador(Vista_GYM log) {
		checador = log;
		controlador = new CheckinController();
		UserModel userModel = new UserModel();
        PaymentModel paymentModel = new PaymentModel();
        ClassModel classModel = new ClassModel();
        controlador2 = new UserController(userModel, paymentModel, classModel);
	}
	
	// === Metodo que construye y lo devuelve a la ventana principal.
	public JPanel getPanel() {
		
		// === Panel que contendra nuestros elementos.
		panel_login = new Graficos_fondo("files/fondo_logo.png");
		panel_login.setLayout(null);
		panel_login.agregarImagen("files/logoATHLON_cn.png", 460, 40, 380, 135);

		// === Colocamos el panel en  y lo añadimos al panel del login.
		panel_inicio = new JPanel();
		panel_inicio.setBackground(Color.WHITE);
		panel_inicio.setBounds(402, 190, 500, 430);
		panel_inicio.setLayout(null);
		panel_login.add(panel_inicio);
		
		// === Elementos.
		text_inicio = new JLabel("Checador");
		text_inicio.setFont(new Font("Arial", Font.BOLD, 40));
		text_inicio.setBounds(160, 50, 500, 50);
        panel_inicio.add(text_inicio);
        
        // === Campos de usuario y contraseña personalizados. 
        campo_usuario = new Graficos_texto();
        campo_usuario.setPlaceholder(" Ingresa tu numero de control");
        campo_usuario.setBounds(50, 140, 390, 50);
        campo_usuario.setBackground(Color.lightGray);
        campo_usuario.setFont(new Font("Arial", Font.PLAIN, 18));
        campo_usuario.setBorder(null);
        panel_inicio.add(campo_usuario);

        // === Boton que nos lleva a la pantalla inicial.
        btn_entrar = new JButton("Checar entrada");
        btn_entrar.setBounds(50, 250, 390, 55);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 22));
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
            String texto = campo_usuario.getText();

            try {
                int numero = Integer.parseInt(texto);
                Object usuario = controlador.checkUser(numero);  
                if (usuario == null) {
                    JOptionPane.showMessageDialog(null, "No se encontró el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    User usuario2 = controlador2.getUser(numero);
                    checador.pintar_vista(new Checador(checador,usuario2).getPanel());
                }

            } catch (NumberFormatException o) {
                System.out.println("El valor ingresado no es un número entero válido.");
            }
        });
        panel_inicio.add(btn_entrar);
        
//        btn_comentario = new JButton("Dejar comentario");
//        btn_comentario.setBounds(50, 350, 390, 55);
//        btn_comentario.setFont(new Font("Arial", Font.BOLD, 22));
//        btn_comentario.setForeground(Color.black);
//        btn_comentario.setContentAreaFilled(false);
//        btn_comentario.setFocusPainted(false);
//        btn_comentario.setBorderPainted(false);
//        panel_inicio.add(btn_comentario);
        
		// === Boton para volver al inicio
		ImageIcon icono_noti = new ImageIcon(getClass().getResource("/files/volver.png"));
		btn_volver = new JButton(icono_noti);
		btn_volver.setBounds(20, 580, 51, 51);
		btn_volver.setBorderPainted(false);
		btn_volver.setContentAreaFilled(false);
		btn_volver.setFocusPainted(false);
		btn_volver.setOpaque(false);
        btn_volver.addActionListener(e -> {
        	checador.pintar_vista(new Pantalla_Inicio(checador).getPanel());
        });
        panel_login.add(btn_volver);
        
        // Agregamos la imagen al panel principal.
		return panel_login;
	}
}