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
public class Avion extends VehiculoAereo {
    private int tiempoVuelo;

    public Avion(int tiempoVuelo, int numAsientos, String matricula, String modelo) {
        super(numAsientos, matricula, modelo);
        this.tiempoVuelo = tiempoVuelo;
    }

    public int getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(int tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }
    
    @Override
    public void imprimir() {
        System.out.println("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tNumero de Asientos: " + getNumAsientos() + "\tHoras de vuelo: " + tiempoVuelo);
    }
}
