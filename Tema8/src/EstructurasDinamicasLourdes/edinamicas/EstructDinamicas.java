/*
 * Para pruebas de las estructuras dinḿicas
 */
package EstructurasDinamicasLourdes.edinamicas;

/**
 *
 * @author alumno
 */
public class EstructDinamicas {

    public static void main(String[] args) {
        
        
       /*Pila pila = new Pila();
       
       pila.agregarNodo(10);
       pila.agregarNodo(20);
       pila.agregarNodo(1);
       pila.agregarNodo(1000);
       System.out.println("Elementos de la Pila:");
       pila.mostrarPila();
       pila.eliminarNodo();
       System.out.println("Elementos de la Pila:");
       pila.mostrarPila();
       System.out.println("Elementos de la Pila: " + pila.obtenerTam());
       System.out.println("Primer elemento de la Pila: " + pila.obtenerNodo());
       System.out.println("Elimino nodos hasta dejar vacia la Pila");
       while(!pila.esVacia()){
           System.out.println("Elimino elemento: " + pila.eliminarNodoConDato());
       }
       System.out.println( pila.esVacia() ? "Pila vacia" : "Pila no vacia");*/
       
       //Cola cola = new Cola();
       /*ColaConFinal cola = new ColaConFinal();
       
       cola.agregarNodo("Lorena");
       cola.agregarNodo("David");
       cola.agregarNodo("Pilar");
       cola.agregarNodo("Diego");
       System.out.println("Elementos de la Cola:");
       cola.mostrarCola();
       System.out.println("\nElimino un elemento...");
       cola.eliminarNodo();
       System.out.println("Elementos de la Cola:");
       cola.mostrarCola();
       System.out.println("\nAgrego un elemento...");
       cola.agregarNodo("Jorge");
       System.out.println("Elementos de la Cola:");
       cola.mostrarCola();
       System.out.print("\nElimino un elemento... ");
       String borro = cola.eliminarNodoConDato();
       if(borro.compareTo("") == 0)
            System.out.println("No hay elementos en la cola");
       else
            System.out.println(borro);
       System.out.println("Nº de elementos de la Cola: " + cola.obtenerTam());
       System.out.println("Primer elemento de la Cola: " + cola.obtenerNodo());
       System.out.println( cola.esVacia() ? "Cola vacia" : "Cola no vacia");
       System.out.println("Elimino todos los elementos hasta dejar vacia la Pila");
       cola.vaciarCola();
       /*while(!cola.esVacia()){
           System.out.println("Elimino elemento: " + cola.eliminarNodoConDato());
       }*/
       //System.out.println( cola.esVacia() ? "Cola vacia" : "Cola no vacia");

       /*Lista lista = new Lista();
       
       lista.agregarNodo("Lorena");
       lista.agregarNodo(0, "David");
       lista.agregarNodo(1, "Pilar");
       lista.agregarNodo(2, "Diego");
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       String eliminado = lista.eliminarNodo(0);
       if(eliminado.compareTo("") == 0){
           System.err.println("Error!! No existe ese elemento");
       } else {
           System.out.println("Elemento borrado: " + eliminado);
       }
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       System.out.println( lista.esVacia() ? "Lista vacia" : "Lista con " + lista.obtenerTam() + " elementos");
       eliminado = lista.eliminarNodo("Lourdes");
       if(eliminado.compareTo("") == 0){
           System.err.println("Error!! No existe ese elemento");
       } else {
           System.out.println("Elemento borrado: " + eliminado);
       }
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       if(lista.obtenerNodo(2).compareTo("") == 0) {
           System.err.println("Error!! No existe esa posicion");
       } else {
           System.out.println("Elemento en posicion 2: " + lista.obtenerNodo(2));
       }
       if(lista.obtenerNodo("Lorena") == -1) {
           System.err.println("Error!! No existe ese nombre");
       } else {
           System.out.println("El elemento dado se encuentra en posicion: " + lista.obtenerNodo("Lorena"));
       } 
       System.out.println( lista.contieneNodo("Pilar") ? "El elemento está en la lista" : "El elemento NO está en la lista");
       lista.imprimirLista();
       lista.vaciarLista();
       lista.imprimirLista();  */

       /*ListaOrdenada lista = new ListaOrdenada();
       
       lista.agregarNodoAsc("Lorena");
       lista.agregarNodoAsc("David");
       lista.agregarNodoAsc("Pilar");
       lista.agregarNodoAsc("Diego");
       //lista.agregarNodoDesc("Lorena");
       //lista.agregarNodoDesc("David");
       //lista.agregarNodoDesc("Pilar");
       //lista.agregarNodoDesc("Diego");
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       String eliminado = lista.eliminarNodo(0);
       if(eliminado.compareTo("") == 0){
           System.err.println("Error!! No existe ese elemento");
       } else {
           System.out.println("Elemento borrado: " + eliminado);
       }
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       System.out.println( lista.esVacia() ? "Lista vacia" : "Lista con " + lista.obtenerTam() + " elementos");
       eliminado = lista.eliminarNodo("Lourdes");
       if(eliminado.compareTo("") == 0){
           System.err.println("Error!! No existe ese elemento");
       } else {
           System.out.println("Elemento borrado: " + eliminado);
       }
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       if(lista.obtenerNodo(2).compareTo("") == 0) {
           System.err.println("Error!! No existe esa posicion");
       } else {
           System.out.println("Elemento en posicion 2: " + lista.obtenerNodo(2));
       }
       if(lista.obtenerNodo("Lorena") == -1) {
           System.err.println("Error!! No existe ese nombre");
       } else {
           System.out.println("El elemento dado se encuentra en posicion: " + lista.obtenerNodo("Lorena"));
       } 
       System.out.println( lista.contieneNodo("Pilar") ? "El elemento está en la lista" : "El elemento NO está en la lista");
       lista.imprimirLista();
       lista.vaciarLista();
       lista.imprimirLista(); */

       //ListaOrdDoble lista = new ListaOrdDoble();
       /*lista.agregarNodoAsc("Lorena");
       lista.agregarNodoAsc("David");
       lista.agregarNodoAsc("Pilar");
       lista.agregarNodoAsc("Diego");*/
       /*lista.agregarNodoDesc("Lorena");
       lista.agregarNodoDesc("David");
       lista.agregarNodoDesc("Pilar");
       lista.agregarNodoDesc("Diego");
       lista.imprimirLista();
       //System.out.println(lista);
       String eliminado = lista.eliminarNodo(0);
       if(eliminado.compareTo("") != 0) {
           System.out.println("Elemento borrado (" + eliminado + ") de posicion 0");
       }
       lista.imprimirLista();
       System.out.println( lista.esVacia() ? "Lista vacia" : "Lista con " + lista.obtenerTam() + " elementos");
       eliminado = lista.eliminarNodo("Lorena");
       if(eliminado.compareTo("") != 0){
       //    System.err.println("Error!! No existe ese elemento");
       //} else {
           System.out.println("Elemento borrado: " + eliminado);
       }
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       if(lista.obtenerNodo(1).compareTo("") != 0) {
        //   System.err.println("Error!! No existe esa posicion");
       //} else {
           System.out.println("Elemento en posicion 1: " + lista.obtenerNodo(21));
       }
       if(lista.obtenerNodo("Diego") != -1) {
       //    System.err.println("Error!! No existe ese nombre");
       //} else {
           System.out.println("El elemento dado se encuentra en posicion: " + lista.obtenerNodo("Lorena"));
       } 
       lista.modificarNodo(1, "Lourdes");
       System.out.println( lista.contieneNodo("Lourdes") ? "Lourdes está en la lista" : "Lourdes NO está en la lista");
       lista.imprimirLista();
       lista.vaciarLista();
       lista.imprimirLista(); */
 
       ListaCircular lista = new ListaCircular();
       lista.agregarNodo("Lorena");
       lista.agregarNodo("David");
       lista.agregarNodo("Lourdes");
       lista.agregarNodo("Pilar");
       lista.agregarNodo(2, "Diego");
       lista.imprimirLista();
       System.out.println("Elementos de la Lista, desde posicion 1:");
       lista.imprimirLista(1);
       String eliminado = lista.eliminarNodo(0);
       if(eliminado.compareTo("") != 0) {
           System.out.println("Elemento borrado (" + eliminado + ") de posicion 0");
       }
       lista.imprimirLista();
       System.out.println( lista.esVacia() ? "Lista vacia" : "Lista con " + lista.obtenerTam() + " elementos");
       eliminado = lista.eliminarNodo("pilar");
       if(eliminado.compareTo("") != 0){
           System.out.println("Elemento borrado: " + eliminado);
       }
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       /*eliminado = lista.eliminarNodo("david");
       if(eliminado.compareTo("") != 0){
           System.out.println("Elemento borrado: " + eliminado);
       }
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();
       eliminado = lista.eliminarNodo("diego");
       if(eliminado.compareTo("") != 0){
           System.out.println("Elemento borrado: " + eliminado);
       }
       System.out.println("Elementos de la Lista:");
       lista.imprimirLista();*/
       if(lista.obtenerNodo(0).compareTo("") == 0) {
           System.err.println("Error!! No existe esa posicion");
       } else {
           System.out.println("Elemento en posicion 0: " + lista.obtenerNodo(0));
       }
       int p = lista.obtenerNodo("Diego");
       if(p == -1) {
           System.err.println("Error!! No existe ese nombre");
       } else {
           System.out.println("Diego se encuentra en posicion: " + p);
       } 
       //lista.modificarNodo(1, "Lourdes");
       System.out.println( lista.contieneNodo("Lourdes") ? "Lourdes está en la lista" : "Lourdes NO está en la lista");
       lista.imprimirLista(2);
       lista.vaciarLista();
       lista.imprimirLista(); 
}
    
}
