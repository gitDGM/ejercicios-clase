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
public class Ejercicio8 {
    public static void main(String[] args) {
        int num1, num2;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("Introduce un número: ");
            num1 = sc.nextInt(); 
            System.out.println("Introduce otro número: ");
            num2 = sc.nextInt(); 
        } while (num1 != num2 && num1 != 0 && num2 != 0);
    }
}
