package Entidades;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import logica.ProductosVentas;


public class GenerarPDFVentas{
    
    double total;
    float anchoPDF;
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
            
            Image encabezado = Image.getInstance("images/Dolcetto/DolcettoPDFBajaResolucion.jpg");
            encabezado.scaleToFit(1000,300);
            encabezado.setAlignment(Chunk.ALIGN_CENTER);
            
            Image pie = Image.getInstance("images/Dolcetto/REDES EN NGRO.png");
            pie.scaleToFit(300,100);
            pie.setAlignment(Chunk.ALIGN_LEFT);
            
            pdfVentas.open();
            
            pdfVentas.add(new Paragraph("\t\tPresupuesto de venta\n\n"));
            pdfVentas.add(encabezado);
            pdfVentas.add(new Paragraph("\n\n"));
            pdfVentas.add(new Paragraph("Precio        " + "Cantidad        " + "Medida        " + "    Nombre"));

            for(ProductosVentas productos : ventas){
                try{
                    String informacionVenta = String.format(Locale.US, "%.2f        %f                %s            %s", productos.getPrecioProducto(), productos.getCantidadProducto(), productos.getMedidaUsada(), productos.getNombreProducto());
                    pdfVentas.add(new Paragraph(informacionVenta));
            }catch(Exception ex){
                System.err.println("Error al agregar producto al PDF: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        
        pdfVentas.add(new Paragraph("\n\n\tTotal de la venta: $" + String.format(Locale.US, "%.2f", total)));
        pdfVentas.add(new Paragraph("\n\n\n"));
        pdfVentas.add(pie);
        
        pdfVentas.close();
        
        JOptionPane.showMessageDialog(null, "PDF generado con éxito en: " + ruta);
        
        }catch(DocumentException | java.io.IOException e){
            JOptionPane.showMessageDialog(null, "Error al generar el archivo PDF. Intente no tener abierto los presupuestos anteriores y vuelva a intentar");
            e.printStackTrace();
        }
    }
}
