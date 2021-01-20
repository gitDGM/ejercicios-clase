/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionJugador1, opcionJugador2;
        do {
            System.out.println("----- Jugador 1 -----");
            System.out.println("1. Piedra");
            System.out.println("2. Papel");
            System.out.println("3. Tijeras");
            System.out.println("---------------------");
            System.out.println("Elige una opción: ");
            opcionJugador1 = sc.nextInt();
            if (opcionJugador1 < 1 || opcionJugador1 > 3) {
                System.out.println("Fuera de rango");
            }
        } while (opcionJugador1 < 1 || opcionJugador1 > 3);
        
        do {
            System.out.println("----- Jugador 2 -----");
            System.out.println("1. Piedra");
            System.out.println("2. Papel");
            System.out.println("3. Tijeras");
            System.out.println("---------------------");
            System.out.println("Elige una opción: ");
            opcionJugador2 = sc.nextInt();
            if (opcionJugador2 < 1 || opcionJugador2 > 3) {
                System.out.println("Fuera de rango");
            }
        } while (opcionJugador2 < 1 || opcionJugador2 > 3);
        
        comprobarGanador(opcionJugador1, opcionJugador2);
    }
    
    static void comprobarGanador(int opcionJugador1, int opcionJugador2) {
        int [][] ganadores = {
                              {0, 2, 1},
                              {1, 0, 2},
                              {2, 1, 0}
                             };
        
        switch (ganadores[opcionJugador1 - 1][opcionJugador2 - 1]) {
            case 1:                
                System.out.println("---------------------");
                System.out.println("Gana Jugador 1");
                System.out.println("---------------------");
                break;
            case 2:           
                System.out.println("---------------------");
                System.out.println("Gana Jugador 2");
                System.out.println("---------------------");
                break;
            case 0:           
                System.out.println("---------------------");
                System.out.println("Empate");
                System.out.println("---------------------");
                break;              
        } 
    }
}
