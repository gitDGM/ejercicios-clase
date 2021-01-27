/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio12;

import java.util.Arrays;
/**
 *
 * @author alumno
 */
public class Lista {
    private int numeroElementos;
    private int[] lista;

    private static final int TAM = 10;
    
    public Lista() {
        this.numeroElementos = 0;
        this.lista = new int[TAM];
    }
    
    public Lista(int capacidad) {
        this.numeroElementos = 0;        
        this.lista = new int[capacidad];
    }
    
    public void mostrarLista() {
        System.out.println(Arrays.toString(this.lista));
    }
    
    public void insertarNumeroAlFinal(int numero) {
        if (this.numeroElementos <= this.lista.length - 1) {
            this.lista[this.numeroElementos] = numero;
            numeroElementos++;
        } else {
            this.lista = Arrays.copyOf(this.lista, this.lista.length + 1);
            this.lista[this.numeroElementos] = numero;
            numeroElementos++;
        }
    }
    
    public void insertarNumeroAlPrincipio(int numero) {
        if (this.numeroElementos <= this.lista.length - 1) {
            avanzarTodosUnaPosicion();
            this.lista[0] = numero;
            numeroElementos++;
        } else {
            this.lista = Arrays.copyOf(this.lista, this.lista.length + 1);
            avanzarTodosUnaPosicion();
            this.lista[0] = numero;
            numeroElementos++;
        }
    }
    
    public void insertarNumeroEnIndice(int numero, int indice) {
        if (indice <= this.numeroElementos) {            
            if (this.numeroElementos <= this.lista.length - 1) {
                avanzarTodosUnaPosicionDesdeIndice(indice);
                this.lista[indice] = numero;
                numeroElementos++;
            } else {
                this.lista = Arrays.copyOf(this.lista, this.lista.length + 1);
                avanzarTodosUnaPosicionDesdeIndice(indice);
                this.lista[indice] = numero;
                numeroElementos++;
            }            
        } else {
            System.err.println("Fuera de rango de la lista.");
        }
    }
    
    public void insertarListaAlFinal(Lista listaParametro) {
        int capacidadAnterior = this.numeroElementos;
        this.lista = Arrays.copyOf(this.lista, this.numeroElementos + listaParametro.numeroElementos);
        for (int i = 0; i < listaParametro.numeroElementos; i++) {
            this.lista[capacidadAnterior + i] = listaParametro.lista[i];
        }
        numeroElementos = numeroElementos + listaParametro.numeroElementos;
    }
    
    public void eliminarNumeroEnIndice(int indice) {
        if (indice < this.numeroElementos) {  
            retrocederTodosUnaPosicionDesdeIndice(indice);                
            this.lista[this.numeroElementos - 1] = 0;
            numeroElementos--;
        } else {
            System.err.println("Fuera de rango de la lista.");
        }
    }
    
    public int getNumeroEnIndice(int indice) {
        return this.lista[indice];
    }
    
    public int buscarNumeroEnLista(int numero) {
        int result = -1;
        
        for (int i = 0; i < this.lista.length && result != -1; i++) {
            if (this.lista[i] == numero) {
                result = i;
            }
        }
        
        return result;
    }
    
    private void avanzarTodosUnaPosicion() {
        for (int i = 0; i < this.numeroElementos; i++) {
            this.lista[this.numeroElementos - i] = this.lista[this.numeroElementos - 1 - i];
        }
    }
    
    private void avanzarTodosUnaPosicionDesdeIndice(int indice) {
        for (int i = 0; i < this.numeroElementos - indice; i++) {
            this.lista[this.numeroElementos - i] = this.lista[this.numeroElementos - 1 - i];
        }
    }
    
    private void retrocederTodosUnaPosicionDesdeIndice(int indice) {
        for (int i = 0; i < this.numeroElementos - indice; i++) {
            if (indice + i + 1 < this.numeroElementos) {
                this.lista[indice + i] = this.lista[indice + 1 + i];         
            }
        }
    }
}
