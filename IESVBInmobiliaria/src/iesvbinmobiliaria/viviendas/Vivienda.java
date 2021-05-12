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

    private final int idVivienda;
    private final String direccion;
    private final String localidad;
    private final String pais;
    private float precio;
    private final Cliente propietario;

    public Vivienda(int idVivienda, String direccion, String localidad, String pais, float precio, Cliente propietario) {
        this.idVivienda = idVivienda;
        this.direccion = direccion;
        this.localidad = localidad;
        this.pais = pais;
        this.precio = precio;
        this.propietario = propietario;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getPais() {
        return pais;
    }

    public float getPrecio() {
        return precio;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
