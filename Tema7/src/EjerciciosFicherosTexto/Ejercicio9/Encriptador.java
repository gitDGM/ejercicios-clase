/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class Encriptador {
    private final String alfabeto;
    private final String cifrado;

    public Encriptador() {
        alfabeto = "abcdefghijklmnopqrstuvwxyz";
        cifrado = getCifrado();
    }
    
        
    private String getCifrado() {
        String cifrado = "";
        File codec = new File("src/EjerciciosFicherosTexto/Ejercicio9/codec.txt");
        
        cifrado = getLineaFichero(codec).split("=")[1];
        
        return cifrado;
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
