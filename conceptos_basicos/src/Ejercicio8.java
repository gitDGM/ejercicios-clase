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

public class Ejercicio8 {
    public static void main(String[] args) {
        int kilosManzanas, kilosPeras;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Introduce los kilos de peras vendidos este trimestre: ");
        kilosPeras = sc.nextInt();
        System.out.print("Introduce los kilos de manzanas vendidos este trimestre: ");
        kilosManzanas = sc.nextInt();
        System.out.println("\nImporte total: " + (((double)kilosManzanas * 2.35) + ((double)kilosPeras * 1.95)));
        
    }
}
