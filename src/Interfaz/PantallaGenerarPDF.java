package Interfaz;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import logica.LogicaProducto;
import logica.LogicaVentas;
import Entidades.GenerarPDFVentas;

public class PantallaGenerarPDF extends JFrame implements ActionListener{
    
    private JTable tabla, tablaParaVentas;
    private Object [][] datosParaTabla, datosParaTablaVentas;
    private String[] nombresColumnasParaTabla, nombresJCombo, nombresColumnasVentas; 
    private JLabel ProductoAgregar, productosExistentes, cantidad, total, generarPDF, fondo;
    private JTextField NombreProducto, textFieldCantidad, totalPrecio;
    private JScrollPane paraLaTabla, paraTablaVentas;
    private JButton botonBuscar, botonCarritoAgregarProducto, botonQuitarProducto, botonGenerarPdf;
    private JComboBox cantidades;
    double totalPara_totalPrecio;
    private int filaSeleccionada;
    
    //variables para almacenar los datos de los campos
    
    private String nombreBuscado;
    private int indice;
    
    public PantallaGenerarPDF(){
        
        setLayout(null);
        this.setTitle("Generar Presupuesto");
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mousePressed(MouseEvent me){
                if(me.getClickCount() == 2){
                   filaSeleccionada = tabla.getSelectedRow();
                   if(filaSeleccionada > -1){
                       NombreProducto.setText(LogicaProducto.productos.get(filaSeleccionada).getNombre());
                   }
                }
            }
        });
        tabla.setEnabled(true);
        
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
        ImageIcon imagenDeFondo = new ImageIcon("images/Dolcetto/fondoParaPantallaBuscarProductos.png");
        
        //JTextFields
        
        NombreProducto = new JTextField();
        NombreProducto.setBounds(20,290,250,30);
        add(NombreProducto);
        
        textFieldCantidad = new JTextField("");
        textFieldCantidad.setBounds(20,370,130,30);
        textFieldCantidad.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        textFieldCantidad.setEnabled(false);
        textFieldCantidad.setDisabledTextColor(Color.BLACK);
        textFieldCantidad.setBackground(new Color(200,200,200));
        add(textFieldCantidad);
        
        totalPrecio = new JTextField();
        totalPrecio.setBounds(240,570,90,30);
        totalPrecio.setEditable(false);
        add(totalPrecio);
        
        //JButtons
        
        botonBuscar = new JButton();
        botonBuscar.setBounds(275,290,30,30);
        botonBuscar.setIcon(new ImageIcon(iconoBuscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        botonBuscar.setBackground(new Color(255,255,255));
        botonBuscar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        botonBuscar.addActionListener(this);
        add(botonBuscar);
        
        botonCarritoAgregarProducto = new JButton();
        botonCarritoAgregarProducto.setBounds(280,370,30,30);
        botonCarritoAgregarProducto.setIcon(new ImageIcon(iconoCarrito.getImage().getScaledInstance(botonCarritoAgregarProducto.getWidth(), botonCarritoAgregarProducto.getHeight(), Image.SCALE_SMOOTH)));
        botonCarritoAgregarProducto.setBackground(new Color(255,255,255));
        botonCarritoAgregarProducto.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        botonCarritoAgregarProducto.addActionListener(this);
        botonCarritoAgregarProducto.setEnabled(false);
        add(botonCarritoAgregarProducto);
        
        botonQuitarProducto = new JButton();
        botonQuitarProducto.setBounds(320,370,30,30);
        botonQuitarProducto.setIcon(new ImageIcon(iconoEliminarProducto.getImage().getScaledInstance(botonQuitarProducto.getWidth(), botonQuitarProducto.getHeight(), Image.SCALE_SMOOTH)));
        botonQuitarProducto.setBackground(new Color(255,255,255));
        botonQuitarProducto.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        botonQuitarProducto.addActionListener(this);
        add(botonQuitarProducto);
        
        
        botonGenerarPdf = new JButton();
        botonGenerarPdf.setBounds(300,610,30,30);
        botonGenerarPdf.setIcon(new ImageIcon(iconoPDF.getImage().getScaledInstance(botonGenerarPdf.getWidth(), botonGenerarPdf.getHeight(), Image.SCALE_SMOOTH)));
        botonGenerarPdf.setBackground(new Color(255,255,255));
        botonGenerarPdf.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        botonGenerarPdf.addActionListener(this);
        add(botonGenerarPdf);
        
        //JComboBox
        
        cantidades = new JComboBox(nombresJCombo);
        cantidades.setBounds(170,370,100,25);
        cantidades.setBackground(new Color(255,255,255));
        cantidades.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        cantidades.setEnabled(false);
        add(cantidades);
        
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
        
        fondo = new JLabel();
        fondo.setBounds(0,0,400,700);
        fondo.setIcon(new ImageIcon(imagenDeFondo.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
        add(fondo);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){

                totalPara_totalPrecio = 0;
                totalPrecio.setText(String.format("%.2f", totalPara_totalPrecio));
                LogicaVentas.ventas.clear();//elimina los elementos del arrayList Ventas
                actualizarTablaVentas();
            }
        });
    }
    
public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() == botonBuscar){
        
        nombreBuscado = NombreProducto.getText().trim();
        indice = LogicaProducto.buscarProducto(nombreBuscado);

        if(indice > -1){
            JOptionPane.showMessageDialog(null, "Se ha encontrado el producto");
            botonCarritoAgregarProducto.setEnabled(true);
            textFieldCantidad.setEnabled(true);
            textFieldCantidad.setDisabledTextColor(Color.WHITE);
            textFieldCantidad.setBackground(new Color(255,255,255));
            NombreProducto.setEnabled(false);
            cantidades.setEnabled(true);
            NombreProducto.setDisabledTextColor(Color.BLACK);
            NombreProducto.setBackground(new Color(200, 200, 200)); // color gris
            botonBuscar.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha encontrado el producto, intente nuevamente");
        }
    }

    if(e.getSource() == botonCarritoAgregarProducto){
        if(agregarProductoAlCarrito(indice)){
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
            NombreProducto.setEnabled(true);
            NombreProducto.setDisabledTextColor(Color.WHITE);
            NombreProducto.setBackground(new Color(255, 255, 255));
            botonBuscar.setEnabled(true);
            botonCarritoAgregarProducto.setEnabled(false);
            textFieldCantidad.setText("");
            textFieldCantidad.setEnabled(false);
            textFieldCantidad.setDisabledTextColor(Color.BLACK);
            textFieldCantidad.setBackground(new Color(200,200,200));
            cantidades.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo agregar el producto, intente nuevamente");
        }
    }
    
    if(e.getSource() == botonQuitarProducto){
        
        int filaSeleccionada = tablaParaVentas.getSelectedRow();
        double totalLuegoDeBorrarElProducto;
    
        if(filaSeleccionada == -1){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un elemento para eliminar");
        }else{
        
            if(filaSeleccionada < LogicaVentas.ventas.size()){
                totalLuegoDeBorrarElProducto = LogicaVentas.quitarProductoVendido(filaSeleccionada, totalPara_totalPrecio);
                if(totalLuegoDeBorrarElProducto < totalPara_totalPrecio){
                    JOptionPane.showMessageDialog(null, "Se ha borrado el producto con éxito");
                    totalPara_totalPrecio = totalLuegoDeBorrarElProducto;
                    actualizarTablaVentas();
                    totalPrecio.setText(String.format("%.2f", totalPara_totalPrecio));
                }else{
                    JOptionPane.showMessageDialog(null, "Error al borrar el producto, intente nuevamente");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Índice de producto no válido");
            }
        }
    }
    
    if(e.getSource() == botonGenerarPdf){
        
        if(totalPara_totalPrecio <= 0){
            
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas generar un informe de ventas con un valor igual o menor a 0?", "Confirmación", JOptionPane.YES_NO_OPTION);
            
            if(confirmacion == JOptionPane.YES_OPTION){
                GenerarPDFVentas pdf = new GenerarPDFVentas(LogicaVentas.ventas, totalPara_totalPrecio);
            }
        }else if(totalPara_totalPrecio > 0){
            GenerarPDFVentas pdf = new GenerarPDFVentas(LogicaVentas.ventas, totalPara_totalPrecio);
            LogicaVentas.ventas.clear(); //borra todos los productos del arraylist
            totalPara_totalPrecio = 0;
            actualizarTablaVentas();
            totalPrecio.setText(String.format("%.2f", totalPara_totalPrecio));
        }
    }
    
}
    
    private boolean agregarProductoAlCarrito(int indice){
        
        String cantidadTexto, getUnidad;
        double canti;
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
            canti = Float.parseFloat(cantidadTexto);
            
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
