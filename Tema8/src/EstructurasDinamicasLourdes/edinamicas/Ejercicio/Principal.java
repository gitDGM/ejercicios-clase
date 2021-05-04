/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicasLourdes.edinamicas.Ejercicio;

import EstructurasDinamicasLourdes.edinamicas.*;
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
                    menuPila();
                    break;
                case 3:
                    menuCola();
                    break;
                case 4:
                    break;
                case 5:
                    menuListaOrdenada();
                    break;
                case 6:
                    menuListaOrdenadaDoble();
                    break;
                case 7:
                    menuListaCircular();
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
            System.out.println("3.- Extraer elemento (por posición)");
            System.out.println("4.- Extraer elemento (por contenido)");
            System.out.println("5.- Mostrar lista");
            System.out.println("6.- Obtener número de elementos");
            System.out.println("7.- ¿Lista vacía?");
            System.out.println("8.- Obtener elemento (por posición)");
            System.out.println("9.- Obtener elemento (por contenido)");
            System.out.println("10.- Obteer elementos (por contenido)");
            System.out.println("11.- Eliminar la lista");
            System.out.println("0.- Salir\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    lista.agregarNodo("test " + lista.obtenerTam());
                    break;
                case 2:
                    lista.agregarNodo(introducirNumero("Elige una posición: "),"test " + lista.obtenerTam());
                    break;
                case 3:
                    lista.eliminarNodo("test " + introducirNumero("Elige cuál quieres borrar:"));
                    break;
                case 4:
                    lista.eliminarNodo(introducirNumero("Elige una posición: "));
                    break;
                case 5:
                    lista.imprimirLista();
                    break;
                case 6:
                    System.out.println("Tamaño: " + lista.obtenerTam() + " elementos");
                    break;
                case 7:
                    if (lista.esVacia()) {
                        System.out.println("Está vacía.");
                    } else {
                        System.out.println("No está vacía.");  
                    }
                    break;
                case 8:
                    lista.obtenerNodo("test " + introducirNumero("Elige cuál quieres obtener: "));
                    break;
                case 9:
                    lista.obtenerNodo(introducirNumero("Elige una posición: "));
                    break;
                case 10:
                    lista.vaciarLista();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Error: Opción no válida.");
                    break;
            }
        } while (opcion != 0); 
    }
    
    static void menuPila() {
        Pila pila = new Pila();
        int opcion;        
        do {
            System.out.println("\n\nTrabajando con LISTAS");
            System.out.println("*************************\n");
            System.out.println("1.- Insertar elemento");
            System.out.println("2.- Extraer elemento");
            System.out.println("3.- Extraer elemento (Mostrar valor)");
            System.out.println("4.- Mostrar pila");
            System.out.println("5.- Obtener número de elementos");
            System.out.println("6.- ¿Pila vacía?");
            System.out.println("0.- Salir\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    pila.agregarNodo(introducirNumero("Introduce un valor: "));
                    break;
                case 2:
                    if (!pila.esVacia()) {                        
                        pila.eliminarNodo();
                    }
                    break;
                case 3:
                    if (!pila.esVacia()) {                        
                        System.out.println("Elemento extraido: " + pila.eliminarNodoConDato());
                    }
                    break;
                case 4:
                    pila.mostrarPila();
                    break;
                case 5:
                    System.out.println("Tamaño: " + pila.obtenerTam() + " elementos");
                    break;
                case 6:
                    if (pila.esVacia()) {
                        System.out.println("Está vacía.");
                    } else {
                        System.out.println("No está vacía.");  
                    }
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Error: Opción no válida.");
                    break;
            }
        } while (opcion != 0); 
    }
    
    static void menuCola() {
        Cola cola = new Cola();
        int opcion;        
        do {
            System.out.println("\n\nTrabajando con LISTAS");
            System.out.println("*************************\n");
            System.out.println("1.- Insertar elemento");
            System.out.println("2.- Extraer elemento");
            System.out.println("3.- Extraer elemento (Mostrar valor)");
            System.out.println("4.- Mostrar cola");
            System.out.println("5.- Obtener número de elementos");
            System.out.println("6.- ¿Cola vacía?");
            System.out.println("6.- Vaciar cola");
            System.out.println("0.- Salir\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    cola.agregarNodo("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 2:
                    if (!cola.esVacia()) {                        
                        cola.eliminarNodo();
                    }
                    break;
                case 3:
                    if (!cola.esVacia()) {                        
                        System.out.println("Elemento extraido: " + cola.eliminarNodoConDato());
                    }
                    break;
                case 4:
                    cola.mostrarCola();
                    break;
                case 5:
                    System.out.println("Tamaño: " + cola.obtenerTam() + " elementos");
                    break;
                case 6:
                    if (cola.esVacia()) {
                        System.out.println("Está vacía.");
                    } else {
                        System.out.println("No está vacía.");  
                    }
                    break;
                case 7:
                    cola.vaciarCola();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Error: Opción no válida.");
                    break;
            }
        } while (opcion != 0); 
    }
    
    static void menuListaOrdenada() {
        ListaOrdenada listaOrd = new ListaOrdenada();
        int opcion;        
        do {
            System.out.println("\n\nTrabajando con LISTAS");
            System.out.println("*************************\n");
            System.out.println("1.- Insertar elemento ascendente");
            System.out.println("2.- Insertar elemento descendente");
            System.out.println("3.- Eliminar elemento (por posición)");
            System.out.println("4.- Eliminar elemento (por dato)");
            System.out.println("5.- Mostrar lista");
            System.out.println("6.- Obtener número de elementos");
            System.out.println("7.- ¿Lista vacía?");
            System.out.println("8.- Vaciar lista");
            System.out.println("0.- Salir\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    listaOrd.agregarNodoAsc("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 2:
                    listaOrd.agregarNodoDesc("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 3:
                    listaOrd.eliminarNodo(introducirNumero("Introduce una posición: "));
                    break;
                case 4:
                    listaOrd.eliminarNodo("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 5:
                    listaOrd.imprimirLista();
                    break;
                case 6:
                    System.out.println("Tamaño de la lista: " + listaOrd.obtenerTam());
                    break;
                case 7:
                    if (listaOrd.esVacia()) {
                        System.out.println("Está vacía.");
                    } else {
                        System.out.println("No está vacía.");  
                    }
                    break;
                case 8:
                    listaOrd.vaciarLista();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Error: Opción no válida.");
                    break;
            }
        } while (opcion != 0); 
    }
    
    static void menuListaOrdenadaDoble() {
        ListaOrdDoble listaOrdDoble = new ListaOrdDoble();
        int opcion;        
        do {
            System.out.println("\n\nTrabajando con LISTAS");
            System.out.println("*************************\n");
            System.out.println("1.- Insertar elemento ascendente");
            System.out.println("2.- Insertar elemento descendente");
            System.out.println("3.- Eliminar elemento (por posición)");
            System.out.println("4.- Eliminar elemento (por dato)");
            System.out.println("5.- Mostrar lista");
            System.out.println("6.- Obtener número de elementos");
            System.out.println("7.- ¿Lista vacía?");
            System.out.println("8.- Modificar nodo");
            System.out.println("9.- Vaciar lista");
            System.out.println("0.- Salir\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    listaOrdDoble.agregarNodoAsc("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 2:
                    listaOrdDoble.agregarNodoDesc("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 3:
                    listaOrdDoble.eliminarNodo(introducirNumero("Introduce una posición: "));
                    break;
                case 4:
                    listaOrdDoble.eliminarNodo("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 5:
                    listaOrdDoble.imprimirLista();
                    break;
                case 6:
                    System.out.println("Tamaño de la lista: " + listaOrdDoble.obtenerTam());
                    break;
                case 7:
                    if (listaOrdDoble.esVacia()) {
                        System.out.println("Está vacía.");
                    } else {
                        System.out.println("No está vacía.");  
                    }
                    break;
                case 8:
                    listaOrdDoble.modificarNodo(introducirNumero("Introduce una posición: "), "test " + introducirNumero("Introduce un valor: "));
                    break;
                case 9:
                    listaOrdDoble.vaciarLista();
                    break;
                case 0:
                    break;
                default:
                    System.err.println("Error: Opción no válida.");
                    break;
            }
        } while (opcion != 0); 
    }
    
    static void menuListaCircular() {
        ListaCircular listaCircular = new ListaCircular();
        int opcion;        
        do {
            System.out.println("\n\nTrabajando con LISTAS");
            System.out.println("*************************\n");
            System.out.println("1.- Insertar elemento ascendente");
            System.out.println("2.- Insertar elemento descendente");
            System.out.println("3.- Eliminar elemento (por posición)");
            System.out.println("4.- Eliminar elemento (por dato)");
            System.out.println("5.- Mostrar lista");
            System.out.println("6.- Mostrar lista desde posición");
            System.out.println("7.- Obtener número de elementos");
            System.out.println("8.- ¿Lista vacía?");
            System.out.println("9.- Vaciar lista");
            System.out.println("0.- Salir\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    listaCircular.agregarNodo("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 2:
                    listaCircular.agregarNodo(introducirNumero("Introduce una posición: ") ,"test " + introducirNumero("Introduce un valor: "));
                    break;
                case 3:
                    listaCircular.eliminarNodo(introducirNumero("Introduce una posición: "));
                    break;
                case 4:
                    listaCircular.eliminarNodo("test " + introducirNumero("Introduce un valor: "));
                    break;
                case 5:                    
                    listaCircular.imprimirLista();
                    break;
                case 6:                    
                    listaCircular.imprimirLista(introducirNumero("Introduce una posición: "));
                    break;
                case 7:
                    System.out.println("Tamaño de la lista: " + listaCircular.obtenerTam());
                    break;
                case 8:
                    if (listaCircular.esVacia()) {
                        System.out.println("Está vacía.");
                    } else {
                        System.out.println("No está vacía.");  
                    }
                    break;
                case 9:
                    listaCircular.vaciarLista();
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
