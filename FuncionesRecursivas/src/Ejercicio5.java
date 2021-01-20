/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *
 * @author Diego
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = sc.nextInt();
        int cifras = String.valueOf(num).length();
        System.out.println("Suma: " + sumarDigitos(num, cifras - 1, 0));        
    }
    private static int sumarDigitos(int num, int cifras, int suma) {
        if (num < 10) {
            suma += num;
            return suma;
        } else {
            suma += num % 10;
            return sumarDigitos(num / 10, cifras - 1, suma);
        }
    }
}
