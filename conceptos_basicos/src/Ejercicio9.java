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

public class Ejercicio9 {

    public static void main(String[] args) {
        int kilosManzanas, kilosPeras;
        double precioManzanas, precioPeras;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Introduce los kilos de peras vendidos este trimestre: ");
        kilosPeras = sc.nextInt();
        System.out.print("Introduce el precio por kilo de las peras: ");
        precioPeras = sc.nextDouble();
        System.out.print("Introduce los kilos de manzanas vendidos este trimestre: ");
        kilosManzanas = sc.nextInt();
        System.out.print("Introduce el precio por kilo de las manzanas: ");
        precioManzanas = sc.nextDouble();
        System.out.println("\nImporte total: " + (((double) kilosManzanas * precioManzanas) + ((double) kilosPeras * precioPeras)));
    }
}
