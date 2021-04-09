/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercanciaspeligrosas;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Mercancia implements Serializable {
    
    // ATRIBUTOS DE LA CLASE
    private static final long serialVersionUID = 22222L;
    private String nombre;
    private final int nivelPeligrosidad;

    // CONSTRUCTOR
    public Mercancia(String nombre, int nivelPeligrosidad) {
        this.nombre = nombre;
        this.nivelPeligrosidad = nivelPeligrosidad;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public int obtenerPeligrosidad() {
        return nivelPeligrosidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // MÉTODO PARA MOSTRAR
    public void visualizar() {
        System.out.println("Nombre: " + nombre + "\tPeligrosidad: " + nivelPeligrosidad);
    }
    
    
}
