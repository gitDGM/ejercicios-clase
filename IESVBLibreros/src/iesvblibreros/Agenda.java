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
public class Agenda extends Articulo {
    // ATRIBUTOS
    private String idioma;
    private int anyo;

    // CONSTRUCTOR
    public Agenda(String idioma, int anyo, String nombre, int existencias, double precio) {
        super(nombre, existencias, precio);
        this.idioma = idioma;
        this.anyo = anyo;
    }

    // GETTERS Y SETTERS
    public String getIdioma() {
        return idioma;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }    
    
    // IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS
    @Override
    public void mostrarArticulo() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Existencias: " + getExistencias());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Fecha de alta: " + getFechaAlta());
        System.out.println("Idioma: " + idioma);
        System.out.println("Año: " + anyo);
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
        } else {
            System.err.println("ATENCIÓN: No es posible la venta.");
            comprarAProveedor(2);
        }
    }
    
}
