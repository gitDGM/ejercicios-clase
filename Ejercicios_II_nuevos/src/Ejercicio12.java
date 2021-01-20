/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio12 {
    public static void main(String[] args) {
        int num, contador1, contador2, contador3;
        contador1 = 0; // Numeros entre 5 y 10
        contador2 = 0; // Numeros entre 11 y 15
        contador3 = 0; // Resto de números
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("Introduce un número positivo: ");
            num = sc.nextInt();
            
            if (num >= 0) {
                if (num >= 5 && num <= 10) {
                    contador1++;
                } else if (num >= 11 && num <= 15) {
                    contador2++;                
                } else {
                    contador3++;
                }  
            }                     
        } while (num >= 0);
        System.out.println("Contador rango 5 - 10: " + contador1);
        System.out.println("Contador rango 11 - 15: " + contador2);
        System.out.println("Contador fuera de rango: " + contador3);
    }
}
