/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosBinarios.Ejercicio10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class Ejercicio10 {
    public static void main(String[] args) {
        String ruta = "src/EjerciciosBinarios/Ejercicio10/data.dat";
        ArrayList<Integer> llamadasRecibidas;
        if (new File(ruta).exists()) {
            llamadasRecibidas = leerFicheroBinario(ruta);
        } else {
            llamadasRecibidas = new ArrayList();
        }
        int llamadasHoy = 0;
        int opcion;
        do {        
            menu();
            opcion = introducirNumero("Elige una opción: ");
            switch(opcion) {
                case 1:
                    System.out.println("Llamada recibida.");
                    llamadasHoy++;
                    break;
                case 2:
                    mostrarNumeroLlamadas(llamadasRecibidas);
                    break;
                case 0:
                    escribirEnFicheroBinario(ruta, llamadasRecibidas, llamadasHoy);
                    break;
                default:                    
                    System.err.println("ERROR: Elige una opción válida.");
                    break;                
            }
        } while (opcion != 0);
    }
    
    static void menu() {
        System.out.println("##########################");
        System.out.println("1.- Recibir llamada");
        System.out.println("2.- Ver numero de llamadas recibidas cada día.");
        System.out.println("0.- Salir");
        System.out.println("##########################");           
    }
    
    static void mostrarNumeroLlamadas(ArrayList<Integer> llamadasRecibidas) {
        int dia = 1;
        for (int llamadasRecibidasDia : llamadasRecibidas) {
            System.out.println("Día " + dia);
            System.out.println("Llamadas recibidas: " + llamadasRecibidasDia);
            System.out.println();
            dia++;
        }
    }
    
    static void escribirEnFicheroBinario(String ruta, ArrayList<Integer> llamadasRecibidas, int llamadasHoy) {
        ObjectOutputStream flujoSalida = null;
        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));
            for (int llamadasRecibidasDia : llamadasRecibidas) {
                flujoSalida.writeInt(llamadasRecibidasDia);
            }
            flujoSalida.writeInt(llamadasHoy);            
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if(flujoSalida != null) {
                    flujoSalida.close();
                } 
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
    }
    
    static ArrayList<Integer> leerFicheroBinario(String ruta)  {
        ObjectInputStream flujoEntrada = null;
        ArrayList<Integer> llamadasRecibidas = new ArrayList();
        try {        
            flujoEntrada = new ObjectInputStream(new FileInputStream(ruta));   
            while (flujoEntrada.available() > 0) {                
                llamadasRecibidas.add(flujoEntrada.readInt());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if(flujoEntrada != null) {
                    flujoEntrada.close();
                } 
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
        
        return llamadasRecibidas;
    }
    
    static int introducirNumero(String msg) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;        
        boolean noValido;
        do {
            System.out.println(msg);
            try {
                numero = sc.nextInt();
                noValido = false;
            } catch (InputMismatchException ex) {
                System.err.println("Debe ser un número decimal.");
                noValido = true;
                sc.next();
            }
        } while (noValido);

        return numero;
    }
}
