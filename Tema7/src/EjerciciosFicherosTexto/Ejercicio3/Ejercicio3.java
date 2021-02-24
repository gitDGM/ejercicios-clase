/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio3 {
    public static String RUTA_ACTUAL = "src/EjerciciosFicherosTexto/Ejercicio3/";
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Duplicar fichero original.txt a copia.txt");
            System.out.println("2.- Copia de fichero");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    duplicarFichero();
                    break;
                case 2:
                    copiarFichero();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Fuera de rango.");   
                    break;
            }
        } while (opcion != 0); 
        
    }
    
    static void duplicarFichero() {
        File fichero = new File(RUTA_ACTUAL + "original.txt");        
        File ficheroCopia = new File(RUTA_ACTUAL + "copia.txt");
        
        if (!ficheroCopia.exists()) {
            crearFichero(fichero, ficheroCopia);
        } else {
            ficheroCopia.delete();
            crearFichero(fichero, ficheroCopia);
        }
    }
    
    static void copiarFichero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del fichero:");
        String nombreFichero = sc.nextLine();
        
        File fichero = new File(RUTA_ACTUAL + nombreFichero);     
        
        if (fichero.exists()) {
            File ficheroCopia = new File(RUTA_ACTUAL + "copia_de_" + nombreFichero);
            if (!ficheroCopia.exists()) {
                crearFichero(fichero, ficheroCopia);                
            } else {
                ficheroCopia.delete();
                crearFichero(fichero, ficheroCopia);                
            }
        } else {
            System.err.println("ERROR: El fichero no existe.");
        }
    }
    
    static void crearFichero(File ficheroIn, File FicheroOut) {
        FileReader filereader = null;
        BufferedReader lector = null;
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {
            filereader = new FileReader(ficheroIn);
            lector = new BufferedReader(filereader);            
            filewriter = new FileWriter(FicheroOut, true);
            escritor = new PrintWriter(filewriter);
            
            String cadenaLeida = lector.readLine();
            while (cadenaLeida != null) {       
                escritor.println(cadenaLeida);     
                cadenaLeida = lector.readLine();                
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filereader != null) filereader.close();
                if (lector != null) lector.close();
                if (filewriter != null) filewriter.close();
                if (escritor != null) escritor.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());                    
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
                System.err.println("Debe ser un número.");
                noValido = true;
                sc.next();
            }
        } while (noValido);

        return numero;
    }
}
