/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio12;

/**
 *
 * @author alumno
 */
public class UsoLista {
    public static void main(String[] args) {
        
        Lista milista = new Lista(5);
        
        Lista milista2 = new Lista(5);
        
        /*
        milista.insertarNumeroAlFinal(5);
        milista.insertarNumeroEnIndice(9, 0);
        */
        
        milista.insertarNumeroAlFinal(5);
        milista.insertarNumeroAlPrincipio(3);
        milista.insertarNumeroAlPrincipio(2);
        milista.insertarNumeroAlPrincipio(7);
        milista.insertarNumeroAlFinal(15);
        milista.insertarNumeroAlFinal(24);
        milista.insertarNumeroAlFinal(50);
        milista.insertarNumeroEnIndice(75, 4);
        milista.insertarNumeroEnIndice(64, 4);
        
        milista2.insertarNumeroAlFinal(7);
        milista2.insertarNumeroAlFinal(8);
        milista2.insertarNumeroAlFinal(17);
        
        milista.insertarListaAlFinal(milista2);
        
        milista.mostrarLista();
        
        milista.eliminarNumeroEnIndice(5);
        milista.mostrarLista();
        
        milista.insertarNumeroEnIndice(99, 11);
        milista.insertarNumeroAlFinal(66);
        milista.mostrarLista();
    }
}
