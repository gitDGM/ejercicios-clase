/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio10;

import java.io.File;

/**
 *
 * @author alumno
 */
public class Ejercicio10 {
    
    public final static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio10/"; 
    public final static String RUTA_EJERCICIO9 = "src/EjerciciosFicherosTexto/Ejercicio9/";
    
    public static void main(String[] args) {
        
        Decodificador decrypt = new Decodificador();
        File fichero = new File(RUTA_EJERCICIO9 + "cifrado.txt");
        
        decrypt.decodificarFichero(fichero);
    }    
}
