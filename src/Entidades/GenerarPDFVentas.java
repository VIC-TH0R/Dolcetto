package Entidades;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import logica.ProductosVentas;


public class GenerarPDFVentas{
    
    double total;
    ArrayList<ProductosVentas> ventas;
    
    public GenerarPDFVentas(ArrayList<ProductosVentas> ventas, double total){
        this.total = total;
        this.ventas = ventas;
        generarPDF();
    }
    
    private void generarPDF(){
        try{
            Document pdfVentas = new Document();
            String ruta = "C:/Users/victo/OneDrive/Desktop/Presupuesto.pdf";
            PdfWriter.getInstance(pdfVentas, new FileOutputStream(ruta));
        
            pdfVentas.open();
            pdfVentas.add(new Paragraph("Presupuesto de venta\n\n"));
            pdfVentas.add(new Paragraph("Precio        " + "Cantidad        " + "Medida        " + "Nombre"));

            for(ProductosVentas productos : ventas){
                try{
                    String informacionVenta = String.format(Locale.US, "%.2f        %d         %s    %s", 
                    productos.getPrecioProducto(), 
                    productos.getCantidadProducto(), 
                    productos.getMedidaUsada(), 
                    productos.getNombreProducto());
                    pdfVentas.add(new Paragraph(informacionVenta));
            }catch (Exception ex){
                System.err.println("Error al agregar producto al PDF: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        pdfVentas.add(new Paragraph("Total de la venta: $" + String.format(Locale.US, "%.2f", total)));
        pdfVentas.close();
        
        JOptionPane.showMessageDialog(null, "PDF generado con éxito en: " + ruta);
        
        }catch(DocumentException | java.io.IOException e){
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF. Ver consola para más detalles.");
            e.printStackTrace();
        }
    }
}
