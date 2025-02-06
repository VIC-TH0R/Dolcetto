package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import logica.LogicaProducto;

public class PantallaBuscarProductos extends JFrame implements ActionListener{
    
    private JLabel nombreABuscar, precioABuscar;
    private JTextField nombre, precio;
    private JButton botonBuscar;
    private String guardaNombreBuscar, guardaPrecioBuscar;
    private double precioBuscar;
    private int busqueda;
    
    public PantallaBuscarProductos(){
        setLayout(null);
        
        nombreABuscar = new JLabel("Nombre del producto a buscar");
        nombreABuscar.setFont(new Font("Andale Mono", 1, 11));
        nombreABuscar.setBounds(10,10,300,30);
        add(nombreABuscar);
        
        precioABuscar = new JLabel("Precio del producto a buscar");  //Borrar en un futuro, ya que no es necesario buscar por precio
        precioABuscar.setFont(new Font("Andale Mono", 1, 11));
        precioABuscar.setBounds(10,90,300,30);
        add(precioABuscar);
        /*Al no poder buscar por precio, tenemos que hacer que la app no permita la introducción de dos productos iguales*/
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
        
        //LogicaProducto.mostrarProductos();
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
                    busqueda = LogicaProducto.buscarProducto(guardaNombreBuscar); //hay que cambiar la pantalla para que no busque por precio, ya que no importa
                    if(busqueda > -1){
                        JOptionPane.showMessageDialog(null, "Se ha podido encontar el producto con éxito"); //sacar después
                        System.out.println("Se ha encontrado el elemento en la posición " + busqueda);
                        PantallaModificarProducto modificar = new PantallaModificarProducto(busqueda);
                        modificar.setBounds(0,0,230,250);
                        modificar.setVisible(true);
                        modificar.setLocationRelativeTo(botonBuscar);
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
