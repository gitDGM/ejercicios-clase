
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce la dimension de la matriz cuadrada: ");
        int dimension = sc.nextInt();
        
        int[][] matrizNumeros = new int[dimension][dimension];
        matrizNumeros = inicializarMatriz(matrizNumeros);
        mostrarMatriz(matrizNumeros);
        
        double mediaValores = calcularMediaValores(matrizNumeros); 
        int minimoValores = conseguirMinimo(matrizNumeros);
        int maximoValores = conseguirMaximo(matrizNumeros);
        int sumaDiagonalDescendente = sumarValoresDiagonalDescendente(matrizNumeros);
        int sumaDiagonalAscendente = sumarValoresDiagonalAscendente(matrizNumeros);        
        int sumaValoresEncimaDiagonal = sumarValoresPorEncimaDiagonal(matrizNumeros);     
        int sumaValoresDebajoDiagonal = sumarValoresPorDebajoDiagonal(matrizNumeros);
        
        
        System.out.println("Media de todos los valores: " + mediaValores);
        System.out.println("Valor mínimo: " + minimoValores);
        System.out.println("Valor máximo: " + maximoValores);
        System.out.println("Suma de la diagonal descendente: " + sumaDiagonalDescendente);
        System.out.println("Suma de la diagonal ascendente: " + sumaDiagonalAscendente);
        System.out.println("Suma de valores por encima de la diagonal descendente: " + sumaValoresEncimaDiagonal);
        System.out.println("Suma de valores por debajo de la diagonal descendente: " + sumaValoresDebajoDiagonal);
        
    }
    
    static int[][] inicializarMatriz(int[][] matriz) {        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int)(Math.random() * 100 + 1);
            }
        }
        
        return matriz;
    }
        
    static double calcularMediaValores(int[][] matriz) {
        double result = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                result += matriz[i][j];
            }
        }
        
        result /= (double)matriz.length * (double)matriz[0].length;
        
        return result;
    }
    
    static int conseguirMinimo(int[][] matriz) {
        int minimo = matriz[0][0];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < minimo) {
                    minimo = matriz[i][j];
                }
            }
        }
        
        return minimo;
    }
    
    static int conseguirMaximo(int[][] matriz) {
        int maximo = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > maximo) {
                    maximo = matriz[i][j];
                }
            }
        }
        
        return maximo;
    }
    
    static int sumarValoresDiagonalDescendente(int[][] matriz) {
        int result = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            result += matriz[i][i];
        }
        
        return result;
    }
    
    static int sumarValoresDiagonalAscendente(int[][] matriz) {
        int result = 0;
        int j = 0;
        
        for (int i = matriz.length - 1; i >= 0; i--) {
            result += matriz[i][j];
            j++;
        }
        
        return result;
    }
    
    static int sumarValoresPorEncimaDiagonal(int[][] matriz) {
        int result = 0;
        
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 1 + i; j < matriz[i].length; j++) {
                result += matriz[i][j];
            }
        }
        
        return result;
    }
    
    static int sumarValoresPorDebajoDiagonal(int[][] matriz) {
        int result = 0; 
        for (int i = 1; i < matriz.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //System.out.println(matriz[i][j]);
                result += matriz[i][j];
            }
        }
        
        return result;
    }
    
    static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println("\n\n");
        }
    }
}
