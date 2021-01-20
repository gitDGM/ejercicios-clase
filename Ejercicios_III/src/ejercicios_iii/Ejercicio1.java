/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_iii;

/**
 *
 * @author alumno
 */
import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numeros = {0, 0 ,0};
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Introducuce un número: ");
            numeros[i] = sc.nextInt();
        }
        
        Arrays.sort(numeros);
        
        for (int num : numeros) {
            System.out.println(num);   
        }        
    }
}
