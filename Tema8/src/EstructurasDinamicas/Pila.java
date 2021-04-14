/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas;

/**
 *
 * @author alumno
 */
public class Pila {
    private Nodo cima;
    
    public Pila() {
        cima = null;
    }
    
    public void push(int dato) {
        cima = new Nodo(dato, cima);
    }
    
    public Nodo pop() throws PilaVaciaException {
        return cima = !isEmpty() ? cima.getSiguiente() : null;
    }
    
    public int peek() throws PilaVaciaException {
        return !isEmpty() ? cima.getDato() : null;
    }
    
    public void vaciar() {
        try {
            if (!isEmpty()) {
                while(cima != null) {
                    pop();
                }
            }
        } catch (PilaVaciaException e) {
            System.err.println(e.getMessage());
        } 
    }
    
    public void mostrar() {
        try {
            if (!isEmpty()) {
                Nodo nodoActual = cima;
                while(nodoActual != null) {
                    nodoActual.mostrar();
                    nodoActual = nodoActual.getSiguiente();
                }
            }
        } catch (PilaVaciaException e) {
            System.err.println(e.getMessage());
        }        
    }
    
    public boolean isEmpty() throws PilaVaciaException {        
        if (cima != null) {
            return false;            
        } else {
            throw new PilaVaciaException("ERROR: La pila está vacía.");
        }
        
    }
            
    private class Nodo {
        private int dato;
        private final Nodo siguiente;
        
        public Nodo(int dato, Nodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }

        public int getDato() {
            return dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setDato(int dato) {
            this.dato = dato;
        }
        
        public void mostrar() {
            System.out.println("Dato: " + dato);
        }
    }
}
