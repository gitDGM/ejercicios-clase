/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejemplo1 {
    public static void main(String[] args) {
        byte enteroByte = 15;
        short enteroCorto = 400;
        int enterno = 500000;
        long enteroLargo = 400000000;
        float decimalCorto = 15.84F;
        double decimalLargo = 253.80;
        char caracter = 'F';
        
        System.out.println(enteroByte + enteroLargo);
        System.out.println(decimalCorto - enteroByte);
        System.out.println(enterno / decimalLargo);
        System.out.println(enteroCorto * decimalLargo);
        System.out.println(enterno + caracter);
    }    
}
