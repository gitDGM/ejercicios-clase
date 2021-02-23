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
public class VehiculoAcuatico extends Vehiculo {
    private final double eslora;

    public VehiculoAcuatico(String matricula, String modelo, double eslora) {
        super(matricula, modelo);
        this.eslora = eslora;
    }

    public double getEslora() {
        return eslora;
    }
    
    @Override
    public void imprimir() {
        System.out.println("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tEslora: " + eslora);
    }
}
