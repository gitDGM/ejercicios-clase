/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class CuentaBancariaMain {
    private static ArrayList<CuentaBancaria> cuentas = new ArrayList();
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Crear cuenta bancaria");
            System.out.println("2.- Mostrar cuentas");   
            System.out.println("3.- Gestionar cuentas"); 
            System.out.println("4.- Calcular intereses");          
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    crearCuentaBancaria();
                    break;
                case 2:
                    mostrarCuentas();
                    break;
                case 3:
                    menuGestionCuentas(elegirCuenta());
                    break;
                case 4:
                    calcularInteresesCuenta(elegirCuenta());
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    /// INICIO CALCULAR INTERESES
    static void calcularInteresesCuenta(int indexCuenta) {
        CuentaBancaria cuenta = cuentas.get(indexCuenta - 1);
        
        cuenta.calcularIntereses();
        cuenta.mostrar();
    }
    /// FIN CALCULAR INTERESES
    
    /// INICIO GESTIONAR CUENTAS (INGRESOS, RETIRADAS Y TRANSFERENCIAS)    
    static void menuGestionCuentas(int indexCuenta) {
        if (indexCuenta != 0) {
            int opcion;
            do {
                System.out.println("##########################");
                System.out.println("1.- Ingresar");   
                System.out.println("2.- Retirar");   
                System.out.println("3.- Transferencia");                 
                System.out.println("0.- Salir");
                System.out.println("##########################");
                opcion = introducirNumero("Elige una opción:");
                switch (opcion) {
                    case 1:
                        ingresar(indexCuenta);
                        break;
                    case 2:
                        retirar(indexCuenta);
                        break;
                    case 3:
                        trasferencia(indexCuenta);
                        break;
                    case 0:
                        break;
                    default:
                        break;
                }
            } while (opcion != 0);
        }         
    }
    
    static void ingresar(int indexCuenta) {
        CuentaBancaria cuentaGestionada = cuentas.get(indexCuenta - 1);
        double cantidad = introducirNumeroDouble("Introduce la cantidad a ingresar:");
        cuentaGestionada.ingresar(cantidad);
    }
    
    static void retirar(int indexCuenta) {
        CuentaBancaria cuentaGestionada = cuentas.get(indexCuenta - 1);
        double cantidad = introducirNumeroDouble("Introduce la cantidad a retirar:");
        cuentaGestionada.retirar(cantidad);
    }
    
    static void trasferencia(int indexCuenta) {
        CuentaBancaria cuentaGestionada = cuentas.get(indexCuenta - 1);
        int indexCuentaAjena = elegirCuenta();
        if (indexCuentaAjena != 0) {
            double cantidad = introducirNumeroDouble("Introduce la cantidad a retirar:");
            CuentaBancaria cuentaAjena = cuentas.get(indexCuentaAjena - 1);
            cuentaGestionada.traspasar(cuentaAjena, cantidad);
        }
    }
    /// FIN GESTIONAR CUENTAS
    
    /// MOSTRAR CUENTAS
    static void mostrarCuentas() {
        for (CuentaBancaria cuenta : cuentas) {
            cuenta.mostrar();
        }
    }    
    ///
    
    /// INICIO CREAR CUENTA
    static void crearCuentaBancaria() {
        int opcion;
        do {
            System.out.println("###### CREAR CUENTA ######");
            System.out.println("1.- Cuenta corriente");
            System.out.println("2.- Cuenta ahorro");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    crearCuentaCorriente();
                    break;
                case 2:
                    crearCuentaAhorro();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }
    
    static void crearCuentaCorriente() {
        System.out.println("Introduce el IBAN: ");
        String iban = generarIBAN();        
        System.out.println("Introduce el saldo: ");
        double saldo = Math.floor(Math.random() * 1000000) / 100;
        
        cuentas.add(new CuentaCorriente(iban, saldo));
        System.out.println("Cuenta creada con éxito.\n");
    }
    
    static void crearCuentaAhorro() {
        System.out.println("Introduce el IBAN: ");
        String iban = generarIBAN();        
        System.out.println("Introduce el saldo: ");
        double saldo = Math.random() * 10000;
        
        cuentas.add(new CuentaAhorro(iban, saldo));
        System.out.println("Cuenta creada con éxito.\n");
        
    }
    
    static String generarIBAN() {
        String iban = "ES";
        for (int i = 0; i < 20; i++) {
            iban += (int)(Math.random() * 10);
        }
        
        return iban;
    }
    /// FIN CREAR CUENTA
    
    
    /// GENERALES
    static int elegirCuenta() {
        int contador = 1;
        System.out.println("##########################");
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println(contador + ".- " + cuenta.getIban());
            contador++;
        }     
        System.out.println("0.- Salir");
        System.out.println("##########################");
        return introducirNumero("Elige una cuenta:");
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
    
    static double introducirNumeroDouble(String msg) {
         double numero = 0;        
         boolean noValido;
         do {
             System.out.println(msg);
             try {
                 numero = sc.nextDouble();
                 noValido = false;
             } catch (InputMismatchException ex) {
                 System.err.println("Debe ser un número decimal.");
                 noValido = true;
                 sc.next();
             }
         } while (noValido);

         return numero;
     }
    ///
}
