
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alumno
 */
public class Fichero {
    private final String ruta;
    private final File fichero;

    public Fichero(String ruta) {
        this.ruta = ruta;
        fichero = new File(ruta);
    }

    public String getRuta() {
        return ruta;
    }
    
    public String[] ficheroToArrayLetrasPalabra(int indexLinea, int indexPalabra) {
        return ficheroToString().split("\n")[indexLinea].split(" ")[indexPalabra].split("");
    }
    
    public String[] ficheroToArrayPalabrasLinea(int index) {
        return ficheroToString().split("\n")[index].split(" ");
    }
    
    public String[] ficheroToArrayLineas() {
        return ficheroToString().split("\n");
    }
    
    public String ficheroToString() {
        String texto = ""; 
        if (fichero.exists()) {
            FileReader filereader = null;
            BufferedReader lector = null;
            try {
                filereader = new FileReader(fichero);
                lector = new BufferedReader(filereader);

                String cadenaLeida = lector.readLine();
                while (cadenaLeida != null && !cadenaLeida.equals("")) {
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
            System.err.println("ERROR: El archivo no existe.");
            texto = "";
        }
        
        return texto;
    }
}
