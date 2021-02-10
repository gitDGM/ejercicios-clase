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
public class Planeta extends Astro {
    private double distanciaSol;
    private double orbitaSol;
    private boolean satelites;

    public Planeta(double distanciaSol, double orbitaSol, boolean tieneSatelites, double radioEcuatorial, double rotacionSobreEje, double masa, double temperatura, double gravedad) {
        super(radioEcuatorial, rotacionSobreEje, masa, temperatura, gravedad);
        this.distanciaSol = distanciaSol;
        this.orbitaSol = orbitaSol;
        this.satelites = tieneSatelites;
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public double getOrbitaSol() {
        return orbitaSol;
    }

    public boolean isSatelites() {
        return satelites;
    }

    public void setDistanciaSol(double distanciaSol) {
        this.distanciaSol = distanciaSol;
    }

    public void setOrbitaSol(double orbitaSol) {
        this.orbitaSol = orbitaSol;
    }

    public void setSatelites(boolean satelites) {
        this.satelites = satelites;
    }

    @Override
    public void muestra() {
        System.out.println("...");
    }    
}
