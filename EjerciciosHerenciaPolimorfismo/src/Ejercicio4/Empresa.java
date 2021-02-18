/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Empresa {
    private final String cif;
    private final String nombre;
    private String telefono;
    private String direccion;
    private ArrayList<Empleado> empleados;

    public Empresa(String cif, String nombre) {
        this.cif = cif;
        this.nombre = nombre;
    }

    public Empresa(String cif, String nombre, String telefono) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Empresa(String cif, String nombre, String telefono, String direccion) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Empresa(String cif, String nombre, String telefono, String direccion, ArrayList<Empleado> empleados) {
        this.cif = cif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empleados = empleados;
    }

    public String getCif() {
        return cif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void addEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    
    public void mostrar() {
        System.out.println("#######################");
        System.out.println("CIF: " + cif);
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Dirección: " + direccion);
        System.out.println("Empleados:");
        mostrarEmpleadosGestion();
        System.out.println("#######################\n");
    }
    
    public void mostrarEmpleados() {
        for (Empleado empleado : empleados) {
            empleado.mostrar();
        }
    }
    
    public void mostrarEmpleadosGestion() {
        for (Empleado empleado : empleados) {
            empleado.mostrarGestion();
        }
    }
    
    public double getTotalSalariosBrutosMensuales() {
        double totalSalariosMensualesBrutos = 0;
        
        for (Empleado empleado : empleados) {
            totalSalariosMensualesBrutos += empleado.getSalario();
        }
        
        return totalSalariosMensualesBrutos;
    }
    
    public double getTotalSalariosNetosMensuales() {
        double totalSalariosMensualesNetos = 0;
        
        for (Empleado empleado : empleados) {
            totalSalariosMensualesNetos += empleado.getSalarioNetoMensual();
        }
        
        return totalSalariosMensualesNetos;
    }
    
    public double getTotalSalariosBrutosAnuales() {
        double totalSalariosAnualesBrutos = 0;
        
        for (Empleado empleado : empleados) {
            totalSalariosAnualesBrutos += (empleado.getSalarioBrutoAnual());
        }
        
        return totalSalariosAnualesBrutos;
    }
    
    public double getTotalSalariosNetosAnuales() {
        double totalSalariosAnualesBrutos = 0;
        
        for (Empleado empleado : empleados) {
            totalSalariosAnualesBrutos += empleado.getSalarioNetoAnual();
        }
        
        return totalSalariosAnualesBrutos;
    }
     
}
