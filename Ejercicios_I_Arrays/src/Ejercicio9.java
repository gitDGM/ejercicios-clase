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
    final static int FILAS = 4;
    final static int COLUMNAS = 3;
    public static void main(String[] args) {
        int[][] arrayNormal = new int[FILAS][COLUMNAS];
        int[][] arrayTraspuesto = new int[COLUMNAS][FILAS];
        
        /* Asignar valores aleatorios a array normal */
        for (int i = 0; i < arrayNormal.length; i++) {            
            for (int j = 0; j < arrayNormal[i].length; j++) {             
                arrayNormal[i][j] = (int)(Math.random() * 100 + 1);
            }
        }
        
        /* Colocar los valores del array normal en el array traspuesto */
        for (int i = 0; i < arrayNormal.length; i++) {            
            for (int j = 0; j < arrayNormal[i].length; j++) {                  
                arrayTraspuesto[j][i] = arrayNormal[i][j];
            }
        }
        
        /* Mostrar array normal */
        System.out.println("Array normal");
        for (int i = 0; i < arrayNormal.length; i++) {            
            for (int j = 0; j < arrayNormal[i].length; j++) {                    
                System.out.print(arrayNormal[i][j] + "\t");
            }        
            System.out.print("\n");
        }
        
        /* Mostrar array traspuesto */
        System.out.println("\nArray traspuesto");
        for (int i = 0; i < arrayTraspuesto.length; i++) {            
            for (int j = 0; j < arrayTraspuesto[i].length; j++) {                    
                System.out.print(arrayTraspuesto[i][j] + "\t");
            }        
            System.out.print("\n");
        }
    }
}
