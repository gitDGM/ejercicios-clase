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
    
    public void addContacto(Contacto nuevoContacto) {
        if (comprobarSiNoExisteContacto(nuevoContacto)) {
            contactos.add(nuevoContacto);            
        } else {
            System.err.println("ERROR: No se ha añadido - Contacto duplicado.");
        }
    }
    
    public void removeContacto(Contacto contactoBorrar) {
        if (buscarSiExisteContacto(contactoBorrar)) {
            contactos.remove(getIndexContacto(contactoBorrar));            
        } else {
            System.err.println("ERROR: No se ha borrado - Contacto no encontrado.");
        }
    }
    
    public boolean buscarSiExisteContacto(Contacto contactoBuscado) {
        return !comprobarSiNoExisteContacto(contactoBuscado);
    }
    
    public void mostrarContactos() {
        for(Contacto contacto : contactos) {
            System.out.println("########################################");
            System.out.println("Nombre: " + contacto.getNombre());
            contacto.getTelefono();
            System.out.println("########################################");
        }
    }
    
    private int getIndexContacto(Contacto contactoBuscado) {
        int index = -1;
        for (int i = 0; i < contactos.size() && index != -1; i++) {
            if(contactos.get(i).getNombre().equals(contactoBuscado.getNombre())) {
                index = i;
            }
        }
        return index;
    }
    
    private boolean comprobarSiNoExisteContacto(Contacto contactoBuscado) {
        boolean noExiste = true;
        for (int i = 0; i < contactos.size() && noExiste; i++) {
            if(contactos.get(i).getNombre().equals(contactoBuscado.getNombre())) {
                noExiste = false;
            }
        }
        
        return noExiste;
    }
    
}
