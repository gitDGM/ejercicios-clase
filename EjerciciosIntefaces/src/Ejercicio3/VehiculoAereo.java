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
public class VehiculoAereo extends Vehiculo {
    private final int numAsientos;

    public VehiculoAereo(int numAsientos, String matricula, String modelo) {
        super(matricula, modelo);
        this.numAsientos = numAsientos;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    @Override
    public void imprimir() {
        System.out.println("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tNumero de Asientos: " + numAsientos);
    }
}
