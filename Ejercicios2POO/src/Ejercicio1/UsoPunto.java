/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author alumno
 */
public class UsoPunto {
    public static void main(String[] args) {
        Punto p1 = new Punto(5,0);
        Punto p2 = new Punto(10,10);
        Punto p3 = new Punto(-3,7);
        
        System.out.println("Punto 1");
        p1.imprime();
        System.out.println("Punto 2");
        p2.imprime();
        System.out.println("Punto 3");
        p3.imprime();
        
        p1.setX(p1.getX() + 5);
        p1.setY(7);
        
        p2.setX(p2.getX() - 5);
        p2.setY(p2.getY() * 5);        
        
        p3.setX(p3.getX() / 3);
        p3.setY(p3.getY() * 2);
        
        System.out.println("-------------------------\n");
        
        System.out.println("Punto 1");
        p1.imprime();
        System.out.println("Punto 2");
        p2.imprime();
        System.out.println("Punto 3");
        p3.imprime();
        
        System.out.println("-------------------------\n");
        
        System.out.println("Punto 1");
        p1.setXY(7, -5);
        p1.imprime();
        
        System.out.println("-------------------------\n");
        
        System.out.println("Punto 2");
        p2.desplaza(5, 10);
        p2.imprime();
        
        System.out.println("-------------------------\n");
        
        System.out.println("Punto 3");
        p3.imprime();  
        System.out.println("Punto 2");
        p2.imprime();      
        System.out.println("Distancia entre p3 y p2: " + p3.distancia(p2));
        
        System.out.println("-------------------------\n");
        
        Punto p4 = Punto.creaPuntoAleatorio();
        p4.imprime();
    }
}
