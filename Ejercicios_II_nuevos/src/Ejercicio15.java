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
public class Ejercicio15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, contador;
        contador = 0;
        System.out.println("Introduce un número: ");
        num = sc.nextInt();
        
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                contador++;
            }
        }
        
        if (contador <= 2) {
            System.out.println("El número " + num + " es primo.");
        } else {
            System.out.println("El número " + num + " no es primo.");
        }
    }
}
