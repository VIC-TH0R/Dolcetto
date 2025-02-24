package logica;

public class ProductosVentas{
    
    private double precioProducto;
    private double cantidadProducto;
    private String medidaUsada;  //peso, unidades o docenas
    private String nombreProducto;
    
    
    public ProductosVentas(String nombreProducto, double precioProducto, double cantidadProducto, String medidaUsada){
        
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
        this.medidaUsada = medidaUsada;
        this.nombreProducto = nombreProducto;
    }
    
    //setters y getters

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(double cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getMedidaUsada() {
        return medidaUsada;
    }

    public void setMedidaUsada(String medidaUsada) {
        this.medidaUsada = medidaUsada;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
