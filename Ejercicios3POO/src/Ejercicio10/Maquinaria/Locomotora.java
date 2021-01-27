/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio10.Maquinaria;

import Ejercicio10.Personal.Mecanico;

/**
 *
 * @author alumno
 */
public class Locomotora {
    private String matricula;
    private int potenciaMotores;
    private int fechaFabricacion;
    private Mecanico mecanico;

    public Locomotora(String matricula, int potenciaMotores, int fechaFabricacion, Mecanico mecanico) {
        super();
        this.matricula = matricula;
        this.potenciaMotores = potenciaMotores;
        this.fechaFabricacion = fechaFabricacion;
        this.mecanico = mecanico;
    }
    
    
}
