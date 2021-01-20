/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_iii;

import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.println("Introduce un número: ");
            num = sc.nextInt();                
        } while (num < 0 || num > 99999);
        
        System.out.println(num + " tiene " + Integer.toString(num).length() + " cifras.");
    }
}
