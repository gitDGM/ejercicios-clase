package EstructurasDinamicas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class PilaTest {
    public static void main(String[] args) {
        Pila pila = new Pila();
        
        pila.push(6);
        pila.push(2);
        pila.push(15);
        pila.push(89);
        pila.push(3);       
        
        pila.mostrar();
        pila.vaciar();
        pila.mostrar();
    }
}
