package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import logica.LogicaProducto;

public class PantallaGenerarPDF extends JFrame{
    
    private JTable tabla;
    private Object [][] datosParaTabla;
    private String[] nombresColumnas; 
    private JLabel ProductoAgregar, productosExistentes;
    private JTextField NombreProducto;
    private JScrollPane paraLaTabla;
    
    public PantallaGenerarPDF(){
        
        setLayout(null);
        //inicializando los datos para la tabla
        nombresColumnas = new String []{"Nombre", "Precio"};
        datosParaTabla = LogicaProducto.convertirArrayListAArray(LogicaProducto.productos);
        
        //creando la tabla
        tabla = new JTable(datosParaTabla, nombresColumnas);
        tabla.setEnabled(false);
        //agreando el JScrollPane
        paraLaTabla = new JScrollPane(tabla);
        paraLaTabla.setBounds(20,50,350,130);
        add(paraLaTabla);
        
        //JLabels
        
        productosExistentes = new JLabel("Productos Almacenados");
        productosExistentes.setFont(new Font("Andale Mono", 1, 13));
        productosExistentes.setBounds(20,20,250,30);
        add(productosExistentes);
    }
}
