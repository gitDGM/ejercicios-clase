/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        int num = 20000;
        
        System.out.println(convertirToBinario(num, ""));
    }
    
    static String convertirToBinario(int num, String result) {
        if (num < 2) {
            result = num + result;
            return result;
        } else {
            result = (num % 2) + result;            
            return convertirToBinario(num / 2, result);
        }
    }
}
