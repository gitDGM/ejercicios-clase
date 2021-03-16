/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjercicioComunidades;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Comunidad {
    // ATRIBUTOS
    private String nombre;
    private ArrayList<Integer> poblaciones;

    // CONSTRUCTOR
    public Comunidad(String nombre, ArrayList<Integer> poblaciones) {
        this.nombre = nombre;
        this.poblaciones = poblaciones;
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getPoblaciones() {
        return poblaciones;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPoblaciones(ArrayList<Integer> poblaciones) {
        this.poblaciones = poblaciones;
    }
    
    // MÉTODO PARA AÑADIR UNA POBLACIÓN AL LISTADO
    public void addPoblacion(int poblacion) {
        poblaciones.add(poblacion);
    }
    
    // MÉTODO PARA MOSTRAR LA INFORMACIÓN DE LA COMUNIDAD
    public void mostrar() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Poblaciones:");
        int i = 1;
        for (int poblacion : poblaciones) {
            System.out.println(i + ".- " + poblacion);
            i++;
        }
    }
    
    // MÉTODO PARA MOSTRAR EL NOMBRE Y LA MEDIA DE LA COMUNIDAD
    public void mostrarMediaPoblacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Poblacion media: " + getMediaPoblacion());
    }
    
    // MÉTODO PARA OBTENER LA MEDIA DE LA COMUNIDAD
    public double getMediaPoblacion() {  
        return getPoblacionTotal() / (double)poblaciones.size();
    }
    
    // MÉTODO PARA OBTENER LA SUMA DE TODAS LAS 
    // POBLACIONES DE LA COMUNIDAD
    public int getPoblacionTotal() {
        int poblacionTotal = 0;
        
        for (int poblacion : poblaciones) {
            poblacionTotal += poblacion;
        }
        
        return poblacionTotal;
    }
}
