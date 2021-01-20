/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condicionales;


import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Condicionales02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int dia;
        System.out.println("Introduce el número de un día de la semana: ");    
        dia = sc.nextInt();
        switch(dia) {
            case 1:
                System.out.println("El día de la semana " + dia + " es " + dias[dia - 1]);
                break;
            case 2:
                System.out.println("El día de la semana " + dia + " es " + dias[dia - 1]);
                break;
            case 3:
                System.out.println("El día de la semana " + dia + " es " + dias[dia - 1]);
                break;
            case 4:
                System.out.println("El día de la semana " + dia + " es " + dias[dia - 1]);
                break;
            case 5:
                System.out.println("El día de la semana " + dia + " es " + dias[dia - 1]);
                break;
            case 6:
                System.out.println("El día de la semana " + dia + " es " + dias[dia - 1]);
                break;
            case 7:
                System.out.println("El día de la semana " + dia + " es " + dias[dia - 1]);
                break;
            default:
                System.out.println("Fuera de rango");
                break;
        }
    }
}