/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio18 {
    final static int CANTIDAD_NUMEROS = 6;
    public static void main(String[] args) {
        int[] numeros = new int[CANTIDAD_NUMEROS];
        int contador = 0;
       
        while (contador < numeros.length) {
            if (numeros[contador] == 0) {
                numeros[contador] = (int)(Math.random() * 49 + 1);     
                if (checkIfExist(numeros, contador)){ 
                    numeros[contador] = 0;         
                } else {   
                    contador++;    
                }
            }
        }
        System.out.println("Resultado: ");
        mostrarArray1D(numeros);
    }
    
    static boolean checkIfExist(int[] numeros, int posicion) {
        for (int i = 0; i < numeros.length; i++) { 
            if (numeros[i] == numeros[posicion] && i != posicion) {
                /* TEST */
                // System.out.println(numeros[i] + " == " + numeros[posicion]);
                return true;
            }      
        }
        return false;
    }
    
    static void mostrarArray1D(int[] array) {
        for (int i = 0; i < array.length; i++) {            
            System.out.print(array[i] + "\t");
        }        
        System.out.println();
    }
}
