/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicasClase.edinamicas.EjercicioLibros;

/**
 *
 * @author alumno
 */
public class Libro {
    private int id;
    private String titulo;
    
    public Libro(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }
    
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return getId() + " - " + getTitulo();
    }
}
