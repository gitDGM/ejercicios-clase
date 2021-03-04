/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author alumno
 */
public class Ejercicio5 {
    public static Scanner sc = new Scanner(System.in);
    public final static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio5/";
    public final static int CANTIDAD_NUMEROS = 20;
    
    public static void main(String[] args) {
        File ficheroNumeros = new File(RUTA_ACTUAL + "numeros.txt");
        if (ficheroNumeros.exists()) {
            ficheroNumeros.delete();
        }
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Generar numeros aleatorios");
            System.out.println("2.- Ordenar numeros");
            System.out.println("3.- Mostrar menor y mayor");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    generarNumerosAleatorios(ficheroNumeros);
                    break;
                case 2:
                    ordenarNumerosFichero(ficheroNumeros);
                    break;
                case 3:
                    int[] numeros = getNumeros(ficheroNumeros);
                    mostrarMenorMayor(numeros);
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static void mostrarMenorMayor(int[] numeros) {
        int menor = 0;
        int mayor = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (i == 0) {
                menor = numeros[0];
                mayor = numeros[0];
            }     
            
            if (numeros[i] < menor) {
                menor = numeros[i];
            } else if (numeros[i] > mayor) {
                mayor = numeros[i];                
            }
        }
        
        System.out.println("\nMenor: " + menor);
        System.out.println("Mayor: " + mayor + "\n");
    }
    
    static void generarNumerosAleatorios(File fichero) {
        
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {          
            filewriter = new FileWriter(fichero, true);
            escritor = new PrintWriter(filewriter);
            
            
            for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
                escritor.println("" + (int)(Math.random() * 100));   
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filewriter != null) filewriter.close();
                if (escritor != null) escritor.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());                    
            }
        }
    }
    
    static void ordenarNumerosFichero(File fichero) {    
        
        if (fichero.exists()) {
            int[] numeros = getNumeros(fichero);
            Arrays.sort(numeros);
            
            fichero.delete();
            
            FileWriter filewriter = null;
            PrintWriter escritor = null;
            
            try {          
                filewriter = new FileWriter(fichero, true);
                escritor = new PrintWriter(filewriter);

                for (int i = 0; i < numeros.length; i++) {
                    escritor.println("" + numeros[i]);
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                try {
                    if (filewriter != null) filewriter.close();
                    if (escritor != null) escritor.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                    
                }
            }
        } else {
            System.err.println("ERROR: El fichero no existe.");
        }
    }    
    
    static int[] getNumeros(File fichero) {
        FileReader filereader = null;
        BufferedReader lector = null;
        
        int[] numeros = new int[CANTIDAD_NUMEROS];
        try {
            filereader = new FileReader(fichero);
            lector = new BufferedReader(filereader);        
            
            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = Integer.parseInt(lector.readLine());
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filereader != null) filereader.close();
                if (lector != null) lector.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());                    
            }
        }
        
        return numeros;
    }
    
    static int introducirNumero(String msg) {
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
}
