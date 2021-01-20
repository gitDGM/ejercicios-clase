
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
public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el tamaño del array: ");
        int arraySize = sc.nextInt();
        int[] arrayEjer16 = new int[arraySize];
        for (int i = 0; i < arrayEjer16.length; i++) {
            System.out.println("Introduce un numero entero: ");
            arrayEjer16[i] = sc.nextInt();
        }
        
        for(int i = 0; i < arrayEjer16.length; i++) {
            for (int j = 0; j < arrayEjer16[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
