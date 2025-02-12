package logica;

import Entidades.DatosParaProducto;
import java.util.ArrayList;
import java.util.Collections;

public class LogicaProducto{
    public static ArrayList <Producto> productos;
    
    public LogicaProducto(){
        
        productos = DatosParaProducto.cargaProductos();
    }
    
    public static boolean quitarProducto(int indice){
        
        boolean bandera;
        
        bandera = false;
        
        if(indice < 0 || indice >= productos.size()){
            return bandera;
        }else{
            productos.remove(indice);
            bandera = true;
        }
        
        return bandera;
    }
    
    public boolean agregarProductos(String nombre, double precio){
        if(existeProducto(nombre)){
            return false;
        }
        Producto producto = new Producto(precio, nombre);
        productos.add(producto);
        DatosParaProducto.guardarProductos(productos);
        return true;
    }
    
    public boolean existeProducto(String nombre){
        for(Producto producto : productos){
            if(producto.getNombre().equalsIgnoreCase(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public static int buscarProducto(String nombre){
        
        for(int i = 0; i < productos.size(); i++){
            if(productos.get(i).getNombre().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return -1;
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
