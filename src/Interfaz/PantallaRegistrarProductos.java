package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import logica.LogicaProducto;

public class PantallaRegistrarProductos extends JFrame implements ActionListener{
    
    private JLabel nombreArticulo, precioArticulo, logoEmpresa, fondo;
    private JTextField nombre, precio;
    private JButton registrar;
    boolean agregado;
    private String getNombre, getPrecioTexto;
    private double getPrecio;
    private LogicaProducto guardarProductos; 
    
    public PantallaRegistrarProductos(){
        
        setLayout(null);
        this.setTitle("Registrar Productos");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        guardarProductos = new LogicaProducto();
        
        //Images
        
        ImageIcon imagenDeFondo = new ImageIcon("images/Dolcetto/fondoParaPantallaBuscarProductos.png");
        ImageIcon logo = new ImageIcon("images/Dolcetto/pdfgenerator.png");
        ImageIcon agregarProducto = new ImageIcon("images/agregarProductoPantallaRegistrarProductos.png");
        
        //JTextField
        
        nombre = new JTextField("");
        nombre.setBounds(20,220,150,30);
        nombre.setBackground(new Color(255,255,255));
        nombre.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(nombre);
        
        precio = new JTextField("");
        precio.setBounds(20,290,150,30);
        precio.setBackground(new Color(255,255,255));
        precio.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(precio);
        
        
        //JButton
        
        registrar = new JButton();
        registrar.setBounds(190,255,24,24);
        registrar.setIcon(new ImageIcon(agregarProducto.getImage().getScaledInstance(registrar.getWidth(), registrar.getHeight(), Image.SCALE_AREA_AVERAGING)));
        registrar.setBackground(new Color(255,255,255));
        registrar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        registrar.addActionListener(this);
        add(registrar);
        
        //JLabels
        
        nombreArticulo = new JLabel("Nombre del artículo");
        nombreArticulo.setFont(new Font("Andale Mono", 1, 12));
        nombreArticulo.setBounds(20,190,200,30);
        add(nombreArticulo);
        
        precioArticulo = new JLabel("Precio del artículo");
        precioArticulo.setFont(new Font("Andale Mono", 1, 12));
        precioArticulo.setBounds(20,260,200,30);
        add(precioArticulo);
        
        logoEmpresa = new JLabel();
        logoEmpresa.setBounds(20,20,100,100);
        logoEmpresa.setIcon(new ImageIcon(logo.getImage().getScaledInstance(logoEmpresa.getWidth(), logoEmpresa.getHeight(), Image.SCALE_SMOOTH)));
        add(logoEmpresa);
        
        fondo = new JLabel();
        fondo.setBounds(0,0,300,500);
        fondo.setIcon(new ImageIcon(imagenDeFondo.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        add(fondo);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == registrar){
            
            getNombre = nombre.getText().toUpperCase().trim();
            getPrecioTexto = precio.getText().trim();
            
            if(getNombre.isEmpty() || getPrecioTexto.isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, rellene los campos para continuar");
                return;
            }else{
                try{
                    //crear objeto y llamar al método para guardar la información
                    getPrecio = Double.parseDouble(getPrecioTexto);
                    
                    if(getPrecio < 0){
                        JOptionPane.showMessageDialog(null, "No se puede agregar un precio menor a 0");
                        return;
                        
                    }
                    
                    boolean agregado = guardarProductos.agregarProductos(getNombre, getPrecio);
                    
                    if(agregado == true){
                        JOptionPane.showMessageDialog(null, "El producto ha sido creado exitosamente");
                    }else{
                        JOptionPane.showMessageDialog(null, "El producto con este mismo nombre ya existe, no es posible duplicar");
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "El precio debe ser un formato válido");
                }
            }
        }
    }
}
