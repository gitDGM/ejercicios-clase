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
public class Locomotora implements Serializable {
    private static final long serialVersionUID = 11111L;
    private final int idLocomotora;

    public Locomotora(int idLocomotora) {
        this.idLocomotora = idLocomotora;
    }

    public int getIdLocomotora() {
        return idLocomotora;
    }
    
    public void mostrar() {
        System.out.println("Locomotora - ID: " + idLocomotora);
    }
}
