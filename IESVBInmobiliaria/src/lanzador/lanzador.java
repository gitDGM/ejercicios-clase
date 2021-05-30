/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzador;

import Helpers.Comprobar;
import iesvbinmobiliaria.IESVBInmobiliaria;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class lanzador {

    private static final IESVBInmobiliaria db = new IESVBInmobiliaria("iesvbinmobiliaria");
    // Función main
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
                case 4:
                    gestionarMovimientos();
                    break;
                case 5:
                    menuConsultas();
                    break;
                case 6:
                    menuInformes();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }
    
    // Función para el menu de clientes
    static void gestionarClientes() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar cliente");
            // System.out.println("2.- Eliminar cliente");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.insertarCliente(
                            introducirCadena("Introduce el nombre del cliente:"),
                            introducirCadena("Introduce los apellidos del cliente:"),
                            verificarDNI(introducirCadena("Introduce el DNI del cliente:")),
                            introducirCadena("Introduce el teléfono del cliente:")
                    );
                    break;
                case 2:
                    /*
                    // COMENTADO POR POSIBLE FALLO AL VISUALIZAR VENTAS DESPUÉS DE BORRAR
                    db.eliminarCliente(
                            introducirCadena("Introduce el DNI del cliente:")
                    );
                    */
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    // Función para el menu de empleados
    static void gestionarEmpleados() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar empleado");
            // System.out.println("2.- Eliminar empleado");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.insertarEmpleado(
                            introducirCadena("Introduce el nombre del empleado:"),
                            introducirCadena("Introduce los apellidos del empleado:"),
                            verificarDNI(introducirCadena("Introduce el DNI del empleado:")),
                            introducirCadena("Introduce el teléfono del empleado:")
                    );
                    break;
                case 2:
                    /*
                    // COMENTADO POR POSIBLE FALLO AL VISUALIZAR VENTAS DESPUÉS DE BORRAR
                    db.eliminarEmpleado(
                            introducirCadena("Introduce el DNI del empleado:")
                    );
                    */
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    // Función para el menu de viviendas
    static void gestionarViviendas() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar vivienda");
            // System.out.println("2.- Eliminar vivienda");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.insertarVivienda(
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
                    /*
                    // COMENTADO POR POSIBLE FALLO AL VISUALIZAR VENTAS DESPUÉS DE BORRAR
                    db.eliminarVivienda(
                            introducirCadena("Introduce la referencia catastral de la vivienda:")
                    );
                    */
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    // Función para el menu de movimientos
    static void gestionarMovimientos() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar venta");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.insertarVenta(
                            verificarDNI(introducirCadena("Introduce el DNI del cliente:")),
                            verificarDNI(introducirCadena("Introduce el DNI del empleado:")),
                            introducirCadena("Introduce la referencia catastral de la vivienda:")
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

    // Función para el menu de consultas
    static void menuConsultas() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Listar todos los clientes");
            System.out.println("2.- Buscar un cliente");
            System.out.println("3.- Listar todos los empleados");
            System.out.println("4.- Buscar un empleado");
            System.out.println("5.- Listar todas las viviendas");
            System.out.println("6.- Buscar una vivienda");
            System.out.println("7.- Listar las viviendas de un cliente.");
            System.out.println("8.- Listar todos los movimientos");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.listarClientes();
                    break;
                case 2:
                    db.listarCliente(introducirCadena("Introduce el DNI del cliente:"));
                    break;
                case 3:
                    db.listarEmpleados();
                    break;
                case 4:
                    db.listarEmpleado(
                            introducirCadena("Introduce el DNI del empleado:")
                    );
                    break;
                case 5:
                    db.listarViviendas();
                    break;
                case 6:
                    db.listarVivienda(
                            introducirCadena("Introduce la referencia catastral de la vivienda:")
                    );
                    break;
                case 7:
                    db.listarViviendasPropietario(
                            introducirCadena("Introduce el DNI del propietario:")
                    );
                    break;
                case 8:
                    db.listarMovimientos();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    // Función para el menu de informes
    static void menuInformes() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Informe de todos los movimientos");
            System.out.println("2.- Informe de todos los clientes");
            System.out.println("3.- Informe de todos los empleados");
            System.out.println("4.- Informe de todas las viviendas");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    db.generarInformeMovimientos();
                    break;
                case 2:
                    db.generarInformeClientes();
                    break;
                case 3:
                    db.generarInformeEmpleados();
                    break;
                case 4:
                    db.generarInformeViviendas();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opción inválida.");
                    break;
            }
        } while (opcion != 0);
    }

    // Función para introducir una cadena
    static String introducirCadena(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.println(msg);

        return sc.nextLine();
    }

    // Función para verificar un DNI
    static String verificarDNI(String dni) {
        boolean valido = Comprobar.verificarDNI(dni);

        while (!valido) {
            if (!valido) {
                System.err.println("ERROR: El DNI es inválido.");
            }
            dni = introducirCadena("Introduce un DNI válido:");
            valido = Comprobar.verificarDNI(dni);
        }

        return dni;
    }

    // Función para introducir un número entero
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
                System.err.println("Debe ser un número entero.");
                noValido = true;
                sc.next();
            }
        } while (noValido);

        return numero;
    }

    // Función para introducir un número decimal
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

    // Función para devolver un boolean
    static boolean elegir(String msg) {
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
