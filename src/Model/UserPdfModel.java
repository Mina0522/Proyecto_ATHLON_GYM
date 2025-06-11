package Model;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class UserPdfModel {
	
	public static void createIdPDF (String first_name, String last_name, int control_num) {
		
		 try (PDDocument documento = new PDDocument()) {

		            PDPage pagina = new PDPage(PDRectangle.A5);
		            documento.addPage(pagina);
		            
		            PDRectangle mediaBox = pagina.getMediaBox();
		            float pageWidth = mediaBox.getWidth();
		            float pageHeight = mediaBox.getHeight();
		            PDImageXObject background = PDImageXObject.createFromFile("src/files/fondoCredencialNegro.png", documento);

		            PDPageContentStream fondo = new PDPageContentStream(documento, pagina, PDPageContentStream.AppendMode.OVERWRITE, false);
		            fondo.setNonStrokingColor(new Color(220, 220, 220));
		            fondo.addRect(0, 0, pageWidth, pageHeight);
		            fondo.fill();
		            fondo.close();

		            PDType1Font fuente = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
		            float fontSize = 24;
		            float leading = 40;
		            float startY = pageHeight - 100;
		            PDImageXObject image = PDImageXObject.createFromFile("src/files/logoATHLON_cb.png", documento);
		            PDPageContentStream contenido = new PDPageContentStream(documento, pagina, PDPageContentStream.AppendMode.APPEND, true);
		            contenido.drawImage(background, 0, 0, pageWidth, pageHeight);
		            contenido.drawImage(image, 80, 350, 250, 100);

		            contenido.beginText();
		            contenido.setFont(fuente, fontSize);
		            contenido.setNonStrokingColor(Color.WHITE);

		            String[] lineas = {
		                first_name,
		                last_name,
		                "Número de control",
		                "" + control_num
		            };
		            float anchoTexto = fuente.getStringWidth("CREDENCIAL") / 1000 * fontSize;
		            contenido.newLineAtOffset(((pageWidth - anchoTexto) / 2), 500);
		            contenido.showText("CREDENCIAL");
		            contenido.newLineAtOffset(-((pageWidth - anchoTexto) / 2), -500);
		            
		            for (int i = 0; i < lineas.length; i++) {
		                String linea = lineas[i];
		                anchoTexto = fuente.getStringWidth(linea) / 1000 * fontSize;
		                float x = (pageWidth - anchoTexto) / 2;
		                float y = startY - (i * leading) - 200;

		                contenido.newLineAtOffset(x, y);
		                contenido.showText(linea);
		                contenido.newLineAtOffset(-x, -y);
		            }
		            
		            fontSize = 40;
		            contenido.setFont(fuente, fontSize);
		            anchoTexto = fuente.getStringWidth("MIEMBRO") / 1000 * fontSize;
		            contenido.newLineAtOffset(((pageWidth - anchoTexto) / 2), 100);
		            contenido.showText("MIEMBRO");

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
        fileChooser.setSelectedFile(new File("credencial.pdf"));

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
	
//    public static void main(String[] args) {
//    	UserPdfModel.createIdPDF("asdasdsa","asdasddsa",666666);
//    }
}
