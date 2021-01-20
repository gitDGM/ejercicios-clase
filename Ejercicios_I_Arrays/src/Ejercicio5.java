/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio5 {
    public static void main(String[] args) {
        int[] elementos = new int[25];
        int nPositivos = 0;
        int nNegativos = 0;
        int nCeros = 0;
        
        boolean positivo;
        for (int i = 0; i < elementos.length; i++) {
            positivo = Math.random() >= 0.5;
            if (positivo) {
                elementos[i] = (int)(Math.random()*100);
            } else {
                elementos[i] = (int)(Math.random()*100) * (-1);
            }
        }
        
        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] > 0) {
                nPositivos++;
            } else if (elementos[i] < 0) {
                nNegativos++;
            } else {
                nCeros++;
            }
            System.out.println(elementos[i]);
        }
        
        System.out.println("--------------------------------");
        System.out.println("Cantidad de positivos: " + nPositivos);
        System.out.println("Cantidad de negativos: " + nNegativos);
        System.out.println("Cantidad de ceros: " + nCeros);
        System.out.println("--------------------------------");
    }
}
