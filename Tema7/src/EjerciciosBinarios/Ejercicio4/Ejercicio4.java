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
        ArrayList<Double> tabla = new ArrayList();
        
        int nNumeros;
        do {            
            nNumeros = introducirNumero("Introduce la cantidad de números que quieres introducir:");
            if (nNumeros <= 0) {
                System.err.println("ATENCIÓN: Introduce un número positivo y distinto de 0.");
            }
        } while (nNumeros <= 0);
        
        for (int i = 0; i < nNumeros; i++) {
            tabla.add(introducirNumeroDouble("Introduce un número decimal: "));
        }
        System.out.println("Tabla de números introducidos por teclado");
        mostrarNumeros(tabla);
        
        escribirEnFicheroBinario(tabla, ruta);
        
        
        /* EJERCICIO 5 */
        tabla = leerFicheroBinario(ruta); 
        System.out.println("Tabla de números introducidos desde fichero binario:");       
        mostrarNumeros(tabla);        
        /***************/
        
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
    
    static void mostrarNumeros(ArrayList<Double> numeros) {
        for (double numero : numeros) {
            System.out.println(numero + "\t");
        }
    }
    
    static void escribirEnFicheroBinario(ArrayList<Double> numeros, String ruta) {
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
    
    /* USADO PARA GENERAR DATOS EN EL EJERCICIO 6 */
    static void escribirEnFicheroBinarioUnoPorUno(ArrayList<Double> numeros, String ruta) {
        ObjectOutputStream flujoSalida = null;
        
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));    
            for (double numero : numeros) {
                flujoSalida.writeDouble(numero);
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
