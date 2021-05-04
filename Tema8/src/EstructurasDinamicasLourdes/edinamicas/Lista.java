/**
 * Implemento una lista genérica
 * Una lista genérica permite las inserciones y extracciones en cualquier parte de la lista
 */
package EstructurasDinamicasLourdes.edinamicas;

/**
 *
 * @author alumno
 */
public class Lista {
    private class Nodo {
        String dato;
        Nodo siguiente;
    }
    private Nodo inicio;
    
    public Lista() {
        this.inicio = null;
    }
    
    //Libera los datos borrados
    public void liberarMemoria(Nodo borrado){
        borrado.dato = null;
        borrado.siguiente = null;
    }
    
    //Indica si la lista está vacía (verdadero)
    public boolean esVacia() {
        boolean vacia = true;
        if(inicio != null) {
            vacia = false;
        }
        return vacia;
    }
    
    //Devuelve el nº de elementos de la lista
    public int obtenerTam() {
        int tam = 0;
        Nodo recorre = inicio;
        while(recorre != null) {
            tam++;
            recorre = recorre.siguiente;
        }
        return tam;
    }
    
    //Inserta un elemento al final de la lista
    public void agregarNodo(String informacion) {
        Nodo nuevo = new Nodo();
        nuevo.dato = informacion;
        nuevo.siguiente = null;
        if(esVacia()){
            inicio = nuevo;
        } else {
            Nodo recorre = inicio;
            while(recorre.siguiente != null){
                recorre = recorre.siguiente;
            }
            recorre.siguiente = nuevo;
        }
        
    }
    
    //Inserta un elemento en la posicion indicada de la lista
    public void agregarNodo(int posicion, String informacion) {
        if(posicion < 0 || posicion > obtenerTam()) { //comprobamos que la posicicon es válida
            System.err.println("Error!!! Posición no válida");
        } else {
            Nodo nuevo = new Nodo();
            nuevo.dato = informacion;
            if(posicion == 0) { //añado al inicio
                nuevo.siguiente = inicio;
                 inicio = nuevo;
            } else if(posicion == obtenerTam()) { //añado al final
                    agregarNodo(informacion);
            } else {
                Nodo recorre = inicio;
                Nodo anterior = inicio;
                for(int i = 0; i < posicion; i++) { //llego hasta la posición indicada
                    anterior = recorre;
                    recorre = recorre.siguiente;
                 } 
                //añado entre anterior y recorre
                anterior.siguiente = nuevo;
                nuevo.siguiente = recorre;
            }
        }        
    }
    
    //Extraer nodo de una posicion indicada
    public String eliminarNodo(int posicion) {
        String borro = "";
        if(!esVacia()) { //hay elementos en la lista
            if(posicion >= 0 && posicion < obtenerTam()) { //posicion válida
                Nodo direcBorrar;
                if(posicion == 0) { //borro el primero
                    direcBorrar = inicio;
                    borro = inicio.dato;
                    inicio = inicio.siguiente;
                } else { //borro cualquier otro
                    Nodo anterior = inicio;
                    Nodo recorre = inicio;
                    for(int i = 0; i < posicion; i++) {
                        anterior = recorre;
                        recorre = recorre.siguiente;
                    }
                    direcBorrar = recorre;
                    borro = recorre.dato;
                    anterior.siguiente = recorre.siguiente;
                }     
                liberarMemoria(direcBorrar);
            }     
        }
        return borro;
    }
    
    //Extraer nodo que contiene la informacion indicada
    public String eliminarNodo(String informacion) {
        String borro = "";
        Nodo direcBorrar = null;
        if(!esVacia()){
            //Elemento a borrar es el primero
            if(informacion.compareToIgnoreCase(inicio.dato) == 0){
                direcBorrar = inicio;
                borro = inicio.dato;
                inicio = inicio.siguiente;
            } else { //no es el primero
                Nodo recorre = inicio;
                Nodo anterior = inicio;
                //recorro hasta encontrar el elemento a borrar o hasta que llegue al fin
                while (recorre.siguiente != null && informacion.compareToIgnoreCase(recorre.dato) != 0) {
                    anterior = recorre;
                    recorre = recorre.siguiente;
                }
                if(informacion.compareToIgnoreCase(recorre.dato) == 0) {
                    //He encontrado el elemento a borrar
                    direcBorrar = recorre;
                    borro = recorre.dato;
                    anterior.siguiente = recorre.siguiente;
                }
            }
        }        
        if(direcBorrar != null) //si he encontrado el elemento, libero memoria
            liberarMemoria(direcBorrar);
        return borro;
    }
    
    //Obtener dato de una posicion
    public String obtenerNodo(int posicion) {
        String informacion = "";
        if(!esVacia()) { //hay elementos en la lista
            if(posicion >= 0 && posicion < obtenerTam()) { //posicion válida
                if(posicion == 0) { //borro el primero
                    informacion = inicio.dato;
                } else { //borro cualquier otro
                    Nodo recorre = inicio;
                    for(int i = 0; i < posicion; i++) {
                        recorre = recorre.siguiente;
                    }
                    informacion = recorre.dato;
                }     
             }     
        }        
        return informacion;
    }
    
    //Obtener posicion de un dato
    public int obtenerNodo(String informacion) {
        int posicion = -1;
        if(!esVacia()){
            //Elemento a borrar es el primero
            if(informacion.compareToIgnoreCase(inicio.dato) == 0){
                posicion = 0;
            } else { //no es el primero
                Nodo recorre = inicio;
                posicion++;
                //recorro hasta encontrar el elemento a borrar o hasta que llegue al fin
                while (recorre.siguiente != null && informacion.compareToIgnoreCase(recorre.dato) != 0) {
                    recorre = recorre.siguiente;
                    posicion++;
                }
                if(informacion.compareToIgnoreCase(recorre.dato) != 0) {
                    //NO he encontrado el elemento a borrar
                    posicion = -1;
                }
            }
        }        
        return posicion;
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
    
    //Libera todos los nodos de la lista
    public void vaciarLista() {
        while(!esVacia()){
            eliminarNodo(0);
        }
    }    
    
    //Visualizo la lista
    public void imprimirLista() {
        if(esVacia()) {
            System.out.println("Lista vacía");
        } else {
            Nodo recorre = inicio;
            while (recorre != null) {
                System.out.print(recorre.dato + "\t");
                recorre = recorre.siguiente;
            }
            System.out.println();
        }
    }
    
}
