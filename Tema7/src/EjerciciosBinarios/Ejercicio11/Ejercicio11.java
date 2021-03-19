/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Ejercicio11 {
    public static void main(String[] args) {
        String ruta = "src/EjerciciosBinarios/Ejercicio11/";
        
        ArrayList<Integer> numeros1 = ordenarNumerosArray(leerFicheroBinario(ruta + "numeros2.dat"));
        escribirEnFicheroBinario(ruta + "numeros2.dat", numeros1);
        
        System.out.println(numeros1);
        
        System.out.println();
    }
    
    static ArrayList<Integer> ordenarNumerosArray(ArrayList<Integer> numeros) {
        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int k = 0; k < numeros.size() - 1 - i; k++) {
                if (numeros.get(k) > numeros.get(k + 1)) {
                    int temp = numeros.get(k);
                    numeros.set(k, numeros.get(k + 1));
                    numeros.set(k + 1, temp);
                }
            }
        }
        
        return numeros;
    }
    
    static void escribirEnFicheroBinario(String ruta, ArrayList<Integer> numeros) {
        ObjectOutputStream flujoSalida = null;
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));
            for (int numero : numeros) {
                flujoSalida.writeInt(numero);
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
    
    static ArrayList<Integer> leerFicheroBinario(String ruta) {
        ObjectInputStream flujoEntrada = null;
        ArrayList<Integer> numeros = new ArrayList();
        try {        
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta));            
            numeros = (ArrayList<Integer>) flujoEntrada.readObject();
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
        
        return numeros;
    }
}
