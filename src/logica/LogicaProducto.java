package logica;

import java.util.ArrayList;

public class LogicaProducto{
    private ArrayList <Producto> productos;
    
    public LogicaProducto(){
        
        productos = new ArrayList<>();
    }
    
    public void agregarProductos(String nombre, double precio){
        
        Producto producto = new Producto(precio, nombre);
        productos.add(producto);
    }
}
