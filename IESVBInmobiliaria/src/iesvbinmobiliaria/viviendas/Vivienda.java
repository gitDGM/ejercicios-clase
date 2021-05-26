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
public class Vivienda {

    private final int idVivienda;
    private final String referenciaCatastral;
    private final String direccion;
    private final String localidad;
    private final String pais;
    private float precio;
    private final int idPropietario;

    public Vivienda(int idVivienda, String referenciaCatastral, String direccion, String localidad, String pais, float precio, int idPropietario) {
        this.idVivienda = idVivienda;
        this.referenciaCatastral = referenciaCatastral;
        this.direccion = direccion;
        this.localidad = localidad;
        this.pais = pais;
        this.precio = precio;
        this.idPropietario = idPropietario;
    }

    public int getIdVivienda() {
        return idVivienda;
    }

    public String getReferenciaCatastral() {
        return referenciaCatastral;
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

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
