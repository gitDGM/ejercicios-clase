/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Inventario {
    private ArrayList<Mascota> mascotas = new ArrayList();
    
    public void insertarAnimal(Mascota animal) {
        mascotas.add(animal);
    }
    
    public void borrarAnimal(String nombre) {
        if (existe(nombre)) {
            int index = getIndex(nombre);
            mascotas.remove(index);
        } else {
            System.err.println("ANTENCIÓN: No existe.");
        }
    }
    
    public void vaciarInventario() {
        mascotas = new ArrayList();
    }
    
    public void mostrarConcreto(String nombre) {
        int index = getIndex(nombre);
        mascotas.get(index).muestra();
    }
    
    public void mostrarBasico() {
        for(Mascota mascota : mascotas) {
            mascota.muestraBasico();
        }
    }
    
    public void mostrar() {
        for(Mascota mascota : mascotas) {
            mascota.muestra();
        }
    }
    
    private boolean existe(String nombre) {
        boolean existe = false;
        for(int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getNombre().equals(nombre)) {
                existe = true;
            }
        }
        return existe;
    }
    
    private int getIndex(String nombre) {
        int index = -1;
        if (existe(nombre)) {
           for(int i = 0; i < mascotas.size() && index == -1; i++) {
                if (mascotas.get(i).getNombre().equals(nombre)) {
                    index = i;
                }
            } 
        } else {
            System.err.println("ANTENCIÓN: No existe.");
        }
        return index;
    }
}
