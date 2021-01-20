

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
public class Ejercicio2 {
    public static void main(String[] args) {
        int num1, num2, result;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        num1 = sc.nextInt();
        System.out.println("Introduce otro número: ");
        num2 = sc.nextInt();
        result = 0;
        for (int i = 0; i < num2; i++) {
            result += num1;
        }
        System.out.println(num1 + " * " + num2 + " = " + result);
    }
}
