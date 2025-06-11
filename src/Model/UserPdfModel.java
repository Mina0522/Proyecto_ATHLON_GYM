package Model;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class UserPdfModel {
	
	public static void createIdPDF (String first_name, String last_name, int Control_num) {
		
		 try (PDDocument documento = new PDDocument()) {
	            PDPage pagina = new PDPage(PDRectangle.A5);
	            documento.addPage(pagina);

	            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);
	            PDType1Font fuente = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);

	            contenido.beginText();
	            contenido.setFont(fuente, 16);
	            contenido.newLineAtOffset(100, 100);
	            contenido.showText("Holalaaaa.");
	            contenido.endText();
	            contenido.close();

	            //Obtener ruta
	            File ruta = askPath(); 
	            //Guardar arvhivo
	            documento.save(ruta);
	            System.out.println("PDF guardado en: " + ruta.getAbsolutePath());

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public static File askPath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setSelectedFile(new File("reporte.pdf")); // nombre sugerido

        int seleccion = fileChooser.showSaveDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();

            // Asegurarse de que termine en ".pdf"
            if (!archivo.getName().toLowerCase().endsWith(".pdf")) {
                archivo = new File(archivo.getParentFile(), archivo.getName() + ".pdf");
            }

            return archivo;
        }

        return null; // El usuario canceló
    }
	
    public static void main(String[] args) {
    	UserPdfModel.createIdPDF("","",1);
    }
}
