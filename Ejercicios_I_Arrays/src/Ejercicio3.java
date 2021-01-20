/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio3 {
    public static void main(String[] args) {
        int[] arrEjer3 = new int[10];
        
        for (int i = 0; i < arrEjer3.length; i++) {
            int aleatorio = (int)(Math.random() * 100 + 1);
            System.out.println(aleatorio);
            arrEjer3[i] = aleatorio;
        }
        
        int suma = 0;
        for (int i : arrEjer3) {
            suma += i;
        }
        
        double media = suma / (double)arrEjer3.length;
        
        System.out.println("Suma " + suma);
        System.out.println("Media " + media);
        
    }
}
