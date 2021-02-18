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

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalario() {
        return salario;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
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
    
    public void mostrarGestion() {
        System.out.println("#######################");
        System.out.println("DNI: " + dni);
        System.out.println("Salario bruto: " + salario);
        System.out.println("Salario neto: " + getSalarioNetoMensual());
        System.out.println("#######################\n");
    }
    
    public double getSalarioBrutoAnual() {        
        return salario * 12;
    }
    
    public double getSalarioNetoAnual() {
        
        double salarioNetoAnual = getSalarioBrutoAnual();
        double irpf = getIRPF(salarioNetoAnual);
        
        return salarioNetoAnual - (salarioNetoAnual * irpf);
    }
    
    public double getSalarioNetoMensual() {
        return getSalarioNetoAnual() / 12;
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
