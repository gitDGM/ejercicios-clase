/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio1_nuevo {
    public static void main(String[] args) {
        int dado1 = (int)(Math.random() * 1000 + 1);
        int dado2 = (int)(Math.random() * (1000 - dado1) + (dado1 + 1));
        System.out.println("Multiplos de 5 entre " + dado1 + " - " + dado2);
        //System.out.println(dado2 / 5);
        int multiplo = dado2 / 5;
        while (multiplo * 5 <= dado2 && multiplo * 5 >= dado1) {
            System.out.println(multiplo * 5);
            multiplo--;
        }
    }
}
