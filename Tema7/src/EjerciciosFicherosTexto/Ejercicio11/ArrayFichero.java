/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class ArrayFichero {
    private final String nombreArchivo;
    private int[][] valores;
    
    public ArrayFichero(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        cargarArrayFromString();
    }    
    
    public void mostrarValores() {
        if (valores != null) {
            for (int i = 0; i < valores.length; i++) {
                for (int j = 0; j < valores[i].length; j++) {
                    System.out.print(valores[i][j] + " ");
                }
                System.out.println();
            }
        }        
    }
    
    private void cargarArrayFromString() {
        try {
            String cadenaValores = ficheroToString();

            int numFilas = cadenaValores.split("\n").length;
            int numColumnas = cadenaValores.split("\n")[0].split(" ").length;        

            valores = new int[numFilas][numColumnas];

            for (int i = 0; i < numFilas; i++) {
                String cadenaFila = cadenaValores.split("\n")[i];
                for (int j = 0; j < numColumnas; j++) {
                    String cadenaValor = cadenaFila.split(" ")[j];
                    valores[i][j] = Integer.parseInt(cadenaValor);
                }
            }
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
            valores = null;
        }
        
    }
    
    private String ficheroToString() throws Exception {
        
        File fichero = new File("src/EjerciciosFicherosTexto/Ejercicio11/" + nombreArchivo);
        
        String texto = ""; 
        if (fichero.exists()) {
            FileReader filereader = null;
            BufferedReader lector = null;

            try {

                filereader = new FileReader(fichero);
                lector = new BufferedReader(filereader);

                String cadenaLeida = lector.readLine();
                while (cadenaLeida != null) {
                    texto += cadenaLeida + "\n";
                    cadenaLeida = lector.readLine();
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());

            } finally {
                try {
                    if (filereader != null) filereader.close();
                    if (lector != null) lector.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());                    
                }
            }       
        } else {
            throw new Exception("El archivo no existe.");
        }
        
        return texto;
    }
}
