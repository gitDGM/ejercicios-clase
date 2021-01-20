/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Introduce un número decimal: ");
        double decimal = sc.nextDouble();
        
        System.out.println("El número redondeado es: " + Math.round(decimal));
    }
}
