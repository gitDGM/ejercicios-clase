/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio6;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author alumno
 */
public class Ejercicio6 {
    private static final Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        LibroFirmas libroFirmas = new LibroFirmas();
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Insertar firma");
            System.out.println("2.- Mostrar libro de firmas");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    insertarFirma(libroFirmas);
                    break;
                case 2:
                    libroFirmas.mostrar();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static void insertarFirma(LibroFirmas libroFirmas) {
        System.out.println("Introduce el nombre de la firma:");
        String nombre = sc.nextLine();
        if (!nombre.equals("")) {
            libroFirmas.addFirma(nombre);            
        } else {
            System.err.println("ATENCIÓN: No puedes añadir una firma vacía.");
        }
    }
    
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
}
