/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicasLourdes.edinamicas.Ejercicio;

import EstructurasDinamicasLourdes.edinamicas.Lista;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Principal {
    
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n\nEstructuras dinámicas");
            System.out.println("*************************\n");
            System.out.println("1.- Trabajar con listas");
            System.out.println("2.- Trabajar con pilas");
            System.out.println("3.- Trabajar con colas");
            System.out.println("4.- Trabajar con listas genéricas");
            System.out.println("5.- Trabajar con listas ordenadas");
            System.out.println("6.- Trabajar con listas doblemente enlazadas");
            System.out.println("7.- Trabajar con listas circulares");
            System.out.println("0.- Salir\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    menuLista();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Error: Opción no válida.");
                    break;
            }
        } while (opcion != 0);       
    }
    
    
    static void menuLista() {
        Lista lista = new Lista();
        int opcion;        
        do {
            System.out.println("\n\nTrabajando con LISTAS");
            System.out.println("*************************\n");
            System.out.println("1.- Insertar elemento");
            System.out.println("2.- Insertar elemento en una posición");
            System.out.println("3.- Trabajar con colas");
            System.out.println("4.- Trabajar con listas genéricas");
            System.out.println("5.- Trabajar con listas ordenadas");
            System.out.println("6.- Trabajar con listas doblemente enlazadas");
            System.out.println("7.- Trabajar con listas circulares");
            System.out.println("0.- Salir\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Error: Opción no válida.");
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
