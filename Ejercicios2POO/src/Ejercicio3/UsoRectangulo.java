/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class UsoRectangulo {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Rectangulo r1 = null, r2 = null, r3 = null, r4 = null;
        try {
            r1 = new Rectangulo(1, 5, 10, 7);
            r2 = new Rectangulo(0, 0, 0, 0);
            r3 = new Rectangulo(0, 0, 0, 0);
            r4 = new Rectangulo(0, 0, 0, 0);        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Rectangulo r5 = crearRectangulo();
        
        Rectangulo r5 = Rectangulo.crearRectanguloAleatorio();
        
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
        
        System.out.println("\n----------------------\n");
        
        r5.imprimir();
    }
    
    public static Rectangulo crearRectangulo() {
        boolean creado = false;
        Rectangulo r = null;
        do {            
            try {
                System.out.println("Introduce X1:");
                int x1 = sc.nextInt();
                
                System.out.println("Introduce Y1:");
                int y1 = sc.nextInt();
                
                System.out.println("Introduce X2:");
                int x2 = sc.nextInt();
                
                System.out.println("Introduce Y2:");
                int y2 = sc.nextInt();                
                r = new Rectangulo(x1, y1, x2, y2);
                
                creado = true;
            } catch (Exception e) {
                System.err.println("Debes introducir valores entre 0 y 100");
            }
        } while (!creado);        
        
        return r;
    }
}
