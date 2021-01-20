
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
public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un número para convertirlo a binario: ");
        int num = sc.nextInt();
        convertirToBinario(num);
        
    }
    
    static void convertirToBinario(int num) {
        String result = "";
        double tempNum = num;
        int contador = 0;
        while (tempNum % (Math.pow(2, contador)) != tempNum) {
            contador++;            
        }
        for (int i = contador; i > 0; i-- ) {
            if (tempNum % (Math.pow(2, i)) >= (Math.pow(2, i - 1))) {
                tempNum = tempNum % (Math.pow(2, i));
                result += 1;
            } else {
                result += 0;
            }
        }
        
        System.out.println("Binario: " + result);
    }
}
