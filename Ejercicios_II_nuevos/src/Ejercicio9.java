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
public class Ejercicio9 {
    public static void main(String[] args) {
        int num, suma, contador;
        double media;
        contador = 0;
        suma = 0;
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.println("Introduce un número: ");
            num = sc.nextInt();
            if (num != 0) {
                contador++;
                suma += num;                
            }
        } while (num != 0);
        media = (double)suma / contador;
        System.out.println("Suma total: " + suma);
        System.out.println("Media: " + media);
    }
}
