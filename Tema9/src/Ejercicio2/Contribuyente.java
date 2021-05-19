/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.time.LocalDate;

/**
 *
 * @author alumno
 */
public class Contribuyente {

    private final int idContribuyente;
    private final String dni;
    private final String poblacion;
    private final int idFuncionario;
    private final double importe;
    private final boolean pagar;
    private final LocalDate fechaRealizacion;

    public Contribuyente(int idContribuyente, String dni, String poblacion, int idFuncionario, double importe, boolean pagar, LocalDate fechaRealizacion) {
        this.idContribuyente = idContribuyente;
        this.dni = dni;
        this.poblacion = poblacion;
        this.idFuncionario = idFuncionario;
        this.importe = importe;
        this.pagar = pagar;
        this.fechaRealizacion = fechaRealizacion;
    }

    public int getIdContribuyente() {
        return idContribuyente;
    }

    public String getDni() {
        return dni;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public double getImporte() {
        return importe;
    }

    public boolean isPagar() {
        return pagar;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

}
