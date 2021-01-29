/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IESVBBank;

import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class IESVBBank {
    private final String iban;
    private final String titular;
    private int saldo;
    private ArrayList<Integer> movimientos;
    
    public IESVBBank(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0;
        this.movimientos = new ArrayList();
    }
    
    public String getIBAN() {
        return this.iban;
    }

    public String getIban() {
        return iban;
    }

    public int getSaldo() {
        return saldo;
    }

    public void getMovimientos() {
        for (int i = 0; i < this.movimientos.size(); i++) {
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

    public void setSaldo(int saldoMovimiento) {
        if (esPosibleHacerElMovimiento(saldoMovimiento)) {
            int saldoAnterior = this.saldo;
            this.saldo += saldoMovimiento;
            nuevoMovimiento(saldoAnterior);
            mostrarPosiblesAvisos(saldoMovimiento);
        } else {
            System.err.println("Cantidad de saldo inválida.");
        }
    }
    
    private void nuevoMovimiento(int saldoAnterior) {
        this.movimientos.add(this.saldo - saldoAnterior);
    }
    
    private boolean esPosibleHacerElMovimiento(int saldo) {
        return this.saldo + saldo < (-50) && saldo > 0;
    }
    
    private void mostrarPosiblesAvisos(int saldoMovimiento) {
        if (saldoMovimiento > 3000) {
            System.out.println("AVISO: Notificar a hacienda.");
        } else if (this.saldo < 0) {
            System.out.println("AVISO: Saldo negativo.");
        }
    }
    
}
