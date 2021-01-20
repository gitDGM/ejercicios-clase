/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author alumno
 */
public class Perro {
    private char color;
    private int edad;
    private static int cuantos;

    public Perro() {
        cuantos++;
    }
    
    public Perro(int edad) {
        this.edad = edad;
        cuantos++;
    }
    
    public Perro(char color) {
        this.color = color;
        cuantos++;
    }
    
    public Perro(char color, int edad) {
        this.color = color;
        this.edad = edad;
        cuantos++;
    }
        
    public void setColor(char color) {
        this.color = color;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public char getColor() {
        return color;
    }

    public int getEdad() {
        return edad;
    }
    
    public static int getCuantos() {
        return cuantos;
    }
    
    public void envejecer() {
        edad = edad + 1;
    }
    
    public void envejecer(int incremento) {
        edad = edad + incremento;
    }
}
