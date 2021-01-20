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
public class Ejercicio10 {
    public static void main(String[] args) {
        char caracter;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce una letra: ");
        caracter = Character.toLowerCase(sc.next().charAt(0));
        if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' ||caracter == 'u') {
            System.out.println("VOCAL");
        } else {
            System.out.println("CONSONANTE");            
        }
    }
}
