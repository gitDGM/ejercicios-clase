/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia01;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Profesor extends Persona{
    
    private int codProfesor;
    private String departamento;
    private ArrayList<String> modulos;
    private String horario;

    public Profesor(int codProfesor, String departamento, ArrayList<String> modulos, String horario, String nombre, String dni, String direccion, int telefono) {
        super(nombre, dni, direccion, telefono);
        this.codProfesor = codProfesor;
        this.departamento = departamento;
        this.modulos = modulos;
        this.horario = horario;
    }

    public int getCodProfesor() {
        return codProfesor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public ArrayList<String> getModulos() {
        return modulos;
    }

    public String getHorario() {
        return horario;
    }

    public void setCodProfesor(int codProfesor) {
        this.codProfesor = codProfesor;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setModulos(ArrayList<String> modulos) {
        this.modulos = modulos;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    public void mostrarModulos() {
        System.out.println("Módulos: ");
        for (int i = 0; i < modulos.size(); i++) {
            System.out.println("Módulo " + i + ": " + modulos.get(i));
        }
    }
    
    @Override
    public void mostrarDatos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("DNI: " + getDni());
        System.out.println("Dirección: " + getDireccion());
        System.out.println("Teléfono: " + getTelefono());    
        System.out.println("Código profesor: " + codProfesor);    
        System.out.println("Departamento: " + departamento);    
        System.out.println("Horario: " + horario);    
        mostrarModulos();
    }
    
}
