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
            r2 = new Rectangulo(0, 0, 0, 0);
            r3 = new Rectangulo(0, 0, 0, 0);
            r4 = new Rectangulo(0, 0, 0, 0);        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Rectangulo r5 = crearRectangulo();
        
        Rectangulo r5 = Rectangulo.crearRectanguloAleatorio();
        
        try {
            r1 = new Rectangulo(1, 5, 10, 7);
            System.out.println("Rectangulo 1");
            r1.imprimir();
            r1.getPerimetro();
            r1.getArea();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        System.out.println("\n----------------------\n");
        
        System.out.println("Rectangulo 2");
        r2.imprimir();
        try {
            r2.setX1Y1(4, 7);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        try {
            r2.setX2Y2(7, 5);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
            
            
        
        r2.imprimir();        
        
        System.out.println("\n----------------------\n");
        
        System.out.println("Rectangulo 3");
        r3.imprimir();
        try {
            r3.setX1(5);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            r3.setX2(7);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            r3.setY1(5);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
            r3.setY1(5);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        r3.imprimir();   
        
        System.out.println("\n----------------------\n");
        
        System.out.println("Rectangulo 4");
        r4.imprimir();
        try {
            r4.setAll(6, 2, 15, 30);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        r4.imprimir();
        r4.getPerimetro();
        r4.getArea();
        
        System.out.println("\n----------------------\n");
        
        System.out.println("Rectangulo 5");
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
