/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio15;

import java.util.Arrays;
/**
 *
 * @author alumno
 */
public class ColaTabla {
    private int cantidadElementos;
    private int[] elementos;
    
    public ColaTabla() {
        this.cantidadElementos = 0;
        this.elementos = new int[1];
    }
    
    public void encolar(int numero) {
        if (comprobarEspacio()) {
            this.elementos[this.elementos.length - 1] = numero;
        } else {
            this.elementos = Arrays.copyOf(elementos, cantidadElementos + 1);
            this.elementos[this.elementos.length - 1] = numero;            
        }
        cantidadElementos++;
    }
    
    public void desencolar() {
        if (comprobarSiHayElementos()) {
            this.elementos[0] = 0;
            avanzarTodosEnLaCola();
            cantidadElementos--;
            this.elementos = Arrays.copyOf(elementos, cantidadElementos);
        } else {
            System.err.println("No hay elementos en la cola.");
        }
    }
    
    public void mostrarCola() {
        System.out.println(Arrays.toString(this.elementos));
    }
    
    private void avanzarTodosEnLaCola() {
        for (int i = 0; i < this.cantidadElementos; i++) {
            if (i + 1 < this.cantidadElementos) {
                this.elementos[i] = this.elementos[i + 1];         
            }
        }
    }
    
    private boolean comprobarEspacio() {
        return this.cantidadElementos < this.elementos.length;
    }
    
    private boolean comprobarSiHayElementos() {
        return this.cantidadElementos > 0;
    }
}
