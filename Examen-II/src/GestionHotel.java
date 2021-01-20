
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class GestionHotel {
    final static int N_PLANTAS = 3;
    final static int N_HABITACIONES_POR_PLANTA = 5;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        String[][] hotel = new String[N_PLANTAS][N_HABITACIONES_POR_PLANTA];
        
        do {
            opcion = 99;
            System.out.println("\tHotel VenancioB\'s Palace");
            System.out.println("======================================");
            System.out.println("1: Listado de habitaciones");
            System.out.println("2: Añadir un cliente");
            System.out.println("3: Mostrar las habitaciones vacías");
            System.out.println("4: Borrar un cliente de una habitación");
            System.out.println("5: Encontrar el cliente de una habitación");
            System.out.println("6: Encontrar la habitación de un cliente");
            System.out.println("0: Salir\n");
            System.out.println("Elija la opción: ");
            opcion = introducirOpcion();

            switch(opcion) {
                case 1: 
                    verHabitaciones(hotel);
                    break;
                case 2: 
                    hotel = nuevoCliente(hotel);
                    break;
                case 3: 
                    mostrarHabitacionesVacias(hotel);
                    break;
                case 4: 
                    hotel = borrarCiente(hotel);
                    break;
                case 5: 
                    buscarClienteDeUnaHabitacion(hotel);
                    break;
                case 6: 
                    buscarHabitacionDeUnCliente(hotel);
                    break;
                case 0: 
                    System.out.println("Finalizó la ejecución del programa...");
                    break;
                default:
                    System.err.println("Introduce una opción válida.");
                    break;
            }
        } while (opcion != 0);
    }
    
    static void verHabitaciones(String[][] hotel) {
        System.out.println("\n\tListado de habitaciones");
        System.out.println("======================================");
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (hotel[i][j] == null) {
                    System.out.print("\"libre\"\t");
                } else {
                    System.out.print(hotel[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
    
    static String[][] nuevoCliente(String[][] hotel) {
        System.out.println("\n\tAñadir nuevo cliente");
        System.out.println("======================================");
        System.out.println("Introduce el nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        
        hotel = addCliente(hotel, nombreCliente);
        
        return hotel;
    }
    
    static String[][] addCliente(String[][] hotel, String nombreCliente) {        
        boolean added = false;
        for (int i = 0; i < hotel.length && !added; i++) {
            for (int j = 0; j < hotel[i].length && !added; j++) {
                if (hotel[i][j] == null) {
                    hotel[i][j] = nombreCliente;
                    added = !added;
                } 
            }
        }
        
        if (!added) {
            System.out.println("¡No hay habitaciones disponibles!");
        } else {
            System.out.println("Cliente añadido con éxito.");
        }
        
        return hotel;
    }   
    
    static void mostrarHabitacionesVacias(String[][] hotel) {
        System.out.println("\n\tListado de habitaciones vacías");
        System.out.println("======================================");
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (hotel[i][j] == null) {
                    System.out.println("Planta: " + (i + 1) + "\tHabitación: " + (j + 1));
                }
            }
        }
    }
    
    static String[][] borrarCiente(String[][] hotel) {        
        System.out.println("\nBorrar cliente");
        System.out.println("======================================");
        System.out.println("Introduce el nombre del cliente: ");
        String nombreCliente = sc.nextLine();
        
        hotel = buscarClienteParaBorrar(hotel, nombreCliente);    
        
        return hotel;
    }
    
    static String[][] buscarClienteParaBorrar(String[][] hotel, String nombreCliente) {
        boolean existe = false;
        int planta = 0;
        
        for (int i = 0; i < hotel.length && !existe; i++) {
            for (int j = 0; j < hotel[i].length && !existe; j++) {
                if (hotel[i][j] != null) {
                    if (hotel[i][j].equals(nombreCliente)) {
                        hotel[i][j] = null;
                        planta = i;
                        existe = true;
                    }
                }                
            }
        }
        
        if (existe) {
            if (planta != 0) {
                System.out.println("El cliente debe abonar 40€");
            } else {
                System.out.println("El cliente debe abonar 30€");
            }
        } else {
            System.out.println("No se ha encontrado el cliente que buscas.");
        }
        return hotel;
    }
    
    static void buscarClienteDeUnaHabitacion(String[][] hotel) {
        int planta, habitacion;
        System.out.println("\n\tBuscar cliente de una habitación");
        System.out.println("===========================================");
        do {                        
            System.out.println("Introduce la planta (1 - 3): ");
            planta = Integer.parseInt(sc.nextLine());
            if (planta <= 0 || planta > 3) {
                System.err.println("ERROR: Introduce una planta válida.");
            }
        } while (planta <= 0 || planta > 3);        
        do {                        
            System.out.println("Introduce la habitación (1 - 5): ");
            habitacion = Integer.parseInt(sc.nextLine());
            if (habitacion <= 0 || habitacion > 5) {
                System.err.println("ERROR: Introduce una habitacion válida.");
            }
        } while (habitacion <= 0 || habitacion > 5);
        
        buscarClienteDeUnaHabitacion(planta, habitacion, hotel);
    }
    
    static void buscarClienteDeUnaHabitacion(int planta, int habitacion, String[][] hotel) {
        if (hotel[planta - 1][habitacion - 1] != null) {
            System.out.println("Cliente actual: " + hotel[planta - 1][habitacion - 1]);
        } else {
            System.out.println("Planta: " + planta + "\tHabitación: " + habitacion + "\t Estado: \"libre\"");
        }
    }
    
    static void buscarHabitacionDeUnCliente(String[][] hotel) {
        System.out.println("\n\tBuscar habitación de un cliente");
        System.out.println("===========================================");       
        System.out.println("Introduce el nombre del cliente");
        String nombreCliente = sc.nextLine();
        buscarHabitacionDeUnCliente(hotel, nombreCliente);
        
    }
    
    static void buscarHabitacionDeUnCliente(String[][] hotel, String nombreCliente) { 
        boolean existe = false;
        int planta = 0;
        int habitacion = 0;
        
        for (int i = 0; i < hotel.length && !existe; i++) {
            for (int j = 0; j < hotel[i].length && !existe; j++) {
                if (hotel[i][j] != null) {
                    if (hotel[i][j].equals(nombreCliente)) {
                        existe = true;
                        planta = i + 1;
                        habitacion = j + 1;
                    }
                }
            }
        }
        
        if (existe) {
            System.out.println("Planta: " + planta + "\tHabitación: " + habitacion);
        } else {
            System.out.println("No se encuentra el cliente que has introducido");
        }
    }
    
    static int introducirOpcion() throws InputMismatchException {
        int opcion = 99;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
            //System.err.println("ERROR: No puedes introducir algo que no sea un numero.");
        }
        
        return opcion;
    }
}
