/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IESVBBank;

import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 *
 * @author alumno
 */
public class IESVBBank {
    private static final double MAX_INGRESO_SIN_AVISO = 3000;
    private static final double MIN_SALDO_NEGATIVO = -50;
    private static final int MAX_MOVIMIENTOS_MOSTRAR = 100;
    
    private final String iban;
    private final String titular;
    private double saldo;
    private ArrayList<Double> movimientos;
    
    public IESVBBank(String iban, String titular) throws Exception {
        if (verificarIBAN(iban) && verificarTitular(titular)) {
            this.iban = iban.toUpperCase();
            this.titular = titular.toUpperCase();
            this.saldo = 0;
            this.movimientos = new ArrayList();
        } else {
            if (verificarIBAN(iban)) {
                throw new Exception("Objeto no creado - IBAN inválido.");            
            } else {
                throw new Exception("Objeto no creado - Titular inválido.");                 
            }
        }
    }
    
    public String getIBAN() {
        return this.iban;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }
    
    public String getTitular() {
        return titular;
    }

    public void getMovimientos() {
        for (int i = 0; i < this.movimientos.size() && i < MAX_MOVIMIENTOS_MOSTRAR; i++) {
            if (this.movimientos.get(i) < 0) {
                System.out.println("RETIRADA: " + this.movimientos.get(i));
            } else {
                System.out.println("INGRESO: " + this.movimientos.get(i));
            }
        }
    }
    
    public void mostarDatosCuenta() {
        System.out.println("IBAN: " + this.iban);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
    }

    public boolean ingresar(double saldoMovimiento) {
        boolean transaccionEstado = true;
        if (esPosibleIngresar(saldoMovimiento)) {
            double saldoAnterior = this.saldo;
            this.saldo += saldoMovimiento;
            nuevoMovimiento(saldoAnterior);
            mostrarPosiblesAvisos(saldoMovimiento);
        } else {
            transaccionEstado = false;
        }
        
        return transaccionEstado;
    }
    
    public boolean retirar(double saldoMovimiento) {
        boolean transaccionEstado = true;
        if (esPosibleRetirar(saldoMovimiento)) {
            double saldoAnterior = this.saldo;
            this.saldo -= saldoMovimiento;
            nuevoMovimiento(saldoAnterior);
            mostrarPosiblesAvisos(saldoMovimiento);
        } else {
            System.err.println("ERROR: No se ha realizado la retirada por falta de saldo.");
            transaccionEstado = false;
        }
        
        return transaccionEstado;
    }
    
    private void nuevoMovimiento(double saldoAnterior) {
        this.movimientos.add(this.saldo - saldoAnterior);
    }
    
    private boolean esPosibleIngresar(double saldo) {
        return saldo > 0;
    }
    private boolean esPosibleRetirar(double saldo) {
        return this.saldo - saldo > MIN_SALDO_NEGATIVO && saldo > 0;
    }
    
    private void mostrarPosiblesAvisos(double saldoMovimiento) {
        if (saldoMovimiento >= MAX_INGRESO_SIN_AVISO) {
            System.err.println("AVISO: Notificar a hacienda.");
        } else if (this.saldo < 0) {
            System.err.println("AVISO: Saldo negativo.");
        }
    }
    
    private boolean verificarIBAN(String iban) {
        String regex = "[A-Z]{2}[0-9]{22}";      
        
        return Pattern.matches(regex, iban.toUpperCase());
    }
    
    private boolean verificarTitular(String titular) {
        String[] nombreApellidos = titular.split(" ");
        boolean result = true;
        for (int i = 0; i < nombreApellidos.length && result; i++) {
            String regex = "[A-Z]{" + nombreApellidos[i].split("").length + "}";
            
            if (!Pattern.matches(regex, nombreApellidos[i].toUpperCase())) {
                result = false;
            }
        }
        
        return result && titular.split(" ").length > 1;
    }
    
}
