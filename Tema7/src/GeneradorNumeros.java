
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 0017610
 */
public class GeneradorNumeros {

    public static void main(String[] args) {
        String ruta = "src/data.dat";
        ArrayList<Integer> tabla = new ArrayList();
        
        for (int i = 0; i < 10; i++) {
            tabla.add(introducirNumero("Introduce un número:"));
        }
        
        escribirEnFicheroBinarioUnoPorUnoEnteros(tabla, ruta);

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

    static void escribirEnFicheroBinarioUnoPorUnoEnteros(ArrayList<Integer> numeros, String ruta) {
        ObjectOutputStream flujoSalida = null;

        try {
            flujoSalida = new ObjectOutputStream(new FileOutputStream(ruta));
            for (int numero : numeros) {
                flujoSalida.writeInt(numero);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error!!! El fichero no existe.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (flujoSalida != null) {
                    flujoSalida.close();
                }
            } catch (IOException ex) {
                System.err.println("Error al cerrar el fichero.");
            }
        }
    }
}
