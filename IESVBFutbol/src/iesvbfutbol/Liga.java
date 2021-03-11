/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iesvbfutbol;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Liga {
    private final ArrayList<Equipo> equipos;
    private final ArrayList<Jornada> jornadas;

    public Liga() {
        this.equipos = new ArrayList();
        this.jornadas = new ArrayList();
    }
    
    private void cargarEquipos() {
    }
}
