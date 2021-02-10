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
public abstract class Contacto {
    private String nombre;
    private ArrayList<String> telefonos;
    
    public Contacto(String nombre, ArrayList<String> telefonos) throws Exception {
        if (validar(nombre, telefonos)) {
            this.nombre = nombre;
            this.telefonos = telefonos;            
        } else {
            if (!validarNombre(nombre)) {
                throw new Exception("ERROR: Contacto no creado - Nombre inválido.");
            } else if (!validarTelefonos(telefonos)) {
                throw new Exception("ERROR: Contacto no creado - Teléfonos inválido.");
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void getTelefono() {
        System.out.println("Teléfonos:");
        for (int i = 0; i < telefonos.size(); i++) {            
            System.out.println("\t" + (i + 1) + ".- " + telefonos.get(i));
        }
    }

    public void setNombre(String nombre) {
        if (validarNombre(nombre)) {
            this.nombre = nombre;            
        } else {
            System.err.println("ERROR: Nombre no añadido - Inválido");            
        }
    }    
    
    public void setUnTelefono(String telefono) {
        if (validarTelefono(telefono)) {
            telefonos.add(telefono);
        } else {
            System.err.println("ERROR: Teléfono no añadido - Inválido");
        }
    }
    
    public abstract void mostrar();
    
    private boolean validar(String nombre, ArrayList<String> telefonos) {
        return validarNombre(nombre) && validarTelefonos(telefonos);
    }

    private boolean validarNombre(String nombre) {        
        return nombre.toLowerCase().replace(" ","").matches("[a-z]{" + nombre.replace(" ","").split("").length + "}");
    }
    
    private boolean validarTelefonos(ArrayList<String> telefonos) {
        boolean validos = true;
        for (int i = 0; i < telefonos.size() && validos; i++) {
            if (!validarTelefono(telefonos.get(i))) {
                validos = false;
            }
        }
        
        return validos;
    }
    
    private boolean validarTelefono(String telefono) {        
        return telefono.matches("[0-9]{9}");
    }
}
