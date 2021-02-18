/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class FuguraPrinci {
    
    public static void main(String[] args) {
        
        // 1.
        ArrayList<IFigura> figuras = new ArrayList();
        
        
        // 2.
        figuras.add(new Cuadrado(12));
        figuras.add(new Rectangulo(8, 14));
        figuras.add(new Triangulo(15, 22));
        figuras.add(new Circulo(7));
        
        
        // 3.
        mostrarFiguras(figuras);
        
        
        // 4.
        figuras = escalarFiguras(figuras, 2);
        // 5.
        mostrarFiguras(figuras);
        
        
        // 6.
        figuras = escalarFiguras(figuras, 0.1);
        // 7.
        mostrarFiguras(figuras);        
    }
    
    static void mostrarFiguras(ArrayList<IFigura> figuras) {
        for (int i = 0; i < figuras.size(); i++) {
            System.out.println("Figura " + (i + 1));
            figuras.get(i).imprimir(); 
            System.out.println("#################\n");
        }
    }
    
    static ArrayList<IFigura> escalarFiguras(ArrayList<IFigura> figuras, double escala) {
        for (int i = 0; i < figuras.size(); i++) {
            figuras.get(i).escalar(escala);
        }
        return figuras;
    }
}
