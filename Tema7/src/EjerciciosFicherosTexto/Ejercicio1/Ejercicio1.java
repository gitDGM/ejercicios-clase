/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio1 {
    public static Scanner sc = new Scanner(System.in);
    public static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio1/";
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del fichero: ");
        String nombreFichero = sc.nextLine();
        
        File fichero = new File(RUTA_ACTUAL + nombreFichero); 
        
        try {
            if (fichero.exists()) {
                mostrarFichero(fichero);
            } else {
                try {
                    mostrarFicheroBuffered(new File(RUTA_ACTUAL + "prueba.txt"));  
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    static void mostrarFichero(File fichero) throws FileNotFoundException {
        Scanner lector = new Scanner(fichero);
        
        while(lector.hasNextLine()) {
            System.out.println(lector.nextLine());
        }
        
        lector.close();
    }
    
    static void mostrarFicheroBuffered(File fichero) throws IOException {
        FileReader fr = new FileReader(fichero);
        BufferedReader lector = new BufferedReader(fr);
                
        String cadenaLeida = lector.readLine();
        while(cadenaLeida != null) {
            System.out.println(cadenaLeida);
            cadenaLeida = lector.readLine();
        }
        
        lector.close();
    }
}
