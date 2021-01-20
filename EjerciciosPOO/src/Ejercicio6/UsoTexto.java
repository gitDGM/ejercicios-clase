/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio6;

/**
 *
 * @author alumno
 */
public class UsoTexto {
    public static void main(String[] args) {
        Texto mitexto = new Texto(9);
        mitexto.addPrincipioCadena("hola");
        System.out.println(mitexto.getCadena());
        mitexto.addFinalCadena("jeje");
        System.out.println(mitexto.getCadena());
        mitexto.addPrincipioCaracter('z');
        System.out.println(mitexto.getCadena());
        mitexto.addFinalCaracter('z');
        System.out.println(mitexto.getCadena());
    }
}
