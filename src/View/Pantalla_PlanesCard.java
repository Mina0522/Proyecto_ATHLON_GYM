package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import Controller.MembershipController;
import Funciones_graficas.Graficos_fondo;
import Model.Membership;
import Model.ComboObject;

public class Pantalla_PlanesCard {
    private final JPanel root;
    private final CardLayout cardLayout;

    public Pantalla_PlanesCard(MembershipController controller) {
        root = new JPanel(new BorderLayout());
        cardLayout = new CardLayout();
        initUI(controller);
    }

    private void initUI(MembershipController controller) {
        JPanel cards = new JPanel(cardLayout);
        
        List<Membership> plans = controller.getAllMemberships();
        for (Membership m : plans) {
            cards.add(createCard(m), String.valueOf(m.getId()));
        }

        JButton btnPrev = new JButton("←");
        JButton btnNext = new JButton("→");
        btnPrev.setForeground(Color.white);
        btnPrev.setBackground(Color.black);
        btnPrev.setBorderPainted(false);
        btnNext.setBorderPainted(false);
        btnNext.setForeground(Color.white);
        btnNext.setBackground(Color.black);
        btnPrev.setFont(new Font("Arial", Font.BOLD, 35));
        btnNext.setFont(new Font("Arial", Font.BOLD, 35));
        btnPrev.addActionListener(e -> cardLayout.previous(cards));
        btnNext.addActionListener(e -> cardLayout.next(cards));

        JPanel nav = new JPanel(new BorderLayout());
        nav.setBackground(Color.BLACK);
        nav.add(btnPrev, BorderLayout.WEST);
        nav.add(btnNext, BorderLayout.EAST);
        nav.setPreferredSize(new Dimension(0, 60));
        JLabel title = new JLabel("Planes", SwingConstants.CENTER);
        title.setForeground(Color.white);
        nav.add(title, BorderLayout.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));
        root.add(nav, BorderLayout.NORTH);
        root.add(cards, BorderLayout.CENTER);
    }

    private JPanel createCard(Membership m) {
    	
    	Graficos_fondo p = new Graficos_fondo("files/fondo_planBasico.png");
 		
 		
 		
        p.setPreferredSize(new Dimension(900, 280));
        p.setBackground(Color.WHITE);

        JLabel lblName = new JLabel(m.getName(), SwingConstants.CENTER);
        lblName.setFont(new Font("Arial", Font.BOLD, 65));
        lblName.setForeground(Color.WHITE);
        lblName.setBounds(0, 50, 900, 60);
        p.add(lblName);

       
        JButton btnDetails = new JButton("Detalles");
        btnDetails.setBounds(250, 140, 400, 50);
        btnDetails.setBackground(Color.BLACK);
        btnDetails.setForeground(Color.WHITE);
        btnDetails.setBorderPainted(false);
        btnDetails.setFont(new Font("Arial", Font.BOLD, 22));
        btnDetails.addActionListener(e -> showDetailsDialog(m));
        p.add(btnDetails);

        return p;
    }

    private void showDetailsDialog(Membership m) {
        JDialog dialogo = new JDialog();
        dialogo.setModal(true);
        dialogo.setSize(550, 300);
        dialogo.setLayout(null);
        dialogo.setLocationRelativeTo(root);

        // Panel superior de título
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(Color.BLACK);
        panelTitulo.setBounds(0, 0, 550, 50);
        panelTitulo.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Detalles del Plan", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panelTitulo.add(titulo, BorderLayout.CENTER);

        dialogo.add(panelTitulo);

        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(2, 2, 20, 10));
        panelDatos.setBounds(50, 70, 450, 120);  

        JLabel lblId = new JLabel("ID: " + m.getId());
        JLabel lblNombre = new JLabel("Nombre: " + m.getName());
        JLabel lblPrecio = new JLabel("Precio: $" + m.getPrice());
        JLabel lblDescripcion = new JLabel("Dias: " + m.getDays());

        Font datosFont = new Font("Arial", Font.PLAIN, 23);
        for (JLabel lbl : new JLabel[]{lblId, lblNombre, lblPrecio, lblDescripcion}) {
            lbl.setFont(datosFont);
        }

        panelDatos.add(lblId);
        panelDatos.add(lblNombre);
        panelDatos.add(lblPrecio);
        panelDatos.add(lblDescripcion);

        dialogo.add(panelDatos);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(200, 200, 150, 40);
        btnCerrar.setBackground(Color.BLACK);
        btnCerrar.setForeground(Color.WHITE);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setFont(new Font("Arial", Font.BOLD, 22));
        btnCerrar.addActionListener(e -> dialogo.dispose());

        dialogo.add(btnCerrar);
        dialogo.setVisible(true);
    }

    public JPanel getPanel() {
        return root;
    }
}
