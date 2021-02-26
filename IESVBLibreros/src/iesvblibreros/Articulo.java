/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvblibreros;

import java.time.LocalDate;

/**
 *
 * @author alumno
 */
public abstract class Articulo {
    // ATRIBUTOS
    private String nombre;
    private int existencias;
    private double precio;
    private LocalDate fechaAlta;

    // CONSTRUCTOR
    public Articulo(String nombre, int existencias, double precio) {
        this.nombre = nombre;
        this.existencias = existencias;
        this.precio = precio;
        this.fechaAlta = LocalDate.now();
    }
    
    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public int getExistencias() {
        return existencias;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    public void modificarStock(int nuevaCantidad) {
        this.existencias = nuevaCantidad;
    }
    
    
    // METODOS ABSTRACTOS
    public abstract void comprarAProveedor(int cantidadComprada);
    
    public abstract void venderACliente(int cantidadVendida);
    
    public abstract void mostrarArticulo();    
    
    // METODO DE CONTROL PARA COMPROBAR SI ES POSIBLE LA VENTA
    public boolean comprobarSiPosibleVender(int cantidadVendida) {        
        return existencias - cantidadVendida < 0;
    }
}
