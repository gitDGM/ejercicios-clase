/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio7 {
    public static void main(String[] args) {
        int num, contador;
        contador = 0;
        Scanner sc = new Scanner(System.in);
        
        do {          
            System.out.println("Introducir un número negativo cierra el programa.");
            System.out.println("Introduce un número positivo: ");
            num = sc.nextInt();  
            if (num >= 0) {
                contador++;
            }            
        } while (num >= 0);
        System.out.println("Has introducido " + contador + " números.");
    }
}
