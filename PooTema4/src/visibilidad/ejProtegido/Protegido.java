/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visibilidad.ejProtegido;

/**
 *
 * @author alumno
 */
public class Protegido {
    protected int numero;

    public Protegido(int numero) {
        this.numero = numero;
    }

    protected int getNumero() {
        return numero;
    }

    protected void setNumero(int numero) {
        this.numero = numero;
    }
}
