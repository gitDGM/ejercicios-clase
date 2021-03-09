/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio13;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio13 {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Nuevo contacto");
            System.out.println("2.- Buscar por nombre");
            System.out.println("3.- mostrar todos");
            System.out.println("4.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    nuevoContacto(agenda);
                    break;
                case 2:
                    buscarContactoPorNombre(agenda);
                    break;
                case 3:
                    agenda.mostrarContactos();
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static void nuevoContacto(Agenda agenda) {
        System.out.println("Introduce el nombre del contacto:");
        String nombre = sc.nextLine();
        System.out.println("Introduce el número de teléfono: ");
        String numero = sc.nextLine();
        
        agenda.addContacto(nombre, numero);        
    }
    
    static void buscarContactoPorNombre(Agenda agenda) {
        System.out.println("Introduce el nombre del contacto:");
        String nombre = sc.nextLine();
        
        agenda.mostrarContactosCadena(nombre);    
    }
    
    static int introducirNumero(String msg) {
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
