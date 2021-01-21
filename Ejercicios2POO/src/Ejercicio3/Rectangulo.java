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
    private static final int min = 0;
    private static final int max = 100;

    public Rectangulo(int x1, int x2, int y1, int y2) throws Exception {
        if (x1 >= min && x1 <= max) {
            this.x1 = x1;            
        } else {
            throw new Exception("Rectangulo no válido.");
        }
        
        if (y1 >= min && y1 <= max) {
            this.y1 = y1;            
        } else {
            throw new Exception("Rectangulo no válido.");
        }
        
        if (x2 >= min && x2 <= max) {
            this.x2 = x2;            
        } else {
            throw new Exception("Rectangulo no válido.");
        }
        
        if (y2 >= min && y2 <= max) {
            this.y2 = y2;            
        } else {
            throw new Exception("Rectangulo no válido.");
        }
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
        
        System.out.println("Perímetro: " + ((ancho * 2) + (alto * 2)));
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
    
    public static Rectangulo crearRectanguloAleatorio() {
        int x1 = (int) (Math.random() * 100 + 1);
        int y1 = (int) (Math.random() * 100 + 1);
        int x2 = (int) (Math.random() * 100 + 1);
        int y2 = (int) (Math.random() * 100 + 1);
        
        Rectangulo r = null;
        try {
            r = new Rectangulo(x1, y1, x2, y2);  
        } catch (Exception e) {
            System.err.println("Error");
        }
        
        return r;
        
    }
}
