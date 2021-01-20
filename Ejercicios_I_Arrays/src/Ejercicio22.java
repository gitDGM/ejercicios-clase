
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diego
 */
public class Ejercicio22 {

    final static int LONGITUD = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[LONGITUD];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 100 + 1);
        }
        numeros = reordenarArray(numeros);
        //mostrarMatriz(numeros);

        System.out.println("Introduce el número que quieres buscar: ");
        int numeroBuscado = sc.nextInt();

        mostrarMatriz(numeros);
        int result = busquedaDicotomica(numeros, numeroBuscado);

        if (result != -1) {
            System.out.println("Entrontrado en la posición: " + (result + 1));
        } else {
            System.out.println("El dato no se encuentra en la matriz o no está correctamente ordenado.");
        }
    }

    static int busquedaDicotomica(int[] matrizNumeros, int numeroBuscado) {
        int inicio = 0;
        int fin = matrizNumeros.length - 1;
        int posicion;
        while (inicio <= fin) {
            posicion = (inicio + fin) / 2;
            if (matrizNumeros[posicion] == numeroBuscado) {
                return posicion;
            } else if (matrizNumeros[posicion] < numeroBuscado) {
                inicio = posicion + 1;
            } else {
                fin = posicion - 1;
            }
        }

        return -1;
    }

    static int[] reordenarArray(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 1; j < (matriz.length - i); j++) {
                if (matriz[j - 1] > matriz[j]) {
                    int temporal = matriz[j - 1];
                    matriz[j - 1] = matriz[j];
                    matriz[j] = temporal;
                }
            }
        }

        return matriz;
    }

    static void mostrarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i] + "\t");
        }
        System.out.println();
    }

}
