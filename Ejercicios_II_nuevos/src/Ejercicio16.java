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
public class Ejercicio16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, contador, contadorPrimos;
        contadorPrimos = 0;
        System.out.println("Introduce la cantidad de números primos que quieres mostrar: ");
        n = sc.nextInt();
        
        for (int i = 1; contadorPrimos < n; i++) {
            contador = 0;
            for (int x = 1; x <= i; x++) {
                if (i % x == 0) {
                    contador++;
                }
            }
            if (contador <= 2) {
                contadorPrimos++;
                System.out.println(i);
            }
        }
    }        
}
