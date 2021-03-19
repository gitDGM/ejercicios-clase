/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio9;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author alumno
 */
public class Ejercicio9 {
    static final int CANTIDAD_NUMS = 10;
    public static void main(String[] args) {
        String ruta = "src/EjerciciosBinarios/Ejercicio9/data.dat";
        escribirEnFicheroBinario(ruta);
        mostrarTabla(leerFicheroBinario(ruta));
    }
    
    static void mostrarTabla(int[] tabla) {
        for (int numero : tabla ) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
    
    static int[] bubbleSortArray(int[] tabla) {
        for(int i = 0; i < tabla.length - 1; i++) {
            for (int k = 0; k < tabla.length - 1 - i; k++) {
                if (tabla[k] > tabla[k + 1]) {
                    int temp = tabla[k];
                    tabla[k] = tabla[k + 1];
                    tabla[k + 1] = temp;
                }
            }
        }
        
        return tabla;
    }
    
    static int[] leerFicheroBinario(String ruta)  {
        ObjectInputStream flujoEntrada = null;
        int[] tabla = new int[CANTIDAD_NUMS];        
        try {        
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta)); 
            tabla = (int[]) flujoEntrada.readObject();            
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
        return tabla;
    }
    
    static void escribirEnFicheroBinario(String ruta) {
        ObjectOutputStream flujoSalida = null;
        int[] tabla = new int[CANTIDAD_NUMS];
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));
            for (int i = 0; i < CANTIDAD_NUMS; i++) {
                tabla[i] = (int)(Math.random() * 100);
            }
            tabla = bubbleSortArray(tabla);
            flujoSalida.writeObject(tabla);
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
    
}
