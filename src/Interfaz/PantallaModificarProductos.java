package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import logica.LogicaProducto;

public class PantallaModificarProductos extends JFrame implements ActionListener{
    
    private JLabel nombreABuscar, precioABuscar;
    private JTextField nombre, precio;
    private JButton botonBuscar;
    private String guardaNombreBuscar, guardaPrecioBuscar;
    private double precioBuscar;
    private int busqueda;
    
    public PantallaModificarProductos(){
        setLayout(null);
        
        nombreABuscar = new JLabel("Nombre del producto a buscar");
        nombreABuscar.setFont(new Font("Andale Mono", 1, 11));
        nombreABuscar.setBounds(10,10,300,30);
        add(nombreABuscar);
        
        precioABuscar = new JLabel("Precio del producto a buscar");
        precioABuscar.setFont(new Font("Andale Mono", 1, 11));
        precioABuscar.setBounds(10,90,300,30);
        add(precioABuscar);
        
        nombre = new JTextField();
        nombre.setBounds(10,40,300,30);
        add(nombre);
        
        precio = new JTextField();
        precio.setBounds(10,120,300,30);
        add(precio);
        
        botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(230,170,80,30);
        botonBuscar.addActionListener(this);
        add(botonBuscar);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botonBuscar){
            guardaNombreBuscar = nombre.getText().trim();
            guardaPrecioBuscar = precio.getText().trim();
            
            if(guardaNombreBuscar.isEmpty() || guardaPrecioBuscar.isEmpty()){
                JOptionPane.showMessageDialog(null, "Es necesario completar ambos campos para continuar");
            }else{
                try{
                    precioBuscar = Double.parseDouble(guardaPrecioBuscar);
                    busqueda = LogicaProducto.buscarProducto(guardaNombreBuscar, precioBuscar);
                    if(busqueda > -1){
                        JOptionPane.showMessageDialog(null, "Se ha podido encontar el producto con éxito");
                        System.out.println("Se ha encontrado el elemento en la posición " + busqueda);
                        //llama nueva ventana para modificar productos
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido encontrar el producto");
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor, introduzca un valor válido " + ex);
                }
            }  
        }
    }
}
