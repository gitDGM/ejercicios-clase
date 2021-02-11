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
public class CajaCarton extends Caja {
    private static double superficieTotal = 0;
    private int idEtiqueta;

    public CajaCarton(int idEtiqueta, int ancho, int alto, int fondo) {
        super(ancho, alto, fondo, new Unidad("cm"));
        this.idEtiqueta = idEtiqueta;
        sumarSuperficeTotal();
    }    
    
    public int getIdEtiqueta() {
        return idEtiqueta;
    }
    
    public static double getSuperficieTotal() {
        return superficieTotal;
    }
    
    private void sumarSuperficeTotal() {        
        superficieTotal += ((super.getAncho() * super.getFondo()) * 2) + ((super.getAncho() * super.getAlto()) * 4);
    }

    @Override
    public double getVolumen() {
        return super.getVolumen() * 0.8;
    }
}
