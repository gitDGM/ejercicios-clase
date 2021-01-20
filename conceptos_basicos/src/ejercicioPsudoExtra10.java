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
public class ejercicioPsudoExtra10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char letra;
        do {
            System.out.print("Introduce una letra: ");
            letra = Character.toLowerCase(sc.next().charAt(0));
            if (letra == 'a' || Character.toLowerCase(letra) == 'e' || Character.toLowerCase(letra) == 'i' || Character.toLowerCase(letra) == 'o' || Character.toLowerCase(letra) == 'u') {
                System.out.println("VOCAL");     
            } else {           
                System.out.println("CONSONANTE");
            }
        } while(letra != 0);
    }
}
