package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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

import Controller.LoginController;
import Funciones_graficas.Graficos;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Model.AuthModel;

public class View_loginGYM {
	
	// === Creamos nuestra ventana de tipo Vista_GYM.
	private Vista_GYM iniciar_sesion;
	private LoginController controller;
	private AuthModel model;

	// === Aqui se crean los elementos que utilizaremos
	public JPanel panel_inicio;
	public Graficos_fondo panel_login;
	public JLabel img, text_inicio, img_logo;
	public JButton btn_entrar, btn_olvido_contra;
	
	// === Constructor de View_loginGYM.
	public View_loginGYM(Vista_GYM log) {
		iniciar_sesion = log;
		model = new AuthModel();
		controller = new LoginController(View_loginGYM.this, model);
	}
	// === Metodo que construye y lo devuelve a la ventana principal.
	public JPanel getPanel() {
		
		// === Panel que contendra nuestros elementos.
		panel_login = new Graficos_fondo("files/fondo_logo.png");
		panel_login.setLayout(null);
    	Color colorGris = Color.decode("#D9D9D9");
		panel_login.agregarImagen("files/logoATHLON_cn.png",460, 40, 380,135);
		

		// === Colocamos el panel en  y lo añadimos al panel del login.
		panel_inicio = new JPanel();
		panel_inicio.setBackground(Color.WHITE);
		panel_inicio.setBounds(402, 190, 490, 400);
		panel_inicio.setLayout(null);
		panel_login.add(panel_inicio);
		
		// === Elementos.
		text_inicio = new JLabel("Iniciar sesión");
		text_inicio.setFont(new Font("Arial", Font.BOLD, 45));
		text_inicio.setBounds(105, 28, 290, 50);
        panel_inicio.add(text_inicio);
        
        // === Campos de usuario y contraseña personalizados. 
        Graficos_texto campo_usuario = new Graficos_texto();
        campo_usuario.setPlaceholder(" Ingresa tu usuario");
        campo_usuario.setBounds(50, 115, 390, 50);
        campo_usuario.setBackground(colorGris);
        campo_usuario.setFont(new Font("Arial", Font.PLAIN, 18));
        campo_usuario.setBorder(null);
        panel_inicio.add(campo_usuario);
        
        Graficos campo_contra = new Graficos();
        campo_contra.setPlaceholder(" Ingresa tu contraseña");
        campo_contra.setEchoChar('*');
        campo_contra.setBounds(50, 195, 390, 50);
        campo_contra.setFont(new Font("Arial", Font.PLAIN, 18));
        campo_contra.setBorder(null);
        campo_contra.setBackground(colorGris);
        panel_inicio.add(campo_contra);

        // === Boton que nos lleva a la pantalla inicial.
        btn_entrar = new JButton("Iniciar sesión");
        btn_entrar.setBounds(50, 290, 390, 60);
        btn_entrar.setFont(new Font("Arial", Font.BOLD, 28));
        btn_entrar.setBackground(Color.BLACK);
        btn_entrar.setForeground(Color.WHITE);
        btn_entrar.setFocusPainted(false);
        btn_entrar.addActionListener(e -> {
            String correo = campo_usuario.getText().trim();
            String contrasena = new String(campo_contra.getPassword()).trim();

            // === Validamos que no haya campos vacios.
            if (correo.isEmpty() || contrasena.isEmpty()) {
            	campo_usuario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                campo_contra.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "¡Campos incompletos!");
                return;
            }
            // === Validamos contraseñas correctas.
            if (controller.auth(correo, contrasena)) {
                iniciar_sesion.pintar_vista(new Pantalla_Inicio(iniciar_sesion).getPanel());
            } else {
            	campo_usuario.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
            	campo_contra.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.");
            }
        });
        panel_inicio.add(btn_entrar);

        // Agregamos la imagen al panel principal.
		return panel_login;
	}
}