/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class Ejercicio7 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        int numero;
        do {            
            System.out.println("\nIntroduce un 0 para parar de introducir números.");
            numero = introducirNumero("Introduce un número: ");
            
            if (numero != 0) {
                lista.add(numero);
            }
        } while (numero != 0);        
        
        if (!lista.isEmpty()) {            
            System.out.println("\nLista de números: ");
            System.out.println(lista.toString());
            int mayor = conseguirMayor(lista);
            System.out.println("Número mayor: " + mayor);
            mostrarPosicionesNumeroMayor(lista, mayor);            
        }
        
    }
    
    static void mostrarPosicionesNumeroMayor(ArrayList<Integer> lista, int mayor) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == mayor) {
                System.out.println("Posición " + (i + 1));
            }
        }
    }
    
    static int conseguirMayor(ArrayList<Integer> lista) {
        int mayor = lista.get(0);
        
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > mayor) {
                mayor = lista.get(i);
            }
        }
        
        return mayor;
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
}
