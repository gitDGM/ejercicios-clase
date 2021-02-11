/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composicion.Ejercicio4y5;

/**
 *
 * @author alumno
 */
public class CajaTest {
    public static void main(String[] args) {
        CajaCarton cc1 = new CajaCarton(Etiqueta.getNextID(), 100, 200, 50);
        
        System.out.println(CajaCarton.getSuperficieTotal() + " " + cc1.getValueUnidad() + "^2");
    }
}
