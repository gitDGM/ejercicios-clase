/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbfutbol;

/**
 *
 * @author alumno
 */
public class Equipo {
    private final String nombre;
    private int puntos;
    private int golesTotales;

    public Equipo(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        golesTotales = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getGolesTotales() {
        return golesTotales;
    }
    
    public void ganar() {
        this.puntos += 3;
    }
    
    public void empatar() {
        this.puntos += 1;
    }
    
    public void sumarGoles(int golesJornada) {
        golesTotales += golesJornada;
    }
}
