/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicasClase.edinamicas.EjercicioLibros;

import java.util.LinkedList;

/**
 *
 * @author alumno
 */
public class Biblioteca {
    private LinkedList<Libro> libros;
    
    public Biblioteca() {
        libros = new LinkedList();
    }
    
    public void agregarLibro(Libro nuevoLibro) {
        libros.add(nuevoLibro);
    }
    
    private int obtenerTam() {
        return libros.size();
    }
    
    private boolean esVacia() {
        return libros.isEmpty();
    }
    
    private boolean existeLibro(){
        boolean existe = false;
        if (!esVacia()) {
            
        }
        
        return existe;
    }
}
