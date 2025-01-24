package logica;

import java.util.ArrayList;
import java.util.Collections;

public class LogicaProducto{
    private static ArrayList <Producto> productos;
    
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
        System.out.println("Dentro del método existeProducto, antes del for");
        for(Producto producto : productos){
            System.out.println("Dentro del for del método, nombre:" + producto.getNombre());
            if(producto.getNombre().equalsIgnoreCase(nombre) && producto.getPrecioUnidad() == precio){
                return true;
            }
        }
        return false;
    }
    
    public int buscarProducto(String nombre, double precio){
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
}
