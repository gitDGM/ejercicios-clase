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
public class Barco extends VehiculoAcuatico {
    private boolean motor;

    public Barco(boolean motor, String matricula, String modelo, double eslora) {
        super(matricula, modelo, eslora);
        this.motor = motor;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }
    
    @Override
    public void imprimir() {
        System.out.print("Matricula: " + getMatricula() + "\tModelo: " + getModelo() + "\tEslora: " + getEslora() + "\tMotor: ");
        if (motor) {
            System.out.println("Si");            
        } else {
            System.out.println("No");
        }
    }
}
