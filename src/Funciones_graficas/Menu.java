package Funciones_graficas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Menu {

    private Graficos_fondo panelMenu;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private ArrayList<JButton> listaBotones = new ArrayList<>();
    public String seccion;

    public Menu(String seccion) {
        this.seccion = seccion;
        panelMenu = new Graficos_fondo();
        panelMenu.setLayout(null);
        panelMenu.setPreferredSize(new Dimension(250, screenSize.height));
        panelMenu.agregarImagen("files/logoATHLON_cb.png", 30, 40, 170, 75);
        panelMenu.setBackground(Color.BLACK);
    }

    public void configurarBotonMenu(String texto, ActionListener accion) {
        int y = 200 + listaBotones.size() * 70;
        JButton boton = new JButton(texto);
        boton.setBounds(15, y, 220, 60);
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(true);
        boton.setForeground(Color.WHITE);
        boton.setBackground(Color.BLACK);
        boton.setFont(new Font("Arial", Font.BOLD, 33));
        boton.setHorizontalAlignment(SwingConstants.LEFT);

        boton.addActionListener(e -> {
            this.seccion = boton.getText(); 
            resetearEstilos();
            pintarBoton();
        });

        listaBotones.add(boton);
        panelMenu.add(boton);

        pintarBoton();
        
    }

    public void pintarBoton() {
        for (JButton boton : listaBotones) {
            if (boton.getText().equals(seccion)) {
                boton.setContentAreaFilled(true);
                boton.setOpaque(true);
                boton.setForeground(Color.BLACK);
                boton.setBackground(Color.WHITE);
                boton.setFont(new Font("Arial", Font.BOLD, 39));
            }
        }
    }
    
    private void resetearEstilos() {
        for (JButton boton : listaBotones) {
            boton.setContentAreaFilled(false);
            boton.setForeground(Color.WHITE);
            boton.setBackground(Color.BLACK);
            boton.setFont(new Font("Arial", Font.BOLD, 33));
        }
    }

    public JPanel obtenerPanel() {
        return panelMenu;
    }
}