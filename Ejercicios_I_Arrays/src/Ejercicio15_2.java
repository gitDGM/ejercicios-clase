/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio15_2 {
    final static int LONGITUD1 = 4;
    final static int LONGITUD2 = 6;
    public static void main(String[] args) {
        int[] array1 = new int[LONGITUD1];
        int[] array2 = new int[LONGITUD2];
        
        for (int i = 0; i < array1.length; i++) {
            array1[i] = (int)(Math.random() * 100 + 1);
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = (int)(Math.random() * 100 + 1);
        }
        
        array1 = reordenarArray(array1);
        array2 = reordenarArray(array2);
        System.out.println("Array 1");
        mostrarArray(array1);
        System.out.println("Array 2");
        mostrarArray(array2);
        
        int[] arrayResultado = reordenarArray(combinarArray(array1, array2));
        mostrarArray(arrayResultado);
        
    }
    
    static int[] reordenarArray(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 1; j < (matriz.length - i); j++) {
                if (matriz[j - 1] > matriz[j]) {
                    int temporal = matriz[j - 1];
                    matriz[j - 1] = matriz[j];
                    matriz[j] = temporal;
                }
            }
        }
                
        return matriz;
    }
    
    static int[] combinarArray(int[] matriz1, int[] matriz2) {
        int[] matrizResultado = new int[matriz1.length + matriz2.length];
        
        for (int i = 0; i < matrizResultado.length; i++) {
            if (i < matriz1.length) {
                matrizResultado[i] = matriz1[i];
            } else {
                matrizResultado[i] = matriz2[i - matriz1.length];
            }
        } 
        
        return matrizResultado;
    }
    
    static void mostrarArray(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i] + "\t");
        }
        System.out.print("\n");
    }
}
