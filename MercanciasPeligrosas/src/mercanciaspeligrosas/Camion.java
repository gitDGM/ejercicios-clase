/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercanciaspeligrosas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Camion implements Serializable {
    
    // ATRIBUTOS DE LA CLASE
    private static final long serialVersionUID = 11111L;
    private int idCamion;
    private ArrayList<Mercancia> mercancias;
    private int nivelPeligrosidad;

    // CONSTRUCTOR
    public Camion(int idCamion, ArrayList<Mercancia> mercancias, int nivelPeligrosidad) {
        this.idCamion = idCamion;
        this.mercancias = mercancias;
        this.nivelPeligrosidad = nivelPeligrosidad;
    }

    // GETTERS Y SETTERS
    public int getIdCamion() {
        return idCamion;
    }

    public ArrayList<Mercancia> getMercancias() {
        return mercancias;
    }

    public int obtenerPeligrosidad() {
        return nivelPeligrosidad;
    }

    public void setIdCamion(int idCamion) {
        this.idCamion = idCamion;
    }

    public void setMercancias(ArrayList<Mercancia> mercancias) {
        this.mercancias = mercancias;
    }

    public void setNivelPeligrosidad(int nivelPeligrosidad) {
        this.nivelPeligrosidad = nivelPeligrosidad;
    }
    
    // MÉTODO PARA AGREGAR UNA MERCANCIA AL ARRAYLIST
    public void agregarMercancia(Mercancia nuevaMercancia) {
        mercancias.add(nuevaMercancia);
    }
    
    // MÉTODO PARA MOSTRAR
    public void visualizar() {
        System.out.println("ID camión: " + idCamion);
        System.out.println("Peligrosidad: " + nivelPeligrosidad);
        System.out.println("Mercancias:");
        for (Mercancia mercancia : mercancias) {
            mercancia.visualizar();
        }
        System.out.println();
    }    
    
}
