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

    public Planeta(String nombre, double distanciaSol, double orbitaSol, double radioEcuatorial, double rotacionSobreEje, double masa, double temperatura, double gravedad) {
        super(nombre, radioEcuatorial, rotacionSobreEje, masa, temperatura, gravedad);
        this.distanciaSol = distanciaSol;
        this.orbitaSol = orbitaSol;
        this.satelites = false;
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
        System.out.println("########################");
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Radio ecuatorial: " + super.getRadioEcuatorial());
        System.out.println("Rotación sobre su eje: " + super.getRotacionSobreEje());
        System.out.println("Masa: " + super.getMasa());
        System.out.println("Temperatura Media: " + super.getTemperatura());
        System.out.println("Gravedad: " + super.getGravedad());
        System.out.println("Distancia al sol: " + getDistanciaSol());
        System.out.println("Órbita al sol: " + getOrbitaSol());
        System.out.print("Satélites: ");
        if (isSatelites()) {
            System.out.println("Sí");            
        } else {
            System.out.println("No");  
        }
        System.out.println("########################");
    }    
}
