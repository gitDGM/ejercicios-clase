package ejercicio1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */

public class CuentaCorriente {
    private int saldo, limiteDescubierto;
    public String nombreTitular;
    protected String dniTitular;
    private static String nombreBanco = "Banco Inventado";
    
    public CuentaCorriente(String nombreTitular, String dniTitular) {
        saldo = 0;
        limiteDescubierto = 50;
        this.nombreTitular = nombreTitular;
        this.dniTitular = dniTitular;
    }
    
    public CuentaCorriente(int saldoInicial) {
        saldo = saldoInicial;
        limiteDescubierto = 0;
        nombreTitular = null;
        dniTitular = null;
    }
    
    public CuentaCorriente(int saldoInicial, int limiteDescubierto, String dniTitular) {
        saldo = saldoInicial;
        this.limiteDescubierto = limiteDescubierto;
        nombreTitular = null;
        this.dniTitular = dniTitular;
    }
    
    public CuentaCorriente(int saldoInicial, int limiteDescubierto, String dniTitular, String nombreTitular) {
        saldo = saldoInicial;
        this.limiteDescubierto = limiteDescubierto;
        this.nombreTitular = nombreTitular;
        this.dniTitular = dniTitular;
    }
    
    public void cambiarNombreBanco(String nuevoNombreBanco) {
        nombreBanco = nuevoNombreBanco;
    }
    
    public void sacarDinero(int dineroSacado) {
        if (dineroSacado <= limiteDescubierto && saldo >= dineroSacado) {
            saldo = saldo - dineroSacado;
            System.out.println("Has sacado " + dineroSacado + " euros.");
        } else {
            if (saldo < dineroSacado) {
                System.out.println("No tienes suficiente saldo.");                
            } else if (dineroSacado > limiteDescubierto) {
                System.out.println("Has superado el límite.");                
            } else {
                System.out.println("Ha surgido un problema.");                   
            }            
        }
    }
    
    public void ingresarDinero(int dineroIngresado) {
        saldo = saldo + dineroIngresado;
        System.out.println("Has ingresado " + dineroIngresado + " euros.");
    }
    
    public void showInfo() {
        System.out.println("-------------------------------");
        System.out.println("Nombre del titular: " + nombreTitular);
        System.out.println("DNI del titular: " + dniTitular);
        System.out.println("Saldo: " + saldo + "€");
        System.out.println("Límite de descubierto: " + limiteDescubierto + "€");
        System.out.println("Nombre Banco: " + nombreBanco);
        System.out.println("-------------------------------");
    }
}
