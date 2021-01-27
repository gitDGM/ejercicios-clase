/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio10.Maquinaria;

/**
 *
 * @author alumno
 */
public class Vagon {
    private int cargaMax;
    private int cargaActual;
    private String tipoMercancia;

    protected Vagon(int cargaMax, int cargaActual, String tipoMercancia) {
        super();
        this.cargaMax = cargaMax;
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
    }
    
    
}
