/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author alumno
 */
public class CuentaCorriente extends CuentaBancaria {

    
    @Override
    public double calcularIntereses() {
        return super.getSaldo() + (super.getSaldo() * super.getInteresAnualBasico());
    }
    
}
