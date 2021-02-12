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
public class Perro extends Mascota{
    private final String raza;
    private boolean pulgas;

    public Perro(String raza, boolean pulgas, String nombre, int edad, boolean vivo, LocalDate fechaNacimiento) {
        super(nombre, edad, vivo, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }

    public String getRaza() {
        return raza;
    }

    public boolean isPulgas() {
        return pulgas;
    }

    public void setPulgas(boolean pulgas) {
        this.pulgas = pulgas;
    }

    @Override
    public void hablar() {
        System.out.println("*Guau, Guau!*");
    }

    @Override
    public void muestra() {
        System.out.println("#######################");
        System.out.println("Tipo: " + getClass().getTypeName());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Fecha de Nacimiento: " + getFechaNacimiento());
        System.out.println("Raza: " + getRaza());
        System.out.print("Raza: ");
        if (isPulgas()) {
            System.out.println("Sí");
        } else {
            System.out.println("No");
        }
        System.out.println("#######################");
    }

    
}
