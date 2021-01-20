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
public class Ejercicio6 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Introduce un número: ");
        num = sc.nextInt();
        
        for (int i = 1; i < (num/2); i++ ) {
            if (num % i == 0) {
                System.out.println(i);
            }
        }
    }
}
