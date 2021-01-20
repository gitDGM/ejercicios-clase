
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
public class Ejercicio6_nuevo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre;
        int num_control;
        do {
            System.out.println("Introduce \"FIN\" para terminar.");
            System.out.println("Introduce el nombre del cliente: ");
            nombre = sc.nextLine();
            if (!nombre.equals("FIN")) {                
                System.out.println("Introduce el número de control: ");
                num_control = sc.nextInt();
                sc.nextLine();     
                Cliente cliente = new Cliente(nombre, num_control);
                mostrarInfoCliente(cliente);
            }
            
            
        } while (!nombre.equals("FIN"));
    }
    
    static void mostrarInfoCliente(Cliente cliente) {
        if (cliente.num_control == 4 || cliente.num_control == 5) {
            System.out.println(cliente.nombre + " - CRÉDITO");
        } else if (cliente.num_control >= 10 && cliente.num_control <= 15) {
            System.out.println(cliente.nombre + " - DÉBITO");
        } else {
            System.out.println(cliente.nombre + " - ERROR");
        }
    }
}

class Cliente {
    String nombre;
    int num_control;
    
    public Cliente(String nombre, int num_control) {
        this.nombre = nombre;
        this.num_control = num_control;
    }
}
