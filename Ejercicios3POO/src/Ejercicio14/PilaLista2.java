/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio14;

import Ejercicio12.Lista;
/**
 *
 * @author alumno
 */
public class PilaLista2 {
    private int cantidadElementos;
    private final Lista lista;

    public PilaLista2() {
        this.cantidadElementos = 0;
        this.lista = new Lista(1);
    }
    
    public void apilar(int numero) {        
        this.lista.insertarNumeroAlFinal(numero);      
        this.cantidadElementos++;
    }
    
    public int retirar() {
        int result = this.lista.getNumeroEnIndice(cantidadElementos - 1);        
        this.lista.eliminarNumeroEnIndice(this.lista.getLongitudLista() - 1);
        this.cantidadElementos--;
        return result;
    }
    
    public void mostrarPila() {
        this.lista.mostrarLista();
    }
}
