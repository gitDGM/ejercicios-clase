
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
public class Ejercicio3_nuevos {
    final static int N_PROVINCIAS = 3;
    final static int N_CIUDADES = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < N_PROVINCIAS; i++) {
            System.out.println("Introduce el nombre de la provincia: ");
            String provincia = sc.nextLine();
            int mayorPoblacion = 0;
            String ciudadMayorPoblacion = "";
            for (int j = 0; j < N_CIUDADES; j++) {
                System.out.println("Introduce el nombre de una ciudad: ");
                String ciudad = sc.nextLine();
                System.out.println("Introduce la cantidad de población: ");
                int poblacion = sc.nextInt();
                sc.nextLine();
                
                if (poblacion > mayorPoblacion) {
                    mayorPoblacion = poblacion;
                    ciudadMayorPoblacion = ciudad;
                }
            }
            System.out.println("##### " + provincia + " #####");
            System.out.println("Ciudad con más población: " + ciudadMayorPoblacion);
            System.out.println("Población: " + mayorPoblacion);
            System.out.println("###################");
        }
    }
}
