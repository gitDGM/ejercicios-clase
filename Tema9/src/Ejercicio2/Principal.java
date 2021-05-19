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

    private static final PrincipalController db = new PrincipalController("agenciatributaria");
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
                    insertarFuncionario();
                    break;
                case 2:
                    insertarContribuyente();
                    break;
                case 3:
                    eliminarContribuyente();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    static void insertarFuncionario() {
        db.insertarFuncionario(
                introducirCadena("Introduce el nombre: "),
                introducirCadena("Introduce el nombre de la provincia: "),
                introducirNumero("Introduce su edad: ")
        );
    }

    static void insertarContribuyente() {
        db.insertarContribuyente(
                introducirCadena("Introduce el DNI: "),
                introducirCadena("Introduce el nombre: "),
                introducirCadena("Introduce el nombre de la población: "),
                introducirNumero("Introduce el ID del funcionario: "),
                introducirNumeroDouble("Introduce la cantiad a pagar:"),
                elegirPagar("Introduce si sale a pagar o no (S/N): ")
        );
    }

    static void eliminarContribuyente() {
        db.eliminarContribuyente(introducirCadena("Introduce el DNI:"));
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

    static boolean elegirPagar(String msg) {
        Scanner sc = new Scanner(System.in);
        boolean opcion = true;
        boolean noValido;

        do {
            System.out.println(msg);
            char letra = sc.next().charAt(0);

            switch (Character.toUpperCase(letra)) {
                case 'N':
                    opcion = false;
                    noValido = false;
                    break;
                case 'S':
                    opcion = true;
                    noValido = false;
                    break;
                default:
                    System.err.println("Opción no valida.");
                    noValido = true;
                    break;
            }
        } while (noValido);

        return opcion;
    }
}
