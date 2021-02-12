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
public class Gato extends Mascota {
    private String color;
    private boolean peloLargo;

    public Gato(String color, boolean peloLargo, String nombre, int edad, boolean vivo, LocalDate fechaNacimiento) {
        super(nombre, edad, vivo, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    public String getColor() {
        return color;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPeloLargo(boolean peloLargo) {
        this.peloLargo = peloLargo;
    }

    @Override
    public void hablar() {
        System.out.println("*Miau, Miau!*");
    }

    @Override
    public void muestra() {
        System.out.println("#######################");
        System.out.println("Tipo: " + getClass().getTypeName());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Fecha de Nacimiento: " + getFechaNacimiento());
        System.out.println("Color: " + getColor());
        System.out.print("Pelo largo: ");
        if (isPeloLargo()) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }
        System.out.println("#######################");
    }
    
    
}
