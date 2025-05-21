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

import Controller.LoginController;
import Funciones_graficas.Graficos;
import Funciones_graficas.Graficos_fondo;
import Funciones_graficas.Graficos_texto;
import Model.AuthModel;

public class Checador {
	
	// === Creamos nuestra ventana de tipo Vista_GYM.
	private Vista_GYM checador;
	private LoginController controller;
	private AuthModel model;

	// === Aqui se crean los elementos que utilizaremos
	public JPanel panel_inicio;
	public Graficos_fondo panel_login;
	public JLabel img, text_inicio, img_logo;
	public JButton btn_entrar, btn_comentario, btn_volver;
	
	// === Constructor de View_loginGYM.
	public Checador(Vista_GYM log) {
		checador = log;
		model = new AuthModel();
	}
	
	// === Metodo que construye y lo devuelve a la ventana principal.
	public JPanel getPanel() {
		
		// === Panel que contendra nuestros elementos.
		panel_login = new Graficos_fondo("files/fondo_logo.png");
		panel_login.setLayout(null);
		panel_login.agregarImagen("files/logoATHLON_cn.png",500, 55, 380,135);

		// === Colocamos el panel en  y lo añadimos al panel del login.
		panel_inicio = new JPanel();
		panel_inicio.setBackground(Color.WHITE);
		panel_inicio.setBounds(445, 225, 500, 470);
		panel_inicio.setLayout(null);
		panel_login.add(panel_inicio);
		
		// === Elementos.
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/usuario.png"));
		img_logo = new JLabel(icono_user);
		img_logo.setBounds(210, 35, 64, 64);
		panel_inicio.add(img_logo);

        // ===================================================================================
		// === Boton para volver al inicio
		ImageIcon icono_noti = new ImageIcon(getClass().getResource("/files/volver.png"));
		btn_volver = new JButton(icono_noti);
		btn_volver.setBounds(20, 650, 51, 51);
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