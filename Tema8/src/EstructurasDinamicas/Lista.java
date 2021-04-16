/*
1.  Lista vacia
2.  Nodo incio "inicio"
3.  Dato String
4.  Obtener tamaño
5.  Insertar nodo con dato o insertar nodo con posición y dato
6.  Eliminar nodo por posicion o eliminar nodo con dato
7.  Obtener el dato que hay en un determinada posicion
8.  Obtener la posicion de un dato
9.  Vaciar la lista
10. Mostrar la lista
 */
package EstructurasDinamicas;

/**
 *
 * @author alumno
 */
public class Lista {
    private Nodo inicio;
    
    public Lista() {
        inicio = null;
    }
    
    public void add(String dato) {
        if (!isEmpty()) {
            Nodo nodoActual = inicio;
            while (nodoActual.getSiguiente() != null) {                
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(new Nodo(dato));
        } else {
            inicio = new Nodo(dato);
        }
    }
    
    public void add(String dato, int posicion) {
        if (!isEmpty() && posicion >= 0 && posicion <= size()) {
            if (posicion == 0) {
                inicio = new Nodo(dato, inicio);
            } else if (posicion == size()) {
                add(dato);
            } else {
                int contador = 0;
                Nodo nodoPosicion = inicio;
                while (contador < posicion) {
                    nodoPosicion = nodoPosicion.getSiguiente();
                    contador++;
                }
                Nodo nodoSiguiente = nodoPosicion.getSiguiente();
                nodoPosicion.setSiguiente(new Nodo(dato, nodoSiguiente));
            }
        } else {
            System.err.println("ERROR: No es posible añadir en esa posición.");
        }
    }
    
    public void remove(int posicion) {
        if (!isEmpty() && posicion >= 0 && posicion < size()) {
            Nodo nodoAnteriorPosicion = inicio; 
            if (posicion == 0) {
                inicio = nodoAnteriorPosicion.getSiguiente();
                liberarMemoria(nodoAnteriorPosicion);
            } else {
                int contador = 0;
                while (contador < posicion - 1) {
                    nodoAnteriorPosicion = nodoAnteriorPosicion.getSiguiente();
                    contador++;
                }
                Nodo nodoSiguiente = nodoAnteriorPosicion.getSiguiente();
                nodoAnteriorPosicion.setSiguiente(nodoSiguiente.getSiguiente());
                liberarMemoria(nodoSiguiente);
            }
        } else {
            System.err.println("ERROR: No es posible borrar ese elemento.");
        }
    }
    
    public void remove(String dato) {
        if (!isEmpty()) {
            boolean encontrado = false;
            Nodo nodoActual = inicio;
            Nodo nodoAnterior = null;
            while(nodoActual != null && !encontrado) {
                if (nodoActual.getDato().equals(dato)) {
                    encontrado = true;
                } else {
                    nodoAnterior = nodoActual;
                    nodoActual = nodoActual.getSiguiente();
                }
            }
            if (encontrado) {
                nodoAnterior.setSiguiente(nodoActual.getSiguiente());
                liberarMemoria(nodoActual);
            } else {
                System.err.println("ERROR: No se ha encontrado ese elemento.");
            }
        } else {
            System.err.println("ERROR: No es posible borrar ese elemento.");
        }
    }
    
    public void mostrar() {
        if (!isEmpty()) {            
            Nodo nodoActual = inicio;
            while (nodoActual != null) {    
                nodoActual.mostrar();
                nodoActual = nodoActual.getSiguiente();
            }
        }
    }
    
    public int size() {
        int size = 0;
        
        if (!isEmpty()) {
            Nodo nodoActual = inicio;
            while (nodoActual != null) {                
                nodoActual = nodoActual.getSiguiente();
                size++;
            }
        }
        
        return size;
    }
    
    public boolean isEmpty() {
        return inicio == null;
    }
    
    private void liberarMemoria(Nodo nodo) {
        nodo = null;
    }
    
    private class Nodo {
        private String dato;
        private Nodo siguiente;
        
        public Nodo(String dato) {
            this.dato = dato;
            siguiente = null;
        }
        
        public Nodo(String dato, Nodo siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;            
        }

        public String getDato() {
            return dato;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setDato(String dato) {
            this.dato = dato;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
        
        public void mostrar() {
            System.out.println(dato + "\t");
        }
    }
}
