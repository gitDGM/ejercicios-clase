
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    public File getFichero() {
        return fichero;
    }
    
    public String[] convertToArrayLetrasPalabra(int indexLinea, int indexPalabra) {
        return convertToString().split("\n")[indexLinea].split(" ")[indexPalabra].split("");
    }
    
    public String[] convertToArrayPalabrasLinea(int index) {
        return convertToString().split("\n")[index].split(" ");
    }
    
    public String[] convertToArrayLineas() {
        return convertToString().split("\n");
    }
    
    public boolean compararDosFicheros(Fichero ficheroExterno) {
        return this.convertToString().equals(ficheroExterno.convertToString());
    }
    
    public String convertToString() {
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
    
    public void copiarFichero(String nombreNuevoArchivo) {
       Fichero nuevoFichero = new Fichero(nombreNuevoArchivo);
       
       if (!nuevoFichero.existeFichero()) {
           String[] cadena = this.convertToString().split("\n");
           nuevoFichero.escribirArrayEnFichero(cadena);
       }
    }
    
    public void escribirCadenaEnFichero(String cadena) {
        insertarLineaEnFichero(cadena);
    }
    
    public void escribirArrayEnFichero(String[] array) {
        for (int i = 0; i < array.length; i++) {
            insertarLineaEnFichero(array[i]);
        }
    }
    
    public boolean existeFichero() {
        return this.getFichero().exists();
    }
    
    public void insertarLineaEnFichero(String linea) {
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {         
            filewriter = new FileWriter(this.fichero, true);
            escritor = new PrintWriter(filewriter);
            
            escritor.println(linea);
            
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
}
