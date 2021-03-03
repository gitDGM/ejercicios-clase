/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author alumno
 */
public class Decodificador {
    
    private final String cifrado;

    public Decodificador() {
        cifrado = getCifradoFichero();
    }

    public String getCifrado() {
        return cifrado;
    }  
    
    public void decodificarFichero(File fichero) {
        
        String[] lineasFichero = ficheroToString(fichero).split("\n");
        String textoCifrado = "";
        
        for (int i = 0; i < lineasFichero.length; i++) {
            String[] palabrasLinea = lineasFichero[i].split(" ");
            for (int j = 0; j < palabrasLinea.length; j++) {
                String[] letrasPalabra = palabrasLinea[j].split("");
                for (int k = 0; k < letrasPalabra.length; k++) {
                   textoCifrado += intercambiarLetraCifrada(letrasPalabra[k]);
                }
                textoCifrado += " ";
            }
            textoCifrado += "\n";
        }
        
        escribirArrayEnFichero(textoCifrado.split("\n"), "descifrado.txt");
    }
    
    private String intercambiarLetraCifrada(String letra) {
        String[] alfabeto = "abcdefghijklmnopqrstuvwxyz".split("");
        String[] cifrado = getCifrado().split("");
        letra = letra.toLowerCase();
        
        String letraCifrada = "";
        boolean descifrada = false;        
        
        for (int i = 0; i < cifrado.length && !descifrada; i++) {
            if (cifrado[i].equals(letra)) { 
                letraCifrada = alfabeto[i];
                descifrada = true;
            }
        }          
        
        return letraCifrada;
    }
    
    private String ficheroToString(File fichero) {
        
        String texto = "";        
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
        
        return texto;
    }
    
    private void escribirArrayEnFichero(String[] array, String nombreFichero) {
        
        File fichero = new File("src/EjerciciosFicherosTexto/Ejercicio10/" + nombreFichero);
        
        if (fichero.exists()) {
            fichero.delete();
        }        
        
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {         
            filewriter = new FileWriter(fichero, true);
            escritor = new PrintWriter(filewriter);
            
            for (int i = 0; i < array.length; i++) {
                escritor.println(array[i]);
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (filewriter != null) filewriter.close();
                if (escritor != null) escritor.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());                    
            }
        }
    }
    
    private String getCifradoFichero() {
        File codec = new File("src/EjerciciosFicherosTexto/Ejercicio9/codec.txt");
        
        String cifradoUsado = getLineaFichero(codec).split("=")[1];
        
        return cifradoUsado;
    }
    
    private String getLineaFichero(File fichero) {
        FileReader filereader = null;
        BufferedReader lector = null;
        String cadenaLeida = "";
        
        if (fichero.exists()) {            
            try {            
                filereader = new FileReader(fichero);
                lector = new BufferedReader(filereader);
                cadenaLeida = lector.readLine();
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
        }        
        
        return cadenaLeida;
    }
}
