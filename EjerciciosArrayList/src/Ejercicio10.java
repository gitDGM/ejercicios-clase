/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
/**
 *
 * @author alumno
 */
public class Ejercicio10 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] elementos = null;
        int longitud;
        do {            
            longitud = introducirNumero("Introduce la cantidad de elementos: ");
            if (longitud < 0) {
                System.err.println("Debe ser un número entero positivo.");
            }
        } while (longitud < 0);
        elementos = generarElementos(elementos, longitud);
        
        System.out.println("Elementos:");
        System.out.println(Arrays.toString(elementos));
        
        System.out.println("\nCombinaciones: ");
        mostrarCombinacionesDeTres(elementos);
    }
    
    static void mostrarCombinacionesDeTres(int[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            int num1 = elementos[i];
            for (int j = 0; j < elementos.length; j++) {
                int num2 = elementos[j];
                for (int k = 0; k < elementos.length; k++) {
                    int num3 = elementos[k];
                    if (num1 != num2 && num1 != num3 && num2 != num3) {
                        System.out.println(num1 + " - " + num2 + " - " + num3);
                    }
                }
            }
        }
    }
    
    static int[] generarElementos(int[] elementos, int longitud) {
        elementos = new int[longitud];
        
        for (int i = 0; i < elementos.length; i++) {
            elementos[i] = (int)(Math.random() * 100);
        }
        
        return elementos;
    }
    
    static int introducirNumero(String msg) {
         int numero = 0;        
         boolean NoValido;
         do {
             System.out.println(msg);
             try {
                 numero = sc.nextInt();      
                 NoValido = false;
             } catch (InputMismatchException ex) {
                 System.err.println("Debe ser un número entero.");
                 NoValido = true;
                 sc.next();
             }
         } while (NoValido);

         return numero;
     }
}
