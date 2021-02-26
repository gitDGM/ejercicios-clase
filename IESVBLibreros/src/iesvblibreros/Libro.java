/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvblibreros;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Libro extends Libros {
    // ATRIBUTOS
    private String comentario;
    private boolean bolsillo;   

    // CONSTRUCTOR
    public Libro(String comentario, boolean bolsillo, String autor, String editorial, int anyo, String nombre, int existencias, double precio) {
        super(autor, editorial, anyo, nombre, existencias, precio);
        this.comentario = comentario;
        this.bolsillo = bolsillo;
    }

    // GETTERS Y SETTERS
    public String getComentario() {
        return comentario;
    }

    public boolean isBolsillo() {
        return bolsillo;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setBolsillo(boolean bolsillo) {
        this.bolsillo = bolsillo;
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
        System.out.println("Comentario: " + comentario);
        System.out.print("Edición de bolsillo: ");
        if (bolsillo) {
            System.out.println("Sí");
        } else {
            System.out.println("No");            
        }
    }

    @Override
    public void enlazarAWeb() {
        System.out.println("Bienvenido a la web del libro: " + getNombre());
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
            if (this.getExistencias() < 2) {
                comprarAProveedor(introducirCantidad());
            }
        } else {
            System.err.println("ATENCIÓN: No es posible la venta.");
        }
    }
    
    // METODO DE CONTROL PARA INTRODUCIR UNA CANTIDAD.
    // La utilizo en el metodo venderACliente para
    // introducir la cantidad de existencias que quiera comprar
    private int introducirCantidad() {
        Scanner sc = new Scanner(System.in);
        int numero = 0;        
        boolean noValido;
        do {
            System.out.println("Introduce la cantidad de libros que quieres comprar: ");
            try {
                numero = sc.nextInt();
                noValido = false;
            } catch (InputMismatchException ex) {
                System.err.println("Debe ser una cantidad valida.");
                noValido = true;
                sc.next();
            }
        } while (noValido);
        
        return numero;
    }    
}
