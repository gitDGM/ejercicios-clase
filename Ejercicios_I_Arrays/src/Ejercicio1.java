/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        int[] arrEjer1 = {1, 3, 5, 6, 7};
        
        System.out.println("Listado");
        for (int i = 0; i < 5; i++) {
            System.out.println(arrEjer1[i]);
        }
        
        System.out.println("\nListado Inverso");
        for (int i = 4; i >= 0; i--) {
            System.out.println(arrEjer1[i]);
        }
    }
}
