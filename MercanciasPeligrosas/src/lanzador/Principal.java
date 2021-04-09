/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanzador;

import mercanciaspeligrosas.PrincipalControlador;

/**
 *
 * @author alumno
 */
public class Principal {
    public static void main(String[] args) {
        // OBJETO DE LA CLASE PRINCIPAL
        PrincipalControlador principal = new PrincipalControlador();
        
        // EJECUTAMOS EL MÉTODO QUE NOS PIDEN
        principal.gestionarMercancias();
    }
}
