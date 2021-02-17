/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author alumno
 */
public class Empleado {
    private final String dni;
    private final String nombre;
    private double salario;
    private int edad;
    private String telefono;
    private String direccion;
    
    public Empleado(String dni, String nombre, double salario) {
        this.dni = dni;
        this.nombre = nombre;
        this.salario = salario;
    }
}
