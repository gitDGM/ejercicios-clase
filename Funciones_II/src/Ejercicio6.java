/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
Crear una función que indique el menor número de monedas de 50, 20, 10, 5 y 1 céntimos con que se puede pagar una cantidad menor que 1€ que se pase como parámetro
*/
import java.util.Scanner;
/**
 *
 * @author alumno
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cantidad;
        do {            
            System.out.println("Introduce cantidad de dinero: ");
            cantidad = sc.nextDouble();
        } while (cantidad > 1 || cantidad < 0);
        cantidadMonedas(cantidad);
    }
    
    static void cantidadMonedas(double cantidad) {
        int temp, monedas50, monedas20, monedas10, monedas5, monedas1;
        temp = (int)(cantidad * 100);
        monedas50 = 0;
        monedas20 = 0;
        monedas10 = 0;
        monedas5 = 0;
        monedas1 = 0;
        while (temp != 0) {
            if (temp >= 50) {
                monedas50 = temp / 50;
                temp %= 50;
            } else if (temp >= 20) {                
                monedas20 = temp / 20;
                temp %= 20;
            } else if (temp >= 10) {                
                monedas10 = temp / 10;
                temp %= 10;
            } else if (temp >= 5) {                
                monedas5 = temp / 5;
                temp %= 5;
            } else if (temp >= 1) {                
                monedas1 = temp;
                temp %= 1;
            }
        }
        
        System.out.println("--------------------------------");  
        System.out.println("Formamos " + (int)(cantidad * 100) + " céntimos con las siguientes monedas: ");        
        System.out.println("Monedas de 50: " + monedas50);
        System.out.println("Monedas de 20: " + monedas20);
        System.out.println("Monedas de 10: " + monedas10);
        System.out.println("Monedas de 5: " + monedas5);
        System.out.println("Monedas de 1: " + monedas1);
        System.out.println("--------------------------------"); 
    }
}
