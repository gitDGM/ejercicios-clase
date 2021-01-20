/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visibilidad;

import CuentaCorriente.CuentaCorriente;

/**
 *
 * @author alumno
 */
public class Visibilidad {
    public static void main(String[] args) {
        CuentaCorriente cuenta1 = new CuentaCorriente("Diego", "123456789A");
        System.out.println(cuenta1.nombre);
    }
}
