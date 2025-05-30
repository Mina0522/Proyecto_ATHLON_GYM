package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista_GYM extends JFrame{
	
	// === Constructor que se ejecutara cada que se cree un objeto de tipo Vista_GYM.
	public Vista_GYM () {
		
		setTitle("ATHLON GYM");
		setSize(1280, 700);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// === Pintamos la pantalla principal de inicio de sesion.
		pintar_vista(new View_loginGYM(this).getPanel());
		setVisible(true);
	}
	
	// === Metodo que nos ayudara a cambiar de vista. 
	public void pintar_vista(JPanel panel_principal) {
		
		setContentPane(panel_principal);
		revalidate();
		repaint();
	}

}