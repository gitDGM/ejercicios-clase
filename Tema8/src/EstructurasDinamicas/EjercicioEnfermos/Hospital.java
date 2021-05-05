/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.EjercicioEnfermos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author alumno
 */
public class Hospital {
    private final Queue<Enfermo> salaEspera;
    private final Queue<Enfermo> enfermosAtendidos;

    public Hospital() {
        salaEspera = new LinkedList();
        enfermosAtendidos = new LinkedList();
    }
    
    public void agregarEnfermo(Enfermo nuevoEnfermo) {
        salaEspera.add(nuevoEnfermo);
    }
    
    public void atenderEnfermo() {
        if (!estaVacia()) {
            Enfermo enfermoActual = salaEspera.poll();
            System.out.print("\nENFERMO ATETENDIDO: ");
            enfermoActual.mostrar();
            enfermosAtendidos.add(enfermoActual);
        } else {
            System.err.println("ERROR: No hay enfermos en la sala de espera.");
        }
    }
    
    public void mostrarColaAtendidos() {
        Iterator<Enfermo> it = enfermosAtendidos.iterator();
        while (it.hasNext()) {
            Enfermo next = it.next();
            next.mostrar();
        }
    }
    
    public void mostrarColaSalaEspera() {
        Iterator<Enfermo> it = salaEspera.iterator();
        while (it.hasNext()) {
            Enfermo next = it.next();
            next.mostrar();
        }
    }
    
    public boolean estaVacia() {
        return salaEspera.isEmpty();
    }
}
