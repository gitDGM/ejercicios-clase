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
public class Alumno extends Persona {
    
    private int numExpediente;
    private String ciclo;
    private int curso;
    private ArrayList<Integer> notas;

    public Alumno(String nombre, String dni, String direccion, int telefono, int numExpediente, String ciclo, int curso, ArrayList<Integer> notas) {
        super(nombre, dni, direccion, telefono);
        this.numExpediente = numExpediente;
        this.ciclo = ciclo;
        this.curso = curso;
        this.notas = notas;
    }
    
    public int getNumExpediente() {
        return numExpediente;
    }

    public String getCiclo() {
        return ciclo;
    }

    public int getCurso() {
        return curso;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNumExpediente(int numExpediente) {
        this.numExpediente = numExpediente;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }    
    
    public double calcularMedia(ArrayList<Integer> notas) {
        double result;
        
        result = sumarNotas(notas);
        
        return result / notas.size();
    }
    
    public void mostrarNotas() {
        System.out.println("Notas: ");
        for (int i = 0; i < notas.size(); i++) {
            System.out.println("Nota " + i + ": " + notas.get(i));
        }
    }
    
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();   
        System.out.println("Nº Expediente: " + numExpediente);    
        System.out.println("Ciclo: " + ciclo);    
        System.out.println("Curso: " + curso);    
        mostrarNotas();
    }
    
    private double sumarNotas(ArrayList<Integer> notas) {
        double result = 0;
        
        for (int i = 0; i < notas.size(); i++) {
            result += notas.get(i);
        }
        
        return result;
    }
    
}
