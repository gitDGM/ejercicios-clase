/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio7;

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
public class Ejercicio7 {
    public static void main(String[] args) {
        String ruta = "src/EjerciciosBinarios/Ejercicio7/data.dat";
        
        escribirEnFicheroBinario(introducirCadena("Introduce una frase:"), ruta);
        
        System.out.println("Frase en el fichero: " + leerFicheroBinario(ruta));
    }
    
    static void escribirEnFicheroBinario(String cadena, String ruta) {
        ObjectOutputStream flujoSalida = null;
        
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta)); 
            flujoSalida.writeObject(cadena);
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
        String cadenaFichero = null;
        
        try {        
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta));            
            cadenaFichero = (String)flujoEntrada.readObject();
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
