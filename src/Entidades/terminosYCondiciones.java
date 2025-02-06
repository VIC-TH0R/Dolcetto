package Entidades;
                                    
//Clase que representa el documento Condiciones.txt

public class terminosYCondiciones{
    
    private String nombreArchivo;
    
    public terminosYCondiciones(){
        nombreArchivo = "Condiciones.txt";
    }
    
    public String getNombreArchivo(){
        return nombreArchivo;
    }
}
