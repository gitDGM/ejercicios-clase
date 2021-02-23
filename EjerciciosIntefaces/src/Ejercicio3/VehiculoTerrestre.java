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
public class VehiculoTerrestre extends Vehiculo {
    private final int numRuedas;
    
    public VehiculoTerrestre(String matricula, String modelo, int numRuedas) {
        super(matricula, modelo);
        this.numRuedas = numRuedas;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    @Override
    public void imprimir() {
        System.out.println("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tNumero de ruedas: " + numRuedas);
    }

}
