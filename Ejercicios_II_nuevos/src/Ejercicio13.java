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
public class Ejercicio13 {
    public static void main(String[] args) {
        int num1, num2, control;
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Introduce un número: ");
        num1 = sc.nextInt();
        System.out.println("Introduce otro número: ");
        num2 = sc.nextInt();
        
        if (num1 > num2) {
            control = num1;
            num1 = num2;
            num2 = control;
        }
        for (int i = num1; i <= num2; i++) {
            System.out.println(i);
        }
        
    }
}
