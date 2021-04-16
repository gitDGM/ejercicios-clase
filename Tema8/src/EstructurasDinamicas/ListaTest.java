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
public class ListaTest {
    public static void main(String[] args) {
        Lista lista = new Lista();
        
        lista.add("test 1");
        lista.add("test 2");
        lista.add("test 3");
        lista.add("test 4");
        lista.add("test 5");
        lista.add("test 6");
        lista.add("test 7", 2);
        lista.add("test 10", 8);
        
        lista.mostrar();
    }
}
