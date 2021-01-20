/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio6 {
    public static void main(String[] args) {        
        int[][] array1 = new int[5][3];
        int[][] array2 = new int[5][3];
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                array1[i][j] = (int)(Math.random() * 100 + 1);
                array2[i][j] = (int)(Math.random() * 100 + 1);
            }
        }
        
        System.out.println("Array 1");       
        for (int i = 0; i < 5; i++) {
            System.out.print("| \t");
            for (int j = 0; j < 3; j++) {
                System.out.print(array1[i][j] + "\t");
            }
            System.out.print("|\n");
        }
        
        System.out.println("\nArray 2");
        for (int i = 0; i < 5; i++) {
            System.out.print("| \t");
            for (int j = 0; j < 3; j++) {
                System.out.print(array2[i][j] + "\t");
            }
            System.out.print("|\n");
        }
        
        System.out.println("\nResultado suma");
        for (int i = 0; i < 5; i++) {
            System.out.print("| \t");
            for (int j = 0; j < 3; j++) {
                System.out.print((array1[i][j] + array2[i][j]) + "\t");
            }
            System.out.print("|\n");
        }
        
        
    }
}
