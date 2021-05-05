/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.EjercicioEnfermos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class HospitalPrincipal {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Agregar articulo");
            System.out.println("2.- Mostrar articulos");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    hospital.agregarEnfermo(new Enfermo(introducirNumero("Introduce le id del enfermo: "), introducirTexto("Introduce el nombre del enfermo: ")));
                    break;
                case 2:
                    articuloController.mostrar();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static String introducirTexto(String msg) {
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
