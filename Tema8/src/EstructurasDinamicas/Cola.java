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
public class Cola {
    private Nodo head;
    
    public Cola() {
        head = null;
    }
    
    public void add(int dato) {
        if (!isEmpty()) {    
            Nodo nodoActual = head;
            while (nodoActual.getSiguiente()!= null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setAnterior(new Nodo(dato, null));
        } else {
            head = new Nodo(dato, null);
        }   
    }
    
    public void remove() {
        if (!isEmpty()) {
            head = head.getSiguiente();
        }
    }
    
    public int size() {
        int size = 0;
        
        if (!isEmpty()) {
            Nodo nodoActual = head;
            while (nodoActual != null) {
                nodoActual = nodoActual.getSiguiente();
                size++;
            }
        }
        
        return size;
    }
    
    public void vaciar() {
        if (!isEmpty()) {
            while(head != null) {
                remove();
            }
        }
    }
    
    public void mostrar() {
        Nodo nodoActual = head;
        while (nodoActual != null) {
            nodoActual.mostrar();
            nodoActual = nodoActual.getSiguiente();
        }
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    private class Nodo {
        private int dato;
        private Nodo siguiente;
        
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
        
        public void setAnterior(Nodo nodoSiguiente) {
            this.siguiente = nodoSiguiente;
        }
        
        public void mostrar() {
            System.out.println("Dato: " + dato);
        }
    }
}
