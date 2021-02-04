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
public class Contacto {
    private String nombre;
    private ArrayList<String> telefonos;
    
    public Contacto(String nombre, ArrayList<String> telefonos) throws Exception {
        if (validar(nombre, telefonos)) {
            this.nombre = nombre;
            this.telefonos = telefonos;            
        } else {
            throw new Exception("ERROR: Contacto no creado.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void getTelefono() {
        System.out.println("Teléfonos:");
        for (int i = 0; i < telefonos.size(); i++) {            
            System.out.println(i + ".- " + telefonos.get(i));
        }
    }

    public void setNombre(String nombre) {
        if (validarNombre(nombre)) {
            this.nombre = nombre;            
        } else {
            System.out.println("ERROR: Nombre no añadido - Inválido");            
        }
    }    
    
    public void setUnTelefono(String telefono) {
        if (validarTelefono(telefono)) {
            telefonos.add(telefono);
        } else {
            System.out.println("ERROR: Teléfono no añadido - Inválido");
        }
    }
    
    private boolean validar(String nombre, ArrayList<String> telefonos) {
        return validarNombre(nombre) && validarTelefonos(telefonos);
    }

    private boolean validarNombre(String nombre) {        
        return nombre.replace(" ","").matches("[a-zA-Z]");
    }
    
    private boolean validarTelefonos(ArrayList<String> telefonos) {
        boolean validos = true;
        for (int i = 0; i < telefonos.size() && validos; i++) {
            if (!telefonos.get(i).matches("[0-9]{9}")) {
                validos = false;
            }
        }
        
        return validos;
    }
    
    private boolean validarTelefono(String telefono) {        
        return telefono.matches("[0-9]{9}");
    }
}
