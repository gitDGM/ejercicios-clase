/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicios_I;


import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        double resultado = 0;
        
        System.out.println("Introduce un número: ");
        num = sc.nextInt();
        
        if (num < 500) {
            resultado = num + num*0.5;
        } else if (num >= 500 && num < 1000) {
            resultado = num + num*0.1;
        } else if (num >= 100 && num <= 5000) {
            resultado = num + num*0.15;
        } else if (num > 5000) {
            resultado = num - num*0.05;
        }
        
        System.out.println("Resultado: " + resultado);
    }
}
