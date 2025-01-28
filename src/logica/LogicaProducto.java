package logica;

import java.util.ArrayList;
import java.util.Collections;

public class LogicaProducto{
    public static ArrayList <Producto> productos;
    
    public LogicaProducto(){
        if(productos == null){
            productos = new ArrayList<>();
        }
    }
    
    public boolean agregarProductos(String nombre, double precio){
        if(existeProducto(nombre, precio)){
            return false;
        }
        Producto producto = new Producto(precio, nombre);
        productos.add(producto);
        return true;
    }
    
    public boolean existeProducto(String nombre, double precio){
        for(Producto producto : productos){
            if(producto.getNombre().equalsIgnoreCase(nombre) && producto.getPrecioUnidad() == precio){
                return true;
            }
        }
        return false;
    }
    
    public static int buscarProducto(String nombre, double precio){
        Producto aux = new Producto(precio, nombre);
        int indice = 0;
        
        while(indice < productos.size()){
            if(aux.getNombre().equals(productos.get(indice).getNombre()) && aux.getPrecioUnidad() == productos.get(indice).getPrecioUnidad()){
                return indice;
            }else{
                indice++;
            }
        }
        return -1;
    }
    
    public static void mostrarProductos(){
        
        System.out.println("\tNOMBRE\t\tPRECIO");
        
        for(Producto aux : productos){
            System.out.print("\t" + aux.getNombre());
            System.out.println("\t" + aux.getPrecioUnidad());
        }
    }
    
    public static Object[][] convertirArrayListAArray(ArrayList<Producto> productosAux){
        
        Object[][] datos = new Object[productosAux.size()][2];
        
        for(int i = 0; i < productosAux.size(); i++){
            
            Producto produ = productosAux.get(i);
            datos[i][0] = produ.getNombre();
            datos[i][1] = produ.getPrecioUnidad();
        }
        
        return datos;
    }
}
