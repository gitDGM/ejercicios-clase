/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alumno
 */
public class Ejercicio9 {
    public static void main(String[] args) {
        int altura = (int)(Math.random() * 15 + 1);
        System.out.println(altura);
        generarTrianguloIsosceles(altura);
    }
    
    static void generarTrianguloIsosceles(int altura) {
        for (int i = 1; i <= altura; i++) {
            for (int j = 0; j < altura - i; j++) {
                System.out.print(" ");
            }
            
            for (int k = 0; k < (i * 2) - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }   
    }
}
