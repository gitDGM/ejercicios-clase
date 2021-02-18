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
public class Canario extends Ave {
    private String color;
    private boolean canta;

    public Canario(String color, boolean canta, boolean pico, boolean vuela, String nombre, int edad, boolean vivo, LocalDate fechaNacimiento) {
        super(pico, vuela, nombre, edad, vivo, fechaNacimiento);
        this.color = color;
        this.canta = canta;
    }

    public String getColor() {
        return color;
    }

    public boolean isCanta() {
        return canta;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCanta(boolean canta) {
        this.canta = canta;
    }
    
    @Override
    public void volar() {
        System.out.println(this.getNombre() + " vuela bajo.");
    }
    
    @Override
    public void hablar() {
        System.out.println("*Pio, Pio!*");
    }

    @Override
    public void muestra() {
        System.out.println("#######################");
        System.out.println("Tipo: " + getClass().getTypeName());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Fecha de Nacimiento: " + getFechaNacimiento());
        System.out.print("Pico: ");
        if (isPico()) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }
        System.out.print("Vuela: ");
        if (isVuela()) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }
        System.out.println("Color: " + getColor());
        System.out.print("Habla: ");
        if (isCanta()) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }
        System.out.println("#######################");
    }
}
