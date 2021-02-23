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
public class Helicoptero extends VehiculoAereo {
    private int numHelices;

    public Helicoptero(int numHelices, int numAsientos, String matricula, String modelo) {
        super(numAsientos, matricula, modelo);
        this.numHelices = numHelices;
    }

    public void setNumHelices(int numHelices) {
        this.numHelices = numHelices;
    }

    public int getNumHelices() {
        return numHelices;
    }
    
    @Override
    public void imprimir() {
        System.out.println("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tNumero de Asientos: " + getNumAsientos() + "\tNumero de helices: " + numHelices);
    }
}
