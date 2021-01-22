/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.util.regex.Pattern;
import java.util.Arrays;

/**
 *
 * @author alumno
 */
public class Articulo {
    private String nombre;
    private double precio;
    private int iva;
    private int cuantosQuedan;

    public Articulo(String nombre, double precio, int iva, int cuantosQuedan) throws Exception {
        if (verificarDatos(nombre, precio, iva, cuantosQuedan)) {
            this.nombre = nombre;
            this.precio = precio;
            this.iva = iva;
            this.cuantosQuedan = cuantosQuedan;               
        } else {
            throw new Exception("Objecto no creado, datos inválidos.");
        }
    }
    
    private boolean verificarDatos(String nombre, double precio, int iva, int cuantosQuedan) {
        boolean result = true;
        String regex = "[a-zA-Z]";   
        if (!Pattern.matches(regex, nombre) && result) {
            result = false;
        }
        if (precio < 0 && result) {
            result = false;
        }
        if (!(iva == 21 || iva == 10 || iva == 4) && result) {
            result = false;
        }
        if (cuantosQuedan < 0 && result) {
            result = false;
        }
        
        return result;
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

    public int getCuantosQuedan() {
        return cuantosQuedan;
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

    public void setCuantosQuedan(int cuantosQuedan) {
        this.cuantosQuedan = cuantosQuedan;
    }
    
    public void imprimir() {
        System.out.println("####################");
        
        System.out.println("####################");
    }
            
}
