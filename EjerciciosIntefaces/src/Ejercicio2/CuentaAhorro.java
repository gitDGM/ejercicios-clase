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
public class CuentaAhorro extends CuentaBancaria {
    private final double saldoMinimo = 1000;

    public CuentaAhorro(String iban, double saldo) {
        super(iban, saldo);
    }

    @Override
    public void calcularIntereses() {
        double interesAnualBasico = getInteresAnualBasico();
        double saldoActual = getSaldo();
        
        if (getSaldo() < saldoMinimo) {
            interesAnualBasico /= 2;
        } else {
            interesAnualBasico *= 2;
        }
        
        setSaldo(saldoActual + (saldoActual * interesAnualBasico));
    }
    
}
