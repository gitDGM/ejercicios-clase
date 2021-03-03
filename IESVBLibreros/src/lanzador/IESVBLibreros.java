/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
    TODO: 
    salida.txt con (nombre - precio - existencias),
    Si el fichero ya existe, los datos se añaden.
*/ 

package lanzador;

import iesvblibreros.Agenda;
import iesvblibreros.Libreria;
import iesvblibreros.Libro;
import iesvblibreros.Manual;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class IESVBLibreros {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        // Instancio un objeto Libreria para usarlo en el programa
        Libreria libreria = new Libreria();
        int opcion;
        
        // Menu principal del programa
        do {
            System.out.println("##########################");
            System.out.println("1.- Agregar articulo");
            System.out.println("2.- Borrar articulo");
            System.out.println("3.- Mostrar un articulo");
            System.out.println("4.- Mostrar todos los articulos");
            System.out.println("5.- Mostrar inventario");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    crearArticulo(libreria);
                    break;
                case 2:
                    borrarArticulo(libreria);
                    break;
                case 3:
                    mostrarArticulo(libreria);
                    break;
                case 4:
                    libreria.mostrarArticulos();
                    break;
                case 5:
                    libreria.mostrarInventario();
                    break;
                case 0:
                    libreria.borrarTodos();
                    System.out.println("Diego Gómez Moreno");
                    System.out.println("Finalizó correctamente la ejecución del programa...");
                    break;
                default:
                    System.err.println("ERROR: Opcion fuera de rango");                    
                    break;
            }
        } while (opcion != 0);       
    }
    
    // Menu para seleccionar el tipo de articulo
    static void crearArticulo(Libreria libreria) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Agenda");
            System.out.println("2.- Libro");
            System.out.println("3.- Manual");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    crearAgenda(libreria);
                    break;
                case 2:
                    crearLibro(libreria);
                    break;
                case 3:
                    crearManual(libreria);
                    break;
                case 0:
                    break;
                default:
                    System.err.println("ERROR: Opcion fuera de rango");                    
                    break;
            }
        } while (!(opcion >= 0 && opcion <= 3));
    }
    
    // Funcion para crear un objeto Agenda
    static void crearAgenda(Libreria libreria) {
        System.out.println("Introduce el nombre de la agenda: ");
        String nombre = sc.nextLine();        
        
        int existencias = introducirNumero("Introduce las existencias iniciales: ");
        
        double precio = introducirNumeroDouble("Introduce el precio unitario: ");
        
        System.out.println("Introduce el idioma: ");
        String idioma = sc.nextLine();
        
        int anyo = introducirNumero("Introduce el año de la agenda: ");
        
        libreria.agregarArticulo(new Agenda(idioma, anyo, nombre, existencias, precio));
        
    }
        
    // Funcion para crear un objeto Libro
    static void crearLibro(Libreria libreria) {
        System.out.println("Introduce el nombre del libro: ");
        String nombre = sc.nextLine();        
        
        int existencias = introducirNumero("Introduce las existencias iniciales: ");
        
        double precio = introducirNumeroDouble("Introduce el precio unitario: ");
        
        System.out.println("Introduce el nombre del autor: ");
        String autor = sc.nextLine();
        
        System.out.println("Introduce el nombre de la editorial: ");
        String editorial = sc.nextLine();
        
        int anyo = introducirNumero("Introduce el año de la agenda: ");
        
        System.out.println("Introduce un comentario del libro: ");
        String comentario = sc.nextLine();
        
        boolean bolsillo = elegirOpcionContinuar("Es una edición de bolsillo? (S/N)");
        
        libreria.agregarArticulo(new Libro(comentario, bolsillo, autor, editorial, anyo, nombre, existencias, precio));        
    }
    
    // Funcion para crear un objeto Manual
    static void crearManual(Libreria libreria) {
        System.out.println("Introduce el nombre del manual: ");
        String nombre = sc.nextLine();        
        
        int existencias = introducirNumero("Introduce las existencias iniciales: ");
        
        double precio = introducirNumeroDouble("Introduce el precio unitario: ");
        
        System.out.println("Introduce el nombre del autor: ");
        String autor = sc.nextLine();
        
        System.out.println("Introduce el nombre de la editorial: ");
        String editorial = sc.nextLine();
        
        int anyo = introducirNumero("Introduce el año de la agenda: ");
        
        System.out.println("Introduce la tematica del manual: ");
        String tematica = sc.nextLine();
        
        libreria.agregarArticulo(new Manual(tematica, autor, editorial, anyo, nombre, existencias, precio));  
        
    }
    
    // Funcion para borrar un articulo
    static void borrarArticulo(Libreria libreria) {
        System.out.println("Introduce el nombre del articulo que quieres borrar: ");
        String nombreArticulo = sc.nextLine();
        
        libreria.eliminarArticulo(nombreArticulo);
    }
    
    // Funcion para mostrar un articulo
    static void mostrarArticulo(Libreria libreria) {
        System.out.println("Introduce el nombre del articulo que quieres mostrar: ");
        String nombreArticulo = sc.nextLine();
        
        libreria.mostrarArticulo(nombreArticulo);
    }
    
    
    // Funcion de control para controlar que lo que entra es un numero 
    static int introducirNumero(String msg) {
        Scanner entrada = new Scanner(System.in);
        int numero = 0;        
        boolean noValido;
        do {
            System.out.println(msg);
            try {
                numero = entrada.nextInt();
                noValido = false;
            } catch (InputMismatchException ex) {
                System.err.println("Debe ser un número decimal.");
                noValido = true;
                entrada.next();
            }
        } while (noValido);

        return numero;
    }
    
    
    // Funcion de control para controlar que lo que entra es un numero double
    static double introducirNumeroDouble(String msg) {
        Scanner entrada = new Scanner(System.in);
        double numero = 0;        
        boolean noValido;
        do {
            System.out.println(msg);
            try {
                numero = entrada.nextDouble();
                noValido = false;
            } catch (InputMismatchException ex) {
                System.err.println("Debe ser un número decimal.");
                noValido = true;
                entrada.next();
            }
        } while (noValido);

        return numero;
    }
    
    // Funcion de control para controlar que lo que entra es un booleano
    static boolean elegirOpcionContinuar(String msg) {
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
