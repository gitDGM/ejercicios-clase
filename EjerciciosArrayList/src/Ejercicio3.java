/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author alumno
 */
public class Ejercicio3 {
    static Scanner sc = new Scanner(System.in);
    final static int FILAS = 3;
    final static int COLUMNAS = 4;    
    public static void main(String[] args) {
        int[][] arrayBidimensional = new int[FILAS][COLUMNAS];
        int numero = introducirNumero("Introduce un número para inicializar todo el array:");
        
        arrayBidimensional = rellenarArrayBidimensional(arrayBidimensional, numero);        
        mostrarArrayBidimensional(arrayBidimensional);
    }
    
    static int[][] rellenarArrayBidimensional(int[][] arrayBidimensional, int numero) {
        
        for (int i = 0; i < arrayBidimensional.length; i++) {
            Arrays.fill(arrayBidimensional[i], numero);
        }
        
        return arrayBidimensional;
    }
    
    static void mostrarArrayBidimensional(int[][] arrayBidimensional) {
        
        for (int i = 0; i < arrayBidimensional.length; i++) {
            System.out.println(Arrays.toString(arrayBidimensional[i]));
        }
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
