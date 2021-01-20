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
public class Ejercicio4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        
        int numero = introducirNumero("Introduce el número que quieres añadir:");
        do {            
            lista.add(numero);
            System.out.println("\nNumero añadido.");
            System.out.println("Estado acual de la lista: ");
            System.out.println(lista.toString());
        } while (elegirOpcionContinuar("\nQuieres continuar? (S/N)"));
        
        lista = logicaEjercicio4(lista);
        
        System.out.println("Lista de números después de la lógica:");
        System.out.println(lista);
    }
    
    static ArrayList<Integer> logicaEjercicio4(ArrayList<Integer> lista) {
        int sumarEnPares = 1;
        int restarEnImpares = 10;
        
        for (int i = 0; i < lista.size(); i++) {
            if (i % 2 == 0) {
                lista.set(i, lista.get(i) + sumarEnPares);
                sumarEnPares++;
            } else {                
                lista.set(i, lista.get(i) - restarEnImpares);
                restarEnImpares--;
            }
        }
        
        return lista;
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
    
    static boolean elegirOpcionContinuar(String msg) {
        boolean opcion = true; 
        boolean noValido;
        
        do {      
            System.out.println(msg);
            char letra = sc.next().charAt(0);

            if (Character.toUpperCase(letra) == 'N') {
                opcion = false;
                noValido = false;
            } else if (Character.toUpperCase(letra) == 'S') {
                opcion = true;
                noValido = false;
            } else {
                System.err.println("Opción no valida.");
                noValido = true;
            }
        } while (noValido);     
        
        return opcion;
    }
}
