/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        int[][] matrizA = new int[3][5];
        int[][] matrizB = new int[5][2];
        int[][] matrizResultado = new int[3][2];
        
        matrizA = rellenarMatriz(matrizA);
        matrizB = rellenarMatriz(matrizB);
        
        System.out.println("\nMatriz A");
        mostrarMatriz(matrizA);
        System.out.println("\nMatriz B");
        mostrarMatriz(matrizB);
        
        matrizResultado = multiplicarMatrices(matrizA, matrizB, matrizResultado);
        
        
        System.out.println("\nMatriz Resultado");
        mostrarMatriz(matrizResultado);
    }
    
    static int[][] multiplicarMatrices(int[][] matrizA, int[][] matrizB, int[][] matrizResultado) {
        for (int i = 0; i < matrizResultado.length; i++) {
            for (int j = 0; j < matrizResultado[i].length; j++) {
                for (int x = 0; x < matrizA[i].length; x++) {
                    //System.out.println(matrizA[i][x] + " * " + matrizB[x][j] + " = " + matrizA[i][x] * matrizB[x][j]);
                    matrizResultado[i][j] += matrizA[i][x] * matrizB[x][j];
                }
            }
        }
        return matrizResultado;
    }
    
    static int[][] rellenarMatriz(int[][] matriz) {
        
        for (int i = 0; i < matriz.length; i++) {
            for( int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int)(Math.random() * 100 + 1);
            }
        }
        return matriz;
    }
    
    static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for( int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.print("\n\n");
        }
    }
}
