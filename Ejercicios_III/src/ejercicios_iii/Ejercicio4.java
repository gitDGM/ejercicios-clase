/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_iii;

import java.util.Scanner;
import java.util.Locale;
/**
 *
 * @author alumno
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
        double num;
        
        System.out.println("Introduce un número real: ");
        num = sc.nextDouble();
        
        if (num > -1 && num < 1) {
            System.out.println("Es un número \"casi-cero\".");
        } else {
            System.out.println("No es un número \"casi-cero\".");            
        }
    }   
}
