package Interfaz;

import java.awt.event.*;
import javax.swing.*;

public class PantallaDeInicio extends JFrame implements ActionListener{
    
    private JLabel label1, label2;
    private JTextField nombre;
    private JButton ingresar;
    private JButton salir;
    static String recuperarNombre;
    
    public PantallaDeInicio(){
        
        setLayout(null);
        this.setTitle("Ingreso");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        label1 = new JLabel("Sistema de gestión");
        label1.setBounds(250,10,230,30);
        add(label1);
        
        label2 = new JLabel("Nombre");
        label2.setBounds(10,45,70,30);
        add(label2);
        
        nombre = new JTextField();
        nombre.setBounds(10,70,170,30);
        add(nombre);
        
        ingresar = new JButton("Ingresar");
        ingresar.setBounds(10,170,90,30);
        ingresar.addActionListener(this);
        add(ingresar);
        
        salir = new JButton("Salir");
        salir.setBounds(105,170,70,30);
        salir.addActionListener(this);
        add(salir);
    }
    
    public void actionPerformed(ActionEvent e){
                
        if(e.getSource() == salir){
            this.dispose();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        
        if(e.getSource() == ingresar){
            recuperarNombre = nombre.getText();
            if(recuperarNombre.isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor, introduzca un nombre para continuar");
            }else{
                abrirVentanaCondiciones(recuperarNombre);
            }
        }
    }
    
    void abrirVentanaCondiciones(String nombre){
        PantallaCondiciones condiciones = new PantallaCondiciones();
        this.dispose();
        condiciones.setVisible(true);
        condiciones.setBounds(0,0,700,400);
        condiciones.setLocationRelativeTo(null);
    }
}
