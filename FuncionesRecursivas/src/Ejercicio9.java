/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio9 {
    public static void main(String[] args) {
        int num = 20;
        
        System.out.println(sumaRecursiva(num, 1, 0.0));
    }
    
    static double sumaRecursiva(int num, int contador, double suma) {
        if (contador == num) {
            return suma + (1.0 / factorial(contador, 1, 1));
        } else {
            return sumaRecursiva(num, contador + 1, suma + (1.0 / factorial(contador, 1, 1)));
        }
    }
    
    static int factorial(int num, int contador, int resultado) {        
        if (num == contador) {
            return resultado * contador;
        } else {
            return factorial(num, contador + 1, resultado * contador);
        }
    }
}
