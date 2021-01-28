/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio13;

import java.util.Arrays;
/**
 *
 * @author alumno
 */
public class PilaTabla {
    private int cantidadElementos;
    private int[] pila;

    public PilaTabla() {
        this.cantidadElementos = 0;
        this.pila = new int[1];
    }
    
    public void apilar(int numero) {
        if (comprobarEspacio()) {
            this.pila[this.pila.length - 1] = numero;
        } else {
            ampliarPilaEnUno();
            this.pila[this.pila.length - 1] = numero;            
        }
        this.cantidadElementos++;
    }
    
    public int retirar() {
        int result = this.pila[cantidadElementos - 1];        
        reducirPilaEnUno();        
        return result;
    }
    
    public void mostrarPila() {
        System.out.println(Arrays.toString(this.pila));
    }
    
    private boolean comprobarEspacio() {        
        return cantidadElementos < pila.length;
    }
    
    private void ampliarPilaEnUno() {
        if (!comprobarEspacio()) {
            this.pila = Arrays.copyOf(this.pila, this.pila.length + 1);
        }
    }
    
    private void reducirPilaEnUno() {
        if (!comprobarEspacio()) {
            this.pila = Arrays.copyOf(this.pila, this.pila.length - 1);
            this.cantidadElementos--;
        }
    }
}
