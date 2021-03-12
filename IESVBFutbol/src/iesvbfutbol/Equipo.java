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
    private final int idEquipo;
    private final String nombre;
    private int puntos;
    private int golesFavor;
    private int golesContra;

    public Equipo(int idEquipo, String nombre) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        puntos = 0;
        golesFavor = 0;
        golesContra = 0;
    }

    public int getIdEquipo() {
        return idEquipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }
    
    public void ganar() {
        this.puntos += 3;
    }
    
    public void empatar() {
        this.puntos += 1;
    }
    
    public void aumentarGolesFavor(int goles) {
        this.golesFavor += goles;
    }
    
    public void aumentarGolesContra(int goles) {
        this.golesContra += goles;
    }
    
    public void mostrar() {
        System.out.print(nombre);
        if (nombre.length() <= 15) { // FIX PARA MOSTRAR BIEN LOS DATOS
            System.out.print("\t");
        }
        System.out.println("\t" + puntos + "\t" + golesFavor + "\t" + golesContra);
    }
}
