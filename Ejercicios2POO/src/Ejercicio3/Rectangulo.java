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

    public Rectangulo(int x1, int y1, int x2, int y2) throws Exception {
        if (x1 >= min && x1 <= max && x1 <= x2) {
            this.x1 = x1;            
        } else {
            throw new Exception("Rectangulo no válido.");
        }
        
        if (y1 >= min && y1 <= max && y1 <= y2) {
            this.y1 = y1;            
        } else {
            throw new Exception("Rectangulo no válido.");
        }
        
        if (x2 >= min && x2 <= max && x2 >= x1) {
            this.x2 = x2;            
        } else {
            throw new Exception("Rectangulo no válido.");
        }
        
        if (y2 >= min && y2 <= max && y2 >= y1) {
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

    public void setX1(int x1) throws Exception {
        if (x1 >= min && x1 <= max && x1 <= x2) {
            this.x1 = x1;            
        } else {
            throw new Exception("Valor X1 no válido.");
        }
    }

    public void setX2(int x2) throws Exception {
        if (x2 >= min && x2 <= max && x2 >= x1) {
            this.x2 = x2;            
        } else {
            throw new Exception("Valor X2 no válido.");
        }
    }

    public void setY1(int y1) throws Exception {
        if (y1 >= min && y1 <= max && y1 <= y2) {
            this.y1 = y1;            
        } else {
            throw new Exception("Valor Y1 no válido.");
        }
    }

    public void setY2(int y2) throws Exception {
        if (y2 >= min && y2 <= max && y2 >= y1) {
            this.y2 = y2;            
        } else {
            throw new Exception("Valor Y2 no válido.");
        }
    }
    
    public void setX1Y1(int x1, int y1) throws Exception {
        if (x1 >= min && x1 <= max && x1 <= x2) {
            this.x1 = x1;            
        } else {
            throw new Exception("Valor X1 no válido.");
        }
        if (y1 >= min && y1 <= max && y1 <= y2) {
            this.y1 = y1;            
        } else {
            throw new Exception("Valor Y1 no válido.");
        }
    }
    
    public void setX2Y2(int x2, int y2) throws Exception {
        if (x2 >= min && x2 <= max && x2 >= x1) {
            this.x2 = x2;            
        } else {
            throw new Exception("Valor X2 no válido.");
        }
        if (y2 >= min && y2 <= max && y2 >= y1) {
            this.y2 = y2;            
        } else {
            throw new Exception("Valor Y2 no válido.");
        }
    }
    
    public void setAll(int x1, int y1, int x2, int y2) throws Exception {
        if (x1 >= min && x1 <= max && x1 <= x2) {
            this.x1 = x1;            
        } else {
            throw new Exception("Valor X1 no válido.");
        }
        
        if (y1 >= min && y1 <= max && y1 <= y2) {
            this.y1 = y1;            
        } else {
            throw new Exception("Valor Y1 no válido.");
        }
        
        if (x2 >= min && x2 <= max && x2 >= x1) {
            this.x2 = x2;            
        } else {
            throw new Exception("Valor X2 no válido.");
        }
        
        if (y2 >= min && y2 <= max && y2 >= y1) {
            this.y2 = y2;            
        } else {
            throw new Exception("Valor Y2 no válido.");
        }
    }
    
    public void getPerimetro() {
        int ancho, alto;
        
        ancho = this.x2 - this.x1;
        alto = this.y2 - this.y1; 
        
        System.out.println("Perímetro: " + ((ancho * 2) + (alto * 2)));
    }
    
    public void getArea() {
        int ancho, alto;
        
        ancho = this.x2 - this.x1;
        alto = this.y2 - this.y1; 
        
        System.out.println("Área: " + (ancho * alto));
    }
    
    public void imprimir() {
        System.out.println("###############");
        System.out.println("(X1, Y1): (" + this.getX1() + ", " + this.getY1() + ")");
        System.out.println("(X2, Y2): (" + this.getX2() + ", " + this.getY2() + ")");
        System.out.println("###############");
    }
    
    public static Rectangulo crearRectanguloAleatorio() {
        boolean creado = false;
        Rectangulo r = null;
        do {           
            int x1 = (int) (Math.random() * 100 + 1);
            int y1 = (int) (Math.random() * 100 + 1);
            int x2 = (int) (Math.random() * 100 + 1);
            int y2 = (int) (Math.random() * 100 + 1); 
            
            try {
                r = new Rectangulo(x1, y1, x2, y2);  
                creado = true;
            } catch (Exception e) {
                System.err.println("Rectangulo aleatorio inválido, probando otro.");
            }
        } while (!creado);
        
        return r;        
    }
}
