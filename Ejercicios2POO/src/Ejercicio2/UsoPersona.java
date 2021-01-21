/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class UsoPersona {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        Persona[] personas = new Persona[2];
        
        for (int i = 0; i < personas.length; i++) {
            boolean creado = false;
                System.out.println("Introduce nombre: ");
                String nombre = sc.next();
                System.out.println("Introduce apellidos: ");
                String apellidos = sc.next();
                int edad = introducirNumero("Introduce edad: "); 
            do {
                System.out.println("Introduce DNI: ");
                String dni = sc.next();
                try {
                    personas[i] = new Persona(dni, nombre, apellidos, edad);
                    creado = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }                    
            } while (!creado);
        }
        
        personas[0].imprime();
        if (personas[0].esMayorEdad()) {
            System.out.println(personas[0].getNombre() + " es mayor de edad");
        } else {            
            System.out.println(personas[0].getNombre() + " no es mayor de edad");
        }
        personas[1].imprime();
        if (personas[1].esJubilado()) {
            System.out.println(personas[1].getNombre() + " está jubilado/a.");
        } else {            
            System.out.println(personas[1].getNombre() + " no está jubilado/a");
        }
        
        System.out.println("La diferencia de edades es: " + personas[0].diferenciaEdad(personas[1]));
        
        System.out.println(Persona.validarDNI("15862394H"));
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
