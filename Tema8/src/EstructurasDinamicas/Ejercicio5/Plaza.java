/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasDinamicas.Ejercicio5;

/**
 *
 * @author alumno
 */
public class Plaza {
    private final int id;
    private boolean ocupada;
    
    public Plaza(int id) {
        this.id = id; 
        ocupada = false;
    }

    public int getId() {
        return id;
    }

    public boolean isOcupada() {
        return ocupada;
    }
    
    public void cambiarEstado() {
        ocupada = !ocupada;
    }
    
    public void mostrar() {
        System.out.print("Plaza: " + id + "\tEstado: ");
        if (ocupada) {
            System.out.println("Ocupada");
        } else {            
            System.out.println("Desocupada");
        }
    }
}
