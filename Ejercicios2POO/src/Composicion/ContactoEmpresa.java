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
public class ContactoEmpresa extends Contacto {

    private String web;

    public ContactoEmpresa(String web, String nombre, ArrayList<String> telefonos) throws Exception {
        super(nombre, telefonos);
        this.web = web;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
    
    @Override
    public void mostrar() {
        System.out.println("########################################");
        System.out.println("Nombre: " + this.getNombre());
        System.out.println("Web: " + this.getWeb());
        this.getTelefono();
        System.out.println("########################################");
    }
}
