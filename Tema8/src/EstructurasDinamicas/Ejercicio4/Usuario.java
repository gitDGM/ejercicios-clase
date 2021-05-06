/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.Ejercicio4;

import java.util.Date;

/**
 *
 * @author alumno
 */
public class Usuario {
    private final int id;
    private final Date horaLlegada;

    public Usuario(int id, Date horaLlegada) {
        this.id = id;
        this.horaLlegada = horaLlegada;
    }

    public int getId() {
        return id;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }
    
    public void mostrar() {
        System.out.println(id + " - " + horaLlegada);
    }
    
}
