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
public class Circulo implements IFigura {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public void escalar(double escala) {
        if (escala > 0) {
            radio *= escala;
        } else {
            System.err.println("ERROR: Escala inválida.");
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Radio: " + radio);
        System.out.println("Area: " + area());
        System.out.println("Perímetro: " + perimetro());  
    }
    
}
