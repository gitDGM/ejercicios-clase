/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria.viviendas;

/**
 *
 * @author alumno
 */
public class Casa extends Vivienda {

    private final int numPlantas;

    public Casa(int numPlantas, int idVivienda, String direccion, String localidad, String pais, float precio, int idPropietario) {
        super(idVivienda, direccion, localidad, pais, precio, idPropietario);
        this.numPlantas = numPlantas;
    }

    public int getNumPlantas() {
        return numPlantas;
    }

}
