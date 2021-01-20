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

public class Test {
    public static void main(String[] args) {
        double baseImponible, iva;
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Base imponible: ");
        baseImponible = sc.nextDouble();
        System.out.println("IVA: ");
        iva = sc.nextDouble();
        
        System.out.println("Importe IVA: " + (baseImponible * (iva / 100)));
        System.out.println("Importe total: " + (baseImponible + (baseImponible * (iva / 100))));
        
    }
}
