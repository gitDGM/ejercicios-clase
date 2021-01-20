
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
public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        /* Permitir solo un número entre 1 y 10 */
        do {                
            System.out.println("Introduce la dimensión del array cuadrado (1 - 10): ");
            n = sc.nextInt();
        } while (n > 10 || n < 1);
        
        /* Inicializar el array con valores aleatorios */
        int[][] arrayCuadrado = new int[n][n];
                for(int i = 0; i < arrayCuadrado.length; i++) {
            for (int j = 0; j < arrayCuadrado[i].length; j++) {
                arrayCuadrado[i][j] = (int)(Math.random() * 100 + 1);
            }
        }
        
        /* Mostrar array y calculo de las medias de para cada diagonal del cuadrado*/
        double mediaDiagonal1 = 0;
        double mediaDiagonal2 = 0;        
        for(int i = 0; i < arrayCuadrado.length; i++) {
            for (int j = 0; j < arrayCuadrado[i].length; j++) {
                System.out.print(arrayCuadrado[i][j] + "\t");
            }
            System.out.print("\n\n\n");
            /* Suma de las diagonales */
            mediaDiagonal1 += arrayCuadrado[i][i];
            mediaDiagonal2 += arrayCuadrado[(arrayCuadrado.length - i) - 1][i];
        }
        /* Dividir entre la cantidad de numeros para conseguir la media */
        mediaDiagonal1 /= (double)arrayCuadrado.length;
        mediaDiagonal2 /= (double)arrayCuadrado.length;
        /* Mostrar diagonales */
        System.out.println("Diagonal 1: " + mediaDiagonal1);
        System.out.println("Diagonal 2: " + mediaDiagonal2);
    }
}
