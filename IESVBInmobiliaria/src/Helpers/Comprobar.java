/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author alumno
 */
public class Comprobar {

    public static boolean isNumeric(String data) {
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean verificarDNI(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (dni.length() == 9) {
            String numerosDNI = dni.trim().replaceAll(" ", "").substring(0, 8);
            char letraDNI = dni.charAt(8);
            int valorNumeroDNI = Integer.parseInt(numerosDNI) % 23;

            return !(isNumeric(dni) == false && letras.charAt(valorNumeroDNI) != letraDNI);
        } else {
            return false;
        }
    }
}
