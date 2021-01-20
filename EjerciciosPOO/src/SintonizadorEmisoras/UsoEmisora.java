/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SintonizadorEmisoras;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class UsoEmisora {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean encendido = true;
        Emisora emisora = new Emisora();
        int opcion;
        do {
            System.out.println("###############################");
            System.out.println("Frecuencia actual: " + emisora.getFrecuencia() + " MHz");
            System.out.println("###############################");
            System.out.println("1. Subir Frecuencia");
            System.out.println("2. Bajar Frecuencia");
            System.out.println("3. Apagar");
            System.out.println("###############################");
            opcion = introducirNumero("Elige una opcion: ");            
            switch (opcion) {
                case 1:
                    emisora.subirFrecuencia();
                    break;
                case 2:
                    emisora.bajarFrecuencia();
                    break;
                case 3:
                    encendido = false;
                    break;
                default:
                    System.out.println("Fuera de rango.");
                    break;
            }
        } while (encendido);
    }
    
    static int introducirNumero(String msg) {
         int numero = 0;        
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
