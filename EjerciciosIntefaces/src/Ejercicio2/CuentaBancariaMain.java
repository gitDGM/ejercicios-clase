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
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción");
            switch(opcion) {
                case 1:
                    crearCuentaBancaria();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static void crearCuentaBancaria() {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Cuenta corriente");
            System.out.println("1.- Cuenta ahorro");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción");
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
        double saldo = Math.random() * 10000;
        
        cuentas.add(new CuentaCorriente(iban, saldo));
    }
    
    static void crearCuentaAhorro() {
        System.out.println("Introduce el IBAN: ");
        String iban = generarIBAN();        
        System.out.println("Introduce el saldo: ");
        double saldo = Math.random() * 10000;
        
        cuentas.add(new CuentaAhorro(iban, saldo));
        
    }
    
    static String generarIBAN() {
        String iban = "ES";
        for (int i = 0; i < 20; i++) {
            iban += (int)(Math.random() * 10);
        }
        
        return iban;
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
