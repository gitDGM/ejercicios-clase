/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SintonizadorEmisoras;

/**
 *
 * @author alumno
 */
public class Emisora {
    private double frecuencia;
    private double frecuenciaMax;
    private double frecuenciaMin;
    
    public Emisora() {
        this.frecuencia = 80;
        this.frecuenciaMax = 108;
        this.frecuenciaMin = 80;
    }

    public double getFrecuencia() {
        return frecuencia;
    }
    
    public void subirFrecuencia() {
        if (this.frecuencia + 0.5 <= this.frecuenciaMax) {
            this.frecuencia += 0.5;            
        } else {
            this.frecuencia = frecuenciaMin + 0.5;
        }
    }

    public void bajarFrecuencia() {
        if (this.frecuencia - 0.5 >= this.frecuenciaMin) {
            this.frecuencia -= 0.5;            
        } else {
            this.frecuencia = frecuenciaMax - 0.5;
        }
    }
}
