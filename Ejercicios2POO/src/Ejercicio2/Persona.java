/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alumno
 */
public class Persona {
    private final String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private static final int mayoriaEdad = 18;
    
    public Persona(String dni, String nombre, String apellidos, int edad) throws Exception {        
        if (validarDNI(dni)) {
            this.dni = dni;
        } else {
            throw new Exception("DNI no válido.");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void imprime() {
        System.out.println("#####################################");
        System.out.println("DNI: " + this.dni);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellidos: " + this.apellidos);
        System.out.println("Edad: " + this.edad);
        System.out.println("#####################################\n");
    }
    
    public boolean esMayorEdad() {
        return this.edad >= Persona.mayoriaEdad;
    }
    
    public boolean esJubilado() {
        return this.edad >= 65;
    }
    
    public int diferenciaEdad(Persona p) {
        
        int result = this.getEdad() - p.getEdad();
        
        result = result < 0 ? result * (-1) : result;
        
        return result;
    }
    
    static boolean validarDNI(String dni) {
        
        
        String regex = "[0-9]{8}[A-HJ-NP-TV-Z]";        
        
        
        return Pattern.matches(regex, dni);
    }
}
