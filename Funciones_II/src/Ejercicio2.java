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
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num1 = sc.nextInt();
        
        System.out.println("Introduce otro número: ");
        int num2 = sc.nextInt();
        
        if (comprobarNumerosAmigos(num1, num2)) {
            System.out.println("Son números amigos.");
        } else {            
            System.out.println("No son números amigos.");
        }
    }
    
    static boolean comprobarNumerosAmigos(int num1, int num2) {
        int sumNum1, sumNum2;
        boolean result;
        sumNum1 = 0;
        sumNum2 = 0;
        
        for(int i = 1; i < num1; i++) {
            if (num1 % i == 0) {
                sumNum1 += i;
            }           
        }
        for(int i = 1; i < num2; i++) {
            if (num2 % i == 0) {
                sumNum2 += i;
            }           
        }
        
        result = sumNum1 == num2 && sumNum2 == num1;        
        
        return result;
    }
}
