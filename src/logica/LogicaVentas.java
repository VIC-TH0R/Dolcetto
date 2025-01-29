package logica;

import java.util.ArrayList;

public class LogicaVentas{
    
    public static ArrayList<ProductosVentas> ventas = new ArrayList<>();
    
    public LogicaVentas(){
        if(ventas == null){
            ventas = new ArrayList<>();
        }
    }
    
    public void agregarProductoVendido(double precio, int cantidad, String medidaUsada, String nombreArticulo){
        //si el producto ya estaba en la lista, actualiza la cantidad
        for(ProductosVentas pv : ventas){
            if(pv.getPrecioProducto() == precio && pv.getCantidadProducto() == cantidad && pv.getMedidaUsada().equalsIgnoreCase(medidaUsada) && pv.getNombreProducto().equalsIgnoreCase(nombreArticulo)){
                pv.setCantidadProducto(pv.getCantidadProducto() + cantidad);
                return;
            }
        }
        //si no estaba en la lista, lo agrega nuevo
        ventas.add(new ProductosVentas(precio, cantidad, medidaUsada, nombreArticulo));
     }
    //para devolver un objecto bidimensional para la tabla
    public static Object[][] ConvertirVentasAArray(){
        
        Object[][] datos = new Object[ventas.size()][4];
        
        for(int i = 0; i < ventas.size(); i++){
            datos[i][0] = ventas.get(i).getPrecioProducto();
            datos[i][1] = ventas.get(i).getCantidadProducto();
            datos[i][2] = ventas.get(i).getMedidaUsada();
            datos[i][3] = ventas.get(i).getNombreProducto();
        }
        return datos;
    }
}

