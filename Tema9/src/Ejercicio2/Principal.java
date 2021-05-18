/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Principal {

    private static final Ejercicio1.PrincipalController db = new Ejercicio1.PrincipalController("tienda");
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar funcionario");
            System.out.println("2.- Insertar contribuyente");
            System.out.println("3.- Eliminar contribuyente");
            System.out.println("4.- Modificar importe de un contribuyente");
            System.out.println("5.- Mostrar contribuyentes atendidos por un funcionario");
            System.out.println("6.- Generar listado de poblaciones de los funcionarios");
            System.out.println("7.- Generar fichero de contribuyentes en una población");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    static String introducirCadena(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);

        return sc.nextLine();
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

    static double introducirNumeroDouble(String msg) {
        Scanner sc = new Scanner(System.in);
        double numero = 0;
        boolean noValido;
        do {
            System.out.println(msg);
            try {
                numero = sc.nextDouble();
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
