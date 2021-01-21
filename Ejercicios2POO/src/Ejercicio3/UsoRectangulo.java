/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author alumno
 */
public class UsoRectangulo {
    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo(1, 5, 10, 7);
        Rectangulo r2 = new Rectangulo(0, 0, 0, 0);
        Rectangulo r3 = new Rectangulo(0, 0, 0, 0);
        Rectangulo r4 = new Rectangulo(0, 0, 0, 0);
        
        System.out.println("Rectangulo 1");
        r1.imprimir();
        r1.getPerimetro();
        r1.getArea();
        
        System.out.println("\n----------------------\n");
        
        System.out.println("Rectangulo 2");
        r2.imprimir();
        r2.setX1Y1(4, 7);
        r2.setX2Y2(7, 5);
        r2.imprimir();        
        
        System.out.println("\n----------------------\n");
        
        System.out.println("Rectangulo 3");
        r3.imprimir();
        r3.setX1(5);
        r3.setX2(7);
        r3.setY1(5);
        r3.setY2(15);
        r3.imprimir();   
        
        System.out.println("\n----------------------\n");
        
        System.out.println("Rectangulo 4");
        r4.imprimir();
        r4.setAll(6, 2, 15, 30);
        r4.imprimir();
        r4.getPerimetro();
        r4.getArea();
    }
}
