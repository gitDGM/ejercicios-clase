
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
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] numeros = new int[3][4];
        System.out.println("Introduce un número: ");
        int num = sc.nextInt();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                numeros[i][j] = num;
            }
        }
        
        System.out.println("Listado");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(numeros[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
