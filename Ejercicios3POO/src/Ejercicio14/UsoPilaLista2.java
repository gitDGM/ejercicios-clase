/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio14;

/**
 *
 * @author alumno
 */
public class UsoPilaLista2 {
    public static void main(String[] args) {
        PilaLista2 miPilaLista = new PilaLista2();
        
        miPilaLista.apilar(5);
        miPilaLista.mostrarPila();
        miPilaLista.apilar(64);
        miPilaLista.apilar(28);
        miPilaLista.apilar(15);
        miPilaLista.mostrarPila();
        miPilaLista.retirar();
        miPilaLista.mostrarPila();
        miPilaLista.apilar(52);
        miPilaLista.apilar(18);
        miPilaLista.apilar(95);
        miPilaLista.mostrarPila();
        miPilaLista.retirar();
        miPilaLista.retirar();
        miPilaLista.mostrarPila();
    }
}
