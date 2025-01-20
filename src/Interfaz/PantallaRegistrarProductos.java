package Interfaz;

import javax.swing.*;
import java.awt.*;

public class PantallaRegistrarProductos extends JFrame{
    
    private JLabel nombreArticulo, precioArticulo;
    private JTextField nombre, precio;
    private JButton registrar;
    
    public PantallaRegistrarProductos(){
        
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        //JLabels
        
        nombreArticulo = new JLabel("Nombre del artículo");
        nombreArticulo.setFont(new Font("Andale Mono", 1, 11));
        nombreArticulo.setBounds(10,10,200,30);
        add(nombreArticulo);
        
        precioArticulo = new JLabel("Precio del artículo");
        precioArticulo.setFont(new Font("Andale Mono", 1, 11));
        precioArticulo.setBounds(10,100,200,30);
        add(precioArticulo);
        
        //JTextField
        nombre = new JTextField();
        nombre.setBounds(10,40,250,30);
        add(nombre);
        
        precio = new JTextField();
        precio.setBounds(10,130,250,30);
        add(precio);
        //JButton
        registrar = new JButton("Registrar");
        registrar.setBounds(130,170,90,30);
        add(registrar);
    }
}
