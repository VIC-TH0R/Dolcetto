package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import logica.LogicaProducto;

public class PantallaRegistrarProductos extends JFrame implements ActionListener{
    
    private JLabel nombreArticulo, precioArticulo;
    private JTextField nombre, precio;
    private JButton registrar;
    boolean agregado;
    private String getNombre, getPrecioTexto;
    private double getPrecio;
    private LogicaProducto guardarProductos; 
    
    public PantallaRegistrarProductos(){
        
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        guardarProductos = new LogicaProducto();
        
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
        registrar.addActionListener(this);
        add(registrar);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == registrar){
            
            getNombre = nombre.getText().trim();
            getPrecioTexto = precio.getText().trim();
            
            if(getNombre.isEmpty() || getPrecioTexto.isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, rellene los campos para continuar");
                return;
            }else{
                try{
                    //crear objeto y llamar al método para guardar la información
                    getPrecio = Double.parseDouble(getPrecioTexto);
                    
                    boolean agregado = guardarProductos.agregarProductos(getNombre, getPrecio);
                    System.out.println(agregado);
                    
                    if(agregado == true){
                        JOptionPane.showMessageDialog(null, "El producto ha sido creado exitosamente");
                    }else{
                        JOptionPane.showMessageDialog(null, "El producto ya existe, no es posible duplicar");
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "El precio debe ser un formato válido");
                }
            }
        }
    }
}
