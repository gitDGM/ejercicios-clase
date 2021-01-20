
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
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número: ");
        int num = sc.nextInt();
        int cifras = String.valueOf(num).length();
        System.out.println(invertirNumero(num, cifras - 1));
    }
    
    private static int invertirNumero(int num, int cifras) {
        if (num < 10) {
            return num;
        } else {
            return ((num % 10) * (int)Math.pow(10, cifras) + invertirNumero(num / 10, cifras - 1));
        }
    }
}
