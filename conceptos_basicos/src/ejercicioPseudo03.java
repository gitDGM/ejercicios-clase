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
public class ejercicioPseudo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letra;
        
        System.out.print("Introduce una letra: ");
        letra = sc.next().charAt(0);
        if (letra != Character.toUpperCase(letra)) {
            System.out.println("\nHas introducido una minúscula.");
        } else {
            System.out.println("\nHas introducido una mayúscula.");            
        }
    }
}
