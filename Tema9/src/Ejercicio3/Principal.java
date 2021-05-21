/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Principal {

    private static final PrincipalController db = new PrincipalController("mascotas");
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar animal");
            System.out.println("2.- Eliminar amimal");
            System.out.println("3.- Consular datos de los animales");
            System.out.println("4.- Consultar datos de un animal");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    opcionInsertarAninal();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    static void opcionInsertarAninal() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Perro");
            System.out.println("2.- Gato");
            System.out.println("3.- Loro");
            System.out.println("4.- Canario");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige un tipo de animal:");
            switch(opcion) {
                case 1:
                    insertarPerro();
                    break;
                case 2:
                    insertarGato();
                    break;
                case 3:
                    insertarLoro();
                    break;
                case 4:
                    insertarCanario();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);

    }

    static void insertarPerro() {
        String nombre = introducirCadena("Introduce el nombre del perro:");
        int edad = introducirNumero("Introduce la edad del perro:");
        boolean estado = elegirEstado("Está vivo? (S/N):");
        LocalDate fechaNacimiento = LocalDate.of(
                introducirNumero("Introduce el año (aaaa): "),
                introducirNumero("Introduce el mes (mm): "),
                introducirNumero("Introduce el día (dd):")
        );
        String raza = introducirCadena("Introduce la raza del perro:");
        boolean pulgas = elegirEstado("Tiene pulgas vivo? (S/N):");

        db.insertarPerro(nombre, edad, estado, fechaNacimiento, raza, pulgas);
    }

    static void insertarGato() {
        String nombre = introducirCadena("Introduce el nombre del gato:");
        int edad = introducirNumero("Introduce la edad del gato:");
        boolean estado = elegirEstado("Está vivo? (S/N):");
        LocalDate fechaNacimiento = LocalDate.of(
                introducirNumero("Introduce el año (aaaa): "),
                introducirNumero("Introduce el mes (mm): "),
                introducirNumero("Introduce el día (dd):")
        );
        String raza = introducirCadena("Introduce el colo del gato:");
        boolean peloLargo = elegirEstado("Tiene pelo largo? (S/N):");
    }

    static void insertarLoro() {
        String nombre = introducirCadena("Introduce el nombre del loro:");
        int edad = introducirNumero("Introduce la edad del loro:");
        boolean estado = elegirEstado("Está vivo? (S/N):");
        LocalDate fechaNacimiento = LocalDate.of(
                introducirNumero("Introduce el año (aaaa): "),
                introducirNumero("Introduce el mes (mm): "),
                introducirNumero("Introduce el día (dd):")
        );
        boolean pico = elegirEstado("Tiene pico? (S/N):");
        boolean vuela = elegirEstado("Puede volar? (S/N):");
        String raza = introducirCadena("Introduce el origen del loro:");
        boolean habla = elegirEstado("Puede hablar? (S/N):");
    }

    static void insertarCanario() {
        String nombre = introducirCadena("Introduce el nombre del canario:");
        int edad = introducirNumero("Introduce la edad del canario:");
        boolean estado = elegirEstado("Está vivo? (S/N):");
        LocalDate fechaNacimiento = LocalDate.of(
                introducirNumero("Introduce el año (aaaa): "),
                introducirNumero("Introduce el mes (mm): "),
                introducirNumero("Introduce el día (dd):")
        );
        boolean pico = elegirEstado("Tiene pico? (S/N):");
        boolean vuela = elegirEstado("Puede volar? (S/N):");
        String color = introducirCadena("Introduce el color del canario:");
        boolean canta = elegirEstado("Puede cantar? (S/N):");
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

    static boolean elegirEstado(String msg) {
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
