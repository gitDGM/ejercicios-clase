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
public class Piso extends Vivienda {

    private boolean duplex;

    public Piso(boolean duplex, int idVivienda, String direccion, String localidad, String pais, float precio, Cliente propietario) {
        super(idVivienda, direccion, localidad, pais, precio, propietario);
        this.duplex = duplex;
    }

    public boolean isDuplex() {
        return duplex;
    }

    public void setDuplex(boolean duplex) {
        this.duplex = duplex;
    }

}
