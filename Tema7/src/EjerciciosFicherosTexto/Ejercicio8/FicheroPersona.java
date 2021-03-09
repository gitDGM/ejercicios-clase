/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjerciciosFicherosTexto.Ejercicio8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author alumno
 */
public final class FicheroPersona {
    private final File fichero;
    
    public FicheroPersona(String nombreFichero) {
        this.fichero = new File("src/EjerciciosFicherosTexto/Ejercicio8/" + nombreFichero);
        ordenarAlfabeticamente();
    }

    public File getFichero() {
        return fichero;
    }
    
    public void fusionarConFicheroEnNuevo(String nombreNuevo, FicheroPersona ficheroFusion) {
        FicheroPersona ficheroNuevo = new FicheroPersona(nombreNuevo);
        
        if (ficheroNuevo.getFichero().exists()) {
            ficheroNuevo.getFichero().delete();
        }
        
        String[] lineasFichero1 = ficheroToString().split("\n");
        String[] lineasFichero2 = ficheroFusion.ficheroToString().split("\n");
        
        escribirArrayEnFicheroNuevo(lineasFichero1, ficheroNuevo);
        escribirArrayEnFicheroNuevo(lineasFichero2, ficheroNuevo);
        ficheroNuevo.ordenarAlfabeticamente();
        
    }
    
    
    private void ordenarAlfabeticamente() {
        
        String[] lineas = ficheroToString().split("\n");        
        Arrays.sort(lineas);
        
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {
            fichero.delete();
            filewriter = new FileWriter(fichero, true);
            escritor = new PrintWriter(filewriter);
            
            for (int i = 0; i < lineas.length; i++) {
                escritor.println(lineas[i]);
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
    
    private void escribirArrayEnFicheroNuevo(String[] array, FicheroPersona ficheroNuevo) {
        
        FileWriter filewriter = null;
        PrintWriter escritor = null;
        
        try {         
            filewriter = new FileWriter(ficheroNuevo.getFichero(), true);
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
    
    
    private String ficheroToString() {
        
        String texto = "";        
        FileReader filereader = null;
        BufferedReader lector = null;
        
        try {
            
            filereader = new FileReader(this.fichero);
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
}
