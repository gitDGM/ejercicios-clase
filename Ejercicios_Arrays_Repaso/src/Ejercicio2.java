
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumno
 */
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cantidad de dias: ");
        int nDias = sc.nextInt();
        
        Dia[] dias = new Dia[nDias];
        
        for (int i = 0; i < nDias; i++) {
            int tempMinima, tempMaxima;
            System.out.println("### Dia " + (i + 1) + " ###");
            do {          
                System.out.println("Introduce la temperatura mínima de ese día: ");
                tempMinima = sc.nextInt();
                if (tempMinima < 0) {
                    System.out.println("Debe ser una temperatura positiva.");
                }
            } while (tempMinima < 0);
            do {                
                System.out.println("Introduce la temperatura máxima de ese día: ");
                tempMaxima = sc.nextInt();
                if (tempMaxima < 0) {
                    System.out.println("Debe ser una temperatura positiva.");
                } else if (tempMaxima < tempMinima) {
                    System.out.println("La temperatura maxima debe ser superior a la temperatura minima.");
                }
            } while (tempMaxima < 0 || tempMaxima < tempMinima);
           
            dias[i] = new Dia(tempMinima, tempMaxima);            
        }
        
        mostrarDatos(dias);
    }
    
    static int conseguirTemperaturaMasAlta(Dia[] dias) {
        int result = dias[0].temperaturaMaxima;
        
        for(int i = 1; i < dias.length; i++) {
            if (dias[i].temperaturaMaxima > result) {
                result = dias[i].temperaturaMaxima;
            }
        }

        return result;
    }
    
    static int conseguirTemperaturaMasBaja(Dia[] dias) {
        int result = dias[0].temperaturaMinima;
        
        for(int i = 1; i < dias.length; i++) {
             if (dias[i].temperaturaMinima < result) {
                result = dias[i].temperaturaMinima;
            }
        }

        return result;
    }
    
    static double conseguirTemperaturaMedia(Dia[] dias) {
        double result = 0;
        for(int i = 0; i < dias.length; i++) {
            result += dias[i].temperaturaDia;
        }
        
        result /= dias.length;

        return result;
    }
    
    static void mostrarDatos(Dia[] dias) {
        System.out.println("Temperatura máxima: " + conseguirTemperaturaMasAlta(dias) + " ºC");
        System.out.println("Temperatura mínima: " + conseguirTemperaturaMasBaja(dias) + " ºC");
        System.out.println("Temperatura media: " + conseguirTemperaturaMedia(dias) + " ºC");
    }
}

class Dia {
    int temperaturaMinima;
    int temperaturaMaxima;
    double temperaturaDia;
    
    public Dia(int temperaturaMinima, int temperaturaMaxima) {
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        temperaturaDia = (temperaturaMaxima + temperaturaMinima) / 2.0;
    }
}
