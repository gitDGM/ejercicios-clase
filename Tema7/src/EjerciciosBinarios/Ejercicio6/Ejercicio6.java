/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio6;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        String ruta = "src/EjerciciosBinarios/Ejercicio6/data.dat";
        ArrayList<Double> numeros = leerFicheroBinarioTest(ruta);
        
        mostrarNumeros(numeros);
    }
    
    static void mostrarNumeros(ArrayList<Double> numeros) {
        for (double numero : numeros) {
            System.out.println(numero + "\t");
        }
    }
    
    static ArrayList leerFicheroBinario(String ruta) {
        ObjectInputStream flujoEntrada = null;
        ArrayList<Double> numerosFichero = null;
                
        try {
            numerosFichero = new ArrayList();
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta));  
            try {
                while (true) {                    
                    numerosFichero.add(flujoEntrada.readDouble());
                }
            } catch (EOFException ex) {
            }
            
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
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
        return numerosFichero;
    }
    
    static ArrayList leerFicheroBinarioTest(String ruta) {
        ObjectInputStream flujoEntrada = null;
        ArrayList<Double> numerosFichero = null;
                
        try {
            numerosFichero = new ArrayList();
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta));
            
            while (flujoEntrada.available() > 0) {                    
                numerosFichero.add(flujoEntrada.readDouble());
                
                // TEST
                // System.err.println(flujoEntrada.available());
            }            
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
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
        return numerosFichero;
    }
}
