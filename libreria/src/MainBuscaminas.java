
import java.util.InputMismatchException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class MainBuscaminas {
    public static void main(String[] args) {
        Buscaminas juego = new Buscaminas(10,8,20);
        int opcion;
        
        do {            
            System.out.println("##### BUSCAMINAS #####");
            System.out.println("1. Mostrar tablero jugador");
            System.out.println("2. Mostrar tablero juego");
            System.out.println("3. Insertar casilla");
            System.out.println("4. Desactivar mina");
            System.out.println("0. Salir");
            System.out.println("######################");
            opcion = introducirNumero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    juego.mostrarTableroJugador();
                    break;
                case 2:
                    juego.mostrarTableroJuego();
                    break;
                case 3:
                    insertarCasilla(juego);
                    break;
                case 0:
                    juego.fin();
                    break;
                default:
                    break;
            }
        } while (!juego.isTerminado() && opcion != 0);
    }
    
    static void insertarCasilla(Buscaminas juego) {
        int posX = introducirNumero("Introduce la posicion X: ");
        int posY = introducirNumero("Introduce la posicion Y: ");
        
        if (juego.getTableroJuego()[posY][posX] != 1) {
            juego.insertarCasilla(posX, posY);
        } else {
            System.err.println("Había una mina.");
            juego.fin();
        }
    }
    
    static int introducirNumero(String msg) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;        
        boolean noValido;
        do {
            System.out.println(msg);
            try {
                numero = sc.nextInt();
                noValido = false;
            } catch (InputMismatchException ex) {
                System.err.println("Debe ser un número decimal.");
                noValido = true;
                sc.next();
            }
        } while (noValido);

        return numero;
    }
}
