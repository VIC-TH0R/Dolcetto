package logica;

public class Producto{
    
    private double precioUnidad;
    private String nombreProducto;
    
    public Producto(double precioUnidad, String nombreProducto){
        this.precioUnidad = precioUnidad;
        this.nombreProducto = nombreProducto;
    }
    
    public String getNombre(){
        return nombreProducto;
    }
    
    public double getPrecioUnidad(){
        return precioUnidad;
    }
    
    public void setNombre(String nombre){
        nombreProducto = nombre;
    }
    
    public void setPrecioUnidad(double precio){
        precioUnidad = precio;
    }
}
