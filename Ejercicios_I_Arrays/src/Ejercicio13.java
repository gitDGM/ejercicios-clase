
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
public class Ejercicio13 {
    final static int LONGITUD = 10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numeros = {2, 4, 6, 7, 10, 15, 40, 63, 85, 0};
        
        System.out.println("Introduce un número: ");
        numeros[LONGITUD - 1] = sc.nextInt();
        
        numeros = reordenarArray(numeros);
        
        for (int i = 0; i < LONGITUD; i++) {
            System.out.print(numeros[i] + " ");
        }
        
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
}
