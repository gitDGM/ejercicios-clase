/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.Ejercicio5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class ParkingPrincipal {
    
    public static void main(String[] args) {
        Parking parking = new Parking();
        int opcion;
        do {
            System.out.println("\n\n##########################");
            System.out.println("1.- Generar plazas");
            System.out.println("2.- Agregar vehículos");
            System.out.println("3.- Plazas disponibles");
            System.out.println("4.- Retirar vehículos");
            System.out.println("0.- Salir");
            System.out.println("##########################\n");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    parking.generarPlazas();
                    break;
                case 2:
                    parking.agregarVehiculo();
                    break;
                case 3:
                    parking.plazasDisponibles();
                    break;
                case 4:     
                    parking.plazasOcupadas();
                    parking.retirarVehiculo(introducirNumero("Introduce el ID de la plaza: "));
                    break;
                case 0:
                    break;
                default:
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
