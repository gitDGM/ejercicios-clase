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

public class Ejercicio10 {
    public static void main(String[] args) {
        double radio;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Introduce el radio de la circunferencia: ");        
        radio = sc.nextDouble();
        
        System.out.println("\nLa longitud: " + (2 * Math.PI * radio));
        System.out.println("El área: " + (Math.PI * radio * radio));
    }
}
