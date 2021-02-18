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
        edad = 16;
        telefono = "";
        direccion = "";
    }

    public Empleado(String dni, String nombre, double salario, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public Empleado(String dni, String nombre, double salario, int edad, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
        this.telefono = telefono;
    }

    public Empleado(String dni, String nombre, double salario, int edad, String telefono, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    public void mostrar() {
        System.out.println("#######################");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: " + salario);
        System.out.println("Edad: " + edad);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
        System.out.println("#######################\n");
    }
    
    public double getSalarioNeto() {
        
        double salarioNetoAnual = salario * 12;
        double irpf = getIRPF(salarioNetoAnual);
        
        return salarioNetoAnual - (salarioNetoAnual * irpf);
    }
    
    private double getIRPF(double salarioNetoAnual) {
        double irpf;
        
        if (salarioNetoAnual < 12000) {
            irpf = 0.20;
        } else if (salarioNetoAnual >= 12000 && salarioNetoAnual <= 25000) {
            irpf = 0.30;
        } else {
            irpf = 0.40;
        }
        
        return irpf;
    }
    
}
