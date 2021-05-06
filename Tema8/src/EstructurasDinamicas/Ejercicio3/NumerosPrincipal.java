/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.Ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class NumerosPrincipal {
    public static void main(String[] args) {
        NumerosController numerosController = new NumerosController();
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Mostrar TreeSet");
            System.out.println("2.- Mostrar HashSet");
            System.out.println("3.- Mostrar LinkedHashSet");
            System.out.println("4.- Generar nuevos números");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    numerosController.mostrarArbol();
                    break;
                case 2:
                    numerosController.mostrarHash();
                    break;
                case 3:
                    numerosController.mostrarLinkedHash();
                    break;
                case 4:
                    numerosController.renovarNumeros();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Elige una opción válida.");
                    break;
            }
        } while (opcion != 0);       
    }
    
    static int introducirNumero(String msg) {
        Scanner sc = new Scanner(System.in);
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
