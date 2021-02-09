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
            if (comprobarSiCoordenadasEnRango(p1, p2)) {
                throw new Exception("ERROR: Rectángulo mal creado - Puntos fuera de rango (0 - 100)");
            } else {
                throw new Exception("ERROR: Rectángulo mal creado - P1 mayor que P2");                
            }
        }
    }

    public Punto getP1() {
        return p1;
    }

    public Punto getP2() {
        return p2;
    }
    
    public int getX1() {
        return p1.getX();
    }
    
    public int getY1() {
        return p1.getY();
    }
    
    public int getX2() {
        return p2.getX();
    }
    
    public int getY2() {
        return p2.getY();
    }
    
    public void setX1(int x1) {
        if (comprobarSiP1Menor(new Punto(x1, p1.getY()), p2)) {
            p1 = new Punto(x1, p1.getY());
        } else {
            System.err.println("ERROR: Nuevo X1 inválido");
        }
    }
    
    public void setX2(int x2) {
        if (comprobarSiP1Menor(p1, new Punto(x2, p2.getY()))) {
            p2 = new Punto(x2, p2.getY());
        } else {
            System.err.println("ERROR: Nuevo X2 inválido");
        }
    }
    
    public void setY1(int y1) {
        if (comprobarSiP1Menor(new Punto(p1.getX(), y1), p2)) {
            p1 = new Punto(p1.getX(), y1);
        } else {
            System.err.println("ERROR: Nuevo Y1 inválido");
        }
    }
    
    public void setY2(int y2) {
        if (comprobarSiP1Menor(p1, new Punto(p2.getX(), y2))) {
            p2 = new Punto(p2.getX(), y2);
        } else {
            System.err.println("ERROR: Nuevo Y2 inválido");
        }
    }

    public void setP1(Punto p1) {
        if (comprobarSiP1Menor(p1, this.p2)) {
            this.p1 = p1;
        } else {
            System.err.println("ERROR: Nuevo P1 inválido");
        }
    }

    public void setP2(Punto p2) {
        if (comprobarSiP1Menor(this.p1, p2)) {
            this.p2 = p2;
        } else {
            System.err.println("ERROR: Nuevo P2 inválido");
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
        return p1.getX() <= p2.getX() && p1.getY() <= p2.getY() && comprobarSiCoordenadasEnRango(p1, p2);
    }
    
    private boolean comprobarSiCoordenadasEnRango(Punto p1, Punto p2) {
        boolean result = true;
        
        result = p1.getX() <= 100 && p1.getX() >= 0 && result;
        result = p1.getY() <= 100 && p1.getY() >= 0 && result;
        result = p2.getX() <= 100 && p2.getX() >= 0 && result;
        result = p2.getY() <= 100 && p2.getY() >= 0 && result;
        
        return result;
    }
    
    public static Rectangulo2 crearRectanguloAleatorio() {
        boolean creado;
        Rectangulo2 r = null;
        do {           
            int x1 = (int) (Math.random() * (100 + 1));
            int y1 = (int) (Math.random() * (100 + 1));
            int x2 = (int) (Math.random() * (100 + 1));
            int y2 = (int) (Math.random() * (100 + 1));
            
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
