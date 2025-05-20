package Funciones_graficas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Graficos_fondo extends JPanel {
    private Image imagenFondo;

    private static class ImagenExtra {
        Image imagen;
        int x, y, ancho, alto;

        ImagenExtra(String ruta, int x, int y, int ancho, int alto) {
            this.imagen = new ImageIcon(Graficos_fondo.class.getClassLoader().getResource(ruta)).getImage();
            this.x = x;
            this.y = y;
            this.ancho = ancho;
            this.alto = alto;
        }
    }

    private List<ImagenExtra> imagenesExtras = new ArrayList<>();

    public Graficos_fondo(String rutaFondo) {
        this.imagenFondo = new ImageIcon(getClass().getClassLoader().getResource(rutaFondo)).getImage();
        setLayout(null);
    }
    public Graficos_fondo() {
        
    }

    public void agregarImagen(String rutaImagen, int x, int y, int ancho, int alto) {
        imagenesExtras.add(new ImagenExtra(rutaImagen, x, y, ancho, alto));
        repaint(); // Forzar repintado
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);

        // Dibujar imágenes extra encima
        for (ImagenExtra img : imagenesExtras) {
            g.drawImage(img.imagen, img.x, img.y, img.ancho, img.alto, this);
        }
    }
}