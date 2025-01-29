package logica;

public class ProductosVentas{
    
    private double precioProducto;
    private int cantidadProducto;
    private String medidaUsada;  //peso, unidades o docenas
    private String nombreProducto;
    
    
    public ProductosVentas(double precioProducto, int cantidadProducto, String medidaUsada, String nombreProducto){
        
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

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
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
