
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
public class Ejercicio11 {
    final static int LONGITUD = 10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] personas = new String[LONGITUD];
        
        for(int i = 0; i < LONGITUD; i++) {
            System.out.println("Introduce un nombre: ");
            personas[i] = sc.nextLine();
        }
        
        System.out.println("Introduce un nombre para buscarlo: ");
        String personaBuscada = sc.nextLine();
        
        System.out.println("-------------------------------------------");
        int contador = 0;
        for(int i = 0; i < LONGITUD; i++) {
            if (personas[i].equals(personaBuscada)) {
                System.out.println((i + 1) + ".- " + personas[i]);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("ERROR: No ha sido encontrada la persona que buscabas.");
        }
        System.out.println("-------------------------------------------");
    }
}
