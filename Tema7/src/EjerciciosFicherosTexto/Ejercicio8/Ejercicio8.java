/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio8;

/**
 *
 * @author alumno
 */
public class Ejercicio8 {
    
    public final static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio8/";
    
    public static void main(String[] args) {
        FicheroPersona perso1 = new FicheroPersona("perso1.txt");
        FicheroPersona perso2 = new FicheroPersona("perso2.txt");
        
        FicheroPersona perso3 = perso1.fusionarConFicheroEnNuevo("todos.txt", perso2);
        
        System.out.println("Se han fusionado los archivos perso1.txt y perso2.txt en todos.txt");
        System.out.println("Están ordenados alfabéticamente.");
    }
}
