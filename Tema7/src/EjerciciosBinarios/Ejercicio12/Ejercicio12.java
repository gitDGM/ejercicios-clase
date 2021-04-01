/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio12;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 0017610
 */
public class Ejercicio12 {
    private static final AplicacionClientes app = new AplicacionClientes();
    public static void main(String[] args) {
        app.cargarClientesDesdeFicheroBinario();
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Añadir nuevo cliente");
            System.out.println("2.- Modificar datos");
            System.out.println("3.- Dar de baja cliente");
            System.out.println("4.- Listar los cliente");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch (opcion) {
                case 1:
                    nuevoCliente();
                    break;
                case 2:
                    if (app.siHayClientes()) {
                        modificarDatos();                        
                    } else {
                        System.err.println("ATENCIÓN: No hay clientes.");
                    }
                    break;
                case 3:
                    if (app.siHayClientes()) {
                        bajaCliente();                   
                    } else {
                        System.err.println("ATENCIÓN: No hay clientes.");
                    }
                    break;
                case 4:
                    if (app.siHayClientes()) {
                        app.mostrarClientes();                    
                    } else {
                        System.err.println("ATENCIÓN: No hay clientes.");
                    }
                    break;
                case 0:
                    app.guardarClientesEnFicheroBinario();
                    break;
                default:
                    System.err.println("ERROR: Fuera de rango.");
                    break;
            }
        } while (opcion != 0);
    }
    
    static void nuevoCliente() {
        String nombre = introducirCadena("Introduce el nombre del cliente:");
        String telefono = introducirCadena("Introduce el teléfono del cliente:");
        app.addCliente(new Cliente(nombre, telefono));
    }
    
    static void bajaCliente() {
        app.removeCliente(elegirCliente());
    }
    
    static void modificarDatos() {
        int idCliente = elegirCliente();
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Nombre");
            System.out.println("2.- Telefono");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch (opcion) {
                case 1:
                    String nombre = introducirCadena("Introduce el nuevo nombre:");
                    app.modificarNombreCliente(idCliente, nombre);
                    break;
                case 2:
                    String telefono = introducirCadena("Introduce el nuevo telefono:");
                    app.modificarTelefonoCliente(idCliente, telefono);
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Fuera de rango.");
                    break;
            }
        } while (opcion != 0);
    }
    
    static void listarClientes() {
        app.mostrarClientes();
    }
    
    static int elegirCliente() {
        int idCliente;
        System.out.println("##########################");
        listarClientes();    
        System.out.println("##########################");
        do {            
            idCliente = introducirNumero("Elige una opción:");         
        } while (!app.buscarSiExiste(idCliente));
        
        return idCliente;
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

}
