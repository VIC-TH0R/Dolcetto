package Interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PantallaAcciones extends JFrame implements ActionListener{
    
    private JButton botonRegistrarProductos, botonModificarProductos;
    private JButton botonGenerarInforme, botonSalir;
    private JLabel registroProductos, modificarProductos, generarInforme, salir;
    
    public PantallaAcciones(){
        
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //JButton with its images
        
        ImageIcon iconoProductos = new ImageIcon("images/agregar-producto.png");
        ImageIcon iconoModificar = new ImageIcon("images/editarproductos.png");
        ImageIcon iconoInforme = new ImageIcon("images/pdfgenerator.png");
        ImageIcon iconoSalir = new ImageIcon("images/exit.png");
        
        //JButtons
        botonRegistrarProductos = new JButton();
        botonRegistrarProductos.setBounds(15,90,100,100);           //falta agregar los listener a los
        botonRegistrarProductos.setIcon(new ImageIcon(iconoProductos.getImage().getScaledInstance(botonRegistrarProductos.getWidth(), botonRegistrarProductos.getHeight(), Image.SCALE_SMOOTH)));
        botonRegistrarProductos.addActionListener(this);
        add(botonRegistrarProductos);                               
        
        botonModificarProductos = new JButton();
        botonModificarProductos.setBounds(150,90,100,100);
        botonModificarProductos.setIcon(new ImageIcon(iconoModificar.getImage().getScaledInstance(botonModificarProductos.getWidth(), botonModificarProductos.getHeight(), Image.SCALE_SMOOTH)));
        botonModificarProductos.addActionListener(this);
        add(botonModificarProductos);
        
        botonGenerarInforme = new JButton();
        botonGenerarInforme.setBounds(285,90,100,100);
        botonGenerarInforme.setIcon(new ImageIcon(iconoInforme.getImage().getScaledInstance(botonGenerarInforme.getWidth(), botonGenerarInforme.getHeight(), Image.SCALE_SMOOTH)));
        botonGenerarInforme.addActionListener(this);
        add(botonGenerarInforme);
        
        botonSalir = new JButton();
        botonSalir.setBounds(420,90,100,100);
        botonSalir.setIcon(new ImageIcon(iconoSalir.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_SMOOTH)));
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
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == botonRegistrarProductos){
            abrirVentanaRegistrarProductos();
        }else if(e.getSource() == botonModificarProductos){
            abrirVentanaModificarProducto();
        }else if(e.getSource() == botonGenerarInforme){
            
            PantallaGenerarPDF pantallaPDF = new PantallaGenerarPDF();
            
            pantallaPDF.setVisible(true);
            pantallaPDF.setBounds(0,0,400,700);
            pantallaPDF.setLocationRelativeTo(botonSalir);
            pantallaPDF.setResizable(true);
        }
    }
    
    private void abrirVentanaRegistrarProductos(){
        
        PantallaRegistrarProductos registro = new PantallaRegistrarProductos();
        registro.setVisible(true);
        registro.setBounds(0,0,400,250);
        registro.setLocationRelativeTo(botonGenerarInforme);
        registro.setResizable(false);
    }
    
    private void abrirVentanaModificarProducto(){
        
        PantallaBuscarProductos modificarProductos = new PantallaBuscarProductos();
        modificarProductos.setBounds(0,0,400,400);
        modificarProductos.setVisible(true);
        modificarProductos.setLocationRelativeTo(botonSalir);
        modificarProductos.setResizable(true);
    }
}
