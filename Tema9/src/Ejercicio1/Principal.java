/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Principal {
    private static final PrincipalController db = new PrincipalController("tienda");
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar fabricante");
            System.out.println("2.- Insertar producto");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.insertarFabricante(introducirCadena("Introduce el nombre del fabricante: "));
                    break;
                case 2:
                    insertarProducto();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    static void insertarProducto() {
        String nombreProducto = introducirCadena("Introduce el nombre del producto: ");
        double precio = introducirNumeroDouble("Introduce el precio: ");
        int idFrabricante = introducirNumero("Introduce el ID del fabricante: ");

        db.insertarProducto(nombreProducto, precio, idFrabricante);
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
