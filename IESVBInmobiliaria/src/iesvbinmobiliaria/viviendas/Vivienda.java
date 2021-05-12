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
public class Vivienda {

    private final String direccion;
    private final String localidad;
    private final String pais;
    private float precio;
    private final Cliente propietario;

    public Vivienda(String direccion, String localidad, String pais, float precio, Cliente propietario) {
        this.direccion = direccion;
        this.localidad = localidad;
        this.pais = pais;
        this.precio = precio;
        this.propietario = propietario;
    }

}
