/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author alumno
 */
public class ColaColec {
    private Queue<Integer> cola;
    private PriorityQueue<Integer> colaP;
    private  Queue<String> colaS;
    
    public ColaColec() {
        cola = new LinkedList();
        colaP = new PriorityQueue();
        colaS = new LinkedList();
    }
    
    private boolean vacia() {
        return cola.isEmpty();
    }
    
    private boolean vaciaNombre(){
        return colaS.isEmpty();
    }
    
    private boolean vaciaPrioridad() {
        return colaP.isEmpty();
    }
}
