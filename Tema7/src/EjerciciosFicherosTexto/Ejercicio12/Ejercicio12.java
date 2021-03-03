/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio12;

import java.io.File;

/**
 *
 * @author alumno
 */
public class Ejercicio12 {
    public final static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio12/";
    
    public static void main(String[] args) {
        Comando comando = new Comando();
        
        File fichero1 = new File(RUTA_ACTUAL + "texto1.txt");
        File fichero2 = new File(RUTA_ACTUAL + "texto2.txt");
        
        if (comando.comp(fichero1, fichero2)) {
            System.out.println("Son iguales.");
        } else {
            System.out.println("Son distintos.");
        }
    }
}
