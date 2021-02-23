/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author alumno
 */
public class Submarino extends VehiculoAcuatico {
    private double profundidadMax;

    public Submarino(double profundidadMax, String matricula, String modelo, double eslora) {
        super(matricula, modelo, eslora);
        this.profundidadMax = profundidadMax;
    }

    public double getProfundidadMax() {
        return profundidadMax;
    }

    public void setProfundidadMax(double profundidadMax) {
        this.profundidadMax = profundidadMax;
    }
    
    @Override
    public void imprimir() {
        System.out.println("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tEslora: " + getEslora() + "\tProfundidad máxima: " + profundidadMax);
    }
}
