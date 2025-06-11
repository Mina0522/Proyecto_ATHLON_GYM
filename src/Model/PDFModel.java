package Model;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDFModel {
	
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
	            File ruta = PDFModel.askPath(); 
	            //Guardar arvhivo
	            documento.save(ruta);
	            System.out.println("PDF guardado en: " + ruta.getAbsolutePath());

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public static void createTrainerPDF (String name, String email, String type) {
		
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
		            	name,
		            	email,
		                "Entrenador: " + type
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
		            anchoTexto = fuente.getStringWidth("ENTRENADOR") / 1000 * fontSize;
		            contenido.newLineAtOffset(((pageWidth - anchoTexto) / 2), 100);
		            contenido.showText("ENTRENADOR");

		            contenido.endText();
		            contenido.close();

	            //Obtener ruta
	            File ruta = PDFModel.askPath(); 
	            //Guardar arvhivo
	            documento.save(ruta);
	            System.out.println("PDF guardado en: " + ruta.getAbsolutePath());

	        } catch (IOException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null,
	    	            "El reporte no se pudo descargar.",
	    	            "Fail",
	    	            JOptionPane.INFORMATION_MESSAGE);
	        }
	}
	
	public static void createUserReportPDF(ArrayList<Payment> paymentList) {
	    try (PDDocument documento = new PDDocument()) {
	    	String userName = paymentList.getFirst().getMember_name();
	        PDPage pagina = new PDPage(PDRectangle.A5);
	        documento.addPage(pagina);

	        PDRectangle mediaBox = pagina.getMediaBox();
	        float pageWidth = mediaBox.getWidth();
	        float pageHeight = mediaBox.getHeight();

	        PDPageContentStream fondo = new PDPageContentStream(documento, pagina, PDPageContentStream.AppendMode.OVERWRITE, false);
	        fondo.setNonStrokingColor(new Color(220, 220, 220));
	        fondo.addRect(0, 0, pageWidth, pageHeight);
	        fondo.fill();
	        fondo.close();

	        PDType1Font fuente = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
	        float fontSize = 12;
	        float startY = pageHeight - 70;
	        float margin = 30;
	        float tableWidth = pageWidth - 2 * margin;
	        float rowHeight = 20;
	        int cols = 3;
	        float colWidth = tableWidth / cols;

	        PDPageContentStream contenido = new PDPageContentStream(documento, pagina, PDPageContentStream.AppendMode.APPEND, true);

	        contenido.setFont(fuente, fontSize);
	        contenido.setNonStrokingColor(Color.BLACK);

	        // Título principal
	        String titulo = "Reporte de pagos de " + userName;
	        float tituloAncho = fuente.getStringWidth(titulo) / 1000 * fontSize;
	        float tituloX = (pageWidth - tituloAncho) / 2;
	        float tituloY = pageHeight - 30;

	        contenido.beginText();
	        contenido.newLineAtOffset(tituloX, tituloY);
	        contenido.showText(titulo);
	        contenido.endText();

	        // Títulos de columna
	        String[] headers = {"Plan", "Fecha de pago", "Monto"};
	        float textY = startY;

	        contenido.beginText();
	        contenido.newLineAtOffset(margin, textY);
	        for (int i = 0; i < headers.length; i++) {
	            contenido.showText(headers[i]);
	            contenido.newLineAtOffset(colWidth, 0);
	        }
	        contenido.endText();

	        // Datos de pagos
	        textY -= rowHeight;
	        for (Payment payment : paymentList) {
	            contenido.beginText();
	            contenido.setFont(fuente, fontSize);
	            contenido.newLineAtOffset(margin, textY);
	            contenido.showText(payment.getMembership_name());
	            contenido.newLineAtOffset(colWidth, 0);
	            contenido.showText(payment.getDate().toString());
	            contenido.newLineAtOffset(colWidth, 0);
	            contenido.showText("$" + payment.getPrice());
	            contenido.endText();

	            textY -= rowHeight;
	        }

	        contenido.close();

	        // Obtener ruta y guardar archivo
	        File ruta = PDFModel.askPath();
	        documento.save(ruta);
	        System.out.println("PDF guardado en: " + ruta.getAbsolutePath());

	    } catch (IOException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null,
	                "El reporte no se pudo descargar.",
	                "Fail",
	                JOptionPane.INFORMATION_MESSAGE);
	    }
	}


	
	public static File askPath() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        fileChooser.setSelectedFile(new File("Nuevo_archivo.pdf"));

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
		PDFModel.createUserReportPDF(new PaymentModel().getAllUserPayments(1));
	}
	
}