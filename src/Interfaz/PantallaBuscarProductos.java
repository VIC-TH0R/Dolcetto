package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import logica.LogicaProducto;

public class PantallaBuscarProductos extends JFrame implements ActionListener{
    
    private JTable productosRegistrados;
    private Object[][] datosParaTablaProductos;
    private String[] NombreColumnasParaTablaProductos;
    private JScrollPane paraTablaProductos;
    private JLabel nombreABuscar, tablaProductos, nombreProductoNuevo, precioProductoNuevo, imagenFondo;
    private JTextField nombreProducto, nuevoNombreProducto, NuevoPrecioProducto;
    private JButton botonBuscar, botonEliminar, botonEditar;
    private String guardaNombreBuscar;
    private int busqueda;
    
    public PantallaBuscarProductos(){
        setLayout(null);
        this.setTitle("Pantalla para modificar/eliminar productos");
        
        //BackGround Image
        
        ImageIcon imagenDeFondo = new ImageIcon("images/Dolcetto/fondoParaPantallaBuscarProductos.png");
        ImageIcon iconoBuscar = new ImageIcon("images/busqueda.png");
        ImageIcon iconoEliminar = new ImageIcon("images/borrarProducto.png");
        ImageIcon iconoEditar = new ImageIcon("images/EditarProducto.png");
        
        //JTable
        NombreColumnasParaTablaProductos = new String[]{"Nombre", "Precio"};
        datosParaTablaProductos = LogicaProducto.convertirArrayListAArray(LogicaProducto.productos);
        productosRegistrados = new JTable(datosParaTablaProductos, NombreColumnasParaTablaProductos);
        productosRegistrados.setEnabled(false);
        
        paraTablaProductos = new JScrollPane(productosRegistrados);
        paraTablaProductos.setBounds(20,50,350,150);
        add(paraTablaProductos);
        
        //JTextFields
        
        nombreProducto = new JTextField("Introduzca el nombre de un producto");
        nombreProducto.setBounds(20,250,200,30);
        nombreProducto.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(nombreProducto);
        
        nuevoNombreProducto = new JTextField("Nombre nuevo");
        nuevoNombreProducto.setBounds(20,350,200,30);
        nuevoNombreProducto.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(nuevoNombreProducto);
        nuevoNombreProducto.setEditable(false);
        
        NuevoPrecioProducto = new JTextField("Precio nuevo");
        NuevoPrecioProducto.setBounds(20,430,200,30);
        NuevoPrecioProducto.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(NuevoPrecioProducto);
        NuevoPrecioProducto.setEditable(false);
        
        //JButton
        
        botonBuscar = new JButton();
        botonBuscar.setBounds(230,250,30,30);
        botonBuscar.setIcon(new ImageIcon(iconoBuscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        botonBuscar.setBackground(new Color(255,255,255));
        botonBuscar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(botonBuscar);
        
        botonEliminar = new JButton();
        botonEliminar.setBounds(265,250,30,30);
        botonEliminar.setIcon(new ImageIcon(iconoEliminar.getImage().getScaledInstance(botonEliminar.getWidth(), botonEliminar.getHeight(), Image.SCALE_SMOOTH)));
        botonEliminar.setBackground(new Color(255,255,255));
        botonEliminar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        botonEliminar.addActionListener(this);
        add(botonEliminar);
        botonEliminar.setEnabled(false);
        
        botonEditar = new JButton();
        botonEditar.setBounds(240,385,30,30);
        botonEditar.setIcon(new ImageIcon(iconoEditar.getImage().getScaledInstance(botonEditar.getWidth(), botonEditar.getHeight(), Image.SCALE_SMOOTH)));
        botonEditar.setBackground(new Color(255,255,255));
        botonEditar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        botonEditar.addActionListener(this);
        add(botonEditar);
        botonEditar.setEnabled(false);
        
        //JLabel
        
        tablaProductos = new JLabel("Tabla de productos existentes");
        tablaProductos.setBounds(20,20,200,30);
        tablaProductos.setFont(new Font("Andale Mono", 1, 12));
        add(tablaProductos);
        
        nombreABuscar = new JLabel("Nombre del producto buscado");
        nombreABuscar.setBounds(25,220,200,30);
        nombreABuscar.setFont(new Font("Andale Mono", 1, 12));
        add(nombreABuscar);
        
        nombreProductoNuevo = new JLabel("Nombre nuevo para el producto");
        nombreProductoNuevo.setBounds(20,320,200,30);
        nombreProductoNuevo.setFont(new Font("Andale Mono", 1, 12));
        add(nombreProductoNuevo);
        
        precioProductoNuevo = new JLabel("Precio nuevo para el producto");
        precioProductoNuevo.setBounds(20,400,200,30);
        precioProductoNuevo.setFont(new Font("Andale Mono", 1, 12));
        add(precioProductoNuevo);
        
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0,0,600,670);
        imagenFondo.setIcon(new ImageIcon(imagenDeFondo.getImage().getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH)));
        add(imagenFondo);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botonBuscar){
            guardaNombreBuscar = nombreProducto.getText().trim();
            if(guardaNombreBuscar.isEmpty()){
                JOptionPane.showMessageDialog(null, "Es necesario completar ambos campos para continuar");
            }else{
                try{
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
