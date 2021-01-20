/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio10 {
    final static int LONGITUD = 10;
    public static void main(String[] args) {
        int[] arrayInicial = new int[LONGITUD];
        int[] arrayResultado = new int[LONGITUD];
        
        for (int i = 0; i < LONGITUD; i++) {
            arrayInicial[i] = (int)(Math.random() * 100 + 1);
        }
        
        int contador = 0;
        for (int i = 0; i < LONGITUD; i++) {
            if (arrayInicial[i] % 2 == 0) {
                arrayResultado[i - contador] = arrayInicial[i];
            } else {
                arrayResultado[(LONGITUD - 1) - contador] = arrayInicial[i];
                contador++;
            }
        }
        
        System.out.println("Array Inicial");
        for (int i = 0; i < LONGITUD; i++) {
            System.out.print(arrayInicial[i] + "\t");
        }
        
        System.out.println("\nArray Resultado");
        for (int i = 0; i < LONGITUD; i++) {
            System.out.print(arrayResultado[i] + "\t");
        }
    }
}
