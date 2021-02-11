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
        CajaCarton cc1 = new CajaCarton(100, 200, 50);
        CajaCarton cc2 = new CajaCarton(100, 200, 50);
        Caja c3 = new Caja(100, 200, 50, new Unidad("m"), new Etiqueta("aaaa", "Calle aaaa"));
        System.out.println(CajaCarton.getSuperficieTotal() + " " + CajaCarton.getUnidad() + "^2");
        System.out.println(cc1.getIdEtiqueta());
        System.out.println(cc2.getIdEtiqueta());
        System.out.println(c3.getEtiqueta().getIdEtiqueta());
    }
}
