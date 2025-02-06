package Entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import logica.Producto;

public class DatosParaProducto{
    private static final String ARCHIVO_PRODUCTOS = "productos.txt";
    
    public static void guardarProductos(ArrayList<Producto> productos){
        
        try(BufferedWriter escritura = new BufferedWriter(new FileWriter(ARCHIVO_PRODUCTOS))){
            
            for(Producto producto : productos){
                escritura.write(producto.getNombre() + "," + producto.getPrecioUnidad());
                escritura.newLine(); 
            }
            
        }catch(IOException e){
            System.out.println("Error al guardar los productos: " + e.getMessage());
        }
    }
    
    public static ArrayList<Producto> cargaProductos(){
        ArrayList<Producto> productos = new ArrayList<>();
        File archivo = new File(ARCHIVO_PRODUCTOS);
        
        if (!archivo.exists() || archivo.length() == 0) return productos;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    String nombre = datos[0];
                    double precio = Double.parseDouble(datos[1]);
                    productos.add(new Producto(precio, nombre));
                }
            }
        }catch(IOException | NumberFormatException e){
            System.out.println("Error al cargar los productos: " + e.getMessage());
        }
        return productos;
    }
}
