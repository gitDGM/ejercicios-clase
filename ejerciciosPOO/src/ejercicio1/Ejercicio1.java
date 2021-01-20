/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author alumno
 */
public class Ejercicio1 {
    public static void main(String[] args) {
        CuentaCorriente cuenta1 = new CuentaCorriente("Diego", "11111111X");
        CuentaCorriente cuenta2 = new CuentaCorriente(5000);
        CuentaCorriente cuenta3 = new CuentaCorriente(3000, 200, "22222222J");
        CuentaCorriente cuenta4 = new CuentaCorriente(1000, 100, "33333333H", "Alfredo");
        cuenta1.ingresarDinero(75);
        cuenta1.sacarDinero(50);
        cuenta2.cambiarNombreBanco("Banco Cambiado");
        cuenta1.showInfo();
        cuenta2.showInfo();
        cuenta3.showInfo();
        cuenta4.showInfo();
    };
}
