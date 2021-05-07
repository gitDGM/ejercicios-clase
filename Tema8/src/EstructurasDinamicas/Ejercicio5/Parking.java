/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.Ejercicio5;

import java.util.HashMap;

/**
 *
 * @author alumno
 */
public class Parking {
    private static final int N_PLAZAS = 10;
    private final HashMap<Integer, Plaza> plazas;
    
    public Parking() {
        plazas = new HashMap();
    }
    
    public void generarPlazas() {
        for (int i = 0; i < N_PLAZAS; i++) {
            plazas.put(i, new Plaza(i));
        }
    }
    
    public void agregarVehiculo() {
        boolean plazaVacia = false;
        
        for (int i = 0; i < N_PLAZAS && !plazaVacia; i++) {
            if (!plazas.get(i).isOcupada()) {
                plazaVacia = !plazas.get(i).isOcupada();   
                plazas.get(i).cambiarEstado();             
            }
        }
        
        if (!plazaVacia) {
            System.err.println("ERROR: El parking está lleno.");
        }
    }
    
    public void retirarVehiculo(int key) {
        if (key >= 0 && key < N_PLAZAS) {
            if (plazas.get(key).isOcupada()) {
                plazas.get(key).cambiarEstado();
            } else {
                System.err.println("ATECIÓN: Esta plaza está desocupada");
            }
        } else {
            System.err.println("ERROR: Introduce una ID válida.");
        }  
    }
    
    public void plazasDisponibles() {
        for (int i = 0; i < N_PLAZAS; i++) {
            if (!plazas.get(i).isOcupada()) {
                plazas.get(i).mostrar();
            }
        }
    }
    
    public void plazasOcupadas() {
        for (int i = 0; i < N_PLAZAS; i++) {
            if (plazas.get(i).isOcupada()) {
                plazas.get(i).mostrar();
            }
        }
    }
}
