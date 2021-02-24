/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio2 {
    public static Scanner sc = new Scanner(System.in);
    public static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio2/";
    public static void main(String[] args) {
        System.out.println("Introduce su nombre de usuario:");
        String usuario = sc.nextLine();
        System.out.println("Introduce su nombre de usuario:");
        int edad = sc.nextInt();
        
        File fichero = new File(RUTA_ACTUAL + "datos.txt");
        
        if (!fichero.exists()) {
            crearFichero(fichero, usuario, edad);
        } else {
            fichero.delete();
            crearFichero(fichero, usuario, edad);
        }
        
        try {
            System.out.println();
            mostrarFichero(fichero);            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    static void crearFichero(File fichero, String usuario, int edad) {
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        try {
            filewriter = new FileWriter(fichero, true);
            escritor = new PrintWriter(filewriter);
            escritor.println(usuario);
            escritor.println(edad);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filewriter != null) filewriter.close();
                if (escritor != null) escritor.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());                    
            }
        }
    }
    
    static void mostrarFichero(File fichero) throws FileNotFoundException {
        Scanner lector = new Scanner(fichero);
        
        while(lector.hasNextLine()) {
            System.out.println(lector.nextLine());
        }
        
        lector.close();
    }
}
