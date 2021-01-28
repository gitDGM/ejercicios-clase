/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio15;

/**
 *
 * @author alumno
 */
public class UsoColaTabla {
    public static void main(String[] args) {
        ColaTabla miColaTabla = new ColaTabla();
        
        miColaTabla.desencolar();
        miColaTabla.encolar(7);
        miColaTabla.mostrarCola();
        miColaTabla.encolar(76);
        miColaTabla.encolar(45);
        miColaTabla.encolar(31);
        miColaTabla.mostrarCola();
        miColaTabla.desencolar();
        miColaTabla.desencolar();
        miColaTabla.mostrarCola();
    }
}
