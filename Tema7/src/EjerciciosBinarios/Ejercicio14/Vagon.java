/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio14;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Vagon implements Serializable {
    private static final long serialVersionUID = 22222L;
    private final int idVagon;
    
    public Vagon(int idVagon) {
        this.idVagon = idVagon;
    }

    public int getIdLocomotora() {
        return idVagon;
    }
    
    public void mostrar() {
        System.out.println("Vagon - ID: " + idVagon);
    }
}
