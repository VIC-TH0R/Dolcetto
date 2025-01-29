package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import logica.LogicaProducto;
import logica.LogicaVentas;

public class PantallaGenerarPDF extends JFrame{
    
    private JTable tabla, tablaParaVentas;
    private Object [][] datosParaTabla, datosParaTablaVentas;
    private String[] nombresColumnasParaTabla, nombresJCombo, nombresColumnasVentas; 
    private JLabel ProductoAgregar, productosExistentes, cantidad;
    private JTextField NombreProducto, textFieldCantidad;
    private JScrollPane paraLaTabla, paraTablaVentas;
    private JButton botonBuscar;
    private JComboBox cantidades;
    
    public PantallaGenerarPDF(){
        
        setLayout(null);
        
        nombresJCombo = new String[]{"", "Unidades", "Decenas", "Kilos"};
        
        //inicializando los datos para la tabla
        nombresColumnasParaTabla = new String []{"Nombre", "Precio"};
        datosParaTabla = LogicaProducto.convertirArrayListAArray(LogicaProducto.productos);
        //inicializando los datos para la tabla de ventas
        datosParaTablaVentas = LogicaVentas.ConvertirVentasAArray();
        nombresColumnasVentas = new String[]{"Precio", "Cantidad", "Medida", "Nombre"};
        
        //creando la tabla
        tabla = new JTable(datosParaTabla, nombresColumnasParaTabla);
        tabla.setEnabled(false);
        
        //creando la tabla para las ventas
        
        tablaParaVentas = new JTable(datosParaTablaVentas, nombresColumnasVentas);
        
        //agreando el JScrollPane
        paraLaTabla = new JScrollPane(tabla);
        paraLaTabla.setBounds(20,50,350,200);
        add(paraLaTabla);
        
        //Agregando el JSrollPane a la tablaParaVentas
       
        paraTablaVentas = new JScrollPane(tablaParaVentas);
        paraTablaVentas.setBounds(20,430,350,200);
        add(paraTablaVentas);
        
        //JLabels
        
        productosExistentes = new JLabel("Productos Almacenados");
        productosExistentes.setFont(new Font("Andale Mono", 1, 13));
        productosExistentes.setBounds(20,20,250,30);
        add(productosExistentes);
        
        ProductoAgregar = new JLabel("Producto a agregar");
        ProductoAgregar.setBounds(20,290,180,30);
        ProductoAgregar.setFont(new Font("Andale Mono", 1, 13));
        add(ProductoAgregar);
        
        cantidad = new JLabel("Cantidad");
        cantidad.setBounds(20,370,100,30);
        cantidad.setFont(new Font("Andale Mono",1, 13));
        add(cantidad);
        //JTextFields
        
        NombreProducto = new JTextField();
        NombreProducto.setBounds(20,320,250,30);
        add(NombreProducto);
        
        textFieldCantidad = new JTextField("");
        textFieldCantidad.setBounds(20,400,130,30);
        add(textFieldCantidad);
        
        //imagen JButton
        
        ImageIcon iconoBuscar = new ImageIcon("images/busqueda.png");
        
        //JButtons
        
        botonBuscar = new JButton();
        botonBuscar.setBounds(275,320,30,30);
        botonBuscar.setIcon(new ImageIcon(iconoBuscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        //botonBuscar.addActionListener(this);
        add(botonBuscar);
        
        //JComboBox
        
        cantidades = new JComboBox(nombresJCombo);
        cantidades.setBounds(170,400,100,25);
        add(cantidades);
        
    }
}
