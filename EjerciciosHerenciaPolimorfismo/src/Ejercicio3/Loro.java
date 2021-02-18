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
public class Loro extends Ave {
    private String origen;
    private boolean habla;

    public Loro(String origen, boolean habla, boolean pico, boolean vuela, String nombre, int edad, boolean vivo, LocalDate fechaNacimiento) {
        super(pico, vuela, nombre, edad, vivo, fechaNacimiento);
        this.origen = origen;
        this.habla = habla;
    }
    
    public String getOrigen() {
        return origen;
    }

    public boolean isHabla() {
        return habla;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setHabla(boolean habla) {
        this.habla = habla;
    }

    @Override
    public void volar() {
        System.out.println(this.getNombre() + "no vuela.");
    }
    
    @Override
    public void hablar() {
        System.out.println("*Hola, Hola!*");
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
        System.out.println("Origen: " + getOrigen());
        System.out.print("Habla: ");
        if (isHabla()) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }
        System.out.println("#######################");
    }
}
