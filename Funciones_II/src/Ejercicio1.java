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
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una letra: ");
        char letra = sc.next().charAt(0);
        if (comprobarVocal(letra)) {
            System.out.println("Es vocal.");
        } else {
            System.out.println("No es vocal.");            
        }
    }
    
    static boolean comprobarVocal(char letra) {
        boolean result;
        letra = Character.toLowerCase(letra);
        result = letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
        return result;
    }
}
