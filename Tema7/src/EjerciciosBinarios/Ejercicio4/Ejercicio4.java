/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        String ruta = "src/EjerciciosBinarios/Ejercicio4/data.dat";
        ArrayList<Integer> tabla = new ArrayList();
        
    }
    
    static ArrayList leerFicheroBinario(String ruta) {
        ObjectInputStream flujoEntrada = null;
        ArrayList<Integer> numerosFichero = null;
        
        try {        
            numerosFichero = new ArrayList();
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta));            
            numerosFichero = (ArrayList<Integer>)flujoEntrada.readObject();
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
        return numerosFichero;
    }
    
    static void escribirEnFicheroBinario(ArrayList<Integer> numeros, String ruta) {
        ObjectOutputStream flujoSalida = null;
        
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));            
            flujoSalida.writeObject(numeros);
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
    
    static int introducirNumero(String msg) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;        
        boolean noValido;
        do {
            System.out.println(msg);
            try {
                numero = sc.nextInt();
                noValido = false;
            } catch (InputMismatchException ex) {
                System.err.println("Debe ser un número decimal.");
                noValido = true;
                sc.next();
            }
        } while (noValido);

        return numero;
    }
    
    static double introducirNumeroDouble(String msg) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;        
        boolean noValido;
        do {
            System.out.println(msg);
            try {
                numero = sc.nextDouble();
                noValido = false;
            } catch (InputMismatchException ex) {
                System.err.println("Debe ser un número decimal.");
                noValido = true;
                sc.next();
            }
        } while (noValido);

        return numero;
    }
}
