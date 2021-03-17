/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        String ruta = "src/EjerciciosBinarios/Ejercicio1/data.dat";
        
        escribirEnFicheroBinario(introducirNumero("Introduce un número double:"), ruta);
        
        System.out.print("El valor que has introducido es: ");
        leerFicheroBinario(ruta);
    }
    
    static void leerFicheroBinario(String ruta) {
        ObjectInputStream flujoEntrada = null;
        
        try {
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta));
            System.out.println(flujoEntrada.readDouble());
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
    }
    
    static void escribirEnFicheroBinario(double numero, String ruta) {
        ObjectOutputStream flujoSalida = null;
        
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));
            flujoSalida.writeDouble(numero);
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if(flujoSalida != null) {
                    flujoSalida.close();
                } //cerramos el flujo para que se vacíe el buffer
                  //y se escriban los datos pendientes en el archivo
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
    }
    
    static double introducirNumero(String msg) {
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
            } finally {
                sc.close();
            }
        } while (noValido);

        return numero;
    }
}
