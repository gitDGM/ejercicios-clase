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
public class Ejercicio4 {
    public static void main(String[] args) {        
        Scanner sc = new Scanner(System.in);
        int opcion;
        System.out.println("Introduce un número: ");
        int numero = sc.nextInt();
        do {
            menu();
            System.out.println("Elige una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    comprobarPar(numero);
                    break;
                case 2:
                    comprobarPositivo(numero);
                    break;
                case 3:
                    comprobarPrimo(numero);
                    break;
                case 4:
                    System.out.println("Hasta la próxima!");
                    break;   
                default:
                    System.out.println("Fuera de rango");
                    break;
            }
        } while (opcion != 4);
    }
    
    static void menu() {
        System.out.println("1.- Par / Impar");
        System.out.println("2.- Positivo / Negativo");
        System.out.println("3.- Primo / No Primo");
        System.out.println("4.- Terminar");
    }
    
    static void comprobarPositivo(int num) {
        boolean result;
        result = num >= 0;
        
        if (result) {
            System.out.println("Es positivo.");
        } else {
            System.out.println("Es negativo.");
        }
    }
    
    static void comprobarPar(int num) {
        boolean result;
        result = num % 2 == 0;
        
        if (result) {
            System.out.println("Es par.");
        } else {
            System.out.println("Es impar.");
        }
    }
    
    static void comprobarPrimo(int num) {
        int contador = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                contador++;
            }
        }
        if (contador <= 2) {
            System.out.println("Es primo.");
        } else {
            System.out.println("No es primo.");
        }
    }
}
