package CuentaCorriente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class UsoCuentaCorriente {
    public static void main(String[] args) {
        CuentaCorriente cuenta1 = new CuentaCorriente("Diego", "123456789A");
        
        cuenta1.ingresarDinero(1000);
        
        if(cuenta1.sacarDinero(50)) {
            cuenta1.mostrarInformacion();
        }
        
        System.out.println(cuenta1.dni);
    }
}
