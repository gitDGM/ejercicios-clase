/*
 * Implemento una lista de tipo Cola (agrego al final, elimino del principio)
 */
package EstructurasDinamicasClase.edinamicas;

public class ColaConFinal {
    private class Nodo {
        String nombre;
        Nodo siguiente;
    }
    private Nodo frente, fondo; //fondo apunta al último elemento
    
    public ColaConFinal() {
        frente = null;
        fondo = null;
    }
    
    //Comprueba si la cola está vacio o no
    public boolean esVacia(){
        boolean vacia = true;
        if(frente != null){
            vacia = false;
        }
        return vacia;
    }
    
    //Agrega un nodo a la cola (es decir, al final)
    public void agregarNodo(String nombre){
        Nodo nuevo = new Nodo();
        nuevo.nombre = nombre;
        nuevo.siguiente = null;
        if(esVacia()) { //la cola está vacia
            frente = nuevo;
            fondo = nuevo;
        } else { //existe ya la cola
             fondo.siguiente = nuevo;
             fondo = nuevo;
        }
        
    }
    
    //Elimina un nodo (es decir, del frente) sin mostrar dato
    public void eliminarNodo() {
        if(!esVacia()){
            if(frente == fondo) {
                frente = null;
                fondo = null;
            } else {
                frente = frente.siguiente;
            }
        }
        
    }
    
    //Elimina un nodo (es decir, del frente) mostrando el dato
    public String eliminarNodoConDato() {
        String informacion = "";
        if(!esVacia()){
            informacion = frente.nombre;
            if(frente == fondo) {
                frente = null;
                fondo = null;
            } else {
                frente = frente.siguiente;
            }
        }
        return informacion;
    }
    
    //Muestra el contenido de la Cola
    public void mostrarCola() {
        if(esVacia()){
            System.out.println("Cola vacía");
        } else {
            Nodo recorre = frente;
            while(recorre != null){
                System.out.print(recorre.nombre + "\t");
                recorre = recorre.siguiente;
            }
        }
    }
    
    //Devuelve el tamaño de la cola
    public int obtenerTam() {
        int tam = 0;
        if(!esVacia()) {
            Nodo recorre = frente;
            while(recorre != null) {
                recorre = recorre.siguiente;
                tam++;
            }
        }
        return(tam);
    }
    
    //Devuelve el primer nombre de la Cola
    public String obtenerNodo() {
        String nombre = "";
        if(!esVacia()) {
            nombre = frente.nombre;
        }
        return(nombre);
    }
    
    public void vaciarCola() {
        while(!esVacia()){            
            System.out.println("Borro " + eliminarNodoConDato());
        }            
    }
    
}
