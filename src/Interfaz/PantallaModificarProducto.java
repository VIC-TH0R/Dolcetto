package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import logica.LogicaProducto;

public class PantallaModificarProducto extends JFrame implements ActionListener{
    
    private JTextArea textPrecio;
    private JLabel labelPrecio;
    private JButton modificar;
    private int posi;
    private String precioNuevo;
    private double precioADouble;
    
    public PantallaModificarProducto(int posicion){
        setLayout(null);
        
        posi = posicion;
        
        textPrecio = new JTextArea();
        textPrecio.setBounds(10,40,200,30);
        add(textPrecio);
        
        labelPrecio = new JLabel("Nuevo precio");
        labelPrecio.setBounds(10,10,100,30);
        add(labelPrecio);
        
        modificar = new JButton("Modificar");
        modificar.setBounds(100,100,100,30);
        modificar.addActionListener(this);
        add(modificar);
    }
    
    public void actionPerformed(ActionEvent e){
        
        precioNuevo = textPrecio.getText().trim();
        precioADouble = Double.parseDouble(precioNuevo);
        
        if(e.getSource() == modificar){
            
            try{
                LogicaProducto.productos.get(posi).setPrecioUnidad(precioADouble);
                JOptionPane.showMessageDialog(null, "Se ha modificado el producto correctamente");
                LogicaProducto.mostrarProductos();
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Error al intentar modificar el producto");
            }
        }
    }
}
