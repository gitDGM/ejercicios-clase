
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class ArrayList02 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        
        String nombre;
        do {
            System.out.println("Introduce \"fin\" para parar la ejecución.");
            System.out.println("Introduce un nombre: ");
            nombre = sc.nextLine();
            if (!nombre.equalsIgnoreCase("fin")) {
                lista.add(nombre);
            }
        } while (!nombre.equalsIgnoreCase("fin"));
        
        System.out.println("Lista Original:");
        System.out.println(lista);
        
        lista = insertarNombre(lista);
                
        System.out.println("Lista con nombre añadido según la posición:");
        System.out.println(lista);
        
        lista = borrarNombre(lista);
                
        System.out.println("Lista con nombre borrado según la posición:");
        System.out.println(lista);
        
        
        lista = sustituirNombrePosicion(lista);                
        System.out.println("Lista con nombre sustituido según la posición:");
        System.out.println(lista);
    }
    
    static ArrayList<String> insertarNombre(ArrayList<String> lista){
        System.out.println("Introduce un nombre:");
        String nombre = sc.nextLine();
        int posicion = 0;
        boolean valido = true;
        do {              
            try {
                System.out.println("Introduce la posición entre 0 y " + lista.size() + ":"); 
                posicion = sc.nextInt();
                if (posicion < 0 || posicion > lista.size()) { 
                    valido = false;
                    System.err.println("Fuera de rango.");
                } else {
                    valido = true;
                }                    
            } catch (InputMismatchException ex) {
                System.err.println("Solo puedes introducir un número entero.");
                valido = false;
                sc.next();
            }
        } while (!valido);        
        
        lista.add(posicion, nombre);
        
        return lista;
    }
    
    
    static ArrayList<String> borrarNombre(ArrayList<String> lista){
        int posicion = 0;
        boolean valido = true;
        do {              
            try {
                System.out.println("Introduce la posición entre 0 y " + (lista.size() - 1) + ":"); 
                posicion = sc.nextInt();

                if (posicion < 0 || posicion > lista.size() - 1) { 
                    valido = false;
                    System.err.println("Fuera de rango.");
                } else {
                    valido = true;
                }             
            } catch (InputMismatchException ex) {
                System.err.println("Solo puedes introducir un número entero.");
                valido = false;
                sc.next();
            }
        } while (!valido);        

        lista.remove(posicion);
        
        return lista;
    }
    
    static ArrayList<String> sustituirNombrePosicion(ArrayList<String> lista){
        sc = new Scanner(System.in);
        System.out.println("Introduce un nombre:");
        String nombre = sc.nextLine();
        int posicion = 0;
        boolean valido = true;
        do {              
            try {
                System.out.println("Introduce la posición entre 0 y " + (lista.size() - 1) + ":"); 
                posicion = sc.nextInt();
                if (posicion < 0 || posicion > lista.size() - 1) { 
                    valido = false;
                    System.err.println("Fuera de rango.");
                } else {
                    valido = true;
                }                    
            } catch (InputMismatchException ex) {
                System.err.println("Solo puedes introducir un número entero.");
                valido = false;
                sc.next();
            }
        } while (!valido);        
        
        lista.set(posicion, nombre);

        return lista;
    }
}
