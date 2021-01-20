
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");            
        int num;
        do {
            num = sc.nextInt();
            System.out.println("El número en la posición " + num + " es: " + fibonnaci(num));
        } while (num < 0);
    }
    
    static int fibonnaci(int num) {
        int n = 0;
        int n1, n2;
        n1 = 1;
        n2 = 1;
        
        if (num == 0) {
            n = num;
        } else if (num == 1){
            n = num;
        } else {
            for (int i = 3; i <= num; i++) {
                n = n1 + n2;
                n2 = n1;
                n1 = n; 
            }
        }
        
        return n;
    }
}
