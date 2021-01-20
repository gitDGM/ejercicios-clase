/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApartadoA.Ejercicio1;

/**
 *
 * @author alumno
 */
public class UsoPunto {
    public static void main(String[] args) {
        Punto p1 = new Punto(5,0);
        Punto p2 = new Punto(10,10);
        Punto p3 = new Punto(-3,7);
        
        p1.mostrarCoordenadas();
        p2.mostrarCoordenadas();
        p3.mostrarCoordenadas();
        
        p1.setX(p1.getX() + 5);
        p1.setY(7);
        
        p2.setX(p2.getX() - 5);
        p2.setY(p2.getY() * 5);        
        
        p3.setX(p3.getX() / 3);
        p3.setY(p3.getY() * 2);
        
        System.out.println("-------------------------\n");
        
        p1.mostrarCoordenadas();
        p2.mostrarCoordenadas();
        p3.mostrarCoordenadas();
    }
}
