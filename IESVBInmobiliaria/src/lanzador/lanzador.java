/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzador;

import iesvbinmobiliaria.IESVBInmobiliaria;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class lanzador {

    private static final IESVBInmobiliaria db = new IESVBInmobiliaria("iesvbinmobiliaria");
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Gestionar clientes");
            System.out.println("2.- Gestionar empleados");
            System.out.println("3.- Gestionar viviendas");
            System.out.println("4.- Gestionar movimientos");
            System.out.println("5.- Menú de consulta de datos");
            System.out.println("6.- Generar informes");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    gestionarClientes();
                    break;
                case 2:
                    gestionarEmpleados();
                    break;
                case 3:
                    gestionarViviendas();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    static void gestionarClientes() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar cliente");
            System.out.println("2.- Eliminar cliente");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.insertarCliente(
                            introducirCadena("Introduce el nombre del cliente:"),
                            introducirCadena("Introduce los apellidos del cliente:"),
                            introducirCadena("Introduce el DNI del cliente:"),
                            introducirCadena("Introduce el teléfono del cliente:")
                    );
                    break;
                case 2:
                    db.eliminarCliente(
                            introducirCadena("Introduce el DNI del cliente:")
                    );
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    static void gestionarEmpleados() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar empleado");
            System.out.println("2.- Eliminar empleado");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.insertarCliente(
                            introducirCadena("Introduce el nombre del empleado:"),
                            introducirCadena("Introduce los apellidos del empleado:"),
                            introducirCadena("Introduce el DNI del empleado:"),
                            introducirCadena("Introduce el teléfono del empleado:")
                    );
                    break;
                case 2:
                    db.eliminarCliente(
                            introducirCadena("Introduce el DNI del empleado:")
                    );
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    static void gestionarViviendas() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar casa");
            System.out.println("2.- Insertar piso");
            System.out.println("3.- Eliminar vivienda");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.insertarCasa(
                            introducirCadena("Introduce la referencia catastral de la vivienda:"),
                            introducirCadena("Introduce la direccion de la vivienda:"),
                            introducirCadena("Introduce la localidad de la vivienda:"),
                            introducirCadena("Introduce el pais de la vivienda:"),
                            introducirNumeroDouble("Introduce el precio de la vivienda:"),
                            introducirNumero("Introduce el número de pisos de la vivienda:"),
                            introducirCadena("Introduce el DNI del propietario:")
                    );
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
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
