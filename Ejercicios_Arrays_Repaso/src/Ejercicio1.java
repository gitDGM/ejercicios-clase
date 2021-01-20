
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
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char opcion;

        Jugador[] jugadores = null;

        int contador = 1;

        do {
            Jugador[] jugadoresTemporal = new Jugador[contador];
            if (contador > 1) {
                for (int i = 0; i < jugadores.length; i++) {
                    jugadoresTemporal[i] = jugadores[i];
                }
            }
            System.out.println("Introduce el nombre del jugador: ");
            String nombre = sc.nextLine();
            System.out.println("Introduce la cantidad de goles que ha marcado: ");
            int golesMarcados = sc.nextInt();
            jugadoresTemporal[contador - 1] = new Jugador(nombre, golesMarcados);
            contador++;

            System.out.println("Quieres continuar? (s/n): ");
            opcion = Character.toLowerCase(sc.next().charAt(0));
            sc.nextLine();
            jugadores = jugadoresTemporal;
        } while (opcion != 'n');

        System.out.println("#########################");
        System.out.println("Goles totales: " + contarGolesTotal(jugadores));
        System.out.println("Pichichi: " + buscarPichichi(jugadores));
        System.out.println("Jugadores que no han metido gol: " + contarJugadoresSinGol(jugadores));
        System.out.println("Jugadores que han metido más de 4 goles: " + contarJugadoresMasDe4Goles(jugadores));
        System.out.println("#########################");
    }

    static int contarGolesTotal(Jugador[] jugadores) {
        int result = 0;

        for (int i = 0; i < jugadores.length; i++) {
            result += jugadores[i].golesMarcados;
        }

        return result;
    }

    static String buscarPichichi(Jugador[] jugadores) {
        String result = "";
        int goles = 0;

        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].golesMarcados > goles) {
                result = jugadores[i].nombre;
                goles = jugadores[i].golesMarcados;
            }
        }
        return result;
    }

    static int contarJugadoresSinGol(Jugador[] jugadores) {
        int result = 0;

        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].golesMarcados == 0) {
                result++;
            }
        }

        return result;
    }

    static int contarJugadoresMasDe4Goles(Jugador[] jugadores) {
        int result = 0;

        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].golesMarcados > 4) {
                result++;
            }
        }

        return result;
    }

}

class Jugador {

    String nombre;
    int golesMarcados;

    public Jugador(String nombre, int golesMarcados) {
        this.nombre = nombre;
        this.golesMarcados = golesMarcados;
    }
}
