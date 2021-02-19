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
public abstract class CuentaBancaria {
    private final String iban;
    private double saldo;
    private double interesAnualBasico = 2.5;

    public CuentaBancaria(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getInteresAnualBasico() {
        return interesAnualBasico;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setInteresAnualBasico(double interesAnualBasico) {
        this.interesAnualBasico = interesAnualBasico;
    }
    
    public void ingresar(double cantidadIngresada) {
        saldo += cantidadIngresada;
    }
    
    public void retirar(double cantidadRetirada) {
        saldo -= cantidadRetirada;
    }
    
    public void traspasar(CuentaBancaria cuentaAjena, double saldoTraspasado) {
        retirar(saldoTraspasado);
        cuentaAjena.ingresar(saldoTraspasado);
    }
    
    public void mostrar() {
        System.out.println("#########################");
        System.out.println("IBA: " + iban);
        System.out.println("Saldo: " + saldo);
        System.out.println("Interes Anual Básico: " + interesAnualBasico);
        System.out.println("#########################");
    }
    
    public abstract void calcularIntereses();
    
}
