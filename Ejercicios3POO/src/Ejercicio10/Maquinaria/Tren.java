/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio10.Maquinaria;

import Ejercicio10.Personal.Maquinista;

/**
 *
 * @author alumno
 */
public class Tren{
    private final int VAGONES_MAX = 5;
    private Locomotora locomotora;
    private Maquinista maquinista;
    private Vagon[] vagones;

    public Tren(Locomotora locomotora, Maquinista maquinista, Vagon[] vagones) {
        this.locomotora = locomotora;
        this.maquinista = maquinista;
        this.vagones = vagones;
    }
    
    
    
}
