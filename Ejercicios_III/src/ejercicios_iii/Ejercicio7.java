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
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        double x1, x2;
        System.out.println("Introduce a: ");
        a = sc.nextInt();
        System.out.println("Introduce b: ");
        b = sc.nextInt();
        System.out.println("Introduce c: ");
        c = sc.nextInt();
        
        x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c )) / (2 * a);
        x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c )) / (2 * a);
        
        if (Double.isNaN(x1) && Double.isNaN(x1)) {
            System.out.println("No existen soluciones");
        } else {
            System.out.println("Primer resultado:" + x1);
            System.out.println("Segundo resultado:" + x2);
        }
        
    }
}
