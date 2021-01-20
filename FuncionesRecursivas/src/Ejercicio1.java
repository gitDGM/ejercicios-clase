
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = sc.nextInt();
        
        System.out.println(num + "! = " +factorial(num, 1, 1));
    }
    
    static int factorial(int num, int contador, int resultado) {        
        if (num == contador) {
            return resultado * contador;
        } else {
            return factorial(num, contador + 1, resultado * contador);
        }
    }
}
