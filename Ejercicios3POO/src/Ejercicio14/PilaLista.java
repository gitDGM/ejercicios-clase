/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio14;

import Ejercicio12.Lista;
import java.util.Arrays;
/**
 *
 * @author alumno
 */
public class PilaLista {
    private int cantidadListas;
    private Lista[] pilaListas;
    
    public PilaLista() {
        this.cantidadListas = 0;
        this.pilaListas = new Lista[1];
    }
    
    public void apilar(Lista lista) {
        if (comprobarEspacio()) {
            this.pilaListas[this.pilaListas.length - 1] = lista;
        } else {
            ampliarPilaEnUno();
            this.pilaListas[this.pilaListas.length - 1] = lista;            
        }
        this.cantidadListas++;
    }
    
    public Lista retirar() {
        Lista result = this.pilaListas[cantidadListas - 1];        
        reducirPilaEnUno();        
        return result;
    }
    
    public void mostrarPila() {
        System.out.println(Arrays.toString(this.pilaListas));
    }
    
    private boolean comprobarEspacio() {        
        return cantidadListas < pilaListas.length;
    }
    
    private void ampliarPilaEnUno() {
        if (!comprobarEspacio()) {
            this.pilaListas = Arrays.copyOf(this.pilaListas, this.pilaListas.length + 1);
        }
    }
    
    private void reducirPilaEnUno() {
        if (!comprobarEspacio()) {
            this.pilaListas = Arrays.copyOf(this.pilaListas, this.pilaListas.length - 1);
            this.cantidadListas--;
        }
    }
}
