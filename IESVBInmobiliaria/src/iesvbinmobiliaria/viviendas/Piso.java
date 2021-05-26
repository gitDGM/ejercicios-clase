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
public class Piso extends Vivienda {

    private final boolean duplex;

    public Piso(boolean duplex, int idVivienda, String referenciaCatastral, String direccion, String localidad, String pais, float precio, int idPropietario) {
        super(idVivienda, referenciaCatastral, direccion, localidad, pais, precio, idPropietario);
        this.duplex = duplex;
    }

    public boolean isDuplex() {
        return duplex;
    }
}
