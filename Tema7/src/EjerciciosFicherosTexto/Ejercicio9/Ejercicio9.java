/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio9;

import java.io.File;

/**
 *
 * @author alumno
 */
public class Ejercicio9 {
    
    public final static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio9/";
    
    public static void main(String[] args) {
        Encriptador encrypt = new Encriptador();
        File fichero = new File(RUTA_ACTUAL + "todos.txt");
        
        encrypt.encriptarFichero(fichero);
        System.out.println("El fichero todos.txt ha sido cifrado en cifrado.txt");
    }
}
