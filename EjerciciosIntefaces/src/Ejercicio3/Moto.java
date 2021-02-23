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
public class Moto extends VehiculoTerrestre {
    private String color;

    public Moto(String color, String matricula, String modelo, int numRuedas) {
        super(matricula, modelo, numRuedas);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public void imprimir() {
        System.out.println("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tNumero de ruedas: " + getNumRuedas() + "\tColor: " + color);
    }
    
}
