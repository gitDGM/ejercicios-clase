/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.EjercicioEnfermos;

/**
 *
 * @author alumno
 */
public class Enfermo {
    private final int id;
    private final String nombre;
    
    public Enfermo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void mostrar() {
        System.out.println(getId() + " - " + getNombre());
    }
}
