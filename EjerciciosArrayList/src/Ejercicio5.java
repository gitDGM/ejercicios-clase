/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Arrays;
/**
 *
 * @author alumno
 */
public class Ejercicio5 {
    final static int LONGITUD = 15;
    public static void main(String[] args) {
        int[] numeros = new int[LONGITUD];
        
        numeros = rellenarMatriz(numeros);
        
        int suma = calcularSuma(numeros);
        double media = suma / (double)numeros.length;
        
        System.out.println("Numeros:");
        System.out.println(Arrays.toString(numeros));
        System.out.println("Suma total: " + suma);
        System.out.println("Media: " + media);
    }
    
    static int calcularSuma(int[] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            suma += matriz[i];
        }        
        
        return suma;
    }
    
    static int[] rellenarMatriz(int[] matriz) {
        
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int)(Math.random() * 1000);
        }
        
        return matriz;
    }
}
