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
public class ColaTest {
    public static void main(String[] args) {
        Cola cola = new Cola();
        
        cola.add(3);
        cola.add(2);
        cola.add(6);
        cola.add(4);
        cola.add(10);
        cola.add(1);
        
        cola.mostrar();
    }
}
