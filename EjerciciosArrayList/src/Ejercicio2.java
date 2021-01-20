
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        int numero;
        do {
            System.out.println("Introduce \"-11111\" para parar la ejecución.");
            numero = introducirNumero("Introduce un número: ");
            
            if (numero != -11111) {
                numeros.add(numero);
            }             
        } while (numero != -11111);
        
        System.out.println("Lista de números:");
        System.out.println(numeros);
        
        System.out.println("Lista de números invertida:");
        System.out.println(invertirLista(numeros));
        
    }
    
    static int introducirNumero(String msg) {
        int numero = 0;        
        boolean NoValido;
        do {
            System.out.println(msg);
            try {
                numero = sc.nextInt();      
                NoValido = false;
            } catch (InputMismatchException ex) {
                System.err.println("Debe ser un número entero.");
                NoValido = true;
                sc.next();
            }
        } while (NoValido);
        
        return numero;
    }
    
    static ArrayList<Integer> invertirLista(ArrayList<Integer> lista) {
        ArrayList<Integer> listaInvertida = new ArrayList<>();
        for (int i = lista.size() - 1; i >= 0; i--) {
            listaInvertida.add(lista.get(i));
        }
        
        return listaInvertida;
    }
}
