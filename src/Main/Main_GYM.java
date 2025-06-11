package Main;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import Model.MyConnection;
import View.Vista_GYM;

public class Main_GYM {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }

        MyConnection.connect();  //Iniciar conexión a la base de datos

        new Vista_GYM(); //Iniciar vista principal
    }
}
