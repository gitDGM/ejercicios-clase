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
public class Rectangulo {
    private int x1, x2, y1, y2;

    public Rectangulo(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    
    public void setX1Y1(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public void setX2Y2(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void setAll(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void getPerimetro() {
        int ancho, alto;
        
        ancho = this.x1 > this.x2 ? this.x1 - this.x2 : this.x2 - this.x1;
        alto = this.y1 > this.y2 ? this.y1 - this.y2 : this.y2 - this.y1; 
        
        System.out.println("Perímetro: " + (ancho * 2) + (alto * 2));
    }
    
    public void getArea() {
        int ancho, alto;
        
        ancho = this.x1 > this.x2 ? this.x1 - this.x2 : this.x2 - this.x1;
        alto = this.y1 > this.y2 ? this.y1 - this.y2 : this.y2 - this.y1; 
        
        System.out.println("Área: " + (ancho * alto));
    }
    
    public void imprimir() {
        System.out.println("###############");
        System.out.println("(X1, Y1): (" + this.getX1() + ", " + this.getY1() + ")");
        System.out.println("(X2, Y2): (" + this.getX2() + ", " + this.getY2() + ")");
        System.out.println("###############");
    }
}
