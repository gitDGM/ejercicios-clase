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
public class Punto {
    private int x;
    private int y;
    
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void desplaza(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public int distancia(Punto p) {
        int contarX = 0;
        int contarY = 0;
        
        if (this.x >= p.x) {
            contarX = this.x - p.x;
        } else {            
            contarX = p.x - this.x;
        }
        
        if (this.y >= p.y) {
            contarY = this.y - p.y;
        } else {            
            contarY = p.y - this.y;
        }
        
        return contarX + contarY;
    }
    
    public void imprime() {
        System.out.println("##########");
        System.out.println("X: " + this.getX());
        System.out.println("Y: " + this.getY());
        System.out.println("##########\n");
    }
}
