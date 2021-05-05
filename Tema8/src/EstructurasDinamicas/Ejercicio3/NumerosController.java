/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.Ejercicio3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author alumno
 */
public class NumerosController {
    private final Queue<Integer> colaNumeros;
    private final Stack<Integer> pilaNumeros;
    private final LinkedList<Integer> listaNumeros;
    
    public NumerosController() {
        colaNumeros = new LinkedList();
        pilaNumeros = new Stack();
        listaNumeros = new LinkedList();
    }
}
