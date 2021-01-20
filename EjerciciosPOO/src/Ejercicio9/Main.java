/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

/**
 *
 * @author alumno
 */
public class Main {
    public static void main(String[] args) {
        
        // INICIALIZACIÓN
        Casa micasa = new Casa(15);
        
        ////////////////////////////////////////////////////////
        
        micasa.getEstadoBombilla(2);
        /* Responde el estado de la bombilla */
                
        micasa.toggleBombilla(2);
        micasa.getEstadoBombilla(2);
        /* No responde el estado de la bombilla porque está apagada */
        
        micasa.toggleBombilla(2);
        micasa.getEstadoBombilla(2);     
        /* Responde el estado de la bombilla porque se ha vuelto a encender */ 
           
        micasa.toggleBombilla(3);
        micasa.getEstadoBombilla(3);
        /* Hacemos esto para comprobar si al reparar el fusible, se mantiene apagada */
        
        System.out.println("################################");
        
        micasa.romperFusible();
        /* Se rompe el fusible */
        
        micasa.toggleBombilla(2);
        micasa.getEstadoBombilla(2);
        /* No se enciende la bombilla porque el fusible está roto */        
        /* y por eso no responde */
        
        System.out.println("################################");
        
        micasa.repararFusible();        
        micasa.getEstadoBombilla(2); 
        /* Después de reparar el fusible, vuelve a estar encendida */      
           
        micasa.getEstadoBombilla(3);   
        /* Después de reparar el fusible, sigue apagada */
        
        
    }
}
