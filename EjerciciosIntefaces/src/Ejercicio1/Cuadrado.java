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
public class Cuadrado implements IFigura {

    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }
    
    public double getLado() {
        return lado;
    }
    
    public void setLado(double lado) {
        this.lado = lado;
    }
    
    @Override
    public double perimetro() {
        return lado * 4;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public void escalar(double escala) {
        if (escala > 0) {
            lado *= escala;
        } else {
            System.err.println("ERROR: Escala inválida.");
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Lado: " + lado);
        System.out.println("Area: " + area());
        System.out.println("Perímetro: " + perimetro()); 
    }
}
