/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvblibreros;

/**
 *
 * @author alumno
 */
public class Manual extends Libros {
    // ATRIBUTOS
    private String tematica;
    
    // CONSTRUCTOR
    public Manual(String tematica, String autor, String editorial, int anyo, String nombre, int existencias, double precio) {
        super(autor, editorial, anyo, nombre, existencias, precio);
        this.tematica = tematica;
    }

    // GETTERS Y SETTERS
    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }    

    // IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS
    @Override
    public void mostrarArticulo() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Existencias: " + getExistencias());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Fecha de alta: " + getFechaAlta());
        System.out.println("Autor: " + getAutor());
        System.out.println("Editorial: " + getEditorial());
        System.out.println("Año: " + getAnyo());
        System.out.println("Tematica: " + tematica);
    }

    @Override
    public void enlazarAWeb() {
        System.out.println("Bienvenido a la web del manual: " + getNombre());
    }

    @Override
    public void comprarAProveedor(int cantidadComprada) {
        if (cantidadComprada > 0) {
            modificarStock(this.getExistencias() + cantidadComprada);            
        }
    }

    @Override
    public void venderACliente(int cantidadVendida) {
        if (comprobarSiPosibleVender(cantidadVendida)) {
            modificarStock(this.getExistencias() - cantidadVendida);
            if (this.getExistencias() == 0) {
                comprarAProveedor(1);
            }
        } else {
            System.err.println("ATENCIÓN: No es posible la venta.");
        }
    }    
}
