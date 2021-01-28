/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio13;

/**
 *
 * @author alumno
 */
public class UsoPila {
    public static void main(String[] args) {
        PilaTabla mipila = new PilaTabla();
        
        mipila.apilar(10);
        
        mipila.mostrarPila();
        mipila.apilar(25);
        mipila.apilar(42);
        mipila.apilar(7);
        mipila.mostrarPila();
        mipila.retirar();
        mipila.retirar();
        mipila.mostrarPila();
        mipila.apilar(97);
        mipila.apilar(15);
        mipila.retirar();
        mipila.apilar(300);
        mipila.mostrarPila();
    }
}
