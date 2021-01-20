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
public class Texto {

    private int longitudCadena;
    private String cadena = "";

    public Texto(int longitudCadena) {
        this.longitudCadena = longitudCadena;
    }

    public void insertarCaracterPrincipio(String caracter) {
        if (caracter.length() == 1 && cadena.length() < longitudCadena) {
            cadena = caracter + cadena;
            System.out.println("Has insertado: " + caracter);
        } else {
            if (caracter.length() > 1) {
                System.out.println("Solo puedes introducir un carácter");
            } else if (cadena.length() >= longitudCadena) {
                System.out.println("Has llegado al límite de caracteres.");
            } else {
                System.out.println("Ha surgido algún problema.");
            }
        }
    }

    public void insertarCaracterFinal(String caracter) {
        if (caracter.length() == 1 && cadena.length() < longitudCadena) {
            cadena = cadena + caracter;
            System.out.println("Has insertado: " + caracter);
        } else {
            if (caracter.length() > 1) {
                System.out.println("Solo puedes introducir un carácter");
            } else if (cadena.length() >= longitudCadena) {
                System.out.println("Has llegado al límite de caracteres.");
            } else {
                System.out.println("Ha surgido algún problema.");
            }
        }
    }

    public void insertarCadenaPrincipio(String cadena) {
        if (this.cadena.length() + cadena.length() <= longitudCadena) {
            this.cadena = cadena + this.cadena;
            System.out.println("Has insertado: " + cadena);
        } else {
            if (this.cadena.length() + cadena.length() >= longitudCadena) {
                System.out.println("Has llegado al límite de caracteres.");
            } else {
                System.out.println("Ha surgido algún problema.");
            }
        }
    }

    public void insertarCadenaFinal(String cadena) {
        if (this.cadena.length() + cadena.length() <= longitudCadena) {
            this.cadena = this.cadena + cadena;
            System.out.println("Has insertado: " + cadena);
        } else {
            if (this.cadena.length() + cadena.length() >= longitudCadena) {
                System.out.println("Has llegado al límite de caracteres.");
            } else {
                System.out.println("Ha surgido algún problema.");
            }
        }
    }

    public void mostrarCadena() {
        int cantidadVocales = 0;
        char[] ch = new char[cadena.length()];
        System.out.println("Cadena: " + cadena);
        for (int i = 0; i < cadena.length(); i++) {
            ch[i] = cadena.charAt(i);
        }
        for (char c : ch) {
            if (Character.toLowerCase(c) == 'a' || Character.toLowerCase(c) == 'e' || Character.toLowerCase(c) == 'i' || Character.toLowerCase(c) == 'o' || Character.toLowerCase(c) == 'u') {
                cantidadVocales++;
            }
        }
        System.out.println("Cantidad de vocales: " + cantidadVocales);
    }
}
