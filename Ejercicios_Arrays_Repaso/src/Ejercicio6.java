
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
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la longitud de la combinación: ");
        int longitud = sc.nextInt();
        Juego camaraSecreta = new Juego(longitud);
        int[] combinacionJugador = new int[longitud];
        //mostrarMatriz(camaraSecreta.combinacion);
        
        while (!comprobarCombinacion(camaraSecreta.combinacion, combinacionJugador)) {
            mostrarMatriz(combinacionJugador);
            for (int i = 0; i < combinacionJugador.length; i++) {
                System.out.println("Introduce el el digito de la posicion " + (i + 1) + ": ");
                combinacionJugador[i] = sc.nextInt();
            }
            if (!comprobarCombinacion(camaraSecreta.combinacion, combinacionJugador)) {
                mostrarPistas(camaraSecreta.combinacion, combinacionJugador);
            }
        }
        
        mostrarMatriz(combinacionJugador);
        System.out.println("Enhorabuena, has encontrado la combinación!!");
    }
    
    static void mostrarPistas(int[] combinacionJuego, int[] combinacionJugador) {
        for (int i = 0; i < combinacionJugador.length; i++) {
            if (combinacionJugador[i] > combinacionJuego[i]) {
                System.out.println("El digito en la posicion " + (i + 1) + " es menor al que has introducido. (" + combinacionJugador[i] + ")");
            } else if (combinacionJugador[i] == combinacionJuego[i]) {
                System.out.println("El digito en la posicion " + (i + 1) + " es igual al que has introducido. (" + combinacionJugador[i] + ")");
            } else {
                System.out.println("El digito en la posicion " + (i + 1) + " es mayor al que has introducido. (" + combinacionJugador[i] + ")");
            }
        }
    }
    
    static boolean comprobarCombinacion(int[] combinacionJuego, int[] combinacionJugador) {
        int contador = 0;
        for (int i = 0; i < combinacionJuego.length; i++) {
            if (combinacionJuego[i] == combinacionJugador[i]) {
                contador++;
            }
        }
        
        if (contador == combinacionJuego.length) {
            return true;
        } else {
            return false;
        }        
    }
    
    static void mostrarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(matriz[i] + "\t");
        }
        System.out.println();
    }
}

class Juego {
    int[] combinacion;
    
    public Juego(int longitud) {
        combinacion = new int[longitud];
        generarCombinacion();
    }
    
    private void generarCombinacion() {
        for (int i = 0; i < this.combinacion.length; i++) {
            this.combinacion[i] = (int)(Math.random() * 5 + 1);
        }
    }
}