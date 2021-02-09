/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import Ejercicio1.Punto;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Rectangulo2Test {
    public static Scanner sc = new Scanner(System.in);
    public static Rectangulo2 r2;
    public static Punto p1, p2;
    public static void main(String[] args) {
        int opcion, x, y;
        do {
            System.out.println("####################################");
            System.out.println("1.\tCrear P1.");
            System.out.println("2.\tCrear P2.");
            System.out.println("3.\tCrear rectángulo.");
            System.out.println("4.\tActualizar P1.");
            System.out.println("5.\tActualizar P2.");
            System.out.println("6.\tArea.");
            System.out.println("7.\tPerímetro");
            System.out.println("8.\tMostrar datos");
            System.out.println("9.\tGenerarlo Aleatorio.");
            System.out.println("10.\tActualizar X1");
            System.out.println("11.\tActualizar X2");
            System.out.println("12.\tActualizar Y1");
            System.out.println("13.\tActualizar Y2");
            System.out.println("0. Salir");
            System.out.println("####################################");            
            opcion = introducirNumero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    x = introducirNumero("Introduce el valor de X en P1:");
                    y = introducirNumero("Introduce el valor de Y en P1:");
                    p1 = new Punto(x, y);
                    break;
                case 2:
                    x = introducirNumero("Introduce el valor de X en P2:");
                    y = introducirNumero("Introduce el valor de Y en P2:");
                    p2 = new Punto(x, y);
                    break;
                case 3:
                    try {
                        r2 = new Rectangulo2(p1, p2);                        
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    x = introducirNumero("Introduce el valor de X en P1:");
                    y = introducirNumero("Introduce el valor de Y en P1:");
                    r2.setP1(new Punto(x, y));
                    break;
                case 5:
                    x = introducirNumero("Introduce el valor de X en P2:");
                    y = introducirNumero("Introduce el valor de Y en P2:");
                    r2.setP2(new Punto(x, y));
                    break;
                case 6:
                    System.out.println(r2.getArea());
                    break;
                case 7:
                    System.out.println(r2.getPerimetro());
                    break;
                case 8:
                    r2.imprimir();
                    break;
                case 9:
                    r2 = Rectangulo2.crearRectanguloAleatorio();
                    break;
                case 10:
                    x = introducirNumero("Introduce el valor de X1:");
                    r2.setX1(x);
                    break;
                case 11:
                    x = introducirNumero("Introduce el valor de X2:");
                    r2.setX2(x);
                    break;
                case 12:
                    y = introducirNumero("Introduce el valor de Y1:");
                    r2.setY1(y);
                    break;
                case 13:
                    y = introducirNumero("Introduce el valor de Y2:");
                    r2.setY2(y);
                    break;
                case 0:
                    System.out.println("Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción inválida"); 
                    break;
            }
        } while (opcion != 0);
    }
    
    static int introducirNumero(String msg) {
         int numero = -1;        
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
