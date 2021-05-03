/*
 * Implementa una lista dinámica de tipo Pila
 */
package edinamicas;

/**
 *
 * @author alumno
 */
public class Pila {
    
    private class Nodo{
        int dato;
        Nodo siguiente;
    }
    private Nodo cima;
    
    //constructor de la pila
    Pila(){
        this.cima = null;
    }
    
    //como el free() de C
    public void liberarMemoria(Nodo borrado) {
        borrado = null;
        //borrado.dato = null;
        //borrado.siguiente = null;
    }
    
    //Metodo para saber si la lista está vacia
    public boolean esVacia(){
        boolean vacia = true;
        if(cima != null){
            vacia = false;
        }
        return vacia;
    }
    
    //Método para agregar un nodo nuevo (por ser una
    //pila, siempre se agrega al inicio)
    public void agregarNodo(int informacion) {
        Nodo nuevo; //declaro un elemento de tipo nodo nuevo
        nuevo = new Nodo(); //reservo la memoria para el elemento declarado
        nuevo.dato = informacion;//guardo el dato
        nuevo.siguiente = cima;//apunto al que hasta ahora era la cima
        cima = nuevo;//guardo la nueva cima
    }
    
    //Método para eliminar un nodo (primero)
    public void eliminarNodo(){
        if(!esVacia()) {
            Nodo borrado = cima;
            cima = cima.siguiente;  
            liberarMemoria(borrado);
        }
    }

    //Método para eliminar un nodo (primero) y visualizarle
    public int eliminarNodoConDato() {
        int informacion = Integer.MIN_VALUE;
        if(!esVacia()){
            informacion = cima.dato;
            cima = cima.siguiente;
        }
        return informacion;
    }
    
    //método para obtener el primero de la lista (sin borrar)
    public int obtenerNodo() {
        int informacion = Integer.MIN_VALUE;
        if(!esVacia()){
            informacion = cima.dato;
        }
        return informacion;
    }
    
    //Método para visualizar la pila
    public void mostrarPila() {
        Nodo recorre; //para no perder la dirección de la pila y recorrerla
        if(esVacia()){
            System.out.print("Pila vacia");
        } else {
            recorre = cima;
            while(recorre != null){
                System.out.print(recorre.dato + "\t");
                recorre = recorre.siguiente;
            }            
        }
        System.out.println();
    }
    
    //Método para calcular el tamaño
    public int obtenerTam() {
        Nodo recorre;
        int tam = 0;
        recorre = cima;
        while(recorre != null){
            tam++;
            recorre = recorre.siguiente;
        }
        return tam;
    }
    
}
