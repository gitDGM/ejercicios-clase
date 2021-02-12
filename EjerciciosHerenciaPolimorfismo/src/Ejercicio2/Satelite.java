/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author alumno
 */
public class Satelite extends Astro {
    private double distanciaPlaneta;
    private double orbitaPlanetaria;
    private Planeta planeta;

    public Satelite(String nombre, double distanciaPlaneta, double orbitaPlanetaria, Planeta planeta, double radioEcuatorial, double rotacionSobreEje, double masa, double temperatura, double gravedad) {
        super(nombre, radioEcuatorial, rotacionSobreEje, masa, temperatura, gravedad);
        this.distanciaPlaneta = distanciaPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        planeta.setSatelites(true);
        this.planeta = planeta;
    }

    public double getDistanciaPlaneta() {
        return distanciaPlaneta;
    }

    public double getOrbitaPlanetaria() {
        return orbitaPlanetaria;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setDistanciaPlaneta(double distanciaPlaneta) {
        this.distanciaPlaneta = distanciaPlaneta;
    }

    public void setOrbitaPlanetaria(double orbitaPlanetaria) {
        this.orbitaPlanetaria = orbitaPlanetaria;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
    
    @Override
    public void muestra() {
        System.out.println("########################");
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Radio ecuatorial: " + super.getRadioEcuatorial());
        System.out.println("Rotación sobre su eje: " + super.getRotacionSobreEje());
        System.out.println("Masa: " + super.getMasa());
        System.out.println("Temperatura Media: " + super.getTemperatura());
        System.out.println("Gravedad: " + super.getGravedad());
        System.out.println("Distancia al sol: " + getDistanciaPlaneta());
        System.out.println("Órbita al sol: " + getOrbitaPlanetaria());
        System.out.println("Pertenece a: " + getPlaneta().getNombre());        
        System.out.println("########################");
    }
    
}
