/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.time.LocalDate;

/**
 *
 * @author alumno
 */
public abstract class Mascota {
    private String nombre;
    private int edad;
    private boolean vivo;
    private LocalDate fechaNacimiento;

    public Mascota(String nombre, int edad, boolean vivo, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.vivo = vivo;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isVivo() {
        return vivo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public LocalDate birthday() {
        return fechaNacimiento;
    }
    
    public void morir() {
        this.vivo = false;
    }
    
     public void muestraBasico() {
        System.out.println("Tipo: " + this.getClass().getTypeName() + " | Nombre: " + this.getNombre());
    }
    
    public abstract void hablar();
    
    public abstract void muestra();
}
