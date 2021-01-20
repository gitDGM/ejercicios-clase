/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visibilidad.ejPrivado;

/**
 *
 * @author alumno
 */
public class Privado {
    private int numero;

    public Privado(int numero) {
        this.numero = numero;
    }

    private int getNumero() {
        return numero;
    }

    private void setNumero(int numero) {
        this.numero = numero;
    }
}
