/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio13;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio13 {
    
    private static final Aula aula = new Aula();
    private static final int CANTIDAD_ASIGNATURAS = 5;
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("##########################");
            System.out.println("1.- Añadir alumno");
            System.out.println("0.- Salir");
            System.out.println("##########################");
            opcion = introducirNumero("Elige una opción:");
            switch(opcion) {
                case 1:
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);       
    }
    
    static void addAlumno() {
        int idMatricula = introducirNumero("Introduce el número de matrícula:");
        String nombre = introducirTexto("Introduce el nombre del alumno:");
        String apellidos = introducirTexto("Introduce los apellidos del alumno:");
        double[] notas = new double[CANTIDAD_ASIGNATURAS];
        for (int i = 0; i < CANTIDAD_ASIGNATURAS; i++) {
            notas[i] = (introducirNumeroDouble("Introduce la nota de la asignatura " + (i + 1) + ": "));
        }
        aula.addAlumno(new Alumno(idMatricula, nombre, apellidos, notas));
    }
    
    static boolean elegirOpcionContinuar(String msg) {        
        Scanner sc = new Scanner(System.in);
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
    
    static double introducirNumeroDouble(String msg) {
        Scanner sc = new Scanner(System.in);
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
    
    static String introducirTexto(String msg) {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
