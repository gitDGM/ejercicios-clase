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

        /*
        // ORDENAR FICHEROS CON NÚMEROS
        ArrayList<Integer> numeros2 = ordenarNumerosArray(leerFicheroBinario(ruta + "numeros1.dat"));
        escribirEnFicheroBinario(ruta + "numeros1.dat", numeros2);        
        System.out.println(numeros2);
         */
        ArrayList<Integer> numeros1 = leerFicheroBinario(ruta + "numeros1.dat");
        ArrayList<Integer> numeros2 = leerFicheroBinario(ruta + "numeros2.dat");
        ArrayList<Integer> numeros = combinarOrdenarDosArrayList(numeros1, numeros2);
        
        // TEST
        // ArrayList<Integer> numeros = leerFicheroBinario(ruta + "numeros.dat");
        
        escribirEnFicheroBinario(ruta + "numeros.dat", numeros);
        System.out.println("Numeros 1: " + numeros1);
        System.out.println("Numeros 1: " + numeros2);
        System.out.println(numeros);

    }

    static ArrayList<Integer> combinarOrdenarDosArrayList(ArrayList<Integer> numeros1, ArrayList<Integer> numeros2) {
        ArrayList<Integer> numeros = new ArrayList();
        int contador1 = 0;
        int contador2 = 0;

        for (int i = 0; i < numeros1.size() + numeros2.size(); i++) {
            if (contador1 < numeros1.size()) {
                if (numeros1.get(contador1) <= numeros2.get(contador2)) {
                    numeros.add(numeros1.get(contador1));
                    contador1++;
                } else {
                    numeros.add(numeros2.get(contador2));
                    contador2++;
                }
            } else {
                numeros.add(numeros2.get(contador2));
                contador2++;
            }

        }

        return numeros;
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
                if (flujoSalida != null) {
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

            while (flujoEntrada.available() > 0) {
                numeros.add(flujoEntrada.readInt());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (flujoEntrada != null) {
                    flujoEntrada.close();
                }
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }

        return numeros;
    }
}
