/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        int serie = 10;
        System.out.println("Serie de  " + serie + " primeros números.");
        
        for (int i = 1; i < serie; i++) {
            System.out.println(fibonacci(i));
        }
    }
    
    private static int fibonacci(int num) {
        if (num == 0){
            return 0;
        } else if ( num == 1) {
            return 1;
        } else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }
}
