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
import javax.swing.JTextArea;
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
	public JPanel panel_inicio, panel_info, panel_info_dos, panel_negro, panel_nero;
	public Graficos_fondo panel_login;
	public JLabel img, text_inicio, img_logo, text_, text_clase, text_fecha;
	public JButton btn_entrar, btn_comentario, btn_volver;
	public JTextArea info_clase, info_fecha; 
	
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
		panel_login.agregarImagen("files/logoATHLON_cn.png", 460, 40, 380,135);

		// === Colocamos el panel en  y lo añadimos al panel del login.
		panel_inicio = new JPanel();
		panel_inicio.setBackground(Color.WHITE);
		panel_inicio.setBounds(402, 190, 550, 445);
		panel_inicio.setLayout(null);
		panel_login.add(panel_inicio);
		
		// === Elementos.
		ImageIcon icono_user = new ImageIcon(getClass().getResource("/files/usuario.png"));
		img_logo = new JLabel(icono_user);
		img_logo.setBounds(220, 15, 128, 128);
		panel_inicio.add(img_logo);
		
		text_inicio = new JLabel("Admin");
		text_inicio.setFont(new Font("Arial", Font.BOLD, 40));
		text_inicio.setForeground(Color.BLACK);
		text_inicio.setBounds(220, 145, 500, 50);
        panel_inicio.add(text_inicio);
        
        text_ = new JLabel("P l a n  a d m i n");
        text_.setFont(new Font("Arial", Font.BOLD, 20));
        text_.setForeground(Color.GRAY);
        text_.setBounds(200, 175, 500, 50);
        panel_inicio.add(text_);
		
        // === Panel 1
        panel_info = new JPanel();
        panel_info.setBackground(Color.lightGray);
        panel_info.setBounds(25, 250, 230, 170);
        panel_info.setLayout(null);
        panel_inicio.add(panel_info);

        // == Franja negra del panel 1
        panel_negro = new JPanel();
        panel_negro.setBackground(Color.black);
        panel_negro.setBounds(0, 0, 230, 30);
        panel_info.add(panel_negro);
        
        text_clase = new JLabel("Clases");
        text_clase.setForeground(Color.white);
        text_clase.setBounds(10, 5, 100, 20);
        text_clase.setFont(new Font("Arial", Font.BOLD, 20));
        panel_negro.add(text_clase);
        
        info_clase = new JTextArea("No tienes clases\nprogramadas hoy.");
        info_clase.setBounds(10, 40, 210, 50);
        info_clase.setFont(new Font("Arial", Font.PLAIN, 20));
        info_clase.setEditable(false);
        info_clase.setOpaque(false);
        info_clase.setFocusable(false);
        info_clase.setBorder(null);
        panel_info.add(info_clase);

        // === Panel 2
        panel_info_dos = new JPanel();
        panel_info_dos.setBackground(Color.lightGray);
        panel_info_dos.setBounds(290, 250, 230, 170);
        panel_info_dos.setLayout(null);
        panel_inicio.add(panel_info_dos);

        // == Franja negra del panel 2
        panel_nero = new JPanel();
        panel_nero.setBackground(Color.black);
        panel_nero.setBounds(0, 0, 230, 30); 
        panel_info_dos.add(panel_nero);
        
        text_fecha = new JLabel("Fecha de pago");
        text_fecha.setForeground(Color.white);
        text_fecha.setBounds(10, 5, 150, 20);
        text_fecha.setFont(new Font("Arial", Font.BOLD, 20));
        panel_nero.add(text_fecha);
        
        info_fecha = new JTextArea("Tu fecha de pago\nes en 12 dias");
        info_fecha.setBounds(10, 40, 210, 50);
        info_fecha.setFont(new Font("Arial", Font.PLAIN, 20));
        info_fecha.setEditable(false);
        info_fecha.setOpaque(false);
        info_fecha.setFocusable(false);
        info_fecha.setBorder(null);
        panel_info_dos.add(info_fecha);
		
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