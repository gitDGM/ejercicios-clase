/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author alumno
 */
public class Calculadora {
    public static void main(String[] args) {
        MarcoCalculadora marco = new MarcoCalculadora();
    }
}


class MarcoCalculadora extends JFrame {
    public MarcoCalculadora() {
        setBounds(100, 100, 400, 650);
        setTitle("Calculadora");
        
        ClickHandlerButton oyente = new ClickHandlerButton();
        
        LaminaCalculadora laminaResultado = new LaminaCalculadora();
        laminaResultado.setLayout(new BorderLayout());
        laminaResultado.addButtonWithEventHandler(laminaResultado.createButton("0", false), oyente);
        add(laminaResultado, BorderLayout.NORTH);
        
        LaminaCalculadora laminaBotones = new LaminaCalculadora();
        laminaBotones.setLayout(new GridLayout(4,4));
        String[] textoBotones = {"7", "8", "9", "-", "4", "5", "6", "+", "1", "2", "3", "*", "/", "="};
        
        for (String textoBoton : textoBotones) {
            laminaBotones.addButtonWithEventHandler(laminaBotones.createButton(textoBoton, true), oyente);
        }
        add(laminaBotones, BorderLayout.CENTER);
        
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    class LaminaCalculadora extends JPanel {
        
        private JButton createButton(String texto, Boolean activo) {
            JButton boton = new JButton(texto);
            if (activo) { 
                boton.setEnabled(activo);
            } else {
                boton.setEnabled(activo);
            }
            return boton;
        }
        
        private void addButtonWithEventHandler(JButton boton, ClickHandlerButton oyente) {
            boton.addActionListener(oyente);  
            add(boton);
        }
    }
    
    private class ClickHandlerButton implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botonPressed = (JButton)e.getSource();
                
                switch (botonPressed.getText()) {
                    case "+":
                        break;
                    case "-":
                        break;
                    case "*":
                        break;
                    case "/":
                        break;
                    case "=":
                        break;
                    default:
                        System.out.println(botonPressed.getText());
                        break;
                }
            }
        }
}

