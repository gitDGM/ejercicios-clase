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
public abstract class Ave extends Mascota {

    private boolean pico;
    private boolean vuela;

    public Ave(boolean pico, boolean vuela, String nombre, int edad, boolean vivo, LocalDate fechaNacimiento) {
        super(nombre, edad, vivo, fechaNacimiento);
        this.pico = pico;
        this.vuela = vuela;
    }

    public boolean isPico() {
        return pico;
    }
    
    public boolean isVuela() {
        return vuela;
    }

    public void setPico(boolean pico) {
        this.pico = pico;
    }
    
    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }
    
    public abstract void volar();
    
    @Override
    public abstract void hablar();
    
    @Override
    public abstract void muestra();
}
