/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class test {
    public static void main(String[] args) {
        Fichero fichero = new Fichero("src/todos.txt");
        
        String[] ficheroLineas = fichero.ficheroToArrayLineas();
        
        for (int i = 0; i < ficheroLineas.length; i++) {
            System.out.println("Linea: " + ficheroLineas[i]);
            String[] palabrasLinea = fichero.ficheroToArrayPalabrasLinea(i);
            for (int j = 0; j < palabrasLinea.length; j++) {
                System.out.println("\tPalabra: " + palabrasLinea[j]);
                for (int k = 0; k < palabrasLinea.length; k++) {
                    System.out.println("\tPalabra: " + palabrasLinea[j]);                
                }
            }
        }
    }
}
