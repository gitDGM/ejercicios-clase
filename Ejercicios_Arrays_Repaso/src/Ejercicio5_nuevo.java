/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class Ejercicio5_nuevo {
    final static int N_NUMEROS = 25;
    public static void main(String[] args) {
        int[] numeros = new int[N_NUMEROS];
        numeros = rellenarMatriz(numeros);
        mostrarMatriz(numeros);
        
        int resultado = algoritmoEjercicio5(numeros);
        System.out.println("Resultado: " + resultado);
    }
    
    static int algoritmoEjercicio5(int[] matriz) {
        int result = 0;
        int contador = 0;
        boolean sumar = true;
        for (int i = 0; i < matriz.length; i++) {
            if (sumar) {
                result += matriz[i];
                sumar = !sumar;
            } else if (!sumar && contador < 2) {
                contador++;
                if (contador == 2 ) {
                    sumar = !sumar;
                    contador = 0;
                }
            }            
        }
        
        return result;
    }
    
    static void mostrarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i] + "\t");
        }
        //System.out.println();
    }
    
    static int[] rellenarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = (int)(Math.random() * 100 + 1);
        }
        return matriz;
    }
}
