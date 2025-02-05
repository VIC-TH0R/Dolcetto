package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import logica.LogicaProducto;
import logica.LogicaVentas;

public class PantallaGenerarPDF extends JFrame implements ActionListener{
    
    private JTable tabla, tablaParaVentas;
    private Object [][] datosParaTabla, datosParaTablaVentas;
    private String[] nombresColumnasParaTabla, nombresJCombo, nombresColumnasVentas; 
    private JLabel ProductoAgregar, productosExistentes, cantidad, total, generarPDF;
    private JTextField NombreProducto, textFieldCantidad, totalPrecio;
    private JScrollPane paraLaTabla, paraTablaVentas;
    private JButton botonBuscar, botonCarritoAgregarProducto, botonQuitarProducto, botonGenerarPdf;
    private JComboBox cantidades;
    double totalPara_totalPrecio;
    
    //variables para almacenar los datos de los campos
    
    private String nombreBuscado;
    private int indice;
    
    public PantallaGenerarPDF(){
        
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        nombresJCombo = new String[]{"", "Unidades", "Docenas", "Kilos"};
        totalPara_totalPrecio = 0;
        
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
        paraTablaVentas.setBounds(20,410,350,150);
        add(paraTablaVentas);
        
        //imagen JButton
        
        ImageIcon iconoBuscar = new ImageIcon("images/busqueda.png");
        ImageIcon iconoCarrito = new ImageIcon("images/Carrito.png");
        ImageIcon iconoPDF = new ImageIcon("images/pdfgenerator.png");
        ImageIcon iconoEliminarProducto = new ImageIcon("images/borrarProducto.png");
        
        //JLabels
        
        productosExistentes = new JLabel("Productos Almacenados");
        productosExistentes.setFont(new Font("Andale Mono", 1, 13));
        productosExistentes.setBounds(20,20,250,30);
        add(productosExistentes);
        
        ProductoAgregar = new JLabel("Producto a vender");
        ProductoAgregar.setBounds(20,260,180,30);
        ProductoAgregar.setFont(new Font("Andale Mono", 1, 13));
        add(ProductoAgregar);
        
        cantidad = new JLabel("Cantidad");
        cantidad.setBounds(20,340,100,30);
        cantidad.setFont(new Font("Andale Mono",1, 13));
        add(cantidad);
        
        total = new JLabel("Total");
        total.setBounds(200,570,70,30);
        total.setFont(new Font("Andale Mono", 1, 13));
        add(total);
        
        generarPDF = new JLabel("Generar Presupuesto");
        generarPDF.setBounds(170,615,140,25);
        generarPDF.setFont(new Font("Andale Mono",1,12));
        add(generarPDF);
        
        //JTextFields
        
        NombreProducto = new JTextField();
        NombreProducto.setBounds(20,290,250,30);
        add(NombreProducto);
        
        textFieldCantidad = new JTextField("");
        textFieldCantidad.setBounds(20,370,130,30);
        add(textFieldCantidad);
        
        totalPrecio = new JTextField();
        totalPrecio.setBounds(240,570,90,30);
        totalPrecio.setEditable(false);
        add(totalPrecio);
        
        //JButtons
        
        botonBuscar = new JButton();
        botonBuscar.setBounds(275,290,30,30);
        botonBuscar.setIcon(new ImageIcon(iconoBuscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        botonBuscar.addActionListener(this);
        add(botonBuscar);
        
        botonCarritoAgregarProducto = new JButton();
        botonCarritoAgregarProducto.setBounds(280,370,30,30);
        botonCarritoAgregarProducto.setIcon(new ImageIcon(iconoCarrito.getImage().getScaledInstance(botonCarritoAgregarProducto.getWidth(), botonCarritoAgregarProducto.getHeight(), Image.SCALE_SMOOTH)));
        botonCarritoAgregarProducto.addActionListener(this);
        add(botonCarritoAgregarProducto);
        
        botonQuitarProducto = new JButton();
        botonQuitarProducto.setBounds(320,370,30,30);
        botonQuitarProducto.setIcon(new ImageIcon(iconoEliminarProducto.getImage().getScaledInstance(botonQuitarProducto.getWidth(), botonQuitarProducto.getHeight(), Image.SCALE_SMOOTH)));
        botonQuitarProducto.addActionListener(this);
        add(botonQuitarProducto);
        
        
        botonGenerarPdf = new JButton();
        botonGenerarPdf.setBounds(300,610,30,30);
        botonGenerarPdf.setIcon(new ImageIcon(iconoPDF.getImage().getScaledInstance(botonGenerarPdf.getWidth(), botonGenerarPdf.getHeight(), Image.SCALE_SMOOTH)));
        //generarPdf.addActionListener(this);
        add(botonGenerarPdf);
        
        //JComboBox
        
        cantidades = new JComboBox(nombresJCombo);
        cantidades.setBounds(170,370,100,25);
        add(cantidades);
    }
    
public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == botonBuscar) {
        nombreBuscado = NombreProducto.getText().trim();
        indice = LogicaProducto.buscarProducto(nombreBuscado);

        if(indice > -1){
            JOptionPane.showMessageDialog(null, "Se ha encontrado el producto");
            NombreProducto.setEnabled(false);
            NombreProducto.setDisabledTextColor(Color.BLACK);
            NombreProducto.setBackground(new Color(200, 200, 200)); // color gris
            botonBuscar.setEnabled(false);
            
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto, intente nuevamente");
            NombreProducto.setText("");
        }
    }

    if (e.getSource() == botonCarritoAgregarProducto){
        if(agregarProductoAlCarrito(indice)){
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
            NombreProducto.setEnabled(true);
            NombreProducto.setDisabledTextColor(Color.WHITE);
            NombreProducto.setBackground(new Color(255, 255, 255));
            botonBuscar.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo agregar el producto, intente nuevamente");
        }
    }
}
    
    private boolean agregarProductoAlCarrito(int indice){
        
        String cantidadTexto, getUnidad;
        int canti;
        boolean seAgregoCorrectamente;
        
        cantidadTexto = textFieldCantidad.getText().trim();
        getUnidad = (String)cantidades.getSelectedItem();
        seAgregoCorrectamente = false;
        
        if(cantidadTexto.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad");
            return false;
        }
        
        if(nombreBuscado.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un artículo para continuar");
        }
        
        try{
            canti = Integer.parseInt(cantidadTexto);
            
            if(canti <= 0){
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0");
                return false;
            }
            
            if(getUnidad == null || getUnidad.isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una unidad de medida");
                return false;
            }
            //Crear un objeto de tipo LogicaVentas
            totalPara_totalPrecio = LogicaVentas.agregarProductoVendido(LogicaProducto.productos.get(indice).getPrecioUnidad(), canti, getUnidad, LogicaProducto.productos.get(indice).getNombre(), totalPara_totalPrecio);
            //ahora hay que actualizar la tabla
            actualizarTablaVentas();
            //actualizar el JTextField
            totalPrecio.setText(String.format("%.2f", totalPara_totalPrecio));
            seAgregoCorrectamente = true;
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Por favor, introduzca un número válido para continuar");
        }
        
        return seAgregoCorrectamente;
    }
    
    private void actualizarTablaVentas(){
        //creando el objeto para la tabla
        Object[][] nuevosDatos = LogicaVentas.ConvertirVentasAArray();
        //creando la tabla
        DefaultTableModel modelo = new DefaultTableModel(nuevosDatos, nombresColumnasVentas);
        tablaParaVentas.setModel(modelo);
        //actualizando la tabla con cada nuevo producto
        tablaParaVentas.revalidate();
        tablaParaVentas.repaint();
    }
}
