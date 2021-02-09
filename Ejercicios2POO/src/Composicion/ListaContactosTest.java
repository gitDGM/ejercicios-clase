/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composicion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class ListaContactosTest {
    private static final Scanner sc = new Scanner(System.in);
    private static final ListaContactos contactos = new ListaContactos();
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Añadir contacto.");
            System.out.println("2.- Buscar si existe un contacto.");
            System.out.println("3.- Visualizar contactos.");
            System.out.println("4.- Buscar contacto y mostrar.");
            System.out.println("5.- Eliminar contacto.");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    crearContacto();
                    break;
                case 2:
                    buscarSiExisteContacto();
                    break;
                case 3:
                    visualizarContactos();
                    break;
                case 4:
                    buscarContactoMostrar();
                    break;
                case 5:
                    eliminarContacto();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }
    
    static void eliminarContacto() {
        System.out.println("Introduce el nombre del contacto:");
        String nombreContactoBuscado = sc.nextLine();
        
        contactos.removeContacto(nombreContactoBuscado);
    }
    
    static void buscarContactoMostrar() {
        
        System.out.println("Introduce el nombre del contacto:");
        String nombreContactoBuscado = sc.nextLine();
        
        contactos.mostrarContacto(nombreContactoBuscado);
    }
    
    static void visualizarContactos() {
        
        if (contactos.getCantidadContactos() > 0) {
            contactos.mostrarContactos();            
        } else {
            System.err.println("AVISO: Lista de contactos vacía.");
        }
    }
    
    static void buscarSiExisteContacto() {
        
        System.out.println("Introduce el nombre del contacto:");
        String nombreContactoBuscado = sc.nextLine();
        
        if (contactos.buscarSiExisteContacto(nombreContactoBuscado)) {
            System.out.println("El contacto que buscas existe.");
        } else {
            System.out.println("El contacto que buscas no existe.");
        }
    }
    
    static void crearContacto() {
        boolean creado;
        do {
            try {
                System.out.println("Introduce el nombre:");
                String nombre = sc.nextLine();
//                String nombre = "Diego Gomez";
                ArrayList<String> telefonos = new ArrayList();                
                do {
                    System.out.println("Introduce un número de teléfono:");
                    telefonos.add(sc.next());
//                    telefonos.add("123456789");
                } while (elegirOpcionContinuar("Quieres introducir otro número? (S/N):"));
                
                Contacto nuevoContacto = new Contacto(nombre, telefonos);
                
                contactos.addContacto(nuevoContacto);
                creado = true;  
                
            } catch (Exception e) {
                sc.nextLine();
                System.err.println(e.getMessage());
                creado = false;
                
            }            
        } while (!creado);
    } 
    
    static int introducirNumero(String msg) {
        int numero = -1;        
        boolean noValido;
        do {
            System.out.println(msg);
            try {
               numero = sc.nextInt();
               sc.nextLine();
               noValido = false;
            } catch (InputMismatchException ex) {
               System.err.println("Debe ser un número decimal.");
               noValido = true;
               sc.next();
            }
        } while (noValido);

        return numero;
     }
    
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
