
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
public class Ejercicio9_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad de numeros: ");
        int x = sc.nextInt();
        int suma = sumaNumeros(x);
        System.out.println("La suma es: " + suma);
    }
    
    static int sumaNumeros(int x) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int y = 1;
        int contador = 1;
        boolean sumar = true;
        
        do { 
            if (sumar) {                
                for (int i = 1; i <= y && contador <= x; i++) {
                    System.out.println("Introduce un numero: ");
                    int num = sc.nextInt();
                    result += num;
                    contador++;
                }
                sumar = false;
                y++;
            } else {                
                for (int i = 1; i <= y && contador <= x; i++) {
                    System.out.println("Introduce un numero: ");
                    int num = sc.nextInt();
                    contador++;
                }
                sumar = true;
                y++;                    
            }
        } while (contador <= x);
        return result;
    }
}
