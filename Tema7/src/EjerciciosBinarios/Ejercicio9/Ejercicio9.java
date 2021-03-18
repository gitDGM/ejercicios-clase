/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author alumno
 */
public class Ejercicio9 {
    static final int CANTIDAD_NUMS = 10;
    public static void main(String[] args) {
        // TODO: ORDENAR
    }
    
    static void escribirEnFicheroBinario(String ruta) {
        ObjectOutputStream flujoSalida = null;
        int[] tabla = new int[CANTIDAD_NUMS];
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));
            for (int i = 0; i < CANTIDAD_NUMS; i++) {
                tabla[i] = (int)(Math.random() * 100);
            }
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
