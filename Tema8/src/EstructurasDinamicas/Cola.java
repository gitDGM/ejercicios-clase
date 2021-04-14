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
        head = new Nodo(dato, null);
    }
    
    private class Nodo {
        private int dato;
        private final Nodo anterior;
        
        public Nodo(int dato, Nodo anterior) {
            this.dato = dato;
            this.anterior = anterior;
        }

        public int getDato() {
            return dato;
        }

        public Nodo getAnterior() {
            return anterior;
        }

        public void setDato(int dato) {
            this.dato = dato;
        }
        
        public void mostrar() {
            System.out.println("Dato: " + dato);
        }
    }
}
