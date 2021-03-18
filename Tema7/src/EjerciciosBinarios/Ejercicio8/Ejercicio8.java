/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio8;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio8 {
    public static void main(String[] args) {
        String ruta = "src/EjerciciosBinarios/Ejercicio8/data.dat";
        
        // DESCOMENTAR PARA ESCRIBIR EN FICHERO
        // escribirEnFicheroBinario(ruta);
        
        System.out.println(leerFicheroBinario(ruta));
    }
    
    static void escribirEnFicheroBinario(String ruta) {
        ObjectOutputStream flujoSalida = null;
        
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));
            String cadena = introducirCadena("Introduce linea de texto:");
            while (!cadena.equals("")) {   
                System.err.println("test");
                flujoSalida.writeObject(cadena + "\n");  
                cadena = introducirCadena("Introduce linea de texto:");    
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if(flujoSalida != null) {
                    flujoSalida.close();
                } 
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
    }
    
    static String leerFicheroBinario(String ruta) {
        ObjectInputStream flujoEntrada = null;
        String cadenaFichero = "";
        
        try {        
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta)); 
            
            try {
                while (true) {        
                    cadenaFichero += (String)flujoEntrada.readObject(); 
                }
            } catch (EOFException e) {
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if(flujoEntrada != null) {
                    flujoEntrada.close();
                } 
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
        return cadenaFichero;
    }
    
    static String introducirCadena(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);
        return sc.nextLine();
    }
}
