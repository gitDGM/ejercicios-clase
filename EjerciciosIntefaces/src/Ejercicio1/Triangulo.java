/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author alumno
 */
public class Triangulo implements IFigura {
    private double ancho;
    private double alto;

    public Triangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }
    
    @Override
    public double perimetro() {
        double hipotenusa = Math.pow(ancho / 2, 2) + Math.pow(alto, 2);        
        
        return (hipotenusa * 2) + ancho;
    }

    @Override
    public double area() {
        return (ancho * alto) / 2;
    }

    @Override
    public void escalar(double escala) {
        if (escala > 0) {
            ancho *= escala;
            alto *= escala;
        } else {
            System.err.println("ERROR: Escala inválida.");
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Ancho: " + ancho);
        System.out.println("Alto: " + alto);
        System.out.println("Area: " + area());
        System.out.println("Perímetro: " + perimetro());        
    }
    
}
