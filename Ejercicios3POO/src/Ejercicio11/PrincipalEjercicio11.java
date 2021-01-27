/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio11;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class PrincipalEjercicio11 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int hora, minuto, segundo, cantidadHoras;
        do {  
            hora = introducirNumero("Introduce una hora:");
            if (!(hora >= 0 && hora <= 23)) {
                System.err.println("Introduce una hora válida.");
            }
        } while (hora == -1 || !(hora >= 0 && hora <= 23));

        do {   
            minuto = introducirNumero("Introduce una minuto:");
            if (!(minuto >= 0 && minuto <= 59)) {
                System.err.println("Introduce un minuto válido.");
            }
        } while (minuto == -1 || !(minuto >= 0 && minuto <= 59));

        do {   
            segundo = introducirNumero("Introduce una segundo:");
            if (!(segundo >= 0 && segundo <= 59)) {
                System.err.println("Introduce un segundo válida.");
            }
        } while (segundo == -1 || !(segundo >= 0 && segundo <= 59));
        
        Hora miHora = new Hora(hora, minuto, segundo);
        
        do {   
            cantidadHoras = introducirNumero("Introduce la cantidad de horas que se diferencian en un segundo:");         
        } while (cantidadHoras == -1);
        
        System.out.println("\n#####################################");
        System.out.println("Hora actual");
        miHora.mostarHora();
        System.out.println("#####################################\n");
        for (int i = 0; i < cantidadHoras; i++) {
            miHora.avanzarUnSegundo();
            miHora.mostarHora();
        }
    }
    
    static int introducirNumero(String msg) {
         int numero = -1;        
         boolean noValido;
         do {
             System.out.println(msg);
             try {
                 numero = sc.nextInt();
                 noValido = false;
             } catch (InputMismatchException ex) {
                 System.err.println("Debe ser un número decimal.");
                 noValido = true;
                 sc.next();
             }
         } while (noValido);

         return numero;
     }
}
