/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composicion;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class ListaContactos {
    private final ArrayList<Contacto> contactos;

    public ListaContactos() {
        this.contactos = new ArrayList();
    }
    
    public int getCantidadContactos() {
        return contactos.size();
    }
    
    public void addContacto(Contacto nuevoContacto) {
        if (comprobarSiNoExisteContacto(nuevoContacto.getNombre())) {
            contactos.add(nuevoContacto);            
        } else {
            System.err.println("ERROR: No se ha añadido - Contacto duplicado.");
        }
    }
    
    public void removeContacto(String nombreContactoBorrar) {
        if (buscarSiExisteContacto(nombreContactoBorrar)) {
            contactos.remove(getIndexContacto(nombreContactoBorrar));            
        } else {
            System.err.println("ERROR: No se ha borrado - El contacto no existe.");
        }
    }
    
    public boolean buscarSiExisteContacto(String nombreContactoBuscado) {
        return !comprobarSiNoExisteContacto(nombreContactoBuscado);
    }
    
    public void mostrarContactos() {
        for(Contacto contacto : contactos) {
            System.out.println("########################################");
            System.out.println("Nombre: " + contacto.getNombre());
            contacto.getTelefono();
            System.out.println("########################################");
        }
    }
    
    public void mostrarContacto(String nombreContactoBuscado) {
        if (buscarSiExisteContacto(nombreContactoBuscado)) { 
            int index = getIndexContacto(nombreContactoBuscado);
            System.out.println("########################################");
            System.out.println("Nombre: " + this.contactos.get(index).getNombre());
            this.contactos.get(index).getTelefono();
            System.out.println("########################################");
        } else {
            System.err.println("ERROR: El contacto no existe");
        }   

    }
    
    private int getIndexContacto(String nombreContactoBuscado) {
        int index = -1;
        
        for (int i = 0; i < contactos.size() && index == -1; i++) {
            if(contactos.get(i).getNombre().equals(nombreContactoBuscado)) {
                index = i;
            }
        } 
        
        return index;
    }
    
    
    private boolean comprobarSiNoExisteContacto(String nombreContactoBuscado) {
        boolean noExiste = true;
        for (int i = 0; i < contactos.size() && noExiste; i++) {
            if(contactos.get(i).getNombre().equals(nombreContactoBuscado)) {
                noExiste = false;
            }
        }
        
        return noExiste;
    }
    
}
