/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio1 {        
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int longitud = introducirNumero("Introduce la cantidad de números que vas a introducir:");
        int[] numeros = new int[longitud];
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = introducirNumero("Introduce un número:");
        }
        
        System.out.println("Array:");
        System.out.println(Arrays.toString(numeros));
        
        System.out.println("Array invertido:");
        int[] numerosInvertidos = invertirArray(numeros);
        System.out.println(Arrays.toString(numerosInvertidos));
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
    
    static int[] invertirArray(int[] matriz) {
        int[] matrizInvertida = new int[matriz.length];
        for (int i = matriz.length - 1, j = 0; i >= 0; i--, j++) {
            matrizInvertida[j] = matriz[i];
        }
        
        return matrizInvertida;
    }
}
