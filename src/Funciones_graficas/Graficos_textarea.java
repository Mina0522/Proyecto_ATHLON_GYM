package Funciones_graficas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Graficos_textarea extends JTextArea {

    private Dimension d = new Dimension(200, 80); // Más alto que JTextField por ser un área de texto
    private String placeholder = "";
    private Color phColor = new Color(0, 0, 0);
    private boolean band = true;

    public Graficos_textarea() {
        super();
        setLineWrap(true);
        setWrapStyleWord(true);
        setSize(d);
        setPreferredSize(d);
        setVisible(true);
        setMargin(new Insets(6, 6, 6, 6));

        getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                band = getText().isEmpty();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                band = getText().isEmpty();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                band = getText().isEmpty();
            }
        });
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public Color getPhColor() {
        return phColor;
    }

    public void setPhColor(Color phColor) {
        this.phColor = phColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (band && !placeholder.isEmpty()) {
            g.setColor(new Color(phColor.getRed(), phColor.getGreen(), phColor.getBlue(), 90));
            Insets ins = getInsets();
            g.drawString(placeholder, ins.left + 2, ins.top + g.getFontMetrics().getAscent());
        }
    }
}
