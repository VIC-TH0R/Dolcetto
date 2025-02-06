package logica;

import Interfaz.PantallaDeInicio;

public class Logica{
    public static void main(String[] args) {
        
        
       PantallaDeInicio inicio = new PantallaDeInicio();
       LogicaProducto primeraParaCargarDatos = new LogicaProducto();
       
       inicio.setVisible(true);
       inicio.setBounds(0,0,400,250);
       inicio.setLocationRelativeTo(null);
       inicio.setResizable(true);
    }
    
}
