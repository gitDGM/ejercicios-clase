/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import java.util.Locale;
/**
 *
 * @author alumno
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        int exponente;
        Scanner sc = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.println("Introduce la base: ");
        double base = sc.nextDouble();
        
        do {
            System.out.println("Introduce el exponente: ");
            exponente = sc.nextInt();      
        } while (exponente < 0 );
        
        potencia(base, exponente);
    }
    
    static void potencia(double base, int exponente) {
        double result = 1;
        for (int i = 0; i < exponente; i++) {
            result *= base;
        } 
        System.out.println(base + "^" + exponente + " = " + result);
    }
}
