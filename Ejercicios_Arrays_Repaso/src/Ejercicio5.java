
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la dimension del vector: ");
        int dimension = sc.nextInt();
        int[] vector = new int[dimension];
        
        vector = rellenarMatriz(vector);
        mostrarMatriz(vector);
        
        System.out.println("Resultado suma: " + sumarVectorRecursiva(vector, vector.length - 1));
    }
    
    static int[] rellenarMatriz(int[] matriz) {        
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int)(Math.random() * 100 + 1);
        }
        return matriz;
    }
    
    static void mostrarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i] + "\t");
        }
        System.out.println();
    }
    
    static int sumarVectorRecursiva(int[] vector, int contador) {
        if (contador == 0) {
            return vector[contador];            
        } else {
            return vector[contador] + sumarVectorRecursiva(vector, contador - 1);
        }
    }
}
