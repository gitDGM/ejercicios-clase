
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
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = sc.nextInt();
        
        System.out.println("Resultado: " + sumaRecursiva(num, 1, 0));
    }
    
    static int sumaRecursiva(int num, int contador, int suma) {
        if (contador == num) {
            return suma + contador;
        } else {
            return sumaRecursiva(num, contador + 1, suma + contador);
        }
    }
}
