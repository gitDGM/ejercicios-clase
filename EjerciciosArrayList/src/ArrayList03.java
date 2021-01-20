
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class ArrayList03 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        int numero = 0;
        boolean valido = true;
        do {
            System.out.println("Introduce un número: ");
            try {
                numero = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.err.println("ERROR: Debes introducir un número entero.");
                sc.next();
                valido = false;
            }
            
            if (valido && numero != 0) {
                lista.add(numero);
            }
        } while (numero != 0 || !valido);
        
        System.out.println("Lista de números:");
        System.out.println(lista);
        
        System.out.println("Suma:" + conseguirSuma(lista));
        System.out.println("Media:" + conseguirMedia(lista));
    } 
    
    static int conseguirSuma(ArrayList<Integer> lista) {
        int result = 0;
        
        for (int i = 0; i < lista.size(); i++) {
            result += lista.get(i);
        }
        
        return result;
    }
    
    static double conseguirMedia(ArrayList<Integer> lista) {
        double result = (double)conseguirSuma(lista); 
        
        result /= lista.size();
        
        return result;
    }
}
