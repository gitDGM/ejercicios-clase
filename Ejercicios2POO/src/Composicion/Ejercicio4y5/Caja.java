/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composicion.Ejercicio4y5;

/**
 *
 * @author alumno
 */
public class Caja {
    private final int ancho;
    private final int alto;
    private final int fondo;
    private final Unidad unidad;
    private Etiqueta etiqueta;

    public Caja(int ancho, int alto, int fondo, Unidad unidad, Etiqueta etiqueta) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.etiqueta = etiqueta;  
        if (validarUnidad(unidad)) {
            this.unidad = unidad;
        } else {
            System.err.println("ERROR: Unidad no válida - Por defecto se ha puesto en metros");
            this.unidad = new Unidad("m");
        }      
    }
    
    public Caja(int ancho, int alto, int fondo, Unidad unidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        if (validarUnidad(unidad)) {
            this.unidad = unidad;
        } else {
            System.err.println("ERROR: Unidad no válida - Por defecto se ha puesto en metros");
            this.unidad = new Unidad("m");
        }  
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getFondo() {
        return fondo;
    }

    public String getValueUnidad() {
        return unidad.getValue();
    }
    
    public Etiqueta getEtiqueta() {
        return etiqueta;
    }
    
    public double getVolumen() {
        return (double)ancho * (double)alto * (double)fondo;
    }
    
    private boolean validarUnidad(Unidad unidad) {
        boolean valida = false;
        if (unidad.getValue().equals("cm") || unidad.getValue().equals("m")) {
            valida = true;
        }  
        return valida;
    }

    @Override
    public String toString() {
        return "Ancho: " + ancho + " Alto: " + alto + " Fondo: " + fondo + " Unidad: " + unidad.getValue() + " Destinatario: " + etiqueta.getDestinatario() + " Dirección: " + etiqueta.getDireccion();
    }
}
