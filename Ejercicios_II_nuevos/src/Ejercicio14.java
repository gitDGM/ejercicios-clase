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
public class Ejercicio14 {
    public static void main(String[] args) {
        int num, n, menor;
        menor = 0;
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Introduce la cantidad de números: ");
        n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.println("Introduce un número: ");
            num = sc.nextInt();
            if (i == 0) {
                menor = num;
            } else if (num < menor) {                
                menor = num;
            }            
        }
        System.out.println("Número menor: " + menor);
    }
}
