/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composicion;

import java.util.ArrayList;
import java.time.*;

/**
 *
 * @author alumno
 */
public class ContactoPersona extends Contacto {
    
    private LocalDate fechaNacimiento;

    public ContactoPersona(LocalDate fechaNacimiento, String nombre, ArrayList<String> telefonos) throws Exception {
        super(nombre, telefonos);
        this.fechaNacimiento = fechaNacimiento;
    } 

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public void mostrar() {
        System.out.println("########################################");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Fecha de nacimiento: " + this.getFechaNacimiento());
        this.getTelefono();
        System.out.println("########################################");
    }
}
