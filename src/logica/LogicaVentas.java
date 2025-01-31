package logica;

import java.util.ArrayList;

public class LogicaVentas{
    
    public static ArrayList<ProductosVentas> ventas = new ArrayList<>();
    
    public LogicaVentas(){
        if(ventas == null){
            ventas = new ArrayList<>();
        }
    }
    
    public static double agregarProductoVendido(double precio, int cantidad, String medidaUsada, String nombreArticulo, double totalVentas){
        //si el producto ya estaba en la lista, actualiza la cantidad
        for(ProductosVentas pv : ventas){
            if(pv.getPrecioProducto() == precio && pv.getCantidadProducto() == cantidad && pv.getMedidaUsada().equalsIgnoreCase(medidaUsada) && pv.getNombreProducto().equalsIgnoreCase(nombreArticulo)){
                pv.setCantidadProducto(pv.getCantidadProducto() + cantidad);
                totalVentas = totalVentas + calcularTotal(pv.getPrecioProducto(), pv.getCantidadProducto(), pv.getMedidaUsada());
                return totalVentas;
            }
        }
        int indiceNuevo;
        //si no estaba en la lista, lo agrega nuevo
        ventas.add(new ProductosVentas(precio, cantidad, medidaUsada, nombreArticulo));
        //obtenemos el índice
        indiceNuevo = ventas.size() - 1;
        totalVentas = totalVentas + calcularTotal(ventas.get(indiceNuevo).getPrecioProducto(), ventas.get(indiceNuevo).getCantidadProducto(), ventas.get(indiceNuevo).getMedidaUsada());
        return totalVentas;
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
    
    public static double calcularTotal(double precioProducto, int cantidadProducto, String medidaProducto){
        
        double medidaANumero;
        double total;
        
        total = -1;
        
        medidaANumero = pasarMedidaANumero(medidaProducto);
        
        if(medidaANumero > -1){
            total = precioProducto * cantidadProducto * medidaANumero;
        }
        return total;
    }
    
    public static int pasarMedidaANumero(String medida){

        switch(medida.trim()){
            
            case "Unidad": return 1;
            case "Docenas": return 12;
            case "Kilos": return 1;
        }
        return -1;
    }
}

