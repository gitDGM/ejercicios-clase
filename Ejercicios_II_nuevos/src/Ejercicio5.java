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
public class Ejercicio5 {
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("Introduce un número mayor que 100: ");
            num = sc.nextInt();
            
        } while (num >= 100);
        System.out.println("Se cerró el programa.");
    }
}
