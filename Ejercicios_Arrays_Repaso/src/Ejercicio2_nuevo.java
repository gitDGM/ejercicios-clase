/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio2_nuevo {
    public static void main(String[] args) {
        int dado = (int)(Math.random() * 10000); 
        int menor = dado;
        int mayor = dado;
        int contador = 1;
        int contador500y3200 = 0;
        int sumaEntre500y300 = 0;
        while (dado != 0) {
            if (dado != 0 && dado < menor) {
                menor = dado;
            }
            if (dado > mayor) {
                mayor = dado;
            }
            if (dado >= 500 && dado <= 3200) {
                contador500y3200++;
                sumaEntre500y300 += dado;
            }
            contador++;            
            dado = (int)(Math.random() * 10000); 
        }
        System.out.println("#################");
        System.out.println("Menor: " + menor);
        System.out.println("Mayor: " + mayor);
        System.out.println("Contador de dados: " + contador);
        System.out.println("Media entre 500 y 3200: " + (sumaEntre500y300 / (double)contador500y3200));
        System.out.println("#################");
    }
}
