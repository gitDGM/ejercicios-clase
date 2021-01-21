/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author alumno
 */
public class Articulo {
    private String nombre;
    private double precio;
    private int iva;
    private int cuantosQueda;

    public Articulo(String nombre, double precio, int iva, int cuantosQueda) {
        this.nombre = nombre;
        this.precio = precio;
        this.iva = iva;
        this.cuantosQueda = cuantosQueda;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getIva() {
        return iva;
    }

    public int getCuantosQueda() {
        return cuantosQueda;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public void setCuantosQueda(int cuantosQueda) {
        this.cuantosQueda = cuantosQueda;
    }
    
    
            
}
