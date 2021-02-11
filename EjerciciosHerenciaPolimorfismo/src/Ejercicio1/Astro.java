/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author alumno
 */
public abstract class Astro {
    private String nombre;
    private double radioEcuatorial;
    private double rotacionSobreEje;
    private double masa;
    private double temperatura;
    private double gravedad;

    public Astro(String nombre, double radioEcuatorial, double rotacionSobreEje, double masa, double temperatura, double gravedad) {
        this.nombre = nombre;
        this.radioEcuatorial = radioEcuatorial;
        this.rotacionSobreEje = rotacionSobreEje;
        this.masa = masa;
        this.temperatura = temperatura;
        this.gravedad = gravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getRadioEcuatorial() {
        return radioEcuatorial;
    }

    public double getRotacionSobreEje() {
        return rotacionSobreEje;
    }

    public double getMasa() {
        return masa;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public double getGravedad() {
        return gravedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRadioEcuatorial(double radioEcuatorial) {
        this.radioEcuatorial = radioEcuatorial;
    }

    public void setRotacionSobreEje(double rotacionSobreEje) {
        this.rotacionSobreEje = rotacionSobreEje;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }
    
    public abstract void muestra();
}
