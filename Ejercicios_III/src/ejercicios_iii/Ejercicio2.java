/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios_iii;

import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sumaEdad, edad, contadorTotal, contadorMayores, contadorJubilados;
        double mediaEdad;
        
        contadorTotal = 0;
        contadorMayores = 0;
        contadorJubilados = 0;
        sumaEdad = 0;
        
        do {
            System.out.println("Introduce una edad: ");
            edad = sc.nextInt();
            
            if (edad >= 0) {
                contadorTotal++;
                sumaEdad += edad;
                if (edad >= 18) {
                    contadorMayores++;
                    if (edad > 64) {
                        contadorJubilados++;
                    }
                }
            }
        } while (edad >= 0);
        mediaEdad = sumaEdad / (double)contadorTotal;
        
        System.out.println("Suma total de las edades: " + sumaEdad);
        System.out.println("Media de edad: " + mediaEdad);
        System.out.println("Contador de personas: " + contadorTotal);
        System.out.println("Contador de personas mayor de edad: " + contadorMayores);
        System.out.println("Contador de personas jubiladas: " + contadorJubilados);
    }
}
