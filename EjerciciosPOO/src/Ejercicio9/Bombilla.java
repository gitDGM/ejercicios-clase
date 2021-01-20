/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

/**
 *
 * @author alumno
 */
public class Bombilla {
    private boolean encendida;
    private boolean estadoAnterior;
    
    public Bombilla() {
        this.encendida = true;
        this.estadoAnterior = true;
    }

    public boolean isEncendida() {
        return encendida;
    }
    
    public boolean getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEncendida(boolean encendida) {
        this.estadoAnterior = this.encendida;
        this.encendida = encendida;
    }  
}
