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

    public CuentaCorriente(String iban, double saldo) {
        super(iban, saldo);
    }
    
    @Override
    public void calcularIntereses() {
        double saldoActual = getSaldo();
        setSaldo(saldoActual + (saldoActual * (getInteresAnualBasico() / 100)));
    }
    
}
