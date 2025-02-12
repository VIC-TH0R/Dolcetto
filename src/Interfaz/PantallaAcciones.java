package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PantallaAcciones extends JFrame implements ActionListener{
    
    private JButton botonRegistrarProductos, botonModificarProductos;
    private JButton botonGenerarInforme, botonSalir;
    private JLabel registroProductos, modificarProductos, generarInforme, salir, imagenFondo;
    private String nombre;
    
    public PantallaAcciones(String nombreRecuperado){
        
        setLayout(null);
        nombre = nombreRecuperado;
        this.setTitle("Bienvenido " + nombre);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Images 
        
        ImageIcon imagenDeFondo = new ImageIcon("images/fondo.jpg");
        
        //JButton with it's images
        
        ImageIcon iconoProductos = new ImageIcon("images/agregar-productoGrande.png");
        ImageIcon iconoModificar = new ImageIcon("images/editarProductosGrande.png");
        ImageIcon iconoInforme = new ImageIcon("images/pdfGeneratorGrande.png");
        ImageIcon iconoSalir = new ImageIcon("images/exitGrande.png");
        
        //JButtons
        botonRegistrarProductos = new JButton();
        botonRegistrarProductos.setBounds(15,90,100,100);           //falta agregar los listener a los
        botonRegistrarProductos.setIcon(new ImageIcon(iconoProductos.getImage().getScaledInstance(botonRegistrarProductos.getWidth(), botonRegistrarProductos.getHeight(), Image.SCALE_SMOOTH)));
        botonRegistrarProductos.setBackground(new Color(255, 230, 250));
        botonRegistrarProductos.setBorder(BorderFactory.createLineBorder(new Color(255, 230, 250)));
        botonRegistrarProductos.addActionListener(this);
        add(botonRegistrarProductos);                               
        
        botonModificarProductos = new JButton();
        botonModificarProductos.setBounds(150,90,100,100);
        botonModificarProductos.setIcon(new ImageIcon(iconoModificar.getImage().getScaledInstance(botonModificarProductos.getWidth(), botonModificarProductos.getHeight(), Image.SCALE_SMOOTH)));
        botonModificarProductos.setBackground(new Color(254, 240, 253));
        botonModificarProductos.setBorder(BorderFactory.createLineBorder(new Color(254, 240, 253)));
        botonModificarProductos.addActionListener(this);
        add(botonModificarProductos);
        
        botonGenerarInforme = new JButton();
        botonGenerarInforme.setBounds(285,90,100,100);
        botonGenerarInforme.setIcon(new ImageIcon(iconoInforme.getImage().getScaledInstance(botonGenerarInforme.getWidth(), botonGenerarInforme.getHeight(), Image.SCALE_SMOOTH)));
        botonGenerarInforme.setBackground(new Color(254, 240, 253));
        botonGenerarInforme.setBorder(BorderFactory.createLineBorder(new Color(254, 240, 253)));
        botonGenerarInforme.addActionListener(this);
        add(botonGenerarInforme);
        
        botonSalir = new JButton();
        botonSalir.setBounds(420,90,100,100);
        botonSalir.setIcon(new ImageIcon(iconoSalir.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_SMOOTH)));
        botonSalir.setBackground(new Color(255, 240, 252));
        botonSalir.setBorder(BorderFactory.createLineBorder(new Color(255, 240, 252)));
        botonSalir.addActionListener(this);
        add(botonSalir);
        
        //JLabels
        
        registroProductos = new JLabel("Registrar productos");
        registroProductos.setBounds(10,185,200,30);
        registroProductos.setFont(new Font("Andale Mono", 1, 11));
        add(registroProductos);
        
        modificarProductos = new JLabel("Mofificar productos");
        modificarProductos.setBounds(150,185,200,30);
        modificarProductos.setFont(new Font("Andale Mono", 1, 11));
        add(modificarProductos);
        
        generarInforme = new JLabel("Generar Informe");
        generarInforme.setBounds(290,185,200,30);
        generarInforme.setFont(new Font("Andale Mono", 1, 11));
        add(generarInforme);
        
        salir = new JLabel("Salir");
        salir.setBounds(455,185,200,30);
        salir.setFont(new Font("Andale Mono", 1, 11));
        add(salir);
        
        imagenFondo = new JLabel();
        imagenFondo.setBounds(0,0,550,330);
        imagenFondo.setIcon(new ImageIcon(imagenDeFondo.getImage().getScaledInstance(imagenFondo.getWidth(), imagenFondo.getHeight(), Image.SCALE_SMOOTH)));
        add(imagenFondo);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == botonRegistrarProductos){
            abrirVentanaRegistrarProductos();
        }else if(e.getSource() == botonModificarProductos){
            abrirPantallaEditarEliminarProducto();
        }else if(e.getSource() == botonGenerarInforme){
            abrirPantallaGenerarPDF();
        }else if(e.getSource() == botonSalir){
            System.exit(0);
        }
    }
    
    private void abrirVentanaRegistrarProductos(){
        
        PantallaRegistrarProductos registro = new PantallaRegistrarProductos();
        registro.setVisible(true);
        registro.setBounds(0,0,400,250);
        registro.setLocationRelativeTo(botonGenerarInforme);
        registro.setResizable(false);
    }
    
    private void abrirPantallaEditarEliminarProducto(){
        
        PantallaEditarEliminarProductos modificarProductos = new PantallaEditarEliminarProductos();
        modificarProductos.setBounds(0,0,400,500);
        modificarProductos.setVisible(true);
        modificarProductos.setLocationRelativeTo(botonSalir);
        modificarProductos.setResizable(false);
    }
    
    private void abrirPantallaGenerarPDF(){
        PantallaGenerarPDF pantallaPDF = new PantallaGenerarPDF();
            
            pantallaPDF.setVisible(true);
            pantallaPDF.setBounds(0,0,400,700);
            pantallaPDF.setLocationRelativeTo(botonSalir);
            pantallaPDF.setResizable(false);
    }
}
