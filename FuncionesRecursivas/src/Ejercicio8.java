
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
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = sc.nextInt();
        
        System.out.println("Resultado: " + sumaRecursiva(num, 1, 0.0));
    }
    
    static double sumaRecursiva(int num, int contador, double suma) {
        if (contador == num) {
            return suma + (1.0 / contador);
        } else {
            return sumaRecursiva(num, contador + 1, suma + (1.0 / contador));
        }
    }
}
