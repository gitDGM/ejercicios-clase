/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio7 {
    
    public final static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio7/";
    public final static int CANTIDAD_LINEAS = 24;
    public final static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        File fichero = new File(RUTA_ACTUAL + "texto.txt");
        
        mostrarParteFichero(fichero);
    }
    
    static void mostrarParteFichero(File fichero) {
        
        FileReader filereader = null;
        BufferedReader lector = null;
        
        try {
            
            filereader = new FileReader(fichero);
            lector = new BufferedReader(filereader);
            
            String cadenaLeida = lector.readLine();
            while (cadenaLeida != null) {
                for (int i = 0; i < CANTIDAD_LINEAS && cadenaLeida != null; i++) {
                    System.out.println(cadenaLeida);
                    cadenaLeida = lector.readLine();
                }
                sc.nextLine();
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filereader != null) filereader.close();
                if (lector != null) lector.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());                    
            }
        }
    }
}
