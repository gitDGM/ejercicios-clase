/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        int dividendo, divisor;
        dividendo = 100;
        divisor = 4;
        
        System.out.println(dividendo + " / " + divisor + " = " + divisionRestasSucesivas(dividendo, divisor));
    }
    
    private static int divisionRestasSucesivas(int dividendo, int divisor) {
        if (dividendo < divisor) {
            return 0;
        } else {
            return 1 + divisionRestasSucesivas(dividendo - divisor, divisor);
        }
    }
}
