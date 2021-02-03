/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import Ejercicio1.Punto;

/**
 *
 * @author alumno
 */
public class Rectangulo2 {
    private Punto p1, p2;

    public Rectangulo2(Punto p1, Punto p2) throws Exception {
        if (comprobarSiP1Menor(p1, p2)) {            
            this.p1 = p1;
            this.p2 = p2;
        } else {
            throw new Exception("ERROR: Rectángulo mal creado.");
        }
    }

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }

    public void setP1(Punto p1) {
        if (comprobarSiP1Menor(p1, this.p2)) {
            this.p1 = p1;
        } else {
            System.err.println("Punto 1 inválido");
        }
    }

    public void setP2(Punto p2) {
        if (comprobarSiP1Menor(this.p1, p2)) {
            this.p2 = p2;
        } else {
            System.err.println("Punto 2 inválido");
        }
    }
    
    public double getPerimetro() {
        int ancho, alto;
        
        ancho = p2.getX() - p1.getX();
        alto = p2.getY() - p1.getY(); 
        
        return (ancho * 2) + (alto * 2);
    }
    
    public double getArea() {
        int ancho, alto;
        
        ancho = p2.getX() - p1.getX();
        alto = p2.getY() - p1.getY(); 
        
        return (ancho * alto);
    }    
    
    public void imprimir() {
        System.out.println("###############");
        System.out.println("(X1, Y1): (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("(X2, Y2): (" + p2.getX() + ", " + p2.getY() + ")");
        System.out.println("###############");
    }
    
    
    private boolean comprobarSiP1Menor(Punto p1, Punto p2) {
        return p1.getX() <= p2.getX() && p1.getY() <= p2.getY();
    }
    
    public static Rectangulo2 crearRectanguloAleatorio() {
        boolean creado;
        Rectangulo2 r = null;
        do {           
            int x1 = (int) (Math.random() * 100 + 1);
            int y1 = (int) (Math.random() * 100 + 1);
            int x2 = (int) (Math.random() * 100 + 1);
            int y2 = (int) (Math.random() * 100 + 1); 
            
            Punto p1 = new Punto(x1, y1);
            Punto p2 = new Punto(x2, y2);
            
            try {
                r = new Rectangulo2(p1, p2);  
                creado = true;
            } catch (Exception e) {
                creado = false;
            }
        } while (!creado);
        
        return r;        
    }
}
