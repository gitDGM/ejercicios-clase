/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class Comando {
    
    public boolean comp(File fichero1, File fichero2) {
        boolean iguales = true;
        
        try {
            String cadenaFichero1 = ficheroToString(fichero1);
            String cadenaFichero2 = ficheroToString(fichero2);             
            
            iguales = logicaComp(cadenaFichero1, cadenaFichero2);
            
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
        
        
        return iguales;
    }
    
    private boolean logicaComp(String fichero1, String fichero2) {
        boolean iguales = true;
        int contadorLetra = 1;
        int contadorPalabra = 1;
        int contadorLinea = 1;
        
        if (iguales || fichero1.length() != fichero1.length()) {
            for (int i = 0; i < fichero1.length() && iguales; i++) {
                if (fichero1.charAt(i) != fichero2.charAt(i)) {
                    iguales = false;
                } else {
                    if (fichero1.charAt(i) == '\n') {
                        contadorLinea++;
                        contadorPalabra = 1;
                        contadorLetra = 1;
                    } else if (fichero1.charAt(i) == ' ') {
                        contadorPalabra++;
                        contadorLetra = 1;                        
                    } else if (!("" + fichero1.charAt(i)).equals("\n") && fichero1.charAt(i) != ' ') {
                        contadorLetra++;
                    }                    
                }
            }
        }
        
        if (!iguales) {
            System.out.println("DIFERENCIA ENCONTRADA EN:");
            System.out.println("LINEA: " + contadorLinea);
            System.out.println("PALABRA: " + contadorPalabra);
            System.out.println("CARACTER: " + contadorLetra + "\n");
        }
        
        return iguales;
    }
    
    private String ficheroToString(File fichero) throws Exception {
        
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
