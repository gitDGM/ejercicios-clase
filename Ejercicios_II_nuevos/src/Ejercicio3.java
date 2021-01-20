/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        int num, contador, contadorPositivos, contadorNegativos;
        Scanner sc = new Scanner(System.in);
        contadorPositivos = 0;     
        contadorNegativos = 0;
        contador = 0;
        
        do {
            System.out.println("Introduce un número: ");
            num = sc.nextInt();
            if (num > 0) {
                contadorPositivos++;
                contador++;
            } else if (num < 0){
                contadorNegativos++;
                contador++;
            }
        } while (num != 0);
        System.out.println("------------------------");
        System.out.println("Cantidad de números: " + contador);
        System.out.println("Positivos:  " + contadorPositivos);
        System.out.println("Negativos:  " + contadorNegativos);
        System.out.println("------------------------");
    }
    
}
