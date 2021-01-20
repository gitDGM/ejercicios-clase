/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio9;

import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Casa {
    private ArrayList<Bombilla> bombillas;
    private Fusible fusible;
    private boolean interruptorGeneral;
    
    public Casa(int n_bombillas) {
        this.bombillas = new ArrayList<Bombilla>();
        generarBombillas(n_bombillas);
        this.fusible = new Fusible();
        this.interruptorGeneral = true;
    }
    
    private void generarBombillas(int n_bombillas) {        
        for (int i = 0; i < n_bombillas; i++) {
            this.bombillas.add(new Bombilla());
        }
    }
    
    private boolean comprobarFusibleRoto() {
        return this.fusible.isRoto();
    }
    
    private void toggleInterruptorGeneral() {        
        if (!comprobarFusibleRoto()) {
            this.interruptorGeneral = !this.interruptorGeneral;
            if (this.interruptorGeneral) {
                for (int i = 0; i < bombillas.size(); i++) {
                    bombillas.get(i).setEncendida(bombillas.get(i).getEstadoAnterior());           
                }
            } else {
                for (int i = 0; i < bombillas.size(); i++) {
                    bombillas.get(i).setEncendida(false);
                }
            }  
        }              
    }
    
    public void romperFusible() {
        if (!comprobarFusibleRoto()) {
            // System.out.println("roto");
            toggleInterruptorGeneral();
            this.fusible.setRoto(true);            
        }
    }
    
    public void repararFusible() {
        if (comprobarFusibleRoto()) {
            // System.out.println("reparado");
            this.fusible.setRoto(false);  
            toggleInterruptorGeneral();          
        }
    }
    
    public void toggleBombilla(int idBombilla) {
        if (!comprobarFusibleRoto()) {
            this.bombillas.get(idBombilla).setEncendida(!this.bombillas.get(idBombilla).isEncendida());            
        }
    }
    
    
    public void getEstadoBombilla(int idBombilla) {
        if (this.bombillas.get(idBombilla).isEncendida() && !comprobarFusibleRoto()) {
            System.out.println("Bombilla " + idBombilla + " está encendida.");
        }
    }     
    
    
}
