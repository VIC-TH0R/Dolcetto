package Entidades;
                                    
//Class to represent the basic entity of the file "Condiciones.txt"

public class terminosYCondiciones{
    
    private String nombreArchivo;
    
    public terminosYCondiciones(){
        nombreArchivo = "Condiciones.txt";
    }
    
    public String getNombreArchivo(){
        return nombreArchivo;
    }
}
