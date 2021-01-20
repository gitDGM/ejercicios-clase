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
public class Ejercicio11 {
    public static void main(String[] args) {
        int num, anterior, contador;
        contador = 0;
        anterior = 0;
        Scanner sc = new Scanner(System.in);
        do {            
            System.out.println("Introduce un número: ");
            num = sc.nextInt();
            if (num != 0) {
                contador++;
                if (contador > 1) {
                    System.out.println(num + " + " + anterior + " = " + (anterior + num));
                }
                anterior = num;
            }
        } while (num != 0);
    }
}
