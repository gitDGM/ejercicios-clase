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
public class Texto {
    private String cadena;
    private int max;
    private int cantidadVocales;
    
    
    public Texto(int max) {
        cadena = "";
        this.max = max;
        cantidadVocales = 0;
    }
    
    public String getCadena() {
        return cadena;
    }
    
    public int getCantidadVocales() {
        return cantidadVocales;
    }
    
    private void setCantidadVocales(int cantidadVocales) {
        this.cantidadVocales = cantidadVocales;
    }
    
    private int contarVocales(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.toUpperCase().charAt(i) == 'A' || cadena.toUpperCase().charAt(i) == 'E' ||cadena.toUpperCase().charAt(i) == 'I' || cadena.toUpperCase().charAt(i) == 'O' || cadena.toUpperCase().charAt(i) == 'U') {
                contador++;
            }
        }
        
        return contador;
    }
    
    public void addPrincipioCaracter(char caracter) {
        if (this.cadena.length() + 1 <= max) {
            this.cadena = caracter + this.cadena;            
        } else {
            System.out.println("Has superado la longitud máxima.");
        }
        setCantidadVocales(contarVocales(this.cadena));
    }
    
    public void addFinalCaracter(char caracter) {
        if (this.cadena.length() + 1 <= max) {
            this.cadena = this.cadena + caracter;            
        } else {
            System.out.println("Has superado la longitud máxima.");
        }
        setCantidadVocales(contarVocales(this.cadena));
    }
    
    public void addPrincipioCadena(String cadena) {
        if (this.cadena.length() + cadena.length() <= max) {
            this.cadena = cadena + this.cadena;       
        } else {
            System.out.println("Has superado la longitud máxima.");
        }
        setCantidadVocales(contarVocales(this.cadena));
    }
    
    public void addFinalCadena(String cadena) {
        if (this.cadena.length() + cadena.length() <= max) {
            this.cadena = this.cadena + cadena;            
        } else {
            System.out.println("Has superado la longitud máxima.");
        }
        setCantidadVocales(contarVocales(this.cadena));
    }
}
