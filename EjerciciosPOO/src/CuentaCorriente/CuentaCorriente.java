package CuentaCorriente;

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
    private double saldo;
    private double limite;
    public String nombre;
    protected String dni;
    private Banco banco;
    
    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
        this.limite = 0;
        this.dni = "";
        this.nombre = "";
        this.banco = null;
    }
    
    public CuentaCorriente(double saldo, double limite, String dni) {
        this.saldo = saldo;
        this.limite = limite;
        this.dni = dni;
        this.nombre = "";
        this.banco = null;
    }
    
    public CuentaCorriente(String nombre, String dni) {
        saldo = 0;
        limite = 50;
        this.nombre = nombre;
        this.dni = dni;
        this.banco = null;
    }

    public boolean sacarDinero(double dinero) {
        boolean realizada;
        if (dinero <= limite) {
            saldo -= dinero;
            realizada = true;
        } else {
            System.out.println("Has superado el límite.");
            realizada = false;
        }
        
        return realizada;
    }
    
    public void ingresarDinero(double dinero) {
        saldo += dinero;
        System.out.println("Has ingresado: " + dinero + " €.");
    }
    
    public void mostrarInformacion() {
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Saldo: " + saldo);
        System.out.println("Limite: " + limite);
    }
    
    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Banco getBanco() {
        return banco;
    }   
}
