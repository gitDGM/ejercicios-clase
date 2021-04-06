/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio14;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio14 {
    private static final PrincipalController principalController = new PrincipalController();
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Alta locomotora");
            System.out.println("2.- Baja locomotora");
            System.out.println("3.- Mostrar locomotora");
            System.out.println("4.- Alta vagón");
            System.out.println("5.- Baja vagón");
            System.out.println("6.- Mostrar vagones");            
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    principalController.altaLocomotora(new Locomotora(introducirNumero("Introduce el ID de la nueva locomotora: ")));
                    break;
                case 2:
                    principalController.bajaLocomotora(introducirNumero("Introduce el ID de la locomotora que quieres dar de baja: "));
                    break;
                case 3:
                    principalController.mostrarLocomotoras();
                    break;
                case 4:
                    principalController.altaVagon(new Vagon(introducirNumero("Introduce el ID del nuevo vagón: ")));
                    break;
                case 5:
                    principalController.bajaVagon(introducirNumero("Introduce el ID del vagón que quieres dar de baja: "));
                    break;
                case 6:
                    principalController.mostrarVagones();
                    break;
                case 0:
                    principalController.guardarDatosEnFicheros();
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static String introducirTexto(String msg) {
        Scanner sc = new Scanner(System.in);
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
