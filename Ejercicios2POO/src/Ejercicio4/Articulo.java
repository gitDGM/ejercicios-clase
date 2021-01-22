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
    private final int iva;
    private int cuantosQuedan;

    public Articulo(String nombre, double precio, int iva, int cuantosQuedan) throws Exception {
        if (verificarDatos(precio, iva, cuantosQuedan)) {
            this.nombre = nombre;
            this.precio = precio;
            this.iva = iva;
            this.cuantosQuedan = cuantosQuedan;               
        } else {
            throw new Exception("Objecto no creado, datos inválidos.");
        }
    }
    
    private boolean verificarDatos(double precio, int iva, int cuantosQuedan) {
        boolean result = true;
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

    public void setPrecio(double precio) throws Exception {
        if (precio < 0) {
            throw new Exception("Precio inválido.");
        } else {
            this.precio = precio;            
        }
    }

    public void setCuantosQuedan(int cuantosQuedan) throws Exception {        
        if (cuantosQuedan < 0) {
            throw new Exception("Cantidad inválida.");
        } else {
            this.cuantosQuedan = cuantosQuedan;         
        }
        
    }
    
    public void imprimir() {
        System.out.println("####################");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Precio: " + this.precio);
        System.out.println("IVA: " + this.iva + "%");
        System.out.println("Cantidad: " + this.cuantosQuedan);
        System.out.println("####################");
    }
    
    public double getPVP() {        
        return this.precio + (this.precio * (this.iva / 100));
    }
    
    public double getPVPDescuento(int descuento) {        
        double pvp = getPVP();
        return pvp - (pvp * ((double)descuento / 100));
    }
    
    public boolean vender(int cantidad) {
        boolean result;
        
        result = this.cuantosQuedan - cantidad >= 0 && cantidad >= 0;
        
        if (result) {
            this.cuantosQuedan -= cantidad;
        }
        return result;
    }
    
    public boolean almacenar(int cantidad) {
        boolean result;
        if (cantidad < 0) {
            result = false;
        } else {
            result = true;
            this.cuantosQuedan += cantidad;
        }
        return result;        
    }
            
}
