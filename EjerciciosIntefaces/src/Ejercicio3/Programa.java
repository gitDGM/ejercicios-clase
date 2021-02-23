/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Programa {
    private final static Scanner sc = new Scanner(System.in);
    private final static ArrayList<Vehiculo> vehiculos = new ArrayList();
    
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Crear vehiculo");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    crearVehiculo();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static void crearVehiculo() {      
        System.out.println("##########################");
        System.out.println("1.- Terrestre");
        System.out.println("2.- Aereo");
        System.out.println("3.- Acuatico");
        System.out.println("0.- Salir");
        System.out.println("##########################");
        int opcion = introducirNumero("Elige una opción:"); 
        switch (opcion) {
            case 1:
                crearVehiculoTerrestre();
                break;
            case 2:
                crearVehiculoAereo();
                break;
            case 3:
                crearVehiculoAcuatico();
                break;   
            case 0:
                break;
            default:
                System.err.println("ERROR: Fuera de rango");                
                break;
        }   
    }
    
    static void crearVehiculoTerrestre() {      
        System.out.println("##########################");
        System.out.println("1.- Coche");
        System.out.println("2.- Moto");
        System.out.println("3.- Generico");
        System.out.println("0.- Salir");
        System.out.println("##########################");
        int opcion = introducirNumero("Elige una opción:"); 
        switch (opcion) {
            case 1:
                crearCoche();
                break;
            case 2:
                crearMoto();
                break; 
            case 3:
                crearTerrestreGenerico();
                break; 
            case 0:
                break;
            default:
                System.err.println("ERROR: Fuera de rango");                
                break;         
        }  
    }
    
    static void crearVehiculoAereo() {
        System.out.println("##########################");
        System.out.println("1.- Coche");
        System.out.println("2.- Moto");
        System.out.println("3.- Generico");
        System.out.println("0.- Salir");
        System.out.println("##########################");
        int opcion = introducirNumero("Elige una opción:"); 
        switch (opcion) {
            case 1:
                crearAvion();
                break;
            case 2:
                crearHelicoptero();
                break; 
            case 3:
                crearAereoGenerico();
                break; 
            case 0:
                break;
            default:
                System.err.println("ERROR: Fuera de rango");                
                break;          
        }
    }
    
    static void crearVehiculoAcuatico() {
        System.out.println("##########################");
        System.out.println("1.- Barco");
        System.out.println("2.- Submarino");
        System.out.println("3.- Generico");
        System.out.println("0.- Salir");
        System.out.println("##########################");
        int opcion = introducirNumero("Elige una opción:"); 
        switch (opcion) {
            case 1:
                crearBarco();
                break;
            case 2:
                crearSubmarino();
                break; 
            case 3:
                crearAcuaticoGenerico();
                break; 
            case 0:
                break;
            default:
                System.err.println("ERROR: Fuera de rango");                
                break;         
        }   
    }
    
    static void crearCoche() {
        System.out.println("Introduce la matricula: ");
        String matricula = "1234AAA";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        boolean aireAcondicionado = elegirOpcionContinuar("Tiene aire acondicionado? (S/N):");
        
        vehiculos.add(new Coche(aireAcondicionado, matricula, modelo));
    }
    
    static void crearMoto() {
        System.out.println("Introduce la matricula: ");
        String matricula = "1234AAA";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        System.out.println("Introduce el color: ");
        String color = "rojo";
        
        vehiculos.add(new Moto(color, matricula, modelo));
    }    
    
    static void crearAvion() {
        System.out.println("Introduce la matricula: ");
        String matricula = "AAAA123456";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        System.out.println("Introduce el numero de asientos: ");
        int numAsientos = 4;
        System.out.println("Introduce las horas de vuelo: ");
        int tiempoVuelo = 5;
        
        vehiculos.add(new Avion(tiempoVuelo, numAsientos, matricula, modelo));
    }
    
    static void crearHelicoptero() {
        System.out.println("Introduce la matricula: ");
        String matricula = "AAAA123456";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        System.out.println("Introduce el numero de asientos: ");
        int numAsientos = 4;
        System.out.println("Introduce el numero de helices: ");
        int numHelices = 5;
        
        vehiculos.add(new Helicoptero(numHelices, numAsientos, matricula, modelo));
    }    
    
    static void crearBarco() {
        System.out.println("Introduce la matricula: ");
        String matricula = "AAA";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        System.out.println("Introduce la eslora: ");
        double eslora = 4;
        boolean motor = elegirOpcionContinuar("Tiene aire acondicionado? (S/N):");
        
        vehiculos.add(new Barco(motor, matricula, modelo, eslora));
    }
    
    static void crearSubmarino() {
        System.out.println("Introduce la matricula: ");
        String matricula = "AAAAAAA";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        System.out.println("Introduce la eslora: ");
        double eslora = 4;
        System.out.println("Introduce la profundidad maxima: ");
        double profundidadMaxima = 15;
        
        vehiculos.add(new Submarino(profundidadMaxima, matricula, modelo, eslora));        
    }
    
    static void crearTerrestreGenerico() {
        System.out.println("Introduce la matricula: ");
        String matricula = "1234AAA";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        System.out.println("Introduce el numero de ruedas: ");
        int numRuedas = 3;
        
        vehiculos.add(new VehiculoTerrestre(matricula, modelo, numRuedas));
    } 
    
    static void crearAereoGenerico() {
        System.out.println("Introduce la matricula: ");
        String matricula = "AAAA123456";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        System.out.println("Introduce el numero de asientos: ");
        int numAsientos = 4;
        
        vehiculos.add(new VehiculoAereo(numAsientos, matricula, modelo));        
    } 
    
    static void crearAcuaticoGenerico() {
        System.out.println("Introduce la matricula: ");
        String matricula = "AAAAAAA";
        System.out.println("Introduce el modelo: ");
        String modelo = "test";
        System.out.println("Introduce la eslora: ");
        double eslora = 4;        
        
        vehiculos.add(new VehiculoAcuatico(matricula, modelo, eslora));
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
