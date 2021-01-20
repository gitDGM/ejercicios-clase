/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class Ejercicio6 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        
        do {            
            numeros.add((int)((Math.random() * (40 - 20)) + 20));
            System.out.println("\nNumero añadido.");
            System.out.println("Estado acual de la lista: ");
            System.out.println(numeros.toString());
        } while (elegirOpcionContinuar("\nQuieres continuar? (S/N)"));
        
        System.out.println("Lista de números:");
        System.out.println(numeros);
        int suma = sumarNumerosLista(numeros);
        double media = suma / (double)numeros.size();
        System.out.println("Suma total: " + suma);
        System.out.println("Media: " + media);
        
        ArrayList<Integer> numerosSuperiorMedia = conseguirNumerosSuperiorMedia(numeros, media);
        ArrayList<Integer> numerosInferiorMedia = conseguirNumerosInferiorMedia(numeros, media);
        
        System.out.println("Lista de números superiores a la media:");
        System.out.println(numerosSuperiorMedia);
        System.out.println("Lista de números inferiores a la media:");
        System.out.println(numerosInferiorMedia);
        
    }   
    
    static ArrayList<Integer> conseguirNumerosSuperiorMedia(ArrayList<Integer> numeros, double media) {
        ArrayList<Integer> numerosSuperiorMedia = new ArrayList<>();
        
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) >= media) {
                numerosSuperiorMedia.add(numeros.get(i));
            }
        }
        
        return numerosSuperiorMedia;
    }
    
    static ArrayList<Integer> conseguirNumerosInferiorMedia(ArrayList<Integer> numeros, double media) {
        ArrayList<Integer> numerosInferiorMedia = new ArrayList<>();
        
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) < media) {
                numerosInferiorMedia.add(numeros.get(i));
            }
        }
        
        return numerosInferiorMedia;
    }
    
    static int sumarNumerosLista(ArrayList<Integer> numeros) {
        int suma = 0;
        
        for (int i = 0; i < numeros.size(); i++) {
            suma += numeros.get(i);
        }
        
        return suma;
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
