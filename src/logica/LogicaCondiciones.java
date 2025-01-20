package logica;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import Entidades.terminosYCondiciones;

public class LogicaCondiciones{
    
    private FileReader archivo;
    private BufferedReader lector;
    private terminosYCondiciones textoCondiciones;
    private String lineaCondiciones;
    
    
    public String leerContenidoArchivo(){
        
        textoCondiciones = new terminosYCondiciones();
        StringBuilder contenido = new StringBuilder();
        try (FileReader archivo = new FileReader(textoCondiciones.getNombreArchivo());
            BufferedReader lector = new BufferedReader(archivo)) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Error al abrir el archivo: " + e.getMessage());
    }
        return contenido.toString();
  }
}

