package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import logica.LogicaProducto;
import Entidades.DatosParaProducto;
import static logica.LogicaProducto.productos;

public class PantallaEditarEliminarProductos extends JFrame implements ActionListener{
    
    private JTable productosRegistrados;
    private Object[][] datosParaTablaProductos;
    private String[] NombreColumnasParaTablaProductos;
    private JScrollPane paraTablaProductos;
    private JLabel nombreABuscar, tablaProductos, nombreProductoNuevo, precioProductoNuevo, imagenFondo;
    private JTextField nombreProducto, nuevoNombreProducto, NuevoPrecioProducto;
    private JButton botonBuscar, botonEliminar, botonEditar;
    private String guardaNombreBuscar, guardarPrecioNuevo;
    private int busqueda = -1;
    private double precioNuevo;
    
    public PantallaEditarEliminarProductos(){
        setLayout(null);
        this.setTitle("Pantalla para modificar/eliminar productos");
        
        //BackGround Image
        
        ImageIcon imagenDeFondo = new ImageIcon("images/Dolcetto/fondoParaPantallaBuscarProductos.png");
        ImageIcon iconoBuscar = new ImageIcon("images/busqueda.png");
        ImageIcon iconoEliminar = new ImageIcon("images/borrarProducto.png");
        ImageIcon iconoEditar = new ImageIcon("images/EditarProducto.png");
        ImageIcon iconoSeguroDeEliminar = new ImageIcon("images/borrarProductoConfirmacion.png");
        
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
        
        NuevoPrecioProducto = new JTextField("Precio nuevo");
        NuevoPrecioProducto.setBounds(20,350,200,30);
        NuevoPrecioProducto.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(NuevoPrecioProducto);
        NuevoPrecioProducto.setEditable(false);
        
        //JButton
        
        botonBuscar = new JButton();
        botonBuscar.setBounds(230,250,30,30);
        botonBuscar.setIcon(new ImageIcon(iconoBuscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        botonBuscar.setBackground(new Color(255,255,255));
        botonBuscar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        botonBuscar.addActionListener(this);
        add(botonBuscar);
        
        botonEliminar = new JButton();
        botonEliminar.setBounds(265,250,30,30);
        botonEliminar.setIcon(new ImageIcon(iconoEliminar.getImage().getScaledInstance(botonEliminar.getWidth(), botonEliminar.getHeight(), Image.SCALE_SMOOTH)));
        botonEliminar.setBackground(new Color(255,255,255));
        botonEliminar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        botonEliminar.addActionListener(this);
        add(botonEliminar);
        
        botonEditar = new JButton();
        botonEditar.setBounds(230,350,30,30);
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
        
        precioProductoNuevo = new JLabel("Precio nuevo para el producto");
        precioProductoNuevo.setBounds(20,320,200,30);
        precioProductoNuevo.setFont(new Font("Andale Mono", 1, 12));
        add(precioProductoNuevo);
        
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0,0,600,670);
        imagenFondo.setIcon(new ImageIcon(imagenDeFondo.getImage().getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH)));
        add(imagenFondo);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == botonBuscar){
            guardaNombreBuscar = nombreProducto.getText().toUpperCase().trim();
            if(guardaNombreBuscar.isEmpty()){
                JOptionPane.showMessageDialog(null, "Es necesario introducir el nombre del producto para continuar");
            }else{
                try{
                    busqueda = LogicaProducto.buscarProducto(guardaNombreBuscar);
                    if(busqueda > -1){
                        JOptionPane.showMessageDialog(null, "Se ha encontrado el producto. Por favor, introduzca el precio nuevo");
                        botonEditar.setEnabled(true);
                        NuevoPrecioProducto.setEditable(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "No se ha podido encontrar el producto, intente nuevamente");
                    }
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Por favor, introduzca un valor válido " + ex);
                }
            }  
        }
        
        if(e.getSource() == botonEditar){
            
            if(busqueda < 0 || busqueda >= LogicaProducto.productos.size()){
                JOptionPane.showMessageDialog(null, "Debe buscar un producto antes de modificar su precio");
                return;
            }
            
            guardarPrecioNuevo = NuevoPrecioProducto.getText().trim();
            
            try{
                precioNuevo = Double.parseDouble(guardarPrecioNuevo);
                if(precioNuevo >= 0){
                    LogicaProducto.productos.get(busqueda).setPrecioUnidad(precioNuevo);
                    DatosParaProducto.guardarProductos(productos);
                    NuevoPrecioProducto.setText("Precio nuevo para el producto");
                    botonEditar.setEnabled(false);
                    NuevoPrecioProducto.setEditable(false);
                    JOptionPane.showMessageDialog(null, "Se ha editado el precio del producto con éxito. Refresque la página para mostrar los cambios");
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor, introduzca un número mayor a 0");
                }
                
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "No se reconoce el valor introducido " + ex);
            }
            
            
        }
        
        if(e.getSource() == botonEliminar){
            
            //guarda el nombre directamente por si el usuario quiere eliminar el producto directamente
            guardaNombreBuscar = nombreProducto.getText().toUpperCase().trim();
            //Busca el producto nuevamente por si las dudas el índice ha cambiado
            busqueda = LogicaProducto.buscarProducto(guardaNombreBuscar);
            
            if(guardaNombreBuscar.isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, introduzca un nombre antes de continuar");
            }
            
            if(busqueda < 0 || busqueda >= LogicaProducto.productos.size()){
                JOptionPane.showMessageDialog(null, "El producto no existe o ha sido eliminado");
                return;
            }
            
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas borrar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
            
            if(confirmacion == JOptionPane.YES_OPTION){
                if(LogicaProducto.quitarProducto(busqueda)){
                    JOptionPane.showMessageDialog(null, "Se ha borrado el producto correctamente. Refresque la página para continuar");
                    DatosParaProducto.guardarProductos(productos);
                    botonEditar.setEnabled(false);
                    NuevoPrecioProducto.setEditable(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al borrar el producto, intente nuevamente");
                    DatosParaProducto.cargaProductos();
                }
            }
        }
    }
}
