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
public class Satelite extends Astro {
    private double distanciaPlaneta;
    private double orbitaPlanetaria;
    private String planeta;

    public Satelite(double distanciaPlaneta, double orbitaPlanetaria, String planeta, double radioEcuatorial, double rotacionSobreEje, double masa, double temperatura, double gravedad) {
        super(radioEcuatorial, rotacionSobreEje, masa, temperatura, gravedad);
        this.distanciaPlaneta = distanciaPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planeta = planeta;
    }

    public double getDistanciaPlaneta() {
        return distanciaPlaneta;
    }

    public double getOrbitaPlanetaria() {
        return orbitaPlanetaria;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setDistanciaPlaneta(double distanciaPlaneta) {
        this.distanciaPlaneta = distanciaPlaneta;
    }

    public void setOrbitaPlanetaria(double orbitaPlanetaria) {
        this.orbitaPlanetaria = orbitaPlanetaria;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }
    
    
    
    @Override
    public void muestra() {
        System.out.println("...");
    }
    
}
