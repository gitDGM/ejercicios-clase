/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio8 {
    public static void main(String[] args) {
        int[] arrayEjer8 = new int[15];
        
        for (int i = 0; i < arrayEjer8.length; i++) {
            arrayEjer8[i] = (int)(Math.random() * 100 + 1);
        }
        
        int[] arrayPares = new int[contarPares(arrayEjer8)];
        int[] arrayImpares = new int[15 - contarPares(arrayEjer8)];
        
        int contadorPar = 0;
        int contadorImpar = 0;
        for (int i = 0; i < arrayEjer8.length; i++) {
            if (arrayEjer8[i] % 2 == 0) {
                arrayPares[contadorPar] = arrayEjer8[i];
                contadorPar++;
            } else {
                arrayImpares[contadorImpar] = arrayEjer8[i];
                contadorImpar++;
            }
        }
        
        System.out.println("Array Números");
        for (int i = 0; i < arrayEjer8.length; i++) {
            System.out.print(arrayEjer8[i] + "\t");
        }
        
        System.out.println("\n\nArray Números Pares");
        for (int i = 0; i < arrayPares.length; i++) {
            System.out.print(arrayPares[i] + "\t");
        }
        
        System.out.println("\n\nArray Números Impares");
        for (int i = 0; i < arrayImpares.length; i++) {
            System.out.print(arrayImpares[i] + "\t");
        }
    }
    
    static int contarPares(int[] array) {
        int contador = 0;
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                contador++;                
            }
        }
        
        return contador;
    }
}
