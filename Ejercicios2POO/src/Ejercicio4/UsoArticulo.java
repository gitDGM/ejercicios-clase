/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author alumno
 */
public class UsoArticulo {
    public static void main(String[] args) {
        try {            
            Articulo a1 = new Articulo("Diego", 5.0, 21, 10);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
