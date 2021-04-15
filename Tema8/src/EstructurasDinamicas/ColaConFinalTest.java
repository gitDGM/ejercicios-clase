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
public class ColaConFinalTest {
    public static void main(String[] args) {
        ColaConFinal cola = new ColaConFinal();
        
        cola.add(3);
        cola.mostrarTail();
        cola.remove();
        System.out.println("Tamaño de la cola: " + cola.size());
        cola.mostrarTail();
        cola.add(2);
        cola.add(6);
        cola.add(4);
        cola.add(10);
        cola.remove();
        cola.add(1);        
        System.out.print("Nodo eliminado: ");
        cola.removeDato();
        cola.mostrar();
        
        System.out.println("Tamaño de la cola: " + cola.size());
        
        cola.vaciar();        
        System.out.println("Cola vaciada.");        
        System.out.println("Tamaño de la cola: " + cola.size());
    }
}
