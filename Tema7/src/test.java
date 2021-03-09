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
        
        /*
        String[] ficheroLineas = fichero.convertToArrayLineas();
        
        for (int i = 0; i < ficheroLineas.length; i++) {
            System.out.println("Linea: " + ficheroLineas[i]);
            String[] palabrasLinea = fichero.convertToArrayPalabrasLinea(i);
            for (int j = 0; j < palabrasLinea.length; j++) {
                System.out.println("\tPalabra: " + palabrasLinea[j]);
                String[] letrasPalabra = fichero.convertToArrayLetrasPalabra(i, j);
                for (int k = 0; k < letrasPalabra.length; k++) {
                    System.out.println("\t\tLetra: " + letrasPalabra[k]);                
                }
            }
        }
*/
        fichero.copiarFichero("src/test.txt");
    }
}
