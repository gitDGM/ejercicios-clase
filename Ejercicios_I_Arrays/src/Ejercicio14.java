
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
public class Ejercicio14 {
    final static int LONGITUD = 10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] numeros = {-30, 2, 4, 6, 7, 15, 15, 40, 63, 85};
        for (int i = 0; i < LONGITUD; i++) {
            System.out.print(numeros[i] + " ");
        }
        
        System.out.println("\n\nIntroduce un número que quieras eliminar: ");
        int num = sc.nextInt();
        for (int i = 0; i < LONGITUD; i++) {
            numeros[i] = num == numeros[i] ? 0 : numeros[i];
        }        
        numeros = reordenarArray(numeros);
        numeros = redimensionarArray(numeros);
        
        for (int i = 0; i < numeros.length; i++) {
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
    
    static int[] redimensionarArray(int[] matriz) {
        int contador = 0;
        for(int i = 0; i < matriz.length; i++) {
            contador = matriz[i] == 0 ? contador + 1 : contador;
        }
        int[] resizedMatriz = new int[matriz.length - contador];
        
        contador = 0;
        for(int i = 0; i < matriz.length; i++) {
            if (matriz[i] != 0) {
                resizedMatriz[contador] = matriz[i];
                contador++;
            }
        }
        
        return resizedMatriz;
    }
}
