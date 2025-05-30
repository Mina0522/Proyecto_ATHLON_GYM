package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista_GYM extends JFrame {

    private JPanel panel_contenedor;
    
    // === Constructor que se ejecutara cada que se cree un objeto de tipo Vista_GYM.
    public Vista_GYM() {
        setTitle("ATHLON GYM");
        setSize(1280, 700);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel_contenedor = new JPanel();
        panel_contenedor.setLayout(null);
        panel_contenedor.setBounds(0, 0, 1280, 700);
        add(panel_contenedor);

        pintar_vista(new View_loginGYM(this).getPanel());

        setVisible(true);
    }
    
    // === Metodo que nos ayudara a cambiar de vista. 
    public void pintar_vista(JPanel panel_principal) {
        panel_contenedor.removeAll();
        panel_principal.setBounds(0, 0, 1280, 700);
        panel_contenedor.add(panel_principal);
        panel_contenedor.revalidate();
        panel_contenedor.repaint();
    }
}
