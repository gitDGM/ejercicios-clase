/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

/**
 *
 * @author alumno
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        Texto texto1 = new Texto(15);
        texto1.insertarCaracterFinal("O");
        texto1.insertarCaracterPrincipio("H");
        texto1.insertarCadenaFinal("OOOOOOOOOOO");
        texto1.insertarCadenaFinal("LA");
        texto1.mostrarCadena();
    }
}
