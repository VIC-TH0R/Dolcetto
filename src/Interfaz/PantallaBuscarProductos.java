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
    private JLabel nombreABuscar, imagenFondo;
    private JTextField nombreProducto;
    private JButton botonBuscar;
    private String guardaNombreBuscar;
    private int busqueda;
    
    public PantallaBuscarProductos(){
        setLayout(null);
        this.setTitle("Pantalla para modificar/eliminar productos");
        
        //BackGround Image
        
        ImageIcon imagenDeFondo = new ImageIcon("images/Dolcetto/fondoPantallaBuscarProducto.jpg");
        ImageIcon iconoBuscar = new ImageIcon("images/busqueda.png");
        
        //JTable
        NombreColumnasParaTablaProductos = new String[]{"Nombre", "Precio"};
        datosParaTablaProductos = LogicaProducto.convertirArrayListAArray(LogicaProducto.productos);
        productosRegistrados = new JTable(datosParaTablaProductos, NombreColumnasParaTablaProductos);
        productosRegistrados.setEnabled(false);
        
        paraTablaProductos = new JScrollPane(productosRegistrados);
        paraTablaProductos.setBounds(20,20,350,150);
        add(paraTablaProductos);
        
        nombreProducto = new JTextField("Introduzca nombre que desea buscar");
        nombreProducto.setBounds(20,250,200,30);
        nombreProducto.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(nombreProducto);
        
        //JButton
        
        botonBuscar = new JButton();
        botonBuscar.setBounds(230,250,30,30);
        botonBuscar.setIcon(new ImageIcon(iconoBuscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        botonBuscar.setBackground(new Color(255,255,255));
        botonBuscar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(botonBuscar);
        
        //JLabel
        
        nombreABuscar = new JLabel("Nombre del producto buscado");
        nombreABuscar.setBounds(25,220,200,30);
        nombreABuscar.setFont(new Font("Andale Mono", 1, 12));
        add(nombreABuscar);
        
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
