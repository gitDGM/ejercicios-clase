/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio7 {
    public static void main(String[] args) {
        int[] temperaturas = new int[31];
        int temperaturaMaxima = 0;
        int temperaturaMinima = 0;
        double temperaturaMedia = 0;
        
        for (int i = 0; i < temperaturas.length; i++) {
            int aleatorio = (int)(Math.random() * (41 - (-10)) - 10);
            temperaturas[i] = aleatorio;
            temperaturaMedia += temperaturas[i];
        }
        
        for (int i = 0; i < temperaturas.length; i++) {
            if (i == 0) {
                temperaturaMaxima = temperaturas[i];
                temperaturaMinima = temperaturas[i];
            }
            if (temperaturas[i] > temperaturaMaxima) {
                temperaturaMaxima = temperaturas[i];
            }
            if (temperaturas[i] < temperaturaMinima) {
                temperaturaMinima = temperaturas[i];
            }            
        }
        temperaturaMedia /= temperaturas.length;
        System.out.println("Media de temperaturas: " + temperaturaMedia);
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturaMaxima == temperaturas[i]) {
                System.out.println("Día " + i + ": " + temperaturas[i] + " (Máxima)");
            }
            if (temperaturaMinima == temperaturas[i]) {
                System.out.println("Día " + i + ": " + temperaturas[i] + " (Mínima)");
            }   
            if (temperaturaMedia <= temperaturas[i]) {
                System.out.println("Día " + i + ": " + temperaturas[i] + " (Ha superado la media)");
                
            }
        }        
    }
}
