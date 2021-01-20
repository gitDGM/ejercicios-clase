
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
public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limite;
        System.out.println("Introduce un límite: ");
        limite = sc.nextInt();
        
        System.out.println("Número devuelto: " + conseguirNumero(limite));
        
        
    }
    
    static int conseguirNumero(int limite) {
        int result = 0;
        int i = 1;        
        
        do {
            result += i;
            i++;            
        } while (result + i <= limite);
        
        return result;
    }
}
