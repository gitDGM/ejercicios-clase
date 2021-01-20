/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class Ejercicio8 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Double> notas = new ArrayList<>();
        
        do {
            double numero;
            do {    
                numero = introducirNumero("Introduce una nota entre 0 y 10: ");            
                if (numero >= 0 && numero <= 10) {
                    notas.add(numero);
                } else {
                   System.err.println("Debe ser un número entro 0 y 10.");
                }
            } while (numero < 0 || numero > 10);            
        } while (elegirOpcionContinuar("\nQuieres continuar? (S/N)"));
        
        if (!notas.isEmpty()) {
            mostrarNotas(notas);
            if (notas.size() >= 2) {
                notas = intercambiarPosicionNotas(notas);
                mostrarNotas(notas);
            }
        }
    }
    
    static ArrayList<Double> intercambiarPosicionNotas(ArrayList<Double> notas) {
        int posicion1, posicion2;
        System.out.println("Intercambiar posición de notas");
        do {            
            posicion1 = (int)introducirNumero("Introduce la posición de una nota (1 - " + notas.size() +"): ");
            if (posicion1 < 1 || posicion1 > notas.size()) {
                System.err.println("Debes introducir una posción dentro del rango.");
            }
        } while (posicion1 < 1 || posicion1 > notas.size());
        do {            
            posicion2 = (int)introducirNumero("Introduce la otra posición de una nota (1 - " + notas.size() +"): ");
            if (posicion2 < 1 || posicion2 > notas.size()) {
                System.err.println("Debes introducir una posción dentro del rango.");
            }
        } while (posicion2 < 1 || posicion2 > notas.size());
        
        // INTERCAMBIO DE POSICIÓN
        double temporal = notas.get(posicion1 - 1);
        notas.set(posicion1 - 1, notas.get(posicion2 - 1));
        notas.set(posicion2 - 1, temporal);
        
        return notas;
    }
    
    static void mostrarNotas(ArrayList<Double> notas) {
        System.out.println("\nNotas:");
        for (int i = 0; i < notas.size(); i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas.get(i));
        }
    }
    
    static boolean elegirOpcionContinuar(String msg) {
        boolean opcion = true; 
        boolean noValido;
        
        do {      
            System.out.println(msg);
            char letra = sc.next().charAt(0);

            switch (Character.toUpperCase(letra)) {
                case 'N':
                    opcion = false;
                    noValido = false;
                    break;
                case 'S':
                    opcion = true;
                    noValido = false;
                    break;
                default:
                    System.err.println("Opción no valida.");
                    noValido = true;
                    break;
            }
        } while (noValido);     
        
        return opcion;
    }
    
    static double introducirNumero(String msg) {
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
