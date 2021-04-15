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
public class ColaConFinal {
    private Nodo head;
    private Nodo tail;
    
    public ColaConFinal() {
        head = null;
        tail = null;
    }
    
    public void add(int dato) {
        if (!isEmpty()) {    
            Nodo nodoActual = head;
            while (nodoActual.getSiguiente()!= null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(new Nodo(dato, null));
            tail = nodoActual.getSiguiente();
        } else {
            head = new Nodo(dato, null);
            tail = head;
        }   
    }
    
    public void remove() {
        if (!isEmpty()) {
            tail = head == tail ? null : tail;
            head = head.getSiguiente();
        }
    }
    
    public void removeDato() {
        if (!isEmpty()) {
            head.mostrar();
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
    
    public void mostrarTail() {
        if (!isEmpty()) {
            System.out.print("ULTIMO: ");
            tail.mostrar();            
        } else {
            System.out.println("ATENCIÓN: Cola vacía.");
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
        
        public void setSiguiente(Nodo nodoSiguiente) {
            this.siguiente = nodoSiguiente;
        }
        
        public void mostrar() {
            System.out.println("Dato: " + dato);
        }
    }
}
