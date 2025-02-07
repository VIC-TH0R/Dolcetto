package Interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class PantallaDeInicio extends JFrame implements ActionListener{
    
    private JLabel imagenEmpresa, usuario, logo, IniciarSesion, separador;
    private JTextField nombre;
    private JButton ingresar;
    static String recuperarNombre;
    
    public PantallaDeInicio(){
        
        setLayout(null);
        this.setTitle("Pantalla de Ingreso");
        getContentPane().setBackground(new Color(255,209,220));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //images
        ImageIcon empresa = new ImageIcon("images/Dolcetto/dolcetto-superpuesto.jpg"); 
        ImageIcon paraLogo = new ImageIcon("images/Dolcetto/pdfgenerator.png");
        
        //JLabels
        
        separador = new JLabel();
        separador.setBounds(290,0,1,370);
        separador.setBorder(BorderFactory.createLineBorder(new Color(50,50,50)));
        add(separador);
        
        imagenEmpresa = new JLabel();
        imagenEmpresa.setBounds(290,0,300,370);
        imagenEmpresa.setIcon(new ImageIcon(empresa.getImage().getScaledInstance(imagenEmpresa.getWidth(), imagenEmpresa.getHeight(), Image.SCALE_SMOOTH)));
        add(imagenEmpresa);
        
        logo = new JLabel();
        logo.setBounds(10,10,90,70);
        logo.setIcon(new ImageIcon(paraLogo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH)));
        add(logo);
        
        usuario = new JLabel("Usuario");
        usuario.setBounds(20,150,70,30);
        usuario.setFont(new Font("Andale Mono", 1, 12));
        add(usuario);
        
        IniciarSesion = new JLabel("Iniciar Sesión");
        IniciarSesion.setBounds(10,90,150,30);
        IniciarSesion.setFont(new Font("Andale Mono", 1, 16));
        add(IniciarSesion);
        
        //JTextFields
        
        nombre = new JTextField("Ingrese su usuario");
        nombre.setBounds(10,180,170,30);
        nombre.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        add(nombre);
        
        ingresar = new JButton("Ingresar");
        ingresar.setBounds(10,215,90,30);
        ingresar.setBackground(new Color(255,255,255));
        ingresar.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
        ingresar.addActionListener(this);
        add(ingresar);
        
    }
    
    public void actionPerformed(ActionEvent e){
                
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
