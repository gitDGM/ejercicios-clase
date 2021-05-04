/**
 * Implemento una lista genérica
 * Una lista genérica permite las inserciones y extracciones en cualquier parte de la lista
 */
package EstructurasDinamicasLourdes.edinamicas;

/**
 *
 * @author alumno
 */
public class ListaCircular {
    private class Nodo {
        String dato;
        Nodo siguiente;
    }
    private Nodo inicio;
    
    public ListaCircular() {
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
        if(!esVacia()){
            Nodo recorre = inicio;
            do {
                tam++;
                recorre = recorre.siguiente;
            } while(recorre != inicio);
        }
        return tam;
    }
    
    //Obtener el ultimo de la lista
    public Nodo obtenerUltimo() {
        Nodo ultimo = null;
        if(!esVacia()){
            ultimo = inicio;
            while (ultimo.siguiente != inicio) {
                ultimo = ultimo.siguiente;
            }  
        }
        return ultimo;
    }
    
    //Inserta un elemento al final de la lista
    public void agregarNodo(String informacion) {
        Nodo nuevo = new Nodo();
        nuevo.dato = informacion;
        if(esVacia()){
            inicio = nuevo;
            nuevo.siguiente = inicio;
        } else {
            /*Nodo recorre = inicio;
            while(recorre.siguiente != inicio){
                recorre = recorre.siguiente;
            }
            nuevo.siguiente = recorre.siguiente;
            recorre.siguiente = nuevo;*/
            //Otra forma (empleando el método obtenerUltimo())
            Nodo fin = obtenerUltimo();
            if(fin != null){
                nuevo.siguiente = fin.siguiente; //nuevo.siguiente = inicio;
                fin.siguiente = nuevo;
            }
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
                if(obtenerUltimo() != null){ //hay lista
                    nuevo.siguiente = inicio;
                    obtenerUltimo().siguiente = nuevo;
                } else { //es el primero que agrego
                    nuevo.siguiente = nuevo;
                }
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
                Nodo ultimo = obtenerUltimo();
                if (ultimo != null){
                    if(posicion == 0) { //borro el primero
                        direcBorrar = inicio;
                        borro = inicio.dato; 
                        if(inicio.siguiente == inicio){
                            inicio = null;
                        } else {
                            inicio = inicio.siguiente;
                            ultimo.siguiente = inicio;
                        }
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
        }
        return borro;
    }
    
    //Extraer nodo que contiene la informacion indicada
    public String eliminarNodo(String informacion) {
        String borro = "";
        Nodo direcBorrar = null;
        if (esVacia()) {
            System.err.println("Error!!! La lista está vacía");
        } else {
            Nodo recorre = inicio;
            if (inicio.dato.compareToIgnoreCase(informacion) == 0) {
                //El elemento a borrar es el primero
                direcBorrar = inicio;
                borro = inicio.dato;
                if (obtenerTam() == 1) { //eliminamos el último
                    inicio = null;
                } else {
                    obtenerUltimo().siguiente = inicio.siguiente;
                    inicio = inicio.siguiente;
                }
            } else {
                Nodo anterior = recorre;
                while((recorre.siguiente != inicio) && (recorre.dato.compareToIgnoreCase(informacion) != 0)) {
                    anterior = recorre;
                    recorre = recorre.siguiente;
                }
                if (recorre.dato.compareToIgnoreCase(informacion) == 0) {
                    //He encontrado el elemento a borrar
                    direcBorrar = recorre;
                    borro = recorre.dato;
                    anterior.siguiente = recorre.siguiente;
                } else {
                    System.err.println("Error!!! No existe esa información");
                }
            }
        }
        if(direcBorrar != null){ //si he encontrado el elemento, libero memoria
            liberarMemoria(direcBorrar);
        }      
        return borro;
    }
    
    //Obtener dato de una posicion
    public String obtenerNodo(int posicion) {
        String informacion = "";
        if(!esVacia() && (posicion >= 0 && posicion < obtenerTam())) {
            Nodo recorre = inicio;
            for(int i = 0; i < posicion; i++) {
                recorre = recorre.siguiente;
            }
            informacion = recorre.dato;
        }
        return informacion;
    }
    
    //Obtener posicion de un dato
    public int obtenerNodo(String informacion) {
        int posicion = -1;
        if (!esVacia()) {
            if(inicio.dato.compareToIgnoreCase(informacion) == 0){//el primero
                posicion = 0;
            } else {
                if(obtenerUltimo().dato.compareToIgnoreCase(informacion) == 0){ //el ultimo
                    posicion = obtenerTam() - 1;
                } else { 
                    Nodo recorre = inicio;
                    posicion = 0;
                    while (recorre.siguiente != inicio && (recorre.dato.compareToIgnoreCase(informacion) != 0)) {
                        posicion++;
                        recorre = recorre.siguiente;
                    }
                    if(recorre.siguiente == inicio && (recorre.dato.compareToIgnoreCase(informacion) != 0)) {
                        posicion = -1;
                    }
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
            do {
                System.out.print(recorre.dato + "\t");
                recorre = recorre.siguiente;
            } while (recorre != inicio);
            System.out.println();
        }
    }
    
    //Visualizo todos los elementos de la lista a partir de la posición indicada
    public void imprimirLista(int posicion) {
        if(esVacia()){
            System.out.print("Lista vacía");
        } else { //contiene algo
            if (posicion == 0) { //Es la primera posicion (lo mismo que imprimirLista() sin indicar posición)
                imprimirLista();
            } else {
                if (posicion > 0 && posicion < obtenerTam()) {
                    Nodo principio = inicio;
                    for(int i = 0; i < posicion; i++) {
                        principio = principio.siguiente;
                    }
                    Nodo recorre = principio; //principio es el comienzo de la impresión
                    do {
                        System.out.print (recorre.dato + "\t");
                        recorre = recorre.siguiente;                
                    } while (recorre != principio);
                } else {
                    System.err.println("Error!!! No existe esa posición");
                }
            }
        }
        System.out.println();
    }

}
