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
public class Coche extends VehiculoTerrestre {
    private boolean aireAcondicionado;

    public Coche(boolean aireAcondicionado, String matricula, String modelo) {
        super(matricula, modelo, 4);
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }
    
    @Override
    public void imprimir() {
        System.out.print("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tNumero de ruedas: " + getNumRuedas() + "\tAire acondicionado: ");
        if (aireAcondicionado) {
            System.out.println("Si");            
        } else {
            System.out.println("No");
        }
    }
}
