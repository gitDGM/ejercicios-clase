/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbinmobiliaria.viviendas;

import iesvbinmobiliaria.personas.Cliente;

/**
 *
 * @author alumno
 */
public class Casa extends Vivienda {

    private int numPlantas;

    public Casa(int numPlantas, String direccion, String localidad, String pais, float precio, Cliente propietario) {
        super(direccion, localidad, pais, precio, propietario);
        this.numPlantas = numPlantas;
    }

}
