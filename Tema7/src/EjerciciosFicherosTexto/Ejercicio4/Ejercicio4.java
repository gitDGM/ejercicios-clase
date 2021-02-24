/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class Ejercicio4 {
    public static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio4/";
    public static void main(String[] args) {
        File fichero = new File(RUTA_ACTUAL + "carta.txt");
        
        String carta = leerCarta(fichero);
        
        
        System.out.println(carta);
        int numLineas = contarLineas(fichero);
        int numPalabras = carta.split(" ").length;
        int numLetras = contarLetras(carta.split(" "));
        
        System.out.println("Lineas: " + numLineas + "\tPalabras: " + numPalabras + "\tLetras: " + numLetras);
        
    }
    
    static String leerCarta(File fichero) {
        FileReader filereader = null;
        BufferedReader lector = null;
        
        String carta = "";        
        try {
            filereader = new FileReader(fichero);
            lector = new BufferedReader(filereader);        
            
            String cadenaLeida = lector.readLine();
            while (cadenaLeida != null) {   
                carta += cadenaLeida + " ";
                cadenaLeida = lector.readLine();
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
        
        return carta;
    }
    
    static int contarLineas(File fichero) {
        FileReader filereader = null;
        BufferedReader lector = null;
        
        int contador = 0;   
        try {
            filereader = new FileReader(fichero);
            lector = new BufferedReader(filereader);        
            
            String cadenaLeida = lector.readLine();
            while (cadenaLeida != null) {   
                contador++;
                cadenaLeida = lector.readLine();
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
        
        return contador;
    }
    
    static int contarLetras(String[] palabras) {
        int contador = 0;
        for (String palabra : palabras) {
            contador += palabra.split("").length;
        }
        
        return contador;
    }
}
