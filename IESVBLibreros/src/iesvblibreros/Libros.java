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
public abstract class Libros extends Articulo {
    // ATRIBUTOS
    private String autor;
    private String editorial;
    private int anyo;

    public Libros(String autor, String editorial, int anyo, String nombre, int existencias, double precio) {
        super(nombre, existencias, precio);
        this.autor = autor;
        this.editorial = editorial;
        this.anyo = anyo;
    }

    // GETTERS Y SETTERS
    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    // METODO ABSTRACTO
    public abstract void enlazarAWeb();        
}
