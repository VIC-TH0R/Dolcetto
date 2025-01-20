package Interfaz;

import static Interfaz.PantallaDeInicio.recuperarNombre;
import logica.LogicaCondiciones;
import java.awt.event.*;
import javax.swing.*;

public class PantallaCondiciones extends JFrame implements ActionListener{
    
    public JTextArea textArea;
    private JScrollPane scrollpane;
    private JButton acepto;
    private JRadioButton aceptar, noAceptar;
    private ButtonGroup grupoBoton;
    
    
    public PantallaCondiciones(){
        
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        textArea.setBounds(10,10,690,280);
        textArea.setEditable(false);
        add(textArea);
        
        mostrarCondiciones();
        
        scrollpane = new JScrollPane(textArea);
        scrollpane.setBounds(10,10,585,275);
        this.add(scrollpane);
        
        grupoBoton = new ButtonGroup();
        
        aceptar = new JRadioButton();
        aceptar.setText("Yo " + recuperarNombre + " Acepto");
        aceptar.setBounds(10,290,150,30);
        aceptar.addActionListener(this);
        this.add(aceptar);
        
        noAceptar = new JRadioButton();
        noAceptar.setText("No acepto");
        noAceptar.setBounds(160,290,100,30);
        noAceptar.addActionListener(this);
        this.add(noAceptar);
        
        grupoBoton.add(aceptar);
        grupoBoton.add(noAceptar);
        
        acepto = new JButton("Acepto");
        acepto.setBounds(520,320,80,30);
        acepto.setEnabled(false);
        acepto.addActionListener(this);
        add(acepto);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == aceptar){
            acepto.setEnabled(true);
        }else if(e.getSource() == noAceptar){
            acepto.setEnabled(false);
        }
        if(e.getSource() == acepto){
            this.dispose();
            abrirPantallaAcciones();
        }
    }
    
    private void abrirPantallaAcciones(){
        
        PantallaAcciones acciones = new PantallaAcciones();
        acciones.setBounds(0,0,550,350);
        acciones.setVisible(true);
        acciones.setLocationRelativeTo(null);
        acciones.setResizable(true);
    }
    
    private void mostrarCondiciones(){
        
        LogicaCondiciones logica = new LogicaCondiciones();
        String contenidoArchivo = logica.leerContenidoArchivo();
        textArea.setText(contenidoArchivo); 
    }
}
