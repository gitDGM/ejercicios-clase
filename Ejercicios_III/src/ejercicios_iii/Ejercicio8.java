/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_iii;


import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num, opcion;
        
        System.out.println("Introduce un número: ");
        num = sc.nextInt();
        
        do {
            System.out.println("-------------------");
            System.out.println("1.- Par / Impar");
            System.out.println("2.- Positivo / Negativo");
            System.out.println("3.- Primo / No Primo");
            System.out.println("4.- Terminar");
            System.out.println("-------------------");
            
            System.out.println("Elige una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    if (num % 2 == 0) {
                        System.out.println("Es par.");                       
                    } else {                        
                        System.out.println("Es impar.");      
                    }
                    break;
                case 2:
                    if (num >= 0) {
                        System.out.println("Es positivo.");                       
                    } else {                        
                        System.out.println("Es negativo.");      
                    }
                    break;
                case 3:
                    int contador = 0;
                    for (int i = 1; i <= num; i++) {
                        if (num % i == 0) {
                            contador++;
                        }
                    }                    
                    if (contador <= 2) {
                        System.out.println("Es primo.");                       
                    } else {                        
                        System.out.println("No es primo.");      
                    }
                    break;
                case 4:
                    System.out.println("Cerrando el programa.");      
                    break;
                default:
                    System.out.println("Opción fuera de rango");                          
                    break;
            }            
        } while (opcion != 4);
    }
}
