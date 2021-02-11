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
    private static final Unidad unidad = new Unidad("cm");
    private final int idEtiqueta;

    public CajaCarton(int ancho, int alto, int fondo) {        
        super(ancho, alto, fondo, unidad);
        this.idEtiqueta = Etiqueta.getNextID();
        sumarSuperficeTotal();
    }    
    
    public int getIdEtiqueta() {
        return idEtiqueta;
    }
    
    public static String getUnidad() {
        return unidad.getValue();
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
