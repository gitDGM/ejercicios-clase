/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicasClase.edinamicas;

/**
 *
 * @author alumno
 */
public class ListaOrdDoble {
    private class Nodo {
        String dato;
        Nodo anterior, siguiente;
    }
    private Nodo inicio, fin;
    
    public ListaOrdDoble() {
        this.inicio = null;
        this.fin = null;
    }
    
    //indica si la lista está vacía (true)
    public boolean esVacia() {
        boolean vacia = false;
        if(inicio == null)
            vacia = true;
        return vacia;
    }
    
    //devuelve el tamaño de la lista
    public int obtenerTam() {
        int tam = 0;
        if(!esVacia()){
            Nodo recorre = inicio;
            while(recorre != null) {
                tam++;
                recorre = recorre.siguiente;
            }
        }
        return tam;
    }
    
    //añade un elemento ordenado, de forma ascendente
    public void agregarNodoAsc(String informacion) {
        Nodo nuevo = new Nodo();
        nuevo.dato = informacion;
        if(esVacia()){ 
            nuevo.anterior = null;
            nuevo.siguiente = null;
            inicio = nuevo;
            fin = nuevo;
        } else { // existe lista
            if(informacion.compareToIgnoreCase(inicio.dato) < 0) { //inserta al inicio
                nuevo.anterior = null;
                nuevo.siguiente = inicio;
                inicio.anterior = nuevo;
                inicio = nuevo;
            } else {
                if(informacion.compareToIgnoreCase(fin.dato) > 0) { //inserta al final
                    nuevo.anterior = fin;
                    nuevo.siguiente = null;
                    fin.siguiente = nuevo;
                    fin = nuevo;
                } else { //entre dos ya existentes (antes de recorre)
                    Nodo recorre = inicio;
                    while(recorre.siguiente != null && informacion.compareToIgnoreCase(recorre.dato) >= 0){
                        recorre = recorre.siguiente;
                    }
                    nuevo.anterior = recorre.anterior;
                    nuevo.siguiente = recorre;
                    (recorre.anterior).siguiente = nuevo;
                    recorre.anterior = nuevo;
                }
            }
        }
    }
    
    //añade un elemento ordenado, de forma descendente
    public void agregarNodoDesc(String informacion) {
        Nodo nuevo = new Nodo();
        nuevo.dato = informacion;
        if(esVacia()){ 
            nuevo.anterior = null;
            nuevo.siguiente = null;
            inicio = nuevo;
            fin = nuevo;
        } else { // existe lista
            if(inicio.dato.compareToIgnoreCase(informacion) < 0) { //inserta al inicio
                nuevo.anterior = null;
                nuevo.siguiente = inicio;
                inicio.anterior = nuevo;
                inicio = nuevo;
            } else {
                if(fin.dato.compareToIgnoreCase(informacion) > 0) { //inserta al final
                    nuevo.anterior = fin;
                    nuevo.siguiente = null;
                    fin.siguiente = nuevo;
                    fin = nuevo;
                } else { //entre dos ya existentes (antes de recorre)
                    Nodo recorre = inicio;
                    while(recorre.siguiente != null && recorre.dato.compareToIgnoreCase(informacion) >= 0){
                        recorre = recorre.siguiente;
                    }
                    nuevo.anterior = recorre.anterior;
                    nuevo.siguiente = recorre;
                    (recorre.anterior).siguiente = nuevo;
                    recorre.anterior = nuevo;
                }
            }
        }
    }  
    
    private void liberarMemoria(Nodo borrado) {
        borrado.dato = null;
        borrado.anterior = null;
        borrado.siguiente = null;
    }
    
    //elimina el elemento indicado en posicion
    public String eliminarNodo(int posicion) {
        String informacion = "";
        Nodo borrado = inicio;
        if(esVacia()){
            System.err.println("Lista vacía");
        } else {
            if(posicion >= 0 && posicion < obtenerTam()) {
                if(posicion == 0) {
                    if(inicio != fin) { //hay al menos 2 elementos
                        inicio = inicio.siguiente;
                        inicio.anterior = null;
                    } else { //solo queda el que quiero borrar
                        inicio = null;
                        fin = null;
                    }
                    //liberarMemoria(borrado);
                } else {
                    if(posicion == (obtenerTam() -1)){ //borro el ultimo
                        borrado = fin;
                        (fin.anterior).siguiente = null;
                        fin = fin.anterior;
                        //liberarMemoria(borrado);
                    } else { //borro un nodo que está entre dos (y no son ni inicio ni fin)
                        Nodo recorre = inicio;
                        for(int i = 0; i < posicion; i++){
                            recorre = recorre.siguiente;
                        }
                        borrado = recorre;
                        (recorre.anterior).siguiente = recorre.siguiente; //anterior de recorre apunta a siguiente a recorre
                        (recorre.siguiente).anterior = recorre.anterior; //siguiente a recorre apunta al anterior de recorre
                    }
                }
                informacion = borrado.dato;
                liberarMemoria(borrado);                    
            } else {
                System.err.println("Posición no válida");
            }                
        }        
        return informacion;
    }

    //extraer nodo que contiene la informacion indicada
    public String eliminarNodo(String informacion) {
        String borro = "";
        if(esVacia()){
            System.err.println("Lista vacía");
        } else {
            boolean existe = false;
            Nodo recorre = inicio;
            for(int i = 0; i < obtenerTam() - 1; i++) {
                if(informacion.compareToIgnoreCase(recorre.dato) == 0){
                    borro = recorre.dato;
                    eliminarNodo(i);
                    existe = true;
                }
                recorre = recorre.siguiente;
            }
            if(!existe){
                System.err.println("Elemento no encontrado");
            }
        }
        return borro;
    }
    
    //obtener la posición de un elemento
    public int obtenerNodo(String informacion) {
        int posicion = -1;
        if(esVacia()){
            System.err.println("Lista vacía");
        } else {
            boolean existe = false;
            Nodo recorre = inicio;
            for(int i = 0; i < obtenerTam(); i++) {
                if(informacion.compareToIgnoreCase(recorre.dato) == 0){
                    posicion = i;
                    existe = true;
                }
                recorre = recorre.siguiente;
            }
            if(!existe){
                System.err.println("Elemento no encontrado");
            }
        }
        return posicion;
    }
    
    //obtener la informacion existente en una posicion
    public String obtenerNodo(int posicion) {
        String informacion = "";
        if(esVacia()){
            System.err.println("Lista vacía");
        } else {
            if(posicion >= 0 && posicion < obtenerTam()){
                Nodo recorre = inicio;
                for(int i = 0; i < posicion; i++) {
                    recorre = recorre.siguiente;
                }
                informacion = recorre.dato;
            }
            else {
                System.err.println("Posicion no encontrada");
            }
        }
        return informacion;
    }

    //Indica si contiene o no el elemento
    public boolean contieneNodo(String informacion) {
        boolean existe = false;
        if(!esVacia()){
            Nodo recorre = inicio;
            //recorro hasta encontrar el elemento a localizar o hasta que llegue al fin
            while (recorre.siguiente != null && informacion.compareToIgnoreCase(recorre.dato) != 0) {
                recorre = recorre.siguiente;
            }
            if(informacion.compareToIgnoreCase(recorre.dato) == 0) {
                //He encontrado el elemento a localizar
                existe = true;
            }
        }        
        return existe;
    }
    
    //obtener la informacion existente en una posicion
    public void modificarNodo(int posicion, String informacion) {
        if(esVacia()){
            System.err.println("Lista vacía");
        } else {
            if(posicion >= 0 && posicion < obtenerTam()){
                Nodo recorre = inicio;
                for(int i = 0; i < posicion; i++) {
                    recorre = recorre.siguiente;
                }
                recorre.dato = informacion;
            }
            else {
                System.err.println("Posicion no encontrada");
            }
        }
    }
    
    //Libera todos los nodos de la lista
    public void vaciarLista() {
        while(!esVacia()){
            eliminarNodo(0);
        }
    }    

    public void imprimirLista() {
        if(esVacia()) {
            System.err.println("Lista vacía");
        } else {
            System.out.println("Elementos de la lista (del primero al último):");
            Nodo recorre = inicio;
            while(recorre != null) {
                System.out.print(recorre.dato + "\t");
                recorre = recorre.siguiente;
            }
            System.out.println("\nElementos de la lista (del último al primero):");
            recorre = fin;
            while(recorre != null) {
                System.out.print(recorre.dato + "\t");
                recorre = recorre.anterior;
            }
            System.out.println();
        }
    }
}
