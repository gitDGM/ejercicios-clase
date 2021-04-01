/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio12;

import java.io.Serializable;

/**
 *
 * @author 0017610
 */
public class Cliente implements Serializable {
    private static int nextID = 1;
    private final int id;
    private String nombre;
    private String telefono;

    public Cliente(String nombre, String telefono) {
        this.id = nextID;
        this.nombre = nombre;
        this.telefono = telefono;
        nextID++;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void mostrar() {
        System.out.println(id + "\t\t" + nombre + "\t" + telefono);
    }
}
